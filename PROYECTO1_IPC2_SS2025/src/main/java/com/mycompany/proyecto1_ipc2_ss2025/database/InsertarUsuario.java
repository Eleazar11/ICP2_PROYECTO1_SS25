/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database;

import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import java.sql.*;

/**
 *
 * @author eleaz
 */
public class InsertarUsuario {

    private Connection connection;

    public InsertarUsuario(Connection connection) {
        this.connection = connection;
    }

    /**
     * Verifica si el correo electrónico ya existe en la base de datos.
     */
    public boolean correoExiste(String correoElectronico) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo_electronico = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correoElectronico);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     */
    public void registrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre_completo, organizacion, correo_electronico, contrasena, telefono, numero_identificacion, foto_path) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getOrganizacion());
            ps.setString(3, usuario.getCorreoElectronico());
            ps.setString(4, usuario.getContrasena()); // texto plano por ahora
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getNumeroIdentificacion());
            ps.setString(7, usuario.getFotoPath());
            ps.executeUpdate();
        }
    }
}
