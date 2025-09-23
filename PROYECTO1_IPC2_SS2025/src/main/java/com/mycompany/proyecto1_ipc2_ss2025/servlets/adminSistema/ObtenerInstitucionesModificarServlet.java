/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ModeloInstitucion;
import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "ObtenerInstitucionesModificarServlet", urlPatterns = {"/ObtenerInstitucionesModificarServlet"})
public class ObtenerInstitucionesModificarServlet extends HttpServlet {

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
            // Cambiamos el JSP al que ahora contendrá la tabla y los modals
            request.getRequestDispatcher("/areaAdminSistema/editarInstitucion.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
