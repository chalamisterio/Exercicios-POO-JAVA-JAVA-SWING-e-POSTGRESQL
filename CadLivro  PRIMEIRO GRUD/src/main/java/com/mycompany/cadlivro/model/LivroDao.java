package com.mycompany.cadlivro.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.core.ConnectionFactory;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author charles
 */
public class LivroDao{ 
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
                    l.setId(rs.getInt("id"));
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


 public void excluir(String titulo) throws SQLException {
        String sql = "DELETE FROM livros WHERE UPPER(titulo) = UPPER(?)";
        
        try (Connection conn = Conexao.getConexao(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, titulo);
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas == 0) {
                throw new SQLException("Nenhum veículo encontrado com o modelo: " + titulo);
            }
        }
 }
public void update(Livro livro) throws SQLException {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, editora = ?, numpags = ? WHERE id = ?";
    

        
            // Cria a conexão com o banco
            try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Vincula os valores aos parâmetros da query (?)
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setString(3, livro.getEditora());
        stmt.setInt(4, livro.getNumPags());
stmt.setInt(5, livro.getId());
            // Executa a atualização no banco de dados
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } 
        
    }

 public List<Object[]> consultarTabela() {
        List<Object[]> dados = new ArrayList<>();
        String sql = "SELECT * FROM livros"; // Altere para o nome da sua tabela

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            int colCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                Object[] linha = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    linha[i] = rs.getObject(i + 1);
                }
                dados.add(linha);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar o banco: " + e.getMessage());
        }
        return dados;
    }



}