package com.example.visao;

import java.sql.Date;
import java.util.List;

import com.example.dao.LivroDao;
import com.example.destino.Livro;

public class LivroForm {
    //int String String int Date String int
    public void cadastrarlivro(int id_livro, String nome, String autor, int quant, java.util.Date data, String cpf, int id_area){
        Livro livro = new Livro(id_livro, nome, autor, quant, data, cpf, id_area);
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
