/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ipc2_ss2025.database;

import java.sql.*;

/**
 *
 * @author eleaz
 */
public class ConexionBaseDeDatos {

    private static final String IP = "localhost";
    private static final int PUERTO = 3306;
    private static final String SCHEMA = "HyruleEventsDB";
    private static final String USER = "hyrule_user";
    private static final String PASSWORD = "Congresos123Cunoc";
    private static final String URL = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + SCHEMA + "?useSSL=false&serverTimezone=UTC";

    private static ConexionBaseDeDatos instance;
    private Connection connection;

    private ConexionBaseDeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public static ConexionBaseDeDatos getInstance() {
        if (instance == null) {
            instance = new ConexionBaseDeDatos();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
