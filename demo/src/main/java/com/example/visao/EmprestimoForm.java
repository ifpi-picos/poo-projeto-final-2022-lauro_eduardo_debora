package com.example.visao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.dao.EmprestimoDao;
import com.example.destino.Emprestimo;

public class EmprestimoForm {
    public void cadastrarEmprestimo(int id, Integer tempo_emp, double valor, Date data_emp, int id_livro, String CPF_usuario){
        Emprestimo emprestimo = new Emprestimo(id, tempo_emp, valor, data_emp, id_livro, CPF_usuario);
        new EmprestimoDao().adicionarEmprestimo(emprestimo);
    }

    public boolean encontrarEmprestimo(String cpf){
        return new EmprestimoDao().buscarEmprestimo(cpf);
    }

    public void removerEmprestimo(String cpf){
        new EmprestimoDao().removerEmprestimo(cpf);
    }

    public void listarEmprestimos(){
        List<Emprestimo> emprestimosCadastrados = new EmprestimoDao().buscarEmprestimos();
        List<String> listEmprestimos = new ArrayList<>();
        
        for(int i = 0; i < emprestimosCadastrados.size(); i++){
            listEmprestimos.add("ID: " + emprestimosCadastrados.get(i).getIdEmprestimo() + ", " + "Tempo: " + emprestimosCadastrados.get(i).getTempoEmp() + " dias" +", " + "Valor: " + emprestimosCadastrados.get(i).getValorEmp() + ", " + "Data: " + emprestimosCadastrados.get(i).getDataEmp() + ", " + "Livro: " + emprestimosCadastrados.get(i).getLivroEmp() + ", " + "Usuário: " + emprestimosCadastrados.get(i).getUsuarioEmp());
        }

        String emprestimos = "";
        for(String item : listEmprestimos){
            emprestimos += item + "\n";
        }

        if(emprestimos == ""){
            JOptionPane.showMessageDialog(null, "Nenhum empréstimo cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, emprestimos);
        }
    }
}
