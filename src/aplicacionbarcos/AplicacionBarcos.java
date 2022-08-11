/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aplicacionbarcos;

import vista.Login;
import vista.PagPrincipal;

import controlador.ControladorLogin;
import controlador.ControladorPagPrincipal;


/**
 *
 * @author Aaron
 */
public class AplicacionBarcos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login VistaLogin = new Login();
        PagPrincipal VistaPrincipal = new PagPrincipal();
        
        ControladorLogin Login = new ControladorLogin(VistaLogin, VistaPrincipal);
        ControladorPagPrincipal PagInicio = new ControladorPagPrincipal(VistaPrincipal);
        Login.iniciar();
        PagInicio.inicio();
        VistaLogin.setVisible(true);
        
    }
    
}
