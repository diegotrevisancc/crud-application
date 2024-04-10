/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import com.mycompany.saaminterview.model.entity.User;
import com.mycompany.saaminterview.utils.EncodingUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author diego
 */
public class RegisterService extends SQLServices {    
   
    public RegisterService(Connection connection) {
        super(connection);
    }
    
    public void register(String email, String name, String password) {
        try {
            String encodedPassword = EncodingUtils.encodePassword(password);
            if (encodedPassword != null) {
                User register = new User(email, name, encodedPassword);          
                String sql = "INSERT INTO users (email, name, password) VALUES (?, ?, ?)";
                PreparedStatement statement = super.getConnection().prepareStatement(sql);
                statement.setString(1, register.getEmail());
                statement.setString(2, register.getName());
                statement.setString(3, register.getPassword());
                
                int affectedRows = statement.executeUpdate();
            
                if (affectedRows > 0) {
                    System.out.println("Register Created");
                } else {
                    System.out.println("Cant create the register.");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            super.closeConnection();
        }
    }
}
