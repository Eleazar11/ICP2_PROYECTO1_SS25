/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import java.sql.*;

/**
 *
 * @author eleaz
 */
public class EliminarUsuario {

    private final Connection connection;

    public EliminarUsuario(Connection connection) {
        this.connection = connection;
    }

    public void eliminarPorId(int idUsuario) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            ps.setInt(1, idUsuario);
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
