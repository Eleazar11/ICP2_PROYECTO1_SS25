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
public class InsertarInstitucion {

    private Connection connection;

    public InsertarInstitucion(Connection connection) {
        this.connection = connection;
    }

    public boolean institucionExiste(String nombreInstitucion) throws SQLException {
        String sql = "SELECT COUNT(*) FROM instituciones WHERE nombre_institucion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombreInstitucion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void registrarInstitucion(ModeloInstitucion institucion) throws SQLException {
        String sql = "INSERT INTO instituciones (nombre_institucion, descripcion, direccion, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, institucion.getNombreInstitucion());
            ps.setString(2, institucion.getDesccripcion());
            ps.setString(3, institucion.getDireccion());
            ps.setString(4, institucion.getTelefono());
            ps.executeUpdate();
        }
    }
}
