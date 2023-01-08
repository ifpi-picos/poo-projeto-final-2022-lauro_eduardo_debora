package com.example.destino;

import java.util.Date;

public class Livro{
    private int id_livro;
    private String titulo;
    private String autor;
    private Date dataPublicacao;
    private int numCopias = 0;
    private String cpfFunc;
    private String area;

    //String String String int Date String int

    public Livro(int idlivro,String titulo, String autor, Date dataPublicacao, int numCopias, String cpffuncionario, String area){
        this.id_livro = idlivro;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.numCopias = numCopias;
        this.cpfFunc = cpffuncionario;
        this.area = area;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getCpfFunc() {
        return cpfFunc;
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

    public String getArea() {
        return area;
    }

    public int getId_livro() {
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