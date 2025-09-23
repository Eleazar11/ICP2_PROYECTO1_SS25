/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoEstadoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import java.sql.*;

/**
 *
 * @author eleaz
 */
public class EditarUsuario {

    private final Connection connection;

    public EditarUsuario(Connection connection) {
        this.connection = connection;
    }

    // Obtener un usuario por su ID
    public Usuario obtenerUsuarioPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getString("nombre_completo"),
                            rs.getString("organizacion"),
                            rs.getString("correo_electronico"),
                            rs.getString("contrasena"),
                            rs.getString("telefono"),
                            rs.getString("numero_identificacion"),
                            rs.getString("foto_path")
                    );
                    usuario.setId_usuario(rs.getInt("id_usuario"));

                    // Coinciden exactamente con los enums
                    usuario.setTipoUsuario(TipoUsuario.valueOf(rs.getString("rol")));
                    usuario.setEstado(TipoEstadoUsuario.valueOf(rs.getString("estado")));

                    return usuario;
                }
            }
        }
        return null;
    }

    // Actualizar usuario
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre_completo=?, correo_electronico=?, telefono=?, "
                + "numero_identificacion=?, foto_path=?, rol=?, estado=? "
                + "WHERE id_usuario=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);

            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getCorreoElectronico());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getNumeroIdentificacion());
            ps.setString(5, usuario.getFotoPath());
            ps.setString(6, usuario.getTipoUsuario().name());
            ps.setString(7, usuario.getEstado().name());
            ps.setInt(8, usuario.getId_usuario());

            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}