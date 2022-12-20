package com.example.destino;

public class Endereco{
    private String bairro;
    private String rua;
    private int numero;
    private int cep;

    public Endereco(String bairro, String rua, int numero, int cep){
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public int getCep() {
        return cep;
    }

}
