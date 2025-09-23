/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025;

import com.mycompany.proyecto1_ipc2_ss2025.database.InstitucionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "RegistroUsuarioFormServlet", urlPatterns = {"/registroUsuario"})
public class RegistroUsuarioFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            InstitucionDAO institucionDAO = new InstitucionDAO();
            List<String> instituciones = institucionDAO.obtenerInstituciones();
            request.setAttribute("instituciones", instituciones);

            // Redirigir al JSP del formulario
            request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
