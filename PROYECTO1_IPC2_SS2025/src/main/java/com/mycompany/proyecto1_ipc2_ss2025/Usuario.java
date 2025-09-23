/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025;

/**
 *
 * @author eleaz
 */
public class Usuario {

    private String nombreCompleto;
    private String organizacion;
    private String correoElectronico;
    private String contrasena;
    private String telefono;
    private String numeroIdentificacion;
    private String fotoPath;
    private TipoUsuario tipoUsuario;
    private TipoEstadoUsuario estado;
    private int id_usuario;

    public Usuario(String nombreCompleto, String organizacion, String correoElectronico,
            String contrasena, String telefono, String numeroIdentificacion, String fotoPath) {
        this.nombreCompleto = nombreCompleto;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fotoPath = fotoPath;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    public TipoEstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(TipoEstadoUsuario estado) {
        this.estado = estado;
    }

    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        this.fotoPath = fotoPath;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}
