/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadlivro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author charles
 */
public class Conexao {
 public static Connection getConexao() {
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/biblioteca", "postgres", "33949910");
        } catch (SQLException e) {
e.printStackTrace();
            // Removed 'this' because the method is static
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null; // The method must return something
        }
    }
}
