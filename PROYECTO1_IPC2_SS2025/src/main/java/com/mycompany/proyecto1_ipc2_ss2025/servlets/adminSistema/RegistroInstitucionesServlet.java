/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.InsertarInstitucion;
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
@WebServlet(name = "RegistroInstitucionesServlet", urlPatterns = {"/RegistroInstitucionesServlet"})
public class RegistroInstitucionesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreInstitucion = request.getParameter("nombreInstitucion");
        String descripcion = request.getParameter("descripcion");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            InsertarInstitucion insertarInstitucion = new InsertarInstitucion(connection);

            // Verificar si ya existe
            if (insertarInstitucion.institucionExiste(nombreInstitucion)) {
                response.sendRedirect(request.getContextPath() + "/areaAdminSistema/institucionRepetida.jsp");
                return;
            }

            // Crear objeto
            ModeloInstitucion institucion = new ModeloInstitucion(nombreInstitucion, descripcion, direccion, telefono);
            insertarInstitucion.registrarInstitucion(institucion);

            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }}
