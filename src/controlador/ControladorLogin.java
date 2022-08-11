/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Login;
import vista.PagPrincipal;

import modelo.ConsultasLogin;

/**
 *
 * @author Aaron
 */
public class ControladorLogin implements ActionListener {
    
    private Login ventanaLogin;
    private PagPrincipal ventanaInicio;
    
    private ConsultasLogin ModeloConsultasLogin = new ConsultasLogin();
    
    
    public ControladorLogin(Login ventanaLogin, PagPrincipal ventanaInicio) {
        this.ventanaLogin = ventanaLogin;
        this.ventanaInicio = ventanaInicio;        
        ventanaLogin.jButton2.addActionListener(this);
    }
    
    public void iniciar() {
        ventanaLogin.setTitle("Barco");
        ventanaLogin.setLocationRelativeTo(null);
        ventanaInicio.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == ventanaLogin.jButton2) {
            int resultado = ModeloConsultasLogin.ExisteUsuario(ventanaLogin.jTextField1.getText());
            
                if(resultado == 1){
                    String dni = ventanaLogin.jTextField1.getText();
                    String passwd = ModeloConsultasLogin.VerificarPasswd(dni);
                    String passwdUsuario = new String(ventanaLogin.jPasswordField1.getPassword());
                        if(passwd.equals(passwdUsuario)){
                        ventanaLogin.setVisible(false);
                        ventanaInicio.setVisible(true);
                        ventanaInicio.jLabel1.setText(dni);
                        }else{
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "El DNI introducido no existe");
                }
            

        }
        
    }
    
}
