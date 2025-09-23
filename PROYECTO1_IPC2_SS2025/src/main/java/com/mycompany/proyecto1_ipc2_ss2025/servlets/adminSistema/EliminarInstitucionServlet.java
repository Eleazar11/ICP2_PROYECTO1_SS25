/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.EliminarInstitucion;

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
@WebServlet(name = "EliminarInstitucionServlet", urlPatterns = {"/EliminarInstitucionServlet"})
public class EliminarInstitucionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idInstitucion = Integer.parseInt(request.getParameter("idInstitucion"));

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            EliminarInstitucion eliminar = new EliminarInstitucion(connection);

            eliminar.eliminarInstitucionPorId(idInstitucion);

            response.sendRedirect(request.getContextPath() + "/ObtenerInstitucionesEliminarServlet");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}