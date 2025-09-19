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

    public InsertarUsuario() {
        this.connection = ConexionBaseDeDatos.getInstance().getConnection();
    }

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

    public void registrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre_completo, organizacion, correo_electronico, contrasena, telefono, numero_identificacion, foto_path) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Desactivar auto-commit para iniciar la transacción
            connection.setAutoCommit(false);

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, usuario.getNombreCompleto());
                ps.setString(2, usuario.getOrganizacion());
                ps.setString(3, usuario.getCorreoElectronico());
                ps.setString(4, usuario.getContrasena());
                ps.setString(5, usuario.getTelefono());
                ps.setString(6, usuario.getNumeroIdentificacion());
                ps.setString(7, usuario.getFotoPath());

                ps.executeUpdate();
            }

            // Confirmar la transacción
            connection.commit();

        } catch (SQLException e) {
            // En caso de error, deshacer cambios
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            throw e; // Re-lanzar la excepción para que el servlet maneje el error
        } finally {
            // Restaurar el auto-commit
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
