/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author eleaz
 */
public class EliminarInstitucion {

    private final Connection connection;

    public EliminarInstitucion(Connection connection) {
        this.connection = connection;
    }

    // Método para eliminar una institución por su ID
    public void eliminarInstitucionPorId(int idInstitucion) throws SQLException {
        String sql = "DELETE FROM instituciones WHERE id_institucion = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // iniciamos la transacción

            ps.setInt(1, idInstitucion);
            ps.executeUpdate();

            connection.commit(); // confirmamos la eliminación
        } catch (SQLException e) {
            connection.rollback(); // revertimos cambios en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true); // volvemos al estado normal
        }
    }
}