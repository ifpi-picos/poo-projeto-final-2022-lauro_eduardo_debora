package com.example.visao;

import java.util.Date;

import com.example.dao.EmprestimoDao;
import com.example.destino.Emprestimo;

public class EmprestimoForm {
    public void cadastrarEmprestimo(Integer tempo_emp, double valor, Date data_emp, int id_livro, String CPF_usuario){
        Emprestimo emprestimo = new Emprestimo(tempo_emp, valor, data_emp, id_livro, CPF_usuario);
        new EmprestimoDao().adicionarEmprestimo(emprestimo);
    }

    public boolean encontrarEmprestimo(String cpf){
        return new EmprestimoDao().buscarEmprestimo(cpf);
    }

    public void removerEmprestimo(String cpf){
        new EmprestimoDao().removerEmprestimo(cpf);
    }
}
