/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import com.mycompany.saaminterview.model.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author diego
 */
public class EmployeeService {
    private Connection connection;
    
    public EmployeeService(Connection connection) {
        this.connection = connection;
    }

    public void register(String name, String date, String salary, boolean status) {
        try {
            Employee register = new Employee(name, date, salary, status);
            String sql = "INSERT INTO employees (name, hiring_date, salary, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(sql);
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
        }
    }
    
    private Date dateFormater(String date) {
        Date sqlDate = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            sqlDate = Date.valueOf(date.substring(6, 10) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2));
        } catch (IllegalArgumentException  exception) {
            System.out.println("Could not format date inside EmployeeService");
            exception.printStackTrace();
        }
        return sqlDate;
    }
}
