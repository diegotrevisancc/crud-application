/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public abstract class SQLServices {

    private Connection connection;

    public SQLServices(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("connection closed");
    }

    public Connection getConnection() {
        return connection;
    }
}
