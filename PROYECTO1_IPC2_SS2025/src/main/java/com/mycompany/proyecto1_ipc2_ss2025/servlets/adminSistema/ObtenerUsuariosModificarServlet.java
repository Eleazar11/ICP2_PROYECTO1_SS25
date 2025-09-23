/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.TipoEstadoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "ObtenerUsuariosModificarServlet", urlPatterns = {"/ObtenerUsuariosModificarServlet"})
public class ObtenerUsuariosModificarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Usuario> listaUsuarios = new ArrayList<>();

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            String sql = "SELECT * FROM usuarios";

            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Usuario usuario = new Usuario(
                            rs.getString("nombre_completo"),
                            rs.getString("organizacion"),
                            rs.getString("correo_electronico"),
                            rs.getString("contrasena"),
                            rs.getString("telefono"),
                            rs.getString("numero_identificacion"),
                            rs.getString("foto_path")
                    );
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setTipoUsuario(TipoUsuario.valueOf(rs.getString("rol").toUpperCase()));
                    usuario.setEstado(TipoEstadoUsuario.valueOf(rs.getString("estado").toUpperCase()));

                    listaUsuarios.add(usuario);
                }
            }

            request.setAttribute("usuarios", listaUsuarios);
            request.getRequestDispatcher("/areaAdminSistema/editarUsuario.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
