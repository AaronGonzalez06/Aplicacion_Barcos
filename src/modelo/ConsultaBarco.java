/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class ConsultaBarco extends Conexion {
    
    PreparedStatement ps;
    ResultSet rs;

    public boolean insertarRespuesta(String matricula, String nombre, String tipo, String capacidad) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into barco (matricula,nombre,tipo,capacidad) values (?,?,?,?);");
            ps.setString(1, matricula);
            ps.setString(2, nombre);
            ps.setString(3, tipo);
            ps.setString(4, capacidad);
            int resultado = ps.executeUpdate();            
            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    
    public ArrayList<Barco> listarBarcos(ArrayList<Barco> barcos) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();
            int contador = 0;
            ps = conexion.prepareStatement("select bar.matricula as matricula, bar.nombre as nombre, bar.tipo as tipo , bar.capacidad as capacidad , soc.DNI as DNI from barco bar inner join anclaje anc on anc.matricula_barco = bar.matricula inner join socio soc on soc.DNI = anc.DNI_socio;");
            rs = ps.executeQuery();

            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));
                barcos.add(new Barco());
                barcos.get(contador).setMatricula(rs.getString("matricula"));
                barcos.get(contador).setNombre(rs.getString("nombre"));
                barcos.get(contador).setTipo(rs.getString("tipo"));
                barcos.get(contador).setCapacidad(rs.getString("capacidad"));
                barcos.get(contador).setDNI(rs.getString("DNI"));
                contador++;
            }
            return barcos;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return barcos;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    public boolean existeBarco(String matricula) {
        Connection conexion = getConnection();
        boolean resultado = false;
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("select count(*) as numero from barco where matricula=?;");
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));                
                int numero = rs.getInt("numero");
                if (numero == 1) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }

            return resultado;

        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return false;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
}
