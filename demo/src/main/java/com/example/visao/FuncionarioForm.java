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
        List<Funcionario> funcionariosCadastrados = new FuncionarioDao().buscarFuncionaio();
        return funcionariosCadastrados;
        /*for(int i = 0; i < funcionariosCadastrados.size(); i++){
            System.out.println(funcionariosCadastrados.get(i).getNome());
        }*/
    }

    public void removefuncionario(String cpf, String nome, String senha){
        new FuncionarioDao().removerFuncionario(cpf, senha, nome);
    }

}
