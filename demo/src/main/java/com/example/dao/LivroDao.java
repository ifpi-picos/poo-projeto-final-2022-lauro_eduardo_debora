package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Livro;


public class LivroDao {
    
    Connection conexao;

    public LivroDao(){
        conexao = ConexaoDao.getConexao();
    }

   /*  public void adicionarUsuario(Livro livro){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into livros (titulo, autor, data_publicacao, num_copias, cpf_funcionario, ) values ('"+usuario.getCpf()+"', '"+usuario.getNome()+"', '"+usuario.getEmail()+"', '"+usuario.getSenha()+"', '"+usuario.getDataNasc()+"', '"+usuario.getIdEndereco()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
