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
        ventanaInicio.jButton9.addActionListener(this);
        ventanaInicio.jButton11.addActionListener(this);
        ventanaInicio.jButton13.addActionListener(this);
        ventanaInicio.jButton10.addActionListener(this);
        ventanaInicio.jButton12.addActionListener(this);
    }

    public void inicio() {

        String matricula ="";
        String DNI ="";
        String ordenarBarco ="";
        modeloBarco.listarBarcos(barcos,matricula,DNI,ordenarBarco);
        DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable2.getModel();
        for (int x = 0; x < barcos.size(); x++) {
            modelo.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
        }
        String dni = "";
        String ordena = "";
        modeloSocio.ListarSocios(socios,dni,ordena);
        DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();
        for (int x = 0; x < socios.size(); x++) {
            modeloTablaSocio.addRow(new Object[]{socios.get(x).getDNI(), socios.get(x).getNombre(), socios.get(x).getApellidos(), socios.get(x).getDireccion(), socios.get(x).getTelefono(), socios.get(x).getFecha_alta()});
        }
        String serial ="";
        String ordenar="";
        ModeloAnclaje.ListarAnclaje(Anclajes,serial,ordenar);
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
            String dni = "";
            String ordenar ="";
            if(ventanaInicio.jRadioButton3.isSelected()){
                ordenar = " order by DNI;";
                modeloSocio.ListarSocios(socios,dni,ordenar);
            } else if(ventanaInicio.jRadioButton4.isSelected()){
                ordenar = " order by nombre;";
                modeloSocio.ListarSocios(socios,dni,ordenar);            
            } else if(ventanaInicio.jRadioButton5.isSelected()){
                ordenar = " order by telefono;";
                modeloSocio.ListarSocios(socios,dni,ordenar);            
            } else if(ventanaInicio.jRadioButton6.isSelected()){
                ordenar = " order by fecha_alta;";
                modeloSocio.ListarSocios(socios,dni,ordenar);            
            }else{
                ordenar = "";
                modeloSocio.ListarSocios(socios,dni,ordenar);            
            }
            
            //DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();            
            for (int x = 0; x < socios.size(); x++) {
                modelo.addRow(new Object[]{socios.get(x).getDNI(), socios.get(x).getNombre(), socios.get(x).getApellidos(), socios.get(x).getDireccion(), socios.get(x).getTelefono(), socios.get(x).getFecha_alta()});
            }

        } else if (e.getSource() == ventanaInicio.jButton9) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable1.getModel();
            int filas = ventanaInicio.jTable1.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }
            socios.clear();
            String dni = ventanaInicio.jTextField12.getText();
            String ordenar= "";
            modeloSocio.ListarSocios(socios,dni,ordenar);
            //DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();            
            for (int x = 0; x < socios.size(); x++) {
                modelo.addRow(new Object[]{socios.get(x).getDNI(), socios.get(x).getNombre(), socios.get(x).getApellidos(), socios.get(x).getDireccion(), socios.get(x).getTelefono(), socios.get(x).getFecha_alta()});
            }
            ventanaInicio.jTextField12.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton11) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable3.getModel();
            int filas = ventanaInicio.jTable3.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }
            Anclajes.clear();
            String anclaje = ventanaInicio.jTextField14.getText();
            String ordenar= "";
            ModeloAnclaje.ListarAnclaje(Anclajes,anclaje,ordenar);
            //DefaultTableModel modeloTablaSocio = (DefaultTableModel) ventanaInicio.jTable1.getModel();            
            for (int x = 0; x < Anclajes.size(); x++) {
            modelo.addRow(new Object[]{Anclajes.get(x).getSerial(), Anclajes.get(x).getContrato_luz(), Anclajes.get(x).getContrato_agua(), Anclajes.get(x).getServicio_limpieza(), Anclajes.get(x).getFecha_compra(), Anclajes.get(x).getDNI_socio(), Anclajes.get(x).getMatricula_barco(), Anclajes.get(x).getZona_zona()});
            }
            ventanaInicio.jTextField14.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton4) {

            DefaultTableModel modeloBorrarBarco = (DefaultTableModel) ventanaInicio.jTable2.getModel();
            int filas = ventanaInicio.jTable2.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modeloBorrarBarco.removeRow(i);
            }
            barcos.clear();
            String matricula="";
            String DNI="";
            String ordenar ="";
            if(ventanaInicio.jRadioButton7.isSelected()){
                ordenar=" order by bar.matricula";
            } else if(ventanaInicio.jRadioButton8.isSelected()){
                ordenar=" order by bar.tipo";
            } else if(ventanaInicio.jRadioButton9.isSelected()){
                ordenar=" order by soc.DNI";
            } else if(ventanaInicio.jRadioButton10.isSelected()){
                ordenar=" order by bar.nombre";
            }
            modeloBarco.listarBarcos(barcos,matricula,DNI,ordenar);
            for (int x = 0; x < barcos.size(); x++) {
                modeloBorrarBarco.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
            }

        } else if (e.getSource() == ventanaInicio.jButton10) {

            DefaultTableModel modeloBorrarBarco = (DefaultTableModel) ventanaInicio.jTable2.getModel();
            int filas = ventanaInicio.jTable2.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modeloBorrarBarco.removeRow(i);
            }
            barcos.clear();
            String matricula= ventanaInicio.jTextField13.getText();
            String DNI="";
            String ordenar ="";
            modeloBarco.listarBarcos(barcos,matricula,DNI,ordenar);
            for (int x = 0; x < barcos.size(); x++) {
                modeloBorrarBarco.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
            }
            ventanaInicio.jTextField13.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton12) {

            DefaultTableModel modeloBorrarBarco = (DefaultTableModel) ventanaInicio.jTable2.getModel();
            int filas = ventanaInicio.jTable2.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modeloBorrarBarco.removeRow(i);
            }
            barcos.clear();
            String matricula= "";
            String DNI= ventanaInicio.jTextField15.getText();
            String ordenar ="";
            modeloBarco.listarBarcos(barcos,matricula,DNI,ordenar);
            for (int x = 0; x < barcos.size(); x++) {
                modeloBorrarBarco.addRow(new Object[]{barcos.get(x).getMatricula(), barcos.get(x).getNombre(), barcos.get(x).getTipo(), barcos.get(x).getCapacidad(), barcos.get(x).getDNI()});
            }
            ventanaInicio.jTextField15.setText(null);

        } else if (e.getSource() == ventanaInicio.jButton13) {

            DefaultTableModel modelo = (DefaultTableModel) ventanaInicio.jTable3.getModel();
            int filas = ventanaInicio.jTable3.getRowCount();
            for (int i = filas -1; i > -1; i--) {
                modelo.removeRow(i);
            }
            Anclajes.clear();
            String serial = "";
            String ordenar="";
            if(ventanaInicio.jRadioButton11.isSelected()){
                ordenar=" order by serial;";
            } else if(ventanaInicio.jRadioButton12.isSelected()){
               ordenar=" order by zona_zona;"; 
            } else if(ventanaInicio.jRadioButton13.isSelected()){
               ordenar=" order by matricula_barco;"; 
            } else if(ventanaInicio.jRadioButton14.isSelected()){
               ordenar=" order by DNI_socio;"; 
            }
            
            ModeloAnclaje.ListarAnclaje(Anclajes, serial,ordenar);
            for (int x = 0; x < Anclajes.size(); x++) {
            modelo.addRow(new Object[]{Anclajes.get(x).getSerial(), Anclajes.get(x).getContrato_luz(), Anclajes.get(x).getContrato_agua(), Anclajes.get(x).getServicio_limpieza(), Anclajes.get(x).getFecha_compra(), Anclajes.get(x).getDNI_socio(), Anclajes.get(x).getMatricula_barco(), Anclajes.get(x).getZona_zona()});
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
