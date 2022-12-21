package com.example.destino;

public class Funcionario{
    private String nome;
    private String CPF;
    private String senha;
    private String id;

    public Funcionario(String nome, String CPF, String senha, String id){
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.id = id;
        
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getId(){
        return id;
    }

    public String getSenha() {
        return senha;
    }
}
