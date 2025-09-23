/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eleaz
 */
public class InsertarUsuario {

    private final Connection connection;

    public InsertarUsuario(Connection connection) {
        this.connection = connection;
    }

    public boolean usuarioExiste(String correoElectronico, String numeroIdentificacion) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo_electronico = ? OR numero_identificacion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correoElectronico);
            ps.setString(2, numeroIdentificacion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void registrarUsuario(Usuario usuario, TipoUsuario tipoUsuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre_completo, foto_path, organizacion, correo_electronico, telefono, numero_identificacion, contrasena, rol, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'ACTIVO')";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // inicio de transacción

            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getFotoPath());
            ps.setString(3, usuario.getOrganizacion());
            ps.setString(4, usuario.getCorreoElectronico());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getNumeroIdentificacion());
            ps.setString(7, usuario.getContrasena());
            ps.setString(8, tipoUsuario.name());

            ps.executeUpdate();
            connection.commit(); // confirmamos la transacción
        } catch (SQLException e) {
            connection.rollback(); // revertimos si hay error
            throw e;
        } finally {
            connection.setAutoCommit(true); // volvemos al estado normal
        }
    }
}