/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aaron
 */
public class Conexion {
    
        public static final String URL = "jdbc:mysql://localhost:3306/trabajo_base_datos?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String passwd = "";
    
    public Connection getConnection() {
        Connection conexion = null;

        //conexion
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(URL, usuario, passwd);
            System.out.println("Todo ok");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return conexion;
    }
    
}
