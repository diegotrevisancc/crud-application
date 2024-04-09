/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.control;

import com.mycompany.saaminterview.model.service.LoginService;
import com.mycompany.saaminterview.utils.DatabaseUtils;
import java.sql.Connection;

/**
 *
 * @author diego
 */
public class LoginController {
    private Connection connection;
    private LoginService service;

    public LoginController() {
        this.connection = DatabaseUtils.getConnection();
        this.service = new LoginService(connection); 
    }
    
    public boolean login(String email, String password) {
        try {
            boolean login = this.service.login(email, password);
            return login;
        } catch (Exception exception) {
            return false;
        }
    }
}
