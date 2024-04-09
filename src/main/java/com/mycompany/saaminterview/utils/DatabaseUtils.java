/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class DatabaseUtils {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/saam_interview";
            String user = "diegotrevisancc";
            String password = "@";
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Conexão bem sucedida");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados!");
        }
        
        return connection;
    } 
    
}
