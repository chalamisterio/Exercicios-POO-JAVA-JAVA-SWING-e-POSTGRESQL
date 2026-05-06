package com.mycompany.cadlivro.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author charles
 */
public class LivroDao {
public void salvar(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (titulo,autor,editora,numPags) VALUES (?, ?, ?,?)";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getNumPags());
            
            
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
            throw e;
        }
    }
public Livro buscarPorLivro(String titulo) throws SQLException {
        String sql = "SELECT * FROM livros WHERE UPPER(titulo) = UPPER(?)";

        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Livro l = new Livro();
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    l.setEditora(rs.getString("editora"));
                    
                    
                    l.setNumPags(rs.getInt("numPags"));

                    

                    return l; // Retorna o livro encontrado
                }
            }
        }
        return null; // Retorna null se nenhum livro for encontrado
    }
}
