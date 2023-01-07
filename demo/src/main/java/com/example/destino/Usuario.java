package com.example.destino;

import java.util.Date;
import java.util.List;

public class Usuario{
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private Date dataNascimento;
    private String idEndereco;
    private String cpfFuncionario;
    
    
    /* public Usuario(String Nome_p, String email, String Senha, String Cpf, Endereco endereco){
        this.cpf = Cpf;
        this.nome = Nome_p;
        this.senha = Senha;
        this.email = email;
        // this.dataNascimento = dataNascimento;
        // this.endereco = endereco;
    } */

    public Usuario(String cpf, String nome, String email, String senha, Date datanascimento, String endereco, String cpfFuncionario){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = datanascimento;
        this.idEndereco = endereco;
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCpf(){
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Date getDataNasc(){
        return dataNascimento;
    }

    public String getIdEndereco() {
        return idEndereco;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }
}

