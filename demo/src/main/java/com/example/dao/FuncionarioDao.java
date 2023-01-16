package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Funcionario;


public class FuncionarioDao {
    Connection conexao;

    public FuncionarioDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void adicionarFuncionario(Funcionario funcionario){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into funcionarios (cpf, nome, senha) values ('"+funcionario.getCPF()+"','"+funcionario.getNome()+"', '"+funcionario.getSenha()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean buscarFuncionario(String cpf, String senha){

        String sql = "select cpf from funcionarios where funcionarios.cpf = '"+cpf+"' and funcionarios.cpf = '"+senha+"'";

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            if(result.next()){
                return true;
            }else{
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public boolean encontrarFuncionarioCPF(String cpf){

        String sql = "select cpf from funcionarios where funcionarios.cpf = '"+cpf+"'";

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            if(result.next()){
                return true;
            }else{
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }


    public List<Funcionario> buscarFuncionarios(){
        String sql = "select cpf, nome, senha from funcionarios";
        List<Funcionario> funcionario = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){
                funcionario.add(new Funcionario(result.getString("cpf"), result.getString("nome"),  result.getString("senha")));
            }

            return funcionario;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public void removerFuncionario(String CPF){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from funcionarios where funcionarios.cpf = '"+CPF+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
