/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import com.mycompany.saaminterview.model.entity.Register;
import com.mycompany.saaminterview.utils.DatabaseUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author diego
 */
public class RegisterService {
    private Connection connection;
    
    public RegisterService(Connection connection) {
        this.connection = connection;
    }
    
    public void register(String email, String name, String password) {
        try {
            String encodedPassword = this.encodePassword(password);
            if (encodedPassword != null) {
                Register register = new Register(email, name, encodedPassword);          
                String sql = "INSERT INTO users (email, name, password) VALUES (?, ?, ?)";
                PreparedStatement statement = this.connection.prepareStatement(sql);
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
        }
    }
    
    private String encodePassword(String password) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
            return new String(messageDigest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
