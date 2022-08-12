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
public class ConsultaAnclaje extends Conexion {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertarRespuesta(int serial, String contrato_luz, String contrato_agua, String servicio_limpieza, String DNI_socio, String matricula_barco, String zona_zona) {
        Connection conexion = getConnection();
        try {
            ps = conexion.prepareStatement("insert into anclaje (serial,contador_luz,contador_agua,servicio_limpieza,fecha_compra,DNI_socio,matricula_barco,zona_zona) values (?,?,?,?,curdate(),?,?,?);");
            ps.setInt(1, serial);
            ps.setString(2, contrato_luz);
            ps.setString(3, contrato_agua);
            ps.setString(4, servicio_limpieza);
            ps.setString(5, DNI_socio);
            ps.setString(6, matricula_barco);
            ps.setString(7, zona_zona);
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
    
    public ArrayList<Anclaje> ListarAnclaje(ArrayList<Anclaje> anclajes,String serial,String ordenar) {
        Connection conexion = getConnection();
        try {
            conexion = getConnection();
            int contador = 0;
            
            if(!"".equals(serial)){
            ps = conexion.prepareStatement("select * from anclaje where serial=?");
            ps.setString(1, serial);
            }else if(!"".equals(ordenar)){
            ps = conexion.prepareStatement("select * from anclaje" + ordenar);
            }else{
            ps = conexion.prepareStatement("select * from anclaje;");
            }
            
            rs = ps.executeQuery();

            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));
                anclajes.add(new Anclaje());
                anclajes.get(contador).setSerial(rs.getInt("Serial"));
                anclajes.get(contador).setContrato_luz(rs.getString("contador_luz"));
                anclajes.get(contador).setContrato_agua(rs.getString("contador_agua"));
                anclajes.get(contador).setServicio_limpieza(rs.getString("Servicio_limpieza"));
                anclajes.get(contador).setFecha_compra(rs.getDate("fecha_compra"));
                anclajes.get(contador).setDNI_socio(rs.getString("DNI_socio"));
                anclajes.get(contador).setMatricula_barco(rs.getString("matricula_barco"));
                anclajes.get(contador).setZona_zona(rs.getString("zona_zona"));
                contador++;
            }
            return anclajes;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return anclajes;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }    
}
