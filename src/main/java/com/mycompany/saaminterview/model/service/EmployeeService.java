/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import com.mycompany.saaminterview.model.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class EmployeeService extends SQLServices {

    public EmployeeService(Connection connection) {
        super(connection);
    }

    public void register(String name, String date, String salary, boolean status) {
        try {
            Employee register = new Employee(name, date, salary, status);
            String sql = "INSERT INTO employees (name, hiring_date, salary, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = super.getConnection().prepareStatement(sql);
            statement.setString(1, register.getName());
            statement.setDate(2, this.dateFormater(register.getHiringDate()));
            statement.setString(3, register.getSalary());
            statement.setBoolean(4, register.isStatus());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Register Created");
            } else {
                System.out.println("Cant create the register.");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            super.closeConnection();
        }
    }

    public ResultSet getEmployees() {
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM employees";
            PreparedStatement statement = super.getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (Exception exception) {
            System.out.println("Can't get employees from the database");
            exception.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return resultSet;
    }

    private Date dateFormater(String date) {
        Date sqlDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            sqlDate = Date.valueOf(date.substring(6, 10) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2));
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not format date inside EmployeeService");
            exception.printStackTrace();
        }
        return sqlDate;
    }
}
