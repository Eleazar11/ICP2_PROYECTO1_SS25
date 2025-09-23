/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.InstitucionDAO;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.InsertarUsuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "RegistroUsuariosServlet", urlPatterns = {"/RegistroUsuariosServlet"})
public class RegistroUsuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreCompleto = request.getParameter("nombreCompleto");
        String organizacion = request.getParameter("organizacion");
        String correoElectronico = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");
        String numeroIdentificacion = request.getParameter("numeroIdentificacion");
        String fotoPath = request.getParameter("foto"); // suponiendo que es la ruta del archivo
        TipoUsuario rol = TipoUsuario.valueOf(request.getParameter("rol")); // viene del select

        Usuario usuario = new Usuario(nombreCompleto, organizacion, correoElectronico,
                contrasena, telefono, numeroIdentificacion, fotoPath);

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            InsertarUsuario insertar = new InsertarUsuario(connection);

            if (insertar.usuarioExiste(correoElectronico, numeroIdentificacion)) {
                response.sendRedirect(request.getContextPath() + "/areaAdminSistema/usuarioRepetido.jsp");
                return;
            }

            insertar.registrarUsuario(usuario, rol);

            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
