package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Usuario;

public class UsuarioDao {
    
    Connection conexao;

    public UsuarioDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void adicionarUsuario(Usuario usuario){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into usuarios (cpf, nome, email, senha, datanascimento, id_endereco) values ('"+usuario.getCpf()+"', '"+usuario.getNome()+"', '"+usuario.getEmail()+"', '"+usuario.getSenha()+"', '"+usuario.getDataNasc()+"', '"+usuario.getIdEndereco()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> buscarUsuarios(){
        String sql = "select cpf, nome, email, senha, datanascimento from usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){
                usuarios.add(new Usuario(result.getString("cpf"), result.getString("nome"), result.getString("email"), result.getString("senha"), result.getDate("datanascimento"), result.getString("id_endereco")));
            }

            return usuarios;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
