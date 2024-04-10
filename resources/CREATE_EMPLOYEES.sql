/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  diego
 * Created: 10 de abr. de 2024
 */

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hiring_date DATE NOT NULL,
    salary VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL
);
