/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database.adminSistema;

import com.mycompany.proyecto1_ipc2_ss2025.Usuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.TipoEstadoUsuario;
import com.mycompany.proyecto1_ipc2_ss2025.database.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eleaz
 */
public class ListarUsuarios {

    private final Connection connection;

    public ListarUsuarios() throws SQLException {
        this.connection = ConexionBaseDeDatos.getInstance().getConnection();
    }

    public List<Usuario> obtenerTodosUsuarios() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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
        return listaUsuarios;
    }
}