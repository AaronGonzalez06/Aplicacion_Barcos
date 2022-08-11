/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aaron
 */
public class ConsultasLogin extends Conexion {

    PreparedStatement ps;
    ResultSet rs;

    public int ExisteUsuario(String dni) {
        Connection conexion = getConnection();
        int resultado = 0;

        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select count(*) as numero from empleado where DNI=?;");
            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));                
                resultado = rs.getInt("numero");
            }
            return resultado;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return 0;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }
    
    
    public String VerificarPasswd(String dni) {
        Connection conexion = getConnection();
        String resultado = "";

        try {
            conexion = getConnection();

            ps = conexion.prepareStatement("select passwd from empleado where DNI=?;");
            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                //Sstem.out.println(rs.getString("nombreTema"));                
                resultado = rs.getString("passwd");
            }
            return resultado;
        } catch (Exception ex) {
            System.out.println("error desde el modelo: " + ex);
            return resultado;
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                System.out.println("error desde el modelo: " + ex);
            }
        }
    }

}
