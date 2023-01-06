package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Endereco;

public class EnderecoDao {

    Connection conexao;

    public EnderecoDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void adicionarEndereco(Endereco endereco){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into enderecos (id_endereco, bairro, rua, numero, cep) values ('"+endereco.getIdEndereco()+"', '"+endereco.getBairro()+"', '"+endereco.getRua()+"', '"+endereco.getNumero()+"', '"+endereco.getCep()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Endereco> buscarEnderecos(){
        String sql = "select id_endereco, bairro, rua, numero, cep from enderecos";
        List<Endereco> enderecos = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){
                enderecos.add(new Endereco(result.getString("id_endereco"), result.getString("bairro"), result.getString("rua"), result.getInt("numero"), result.getLong("cep")));
            }

            return enderecos;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
    
}
