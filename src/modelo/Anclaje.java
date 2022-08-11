/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Aaron
 */
public class Anclaje {
    
    private int serial;
    private String contrato_luz;
    private String contrato_agua;
    private String servicio_limpieza;
    private Date fecha_compra;
    private String DNI_socio;
    private String matricula_barco;
    private String zona_zona;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getContrato_luz() {
        return contrato_luz;
    }

    public void setContrato_luz(String contrato_luz) {
        this.contrato_luz = contrato_luz;
    }

    public String getContrato_agua() {
        return contrato_agua;
    }

    public void setContrato_agua(String contrato_agua) {
        this.contrato_agua = contrato_agua;
    }

    public String getServicio_limpieza() {
        return servicio_limpieza;
    }

    public void setServicio_limpieza(String servicio_limpieza) {
        this.servicio_limpieza = servicio_limpieza;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getDNI_socio() {
        return DNI_socio;
    }

    public void setDNI_socio(String DNI_socio) {
        this.DNI_socio = DNI_socio;
    }

    public String getMatricula_barco() {
        return matricula_barco;
    }

    public void setMatricula_barco(String matricula_barco) {
        this.matricula_barco = matricula_barco;
    }

    public String getZona_zona() {
        return zona_zona;
    }

    public void setZona_zona(String zona_zona) {
        this.zona_zona = zona_zona;
    }
    
    
    
}
