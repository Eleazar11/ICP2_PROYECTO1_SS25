/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ModeloInstitucion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "ObtenerInstitucionesEliminarServlet", urlPatterns = {"/ObtenerInstitucionesEliminarServlet"})
public class ObtenerInstitucionesEliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<ModeloInstitucion> listaInstituciones = new ArrayList<>();

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
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

            request.setAttribute("instituciones", listaInstituciones);
            request.getRequestDispatcher("/areaAdminSistema/eliminarInstitucion.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
