package com.example.destino;

import java.util.List;

public class AreaConhecimento{
    private String titulo;
    private String descricao;
    private int id;
    private List<Livro> livro;
    
    public AreaConhecimento(String titu, String descri, int ide){
        this.titulo = titu;
        this.descricao = descri;
        this.id = ide;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getdescricao(){
        return descricao;
    }

    public int getId(){
        return id;
    }

    public void setLivro(Livro li){
        livro.add(li);
    }
}
