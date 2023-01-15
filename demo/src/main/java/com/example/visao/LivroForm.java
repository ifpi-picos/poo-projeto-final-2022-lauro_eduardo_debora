package com.example.visao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.dao.LivroDao;
import com.example.destino.Livro;

public class LivroForm {
    //int String String int Date String int
    public void cadastrarlivro(int id_livro, String nome, String autor, java.util.Date data, int quant, String cpfFunc, String nomeArea){
        Livro livro = new Livro(id_livro, nome, autor, data, quant, cpfFunc, nomeArea);
        new LivroDao().adicionarLivro(livro);
    }

    public boolean encontrarLivro(String nome, String autor, Date data){
        return new LivroDao().buscarLivro(nome, autor, data);
    }

    public void alterarTitulo(String antTitulo, String titulo, String autor, Date data){
        new LivroDao().alterarTituloLivro(antTitulo, titulo, autor, data);
    }

    public void alterarAutor(String antAutor, String titulo, String autor, Date data){
        new LivroDao().alterarAutorLivro(antAutor, titulo, autor, data);
    }

    public void alterarDataPub(Date antData, String titulo, String autor, Date data){
        new LivroDao().alterarDataLivro(antData, titulo, autor, data);
    }

    public void alterarNumCop(String titulo, String autor, Date data, int num){
        new LivroDao().alterarNumCopiasLivro(titulo, autor, data, num);
    }

    public void removerLivro(String titulo, String autor, Date data){
        new LivroDao().deletarLivro(titulo, autor, data);
    }

    public int totalLivro(String Titulo, String autor){
        return new LivroDao().quantLivro(Titulo, autor);
    }

    public void listarLivros(){
        List<Livro> livrosCadastrados = new LivroDao().buscarlivros();
        List<String> listLivros = new ArrayList<>();
        
        for(int i = 0; i < livrosCadastrados.size(); i++){
            listLivros.add("ID: " + livrosCadastrados.get(i).getId_livro() + ", " + "Título: " + livrosCadastrados.get(i).getTitulo() + ", " + "Autor: " + livrosCadastrados.get(i).getAutor() + ", " + "Publicação: " + livrosCadastrados.get(i).getDataPublicacao() + ", " + "Cópias: " + livrosCadastrados.get(i).getNumCopias() + ", " + "cpfFuncionario: " + livrosCadastrados.get(i).getCpfFunc() + ", " + "Área: " + livrosCadastrados.get(i).getArea());
        }

        String livros = "";
        for(String item : listLivros){
            livros += item + "\n";
        }

        if(livros == ""){
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, livros);
        }
    }

}
