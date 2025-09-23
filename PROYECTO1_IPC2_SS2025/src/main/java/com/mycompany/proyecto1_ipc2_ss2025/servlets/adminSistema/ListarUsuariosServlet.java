/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.ListarUsuarios;

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
@WebServlet(name = "ListarUsuariosServlet", urlPatterns = {"/ListarUsuariosServlet"})
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ListarUsuarios listar = new ListarUsuarios();
            List<Usuario> usuarios = listar.obtenerTodosUsuarios();

            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("/areaAdminSistema/listarUsuarios.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}