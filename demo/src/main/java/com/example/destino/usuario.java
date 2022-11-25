package com.example.destino;

public class usuario {
    private String Nome;
    private String e_mail;
    private int senha;
    private String cpf;
    
    public usuario(String Nome_p, String email, int Senha, String Cpf){
        this.cpf = Cpf;
        this.Nome = Nome_p;
        this.senha = Senha;
        this.e_mail = email;

    }

    public String getcpf(){
        return cpf;
    }

    public String getemail(){
        return e_mail;
    }

    public int getsenha() {
        return senha;
    }

}

