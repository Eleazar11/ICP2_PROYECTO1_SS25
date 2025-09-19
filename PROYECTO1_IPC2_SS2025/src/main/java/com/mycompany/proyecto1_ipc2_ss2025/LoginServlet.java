/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConsultarUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author eleaz
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Instancia de la clase ConsultarUsuario (ya usa el Singleton)
        ConsultarUsuario consultarUsuario = new ConsultarUsuario();

        try {
            // Verificar si el usuario es válido
            String tipoUsuario = consultarUsuario.consultarTipoUsuario(email, password);

            if (tipoUsuario != null) {
                // Si las credenciales son válidas, crear una sesión y redirigir al usuario
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("tipoUsuario", tipoUsuario);

                // Redirigir según el tipo de usuario
                switch (tipoUsuario) {
                    case "USUARIO":
                        response.sendRedirect("areaUsuario/vistaUsuario.jsp");
                        break;
                    case "ADMIN_SISTEMA":
                        response.sendRedirect("areaAdminSistema/vistaAdminSistema.jsp");
                        break;
                    default:
                        response.sendRedirect("index.jsp"); // En caso de que no haya coincidencia
                }
            } else {
                // Si las credenciales no son válidas, mostrar un mensaje de error
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }
}
