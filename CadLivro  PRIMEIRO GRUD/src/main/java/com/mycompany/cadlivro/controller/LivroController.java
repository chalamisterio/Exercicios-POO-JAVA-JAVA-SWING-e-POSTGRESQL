package com.mycompany.cadlivro.controller;
import com.mycompany.cadlivro.model.Livro;
import com.mycompany.cadlivro.model.LivroDao;
import com.mycompany.cadlivro.view.LivroView;// Verifique se é Wiew ou View
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 * @author charles
 */
public class LivroController {

    public LivroView view;
    public LivroDao dao;

    public LivroController(LivroView view) {
        this.view = view;
        this.dao = new LivroDao();
    }




    public boolean LivroCadastro(String titulo, String autor, String editora, int numPags) {
        
        if (titulo != null && !titulo.trim().isEmpty()
                && autor != null && !autor.trim().isEmpty()
                && numPags > 0) {

            Livro novoLivro = new Livro(titulo, autor, editora, numPags);
            
            try {
                dao.salvar(novoLivro);
                
                
                view.limparTela();
                return true;
               
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + e.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
            return false;
        }
    }
    
    public String buscaLivro (String tituloBusca){
        
    if (tituloBusca == null || tituloBusca.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Digite um título para buscar.");
        return tituloBusca;
    }

    try {
        Livro v = dao.buscarPorLivro(tituloBusca);

        if (v != null) {
            view.mostrarResultados(v); 
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com o título: " + tituloBusca);
            view.limparTela();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + e.getMessage());
    }
        return null;
}}
     

    
    