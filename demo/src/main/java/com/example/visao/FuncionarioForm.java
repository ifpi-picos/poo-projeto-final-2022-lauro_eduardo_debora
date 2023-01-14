package com.example.visao;

import java.util.List;

import com.example.dao.FuncionarioDao;
import com.example.destino.Funcionario;

public class FuncionarioForm {
    
    public void cadastrarFuncionario(String cpf, String nome, String senha){
        Funcionario funcionario = new Funcionario(cpf, nome, senha);
        new FuncionarioDao().adicionarFuncionario(funcionario);
    }

    public boolean encontrarFuncionario(String cpf,String senha){
        return new FuncionarioDao().buscarFuncionario(cpf, senha);
    }

    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionariosCadastrados = new FuncionarioDao().buscarFuncionarios();
        return funcionariosCadastrados;
    }

    public void removefuncionario(String cpf){
        new FuncionarioDao().removerFuncionario(cpf);
    }

}
