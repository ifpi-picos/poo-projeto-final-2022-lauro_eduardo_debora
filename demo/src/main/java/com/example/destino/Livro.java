package com.example.destino;

import java.util.Date;

public class Livro{
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private int numCopias;

    public Livro(String titulo, String autor, Date dataPublicacao, int numCopias){
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.numCopias = numCopias;
    }

    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public Date getDataPublicacao() {
        return dataPublicacao;
    }
    
    public int getNumCopias() {
        return numCopias;
    }
    
}