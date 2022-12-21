package com.example.destino;

import java.util.Date;

public class Livro{
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private int numCopias = 0;

    public Livro(String titulo, String autor, /*Date dataPublicacao,*/ int numCopias){
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

    public void setNumCopias(int num){
        this.numCopias = num;
    }

    public void setTitulo(String nome){
        this.titulo = nome;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setData(Date data){
        this.dataPublicacao = data;
    }
    
}