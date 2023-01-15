package com.example.visao;

import com.example.dao.EnderecoDao;
import com.example.destino.Endereco;

public class EnderecoForm {

    public void cadastrarEndereco(String id_endereco, String bairro, String rua, int numero, long cep){
        Endereco endereco = new Endereco(id_endereco, bairro, rua, numero, cep);
        new EnderecoDao().adicionarEndereco(endereco);
    }
    
}
