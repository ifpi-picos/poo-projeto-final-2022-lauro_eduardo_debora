package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
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

        String sql = "select cpf from funcionarios where funcionarios.cpf = '"+cpf+"' and funcionarios.senha = '"+senha+"'";

        System.out.println("CPF: \n" + cpf);
        System.out.println("Senha: " + senha);

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

    public List<Funcionario> buscarFuncionaio(){
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

    public void removerFuncionario(String CPF, String senha){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from funcionarios where funcionarios.cpf = '"+CPF+"' and senha = '"+senha+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
