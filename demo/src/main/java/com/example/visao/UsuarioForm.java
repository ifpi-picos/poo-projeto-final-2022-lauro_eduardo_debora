package com.example.visao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.dao.UsuarioDao;
import com.example.destino.Usuario;

public class UsuarioForm {

    public void cadastrarUsuario(String cpf, String nome, String email, String senha, Date dataNascimento, String idEndereco, String cpfFuncionario){
        Usuario usuario = new Usuario(cpf, nome, email, senha, dataNascimento, idEndereco, cpfFuncionario);
        new UsuarioDao().adicionarUsuario(usuario);
    }

    public boolean encontrarUsuario(String cpf){
        return new UsuarioDao().buscarUsuario(cpf);
    }

    public void alterarNome(String nome, String cpf){
        new UsuarioDao().alterarNomeUsuario(nome, cpf);
    }

    public void alterarEmail(String email, String cpf){
        new UsuarioDao().alterarEmailUsuario(email, cpf);
    }

    public void alterarSenha(String senha, String cpf){
        new UsuarioDao().alterarSenhaUsuario(senha, cpf);
    }

    public void alterarDataUsuario(String data, String cpf){
        new UsuarioDao().alterarDataUsuario(data, cpf);
    }

    public void removerUsuario(String cpf){
        new UsuarioDao().deletarUsuario(cpf);
    }

    public void listarUsuarios(){
        List<Usuario> usuariosCadastrados = new UsuarioDao().buscarUsuarios();
        List<String> listUsuarios = new ArrayList<>();
        
        for(int i = 0; i < usuariosCadastrados.size(); i++){
            /* System.out.println("CPF: " + usuariosCadastrados.get(i).getCpf() + ", " + "Nome: " + usuariosCadastrados.get(i).getNome() + ", " + "Email: " + usuariosCadastrados.get(i).getEmail() + ", " + "Data nascimento: " + usuariosCadastrados.get(i).getDataNasc() + ", " + "idEndereço: " + usuariosCadastrados.get(i).getIdEndereco()); */

            listUsuarios.add("CPF: " + usuariosCadastrados.get(i).getCpf() + ", " + "Nome: " + usuariosCadastrados.get(i).getNome() + ", " + "Email: " + usuariosCadastrados.get(i).getEmail() + ", " + "Data nascimento: " + usuariosCadastrados.get(i).getDataNasc() + ", " + "idEndereço: " + usuariosCadastrados.get(i).getIdEndereco() + ", " + "cpfFuncionario: " + usuariosCadastrados.get(i).getCpfFuncionario());
        }

        String usuarios = "";
        for(String item : listUsuarios){
            usuarios += item + "\n";
        }

        if(usuarios == ""){
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!");
        }else{
            JOptionPane.showMessageDialog(null, usuarios);
        }
        
    }
    
}
