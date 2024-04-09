/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saaminterview.control;

import com.mycompany.saaminterview.model.service.RegisterService;
import com.mycompany.saaminterview.utils.DatabaseUtils;
import java.sql.Connection;

/**
 *
 * @author diego
 */
public class RegisterController {
    private Connection connection;
    private RegisterService service;

    public RegisterController() {
        this.connection = DatabaseUtils.getConnection();
        this.service = new RegisterService(connection); 
    }
    
    public boolean saveRegister(String email, String name, String password) {
        try {
            this.service.register(email, name, password);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
