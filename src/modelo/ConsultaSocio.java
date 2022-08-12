/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aaron
 */
public class ConsultaSocio extends Conexion {

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Socio> ListarSocios(ArrayList<Socio> socios, String DNI, String ordenado) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();
            int contador = 0;
            if (!"".equals(ordenado)) {                
                ps = conexion.prepareStatement("select * from socio" + ordenado);
            } else if ("".equals(DNI)) {
                ps = conexion.prepareStatement("select * from socio;");
            } else {
                ps = conexion.prepareStatement("select * from socio where DNI =?;");
                ps.setString(1, DNI);
            }
            rs = ps.executeQuery();

            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));
                socios.add(new Socio());
                socios.get(contador).setDNI(rs.getString("DNI"));
                socios.get(contador).setNombre(rs.getString("nombre"));
                socios.get(contador).setApellidos(rs.getString("apellidos"));
                socios.get(contador).setTelefono(rs.getString("telefono"));
                socios.get(contador).setDireccion(rs.getString("direccion"));
                socios.get(contador).setFecha_alta(rs.getDate("fecha_alta"));
                contador++;
            }
            return socios;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return socios;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }

    public boolean insertarRespuesta(String DNI, String nombre, int telefono, String direccion, String apellidos) {
        Connection conexion = getConnection();
        try {
            System.out.println("entro en el try");
            ps = conexion.prepareStatement("insert into socio values (?,?,?,?,curdate(),?);");
            ps.setString(1, DNI);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setInt(4, telefono);
            //ps.setDate(5, fecha_alta);
            ps.setString(5, apellidos);
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

    public boolean existeSocio(String DNI) {
        Connection conexion = getConnection();
        boolean resultado = false;
        try {
            conexion = getConnection();
            ps = conexion.prepareStatement("select count(*) as numero from socio where DNI=?;");
            ps.setString(1, DNI);
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
