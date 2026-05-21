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
    
    private static Livro LIVRO_ATUAL = null;
    
    private LivroView view;
    private LivroDao dao;

    public LivroController(LivroView view) {
        this.view = view;
        this.dao = new LivroDao();
    }

   

    public LivroView getView() {
        return view;
    }

    public LivroDao getDao() {
        return dao;
    }

    public void setView(LivroView view) {
        this.view = view;
    }

    public void setDao(LivroDao dao) {
        this.dao = dao;
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
    
    public String buscaLivro (String tituloBusca,int auxi){
        
    if (tituloBusca == null || tituloBusca.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Digite um título para buscar.");
        return tituloBusca;
    }

    try {
        LIVRO_ATUAL = dao.buscarPorLivro(tituloBusca);

        if (LIVRO_ATUAL != null) {
            view.mostrarResultados(LIVRO_ATUAL,auxi);
            
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com o título: " + tituloBusca);
            view.limparTela();
            
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar no banco: " + e.getMessage());
    }
        return null;
}
    public int viraPaginaMais() {
      return LIVRO_ATUAL.viraPaginaMais();
    }                                              
public int viraPagianaMenos(){
    return LIVRO_ATUAL.viraPaginaMenos();
}
public void excluirLivro(String LivroExcluido){
     if (LivroExcluido.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Digite o Livro para excluir.");
        return;
    }

    int resposta = JOptionPane.showConfirmDialog(null, "Excluir " + LivroExcluido + "?", "Confirmar", JOptionPane.YES_NO_OPTION);

    if (resposta == JOptionPane.YES_OPTION) {
        try {
            LivroDao dao = new LivroDao();
            dao.excluir(LivroExcluido);

            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
            view.limparExcluido(); // Limpa a tela após excluir
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        }
    
}

}

public boolean atualizarLivro(String titulo, String autor, String editora, int numPags) {
        // 1. Verifica se existe um livro buscado/selecionado na memória para ser atualizado
        if (LIVRO_ATUAL == null) {
            JOptionPane.showMessageDialog(null, "Busque um livro antes de tentar atualizá-lo.");
            return false;
        }

        // 2. Validação simples dos dados vindos da tela
        if (titulo != null && !titulo.trim().isEmpty()
                && autor != null && !autor.trim().isEmpty()
                && numPags > 0) {

            try {
                // 3. Modifica o objeto que já está na memória com os novos dados digitados na View
                LIVRO_ATUAL.setTitulo(titulo);
                LIVRO_ATUAL.setAutor(autor);
                LIVRO_ATUAL.setEditora(editora);
                LIVRO_ATUAL.setNumPags(numPags);

                // 4. Manda para o DAO fazer o UPDATE usando o ID que está guardado no LIVRO_ATUAL
                dao.update(LIVRO_ATUAL);

                JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
                view.limparTelaUpdate();
                
                // Limpa o estado atual para o próximo ciclo
                LIVRO_ATUAL = null; 
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco: " + e.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente.");
            return false;
        }


}
}

    
    