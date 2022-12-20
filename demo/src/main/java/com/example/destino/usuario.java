package com.example.destino;

public class Usuario{
    private String Nome;
    private String e_mail;
    private String senha;
    private String cpf;
    private Endereco endereco;
    private Boolean confirma;
    
    
    public Usuario(String Nome_p, String email, String Senha, String Cpf, Endereco endereco){
        this.cpf = Cpf;
        this.Nome = Nome_p;
        this.senha = Senha;
        this.e_mail = email;
        this.endereco = endereco;

    }

    public String getcpf(){
        return cpf;
    }

    public String getemail(){
        return e_mail;
    }

    public String getsenha() {
        return senha;
    }

}

