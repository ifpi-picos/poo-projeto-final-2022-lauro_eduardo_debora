package com.example.destino;

public class Endereco{
    private String idEndereco;
    private String bairro;
    private String rua;
    private int numero;
    private long cep;

    public Endereco(String idEndereco, String bairro, String rua, int numero, long cep){
        this.idEndereco = idEndereco;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;  
    }
    
    public String getIdEndereco() {
        return idEndereco;
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

    public long getCep() {
        return cep;
    }

}
