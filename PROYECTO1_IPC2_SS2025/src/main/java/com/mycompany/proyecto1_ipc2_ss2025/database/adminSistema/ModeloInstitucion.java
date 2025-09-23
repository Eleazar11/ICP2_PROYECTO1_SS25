/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

/**
 *
 * @author eleaz
 */
public class ModeloInstitucion {
    private int idInstitucion; 
    private String nombreInstitucion;
    private String desccripcion;
    private String direccion;
    private String telefono;

    public ModeloInstitucion(String nombreInstitucion, String desccripcion, String direccion, String telefono) {
        this.nombreInstitucion = nombreInstitucion;
        this.desccripcion = desccripcion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ModeloInstitucion(int idInstitucion, String nombreInstitucion, String desccripcion, String direccion, String telefono) {
        this.idInstitucion = idInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.desccripcion = desccripcion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    
    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getDesccripcion() {
        return desccripcion;
    }

    public void setDesccripcion(String desccripcion) {
        this.desccripcion = desccripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
