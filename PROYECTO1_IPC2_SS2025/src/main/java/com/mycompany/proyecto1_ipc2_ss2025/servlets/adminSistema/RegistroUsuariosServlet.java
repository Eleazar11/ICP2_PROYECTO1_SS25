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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "RegistroUsuariosServlet", urlPatterns = {"/RegistroUsuariosServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,    // 1 MB
                 maxFileSize = 1024 * 1024 * 5,     // 5 MB
                 maxRequestSize = 1024 * 1024 * 25) // 25 MB
public class RegistroUsuariosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 📌 Campos de texto del formulario
            String nombreCompleto = request.getParameter("nombreCompleto");
            String organizacion = request.getParameter("organizacion");
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");
            String telefono = request.getParameter("telefono");
            String numeroIdentificacion = request.getParameter("numeroIdentificacion");

            // 📌 Archivo de foto
            Part fotoPart = request.getPart("foto");
            String fotoPath = null;
            if (fotoPart != null && fotoPart.getSize() > 0) {
                String fileName = Path.of(fotoPart.getSubmittedFileName()).getFileName().toString();

                // Carpeta "uploads" dentro del directorio del proyecto desplegado en Tomcat
                String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads";
                Files.createDirectories(Paths.get(uploadDir));

                String fullPath = uploadDir + File.separator + fileName;
                fotoPart.write(fullPath);

                // Guardamos la ruta relativa (útil para mostrar en JSP)
                fotoPath = "uploads/" + fileName;
            }

            // 📌 Rol (desde el <select>)
            String rolStr = request.getParameter("rol");
            if (rolStr == null || rolStr.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
                return;
            }
            TipoUsuario rol = TipoUsuario.valueOf(rolStr);

            // 📌 Crear objeto Usuario
            Usuario usuario = new Usuario(
                    nombreCompleto,
                    organizacion,
                    correoElectronico,
                    contrasena,
                    telefono,
                    numeroIdentificacion,
                    fotoPath
            );

            // 📌 Guardar en la base de datos
            Connection connection = ConexionBaseDeDatos.getInstance().getConnection();
            InsertarUsuario insertar = new InsertarUsuario(connection);

            if (insertar.usuarioExiste(correoElectronico, numeroIdentificacion)) {
                response.sendRedirect(request.getContextPath() + "/areaAdminSistema/usuarioRepetido.jsp");
                return;
            }

            insertar.registrarUsuario(usuario, rol);
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/confirmacion.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/areaAdminSistema/error.jsp");
        }
    }
}
