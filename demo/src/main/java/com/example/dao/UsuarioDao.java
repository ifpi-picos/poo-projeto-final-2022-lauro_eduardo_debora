package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
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

    public boolean buscarUsuario(String cpf){

        String sql = "select cpf from usuarios where usuarios.cpf = '"+cpf+"' ";

        System.out.println("CPF: " + cpf);

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            // System.out.println("result: " + result);

            if(result.next()){
                // System.out.println("Entrou no true");
                return true;
            }else{
                // System.out.println("Entrou no false");
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public void alterarUsuario(String nome, String email, String senha, Date dataNascimento, String cpf){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update usuarios set nome = '"+nome+"', email = '"+email+"', senha = '"+senha+"', datanascimento = '"+dataNascimento+"' where cpf = '"+cpf+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarNomeUsuario(String nome, String cpf){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update usuarios set nome = '"+nome+"' where cpf = '"+cpf+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarEmailUsuario(String email, String cpf){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update usuarios set email = '"+email+"' where cpf = '"+cpf+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarSenhaUsuario(String senha, String cpf){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update usuarios set senha = '"+senha+"' where cpf = '"+cpf+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterarDataUsuario(String data, String cpf){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update usuarios set datanascimento = '"+data+"' where cpf = '"+cpf+"'";
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

            while(result.next()){;
                usuarios.add(new Usuario(result.getString("cpf"), result.getString("nome"), result.getString("email"), result.getString("senha"), result.getDate("datanascimento"), result.getString("id_endereco")));
            }

            return usuarios;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
