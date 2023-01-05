package com.example.destino;

public class AreaConhecimento{
    private String titulo;
    private String descricao;
    
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
}
