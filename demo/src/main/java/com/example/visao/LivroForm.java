package com.example.visao;

import java.util.Date;
import java.util.List;

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

    public List<Livro> listarLivros(){
        List<Livro> livrosCadastrados = new LivroDao().buscarlivros();
        return livrosCadastrados;
        /*for(int i = 0; i < usuariosCadastrados.size(); i++){
            System.out.println(usuariosCadastrados.get(i).getNome() + "-" + usuariosCadastrados.get(i).getEmail());
        }*/
    }

}
