/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025;

import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;
import com.mycompany.proyecto1_ipc2_ss2025.database.InsertarUsuario;
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
import java.sql.SQLIntegrityConstraintViolationException;

/**
 *
 * @author eleaz
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Recibir datos del formulario
            String nombreCompleto = request.getParameter("nombreCompleto");
            String organizacion = request.getParameter("organizacion");
            String correoElectronico = request.getParameter("correoElectronico");
            String contrasena = request.getParameter("contrasena");
            String telefono = request.getParameter("telefono");
            String numeroIdentificacion = request.getParameter("numeroIdentificacion");

            // Subida de foto (opcional)
            Part fotoPart = request.getPart("foto");
            String fotoPath = null;
            if (fotoPart != null && fotoPart.getSize() > 0) {
                String fileName = Path.of(fotoPart.getSubmittedFileName()).getFileName().toString();
                // Carpeta uploads en la raíz del proyecto
                String projectPath = System.getProperty("user.dir");
                String uploadPath = projectPath + File.separator + "uploads" + File.separator;
                Files.createDirectories(Paths.get(uploadPath));
                fotoPart.write(uploadPath + fileName);
                fotoPath = "uploads/" + fileName;
            }

            // Usar DAO con Singleton
            InsertarUsuario insertarUsuario = new InsertarUsuario();

            // Verificar si el correo ya existe
            if (insertarUsuario.correoExiste(correoElectronico)) {
                response.sendRedirect(request.getContextPath() + "/usuarioRepetido.jsp");
                return;
            }

            // Crear objeto usuario
            Usuario usuario = new Usuario(
                    nombreCompleto,
                    organizacion,
                    correoElectronico,
                    contrasena,
                    telefono,
                    numeroIdentificacion,
                    fotoPath
            );

            // Insertar usuario en la base de datos
            insertarUsuario.registrarUsuario(usuario);
            response.sendRedirect(request.getContextPath() + "/confirmacion.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
