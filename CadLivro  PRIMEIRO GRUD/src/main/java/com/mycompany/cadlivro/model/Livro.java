/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadlivro.model;

import com.mycompany.cadlivro.controller.LivroController;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author charles
 */
public class Livro {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private String titulo;
    private String autor;
private String editora;
private int numPags;
private int pagAtual=0;
private int pagina =0;
public Livro(){}

    public Livro(String titulo, String autor, String editora, int numPags) {
    
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora; // agora está correto
    this.numPags = numPags;
}

  

  
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editara) {
        this.editora = editara;
    }

    public int getNumPags() {
        return numPags;
    }

    public void setNumPags(int numPags) {
        this.numPags = numPags;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }


   
   public int viraPaginaMais(){
       if(pagina < getNumPags()){
           pagina  +=1;
       } else {
           JOptionPane.showMessageDialog(null,"Livro Chegou a Ultima Página");
       }
       
       return this.pagina;
}
    
  public int viraPaginaMenos(){
      if(pagina <= 0){
          JOptionPane.showMessageDialog(null,"Livro Chegou a Pagina 0");
      }else{
        pagina -=1;
      }
      return this.pagina;
  }  
    
}
