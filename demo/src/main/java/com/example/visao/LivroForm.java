package com.example.visao;

import java.sql.Date;
import java.util.List;

import com.example.dao.LivroDao;
import com.example.destino.Livro;

public class LivroForm {
    //int String String int Date String int
    public void cadastrarlivro(int id_livro, String nome, String autor, java.util.Date data, int quant, String cpfFunc, String nomeArea){
        Livro livro = new Livro(id_livro, nome, autor, data, quant, cpfFunc, nomeArea);
        new LivroDao().adicionarLivro(livro);
    }

    public boolean encontrarLivro(String nome, Date data, String autor){
        return new LivroDao().buscarLivro(nome, autor, data);
    }

    public List<Livro> listarLivros(){
        List<Livro> livrosCadastrados = new LivroDao().buscarlivros();
        return livrosCadastrados;
        /*for(int i = 0; i < usuariosCadastrados.size(); i++){
            System.out.println(usuariosCadastrados.get(i).getNome() + "-" + usuariosCadastrados.get(i).getEmail());
        }*/
    }

}
