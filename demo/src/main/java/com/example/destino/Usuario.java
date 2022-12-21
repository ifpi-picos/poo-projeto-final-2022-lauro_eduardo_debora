package com.example.destino;

import java.util.Date;

public class Usuario{
    private String Nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dataNascimento;
    private Endereco endereco;
    private Boolean confirma;
    
    
    public Usuario(String Nome_p, String email, String Senha, String Cpf, Date dataNascimento,Endereco endereco){
        this.cpf = Cpf;
        this.Nome = Nome_p;
        this.senha = Senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getCpf(){
        return cpf;
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

}

