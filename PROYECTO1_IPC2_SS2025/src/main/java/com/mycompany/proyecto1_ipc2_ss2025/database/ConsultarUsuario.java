/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database;

import java.sql.*;

/**
 *
 * @author eleaz
 */
public class ConsultarUsuario {

    private Connection connection;

    public ConsultarUsuario() {
        this.connection = ConexionBaseDeDatos.getInstance().getConnection();
    }

    public String consultarTipoUsuario(String email, String password) throws SQLException {
        String sql = "SELECT rol FROM usuarios WHERE correo_electronico = ? AND contrasena = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("rol");
                }
            }
        }
        return null;
    }
}
