package com.example.visao;

import java.sql.Date;

import com.example.dao.EmprestimoDao;
import com.example.destino.Emprestimo;

public class EmprestimoForm {
    public void cadastrarEmprestimo(Date data_emp, int id_livro, String CPF_usuario, float valor, int tempo_emp){
        Emprestimo emprestimo = new Emprestimo(data_emp, id_livro, CPF_usuario, valor, tempo_emp);
        new EmprestimoDao().adicionarEmprestimo(emprestimo);
    }

    public boolean encontrarEmprestimo(String cpf){
        return new EmprestimoDao().buscarEmprestimo(cpf);
    }

    public void removerEmprestimo(String cpf){
        new EmprestimoDao().removerEmprestimo(cpf);
    }
}
