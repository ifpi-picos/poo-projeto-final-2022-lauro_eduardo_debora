package com.example.destino;

import java.util.Date;

public class Livro{
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private int numCopias = 0;
    private int id_area;
    private int id_livro;
    private String CPF;

    //String String String int Date String int

    public Livro(int idlivro,String titulo, String autor, int numCopias, Date dataPublicacao, String cpffuncionario, int idArea){
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.numCopias = numCopias;
        this.CPF = cpffuncionario;
        this.id_livro = idlivro;
        this.id_area = idArea;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getCPFfuncionario(){
        return CPF;
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

    public int getIdarea() {
        return id_area;
    }

    public int getIdlivro() {
        return id_livro;
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