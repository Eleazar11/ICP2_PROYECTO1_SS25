/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database;

import java.sql.*;
import java.util.*;

/**
 *
 * @author eleaz
 */
public class InstitucionDAO {
    private Connection connection;

    public InstitucionDAO() {
        this.connection = ConexionBaseDeDatos.getInstance().getConnection();
    }

    public List<String> obtenerInstituciones() throws SQLException {
        List<String> instituciones = new ArrayList<>();
        String sql = "SELECT nombre_institucion FROM instituciones ORDER BY nombre_institucion ASC";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                instituciones.add(rs.getString("nombre_institucion"));
            }
        }
        return instituciones;
    }
}
