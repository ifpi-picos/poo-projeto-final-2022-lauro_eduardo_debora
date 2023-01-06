package com.example.visao;

import java.util.List;

import com.example.dao.EnderecoDao;
import com.example.destino.Endereco;

public class EnderecoForm {

    public void cadastrarEndereco(String id_endereco, String bairro, String rua, int numero, long cep){
        Endereco endereco = new Endereco(id_endereco, bairro, rua, numero, cep);
        new EnderecoDao().adicionarEndereco(endereco);
    }

    public void listarEnderecos(){
        List<Endereco> usuariosCadastrados = new EnderecoDao().buscarEnderecos();
        
        for(int i = 0; i < usuariosCadastrados.size(); i++){
            System.out.println(usuariosCadastrados.get(i).getIdEndereco() + "-" + usuariosCadastrados.get(i).getBairro());
        }
    }

    public void cadastrarEndereco(String id_endere, String bairro_p, String rua_p, String numero_p, String cep_p) {
    }
    
}
