/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ListarInstituciones;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ModeloInstitucion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "ListarInstitucionesServlet", urlPatterns = {"/ListarInstitucionesServlet"})
public class ListarInstitucionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ListarInstituciones listar = new ListarInstituciones();
            List<ModeloInstitucion> instituciones = listar.obtenerTodasInstituciones();

            request.setAttribute("instituciones", instituciones);
            request.getRequestDispatcher("/areaAdminSistema/listarInstituciones.jsp")
                   .forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}