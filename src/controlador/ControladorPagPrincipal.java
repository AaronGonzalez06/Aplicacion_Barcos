/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Anclaje;
import vista.Login;
import vista.PagPrincipal;
import modelo.ConsultaBarco;
import modelo.Barco;
import modelo.ConsultaAnclaje;
import modelo.ConsultaSocio;
import modelo.Socio;

/**
 *
 * @author Aaron
 */
public class ControladorPagPrincipal implements ActionListener {

    private PagPrincipal ventanaInicio;
    private ConsultaBarco modeloBarco = new ConsultaBarco();
    private ConsultaSocio modeloSocio = new ConsultaSocio();
    private ConsultaAnclaje ModeloAnclaje = new ConsultaAnclaje();
    private ArrayList<Barco> barcos = new ArrayList<Barco>();
    private ArrayList<Socio> socios = new ArrayList<Socio>();
    private ArrayList<Anclaje> Anclajes = new ArrayList<Anclaje>();

    public ControladorPagPrincipal(PagPrincipal ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
        ventanaInicio.jButton2.addActionListener(this);
        ventanaInicio.jButton1.addActionListener(this);
        ventanaInicio.jButton6.addActionListener(this);
        ventanaInicio.jButton5.addActionListener(this);
        ventanaInicio.jButton3.addActionListener(this);
        ventanaInicio.jButton4.addActionListener(this);
        ventanaInicio.jButton7.addActionListener(this);
        ventanaInicio.jButton8.addActionListener(this);
    }

    public void inicio() {

        modeloBarco.listarBarcos(barcos);
        DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable2.getModel();
        for (int x = 0; x < barcos.size(); x++) {
            modelo.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
        }

        modeloSocio.ListarSocios(socios);
        DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();
        for (int x = 0; x < socios.size(); x++) {
            modeloTablaSocio.addRow(new Object[]{socios.get(x).getDNI(), socios.get(x).getNombre(), socios.get(x).getApellidos(), socios.get(x).getDireccion(), socios.get(x).getTelefono(), socios.get(x).getFecha_alta()});
        }

        ModeloAnclaje.ListarSocios(Anclajes);
        DefaultTableModel modeloTablaAnclaje = (DefaultTableModel) ventanaInicio.jTable3.getModel();
        for (int x = 0; x < Anclajes.size(); x++) {
            modeloTablaAnclaje.addRow(new Object[]{Anclajes.get(x).getSerial(), Anclajes.get(x).getContrato_luz(), Anclajes.get(x).getContrato_agua(), Anclajes.get(x).getServicio_limpieza(), Anclajes.get(x).getFecha_compra(), Anclajes.get(x).getDNI_socio(), Anclajes.get(x).getMatricula_barco(), Anclajes.get(x).getZona_zona()});
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ventanaInicio.jButton2) {
            if (ventanaInicio.jTextField7.getText().length() == 0 || ventanaInicio.jTextField8.getText().length() == 0 || ventanaInicio.jTextField10.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Faltan campos por intriducir");
            } else {
                String matricula = ventanaInicio.jTextField7.getText();
                String nombre = ventanaInicio.jTextField8.getText();
                String capacidad = ventanaInicio.jTextField10.getText();
                String tipo = (String) ventanaInicio.jComboBox1.getSelectedItem();

                System.out.println(tipo);
                if (modeloBarco.insertarRespuesta(matricula, nombre, tipo, capacidad)) {
                    JOptionPane.showMessageDialog(null, "Barco añadido correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al añadir el barco");
                }

            }
        } else if (e.getSource() == ventanaInicio.jButton1) {

            if (ventanaInicio.jTextField1.getText().length() == 0 || ventanaInicio.jTextField2.getText().length() == 0 || ventanaInicio.jTextField3.getText().length() == 0 || ventanaInicio.jTextField4.getText().length() == 0 || ventanaInicio.jTextField5.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Faltan campos por intriducir");
            } else {
                String nombre = ventanaInicio.jTextField1.getText();
                String apellidos = ventanaInicio.jTextField2.getText();
                String DNI = ventanaInicio.jTextField3.getText();
                int telefono = Integer.parseInt(ventanaInicio.jTextField4.getText());
                String direccion = ventanaInicio.jTextField5.getText();

                if (modeloSocio.insertarRespuesta(DNI, nombre, telefono, direccion, apellidos)) {
                    JOptionPane.showMessageDialog(null, "Socio añadido correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al añadir nuevo socio");
                }

            }

        } else if (e.getSource() == ventanaInicio.jButton6) {
            ventanaInicio.jTextField7.setText(null);
            ventanaInicio.jTextField8.setText(null);
            ventanaInicio.jTextField10.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton8) {
            ventanaInicio.jTextField6.setText(null);
            ventanaInicio.jTextField9.setText(null);
            ventanaInicio.jTextField11.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton5) {
            ventanaInicio.jTextField1.setText(null);
            ventanaInicio.jTextField2.setText(null);
            ventanaInicio.jTextField3.setText(null);
            ventanaInicio.jTextField4.setText(null);
            ventanaInicio.jTextField5.setText(null);
        } else if (e.getSource() == ventanaInicio.jButton3) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable1.getModel();
            int filas = ventanaInicio.jTable1.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }
            socios.clear();
            modeloSocio.ListarSocios(socios);
            //DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();            
            for (int x = 0; x < socios.size(); x++) {
                modelo.addRow(new Object[]{socios.get(x).getDNI(), socios.get(x).getNombre(), socios.get(x).getApellidos(), socios.get(x).getDireccion(), socios.get(x).getTelefono(), socios.get(x).getFecha_alta()});
            }

        } else if (e.getSource() == ventanaInicio.jButton4) {

            DefaultTableModel modeloBorrarBarco = (DefaultTableModel) ventanaInicio.jTable2.getModel();
            int filas = ventanaInicio.jTable2.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modeloBorrarBarco.removeRow(i);
            }
            barcos.clear();
            modeloBarco.listarBarcos(barcos);
            for (int x = 0; x < barcos.size(); x++) {
                modeloBorrarBarco.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
            }

        } else if (e.getSource() == ventanaInicio.jButton7) {

            if (ventanaInicio.jTextField6.getText().length() == 0 || ventanaInicio.jTextField9.getText().length() == 0 || ventanaInicio.jTextField11.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Falta datos por añadir.");
            } else {
                int serial = Integer.parseInt(ventanaInicio.jTextField6.getText());
                String DNI = ventanaInicio.jTextField9.getText();
                String matricula = ventanaInicio.jTextField11.getText();
                String contrato_luz = (String) ventanaInicio.jComboBox2.getSelectedItem();
                String contrato_agua = (String) ventanaInicio.jComboBox3.getSelectedItem();
                String zona_zona = (String) ventanaInicio.jComboBox4.getSelectedItem();
                String servicio_limpieza;
                if (ventanaInicio.jRadioButton1.isSelected()) {
                    servicio_limpieza = ventanaInicio.jRadioButton1.getText();
                } else {
                    servicio_limpieza = ventanaInicio.jRadioButton2.getText();
                }

                if (modeloSocio.existeSocio(DNI) && modeloBarco.existeBarco(matricula)) {
                    if (ModeloAnclaje.insertarRespuesta(serial, contrato_luz, contrato_agua, servicio_limpieza, DNI, matricula, zona_zona)) {
                        JOptionPane.showMessageDialog(null, "Anclaje añadido correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al añadir el anclaje.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "DNI o matricula no existen.");

                }
            }
        }

    }

}
