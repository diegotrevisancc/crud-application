/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.control;

import com.mycompany.saaminterview.model.service.EmployeeService;
import com.mycompany.saaminterview.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author diego
 */
public class EmployeeController {
    
    private Connection connection;
    private EmployeeService service;

    public EmployeeController() {
        this.connection = DatabaseUtils.getConnection();
        this.service = new EmployeeService(connection); 
    }
    
    public boolean saveRegister(String name, String date, String salary, boolean status) {
        try {
            this.service.register(name, date, salary, status);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
    
    public ResultSet getEmployees() {
        try {
            ResultSet rs = this.service.getEmployees();
            return rs;
        } catch (Exception exception) {
            return null;
        }
    }
}
