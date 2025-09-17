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

    public ConsultarUsuario(Connection connection) {
        this.connection = connection;
    }

    /**
     * Consulta el usuario en la base de datos con su nombre de usuario y contraseña.
     * 
     * @param email El nombre de usuario
     * @param password La contraseña del usuario
     * @return El tipo de usuario (editor, administrador, suscriptor, especial) o null si las credenciales no son válidas.
     * @throws SQLException En caso de error en la base de datos
     */
    public String consultarTipoUsuario(String email, String password) throws SQLException {
        String sql = "SELECT rol FROM usuarios WHERE correo_electronico = ? AND contrasena = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si el usuario existe, devolver el tipo de usuario
                    return rs.getString("rol");
                } else {
                    // Si no se encuentra, retornar null
                    return null;
                }
            }
        }
    }
}
