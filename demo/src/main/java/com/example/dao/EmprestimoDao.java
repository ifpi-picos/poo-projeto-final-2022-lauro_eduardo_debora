package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Emprestimo;

public class EmprestimoDao {
    
    Connection conexao;

    public EmprestimoDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into emprestimos (tempo_emp, valor_emp, data_emp, id_livro, cpf_usuario) values ('"+emprestimo.getTempoEmp()+"','"+emprestimo.getValorEmp()+"', '"+emprestimo.getDataEmp()+"','"+emprestimo.getLivroEmp()+"', '"+emprestimo.getUsuarioEmp()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean buscarEmprestimo(String cpf){

        String sql = "select id_emprestimo from emprestimos where emprestimos.cpf_usuario = '"+cpf+"'";

        System.out.println("CPF: \n" + cpf);

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

    public void removerEmprestimo(String CPF_usuario){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from emprestimos where emprestimos.cpf_usuario = '"+CPF_usuario+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}