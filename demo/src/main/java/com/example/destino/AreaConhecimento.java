package com.example.destino;

import java.util.List;

public class AreaConhecimento{
    private String titulo;
    private String descricao;
    private List<Livro> livro;
    
    public AreaConhecimento(String titu, String descri){
        this.titulo = titu;
        this.descricao = descri;
    }

    public String gettitulo(){
        return titulo;
    }

    public String getdescricao(){
        return descricao;
    }

    public void setLivro(Livro li){
        livro.add(li);
    }
}
