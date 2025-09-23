/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.servlets.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.TipoEstadoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema.EditarUsuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "EditarUsuariosServlet", urlPatterns = {"/EditarUsuariosServlet"})
public class EditarUsuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String nombreCompleto = request.getParameter("nombreCompleto");
        String correo = request.getParameter("correoElectronico");
        String telefono = request.getParameter("telefono");
        String identificacion = request.getParameter("numeroIdentificacion");
        String fotoPath = request.getParameter("fotoPath");
        String rol = request.getParameter("rol");
        String estado = request.getParameter("estado");

        try {
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            EditarUsuario editar = new EditarUsuario(connection);

            Usuario usuario = new Usuario(
                    nombreCompleto, "", correo, "", telefono, identificacion, fotoPath
            );
            usuario.setId_usuario(idUsuario);
            usuario.setTipoUsuario(TipoUsuario.valueOf(rol.toUpperCase()));
            usuario.setEstado(TipoEstadoUsuario.valueOf(estado.toUpperCase()));

            editar.actualizarUsuario(usuario);

            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
