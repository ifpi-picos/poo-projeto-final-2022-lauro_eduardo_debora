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
            String sql = "insert into emprestimos (id_emprestimo, tempo_emp, valor_emp, data_emp, id_livro, cpf_usuario) values ('"+emprestimo.getIdEmprestimo()+"','"+emprestimo.getTempoEmp()+"','"+emprestimo.getValorEmp()+"', '"+emprestimo.getDataEmp()+"','"+emprestimo.getLivroEmp()+"', '"+emprestimo.getUsuarioEmp()+"')";
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

    public void removerEmprestimo(String CPF_usuario){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from emprestimos where emprestimos.cpf_usuario = '"+CPF_usuario+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public List<Emprestimo> buscarEmprestimos(){
        String sql = "select * from emprestimos";
        List<Emprestimo> emprestimos = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){
                emprestimos.add(new Emprestimo(result.getInt("id_emprestimo"), result.getInt("tempo_emp"),  result.getDouble("valor_emp"),  result.getDate("data_emp"),  result.getInt("id_livro"),  result.getString("cpf_usuario")));
            }

            return emprestimos;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}