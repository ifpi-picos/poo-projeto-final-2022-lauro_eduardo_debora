package com.example.destino;

public class Endereco {
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

}
