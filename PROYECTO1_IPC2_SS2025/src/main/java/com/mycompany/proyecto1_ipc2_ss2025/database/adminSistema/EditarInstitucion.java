/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import java.sql.*;

/**
 *
 * @author eleaz
 */
public class EditarInstitucion {

    private final Connection connection;

    public EditarInstitucion(Connection connection) {
        this.connection = connection;
    }

    // Obtener una institución por su ID
    public ModeloInstitucion obtenerInstitucionPorId(int idInstitucion) throws SQLException {
        String sql = "SELECT * FROM instituciones WHERE id_institucion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idInstitucion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ModeloInstitucion(
                            rs.getInt("id_institucion"),
                            rs.getString("nombre_institucion"),
                            rs.getString("descripcion"),
                            rs.getString("direccion"),
                            rs.getString("telefono")
                    );
                }
            }
        }
        return null;
    }

    // Actualizar institución con manejo de transacciones
    public void actualizarInstitucion(ModeloInstitucion institucion) throws SQLException {
        String sql = "UPDATE instituciones "
                + "SET nombre_institucion = ?, descripcion = ?, direccion = ?, telefono = ? "
                + "WHERE id_institucion = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false); // iniciamos la transacción

            ps.setString(1, institucion.getNombreInstitucion());
            ps.setString(2, institucion.getDesccripcion());
            ps.setString(3, institucion.getDireccion());
            ps.setString(4, institucion.getTelefono());
            ps.setInt(5, institucion.getIdInstitucion());

            ps.executeUpdate();
            connection.commit(); // confirmamos la transacción
        } catch (SQLException e) {
            connection.rollback(); // revertimos cambios en caso de error
            throw e;
        } finally {
            connection.setAutoCommit(true); // volvemos al estado normal
        }
    }
}
