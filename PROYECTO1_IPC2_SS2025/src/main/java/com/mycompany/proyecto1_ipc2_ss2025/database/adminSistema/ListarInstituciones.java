/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eleaz
 */
public class ListarInstituciones {

    private final Connection connection;

    public ListarInstituciones() {
        this.connection = ConexionBaseDeDatos.getInstance().getConnection();
    }

    public List<ModeloInstitucion> obtenerTodasInstituciones() throws SQLException {
        List<ModeloInstitucion> listaInstituciones = new ArrayList<>();
        String sql = "SELECT * FROM instituciones";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ModeloInstitucion institucion = new ModeloInstitucion(
                        rs.getInt("id_institucion"),
                        rs.getString("nombre_institucion"),
                        rs.getString("descripcion"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
                listaInstituciones.add(institucion);
            }
        }

        return listaInstituciones;
    }
}
