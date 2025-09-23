package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;


import com.mycompany.proyecto1_ipc2_ss2025.database.InstitucionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eleaz
 */
@WebServlet(name = "RegistroUsuarioFormServletAdmin", urlPatterns = {"/registroUsuarioAdmin"})
public class RegistroUsuarioFormServletAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InstitucionDAO institucionDAO = new InstitucionDAO();
            List<String> instituciones = institucionDAO.obtenerInstituciones();
            request.setAttribute("instituciones", instituciones);

            // Redirigir al JSP del formulario
            request.getRequestDispatcher("/areaAdminSistema/registroUsuarios.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
