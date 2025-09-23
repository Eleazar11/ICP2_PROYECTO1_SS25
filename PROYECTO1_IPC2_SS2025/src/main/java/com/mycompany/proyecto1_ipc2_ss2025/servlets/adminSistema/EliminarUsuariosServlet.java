/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;


import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.EliminarUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author eleaz
 */
@WebServlet(name = "EliminarUsuariosServlet", urlPatterns = {"/EliminarUsuariosServlet"})
public class EliminarUsuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            EliminarUsuario eliminar = new EliminarUsuario(connection);

            eliminar.eliminarPorId(idUsuario);

            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
