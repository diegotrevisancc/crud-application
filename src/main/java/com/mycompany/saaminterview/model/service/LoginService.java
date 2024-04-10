/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.model.service;

import com.mycompany.saaminterview.utils.EncodingUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author diego
 */
public class LoginService extends SQLServices{
    
    public LoginService(Connection connection) {
        super(connection);
    }
    
    public boolean login(String email, String password) {
        try {
            String encodedPassword = EncodingUtils.encodePassword(password);
            if (encodedPassword != null) {
                String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement statement = super.getConnection().prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, encodedPassword);
                
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    return true;
                }
                return false;
            } 
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            super.closeConnection();
        }
        return false;
    }
}
