/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.EditarInstitucion;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ModeloInstitucion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "EditarInstitucionServlet", urlPatterns = {"/EditarInstitucionServlet"})
public class EditarInstitucionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idInstitucion = Integer.parseInt(request.getParameter("id"));

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            EditarInstitucion editar = new EditarInstitucion(connection);

            ModeloInstitucion institucion = editar.obtenerInstitucionPorId(idInstitucion);
            request.setAttribute("institucion", institucion);

            request.getRequestDispatcher("/areaAdminSistema/editarInstitucion.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idInstitucion = Integer.parseInt(request.getParameter("idInstitucion"));
        String nombreInstitucion = request.getParameter("nombreInstitucion");
        String descripcion = request.getParameter("descripcion");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            EditarInstitucion editar = new EditarInstitucion(connection);

            ModeloInstitucion institucion = new ModeloInstitucion(
                    idInstitucion, nombreInstitucion, descripcion, direccion, telefono);

            editar.actualizarInstitucion(institucion);

            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}