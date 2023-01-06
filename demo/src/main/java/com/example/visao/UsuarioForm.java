package com.example.visao;

import java.util.Date;
import java.util.List;

import com.example.dao.UsuarioDao;
import com.example.destino.Usuario;

public class UsuarioForm {

    public void cadastrarUsuario(String cpf, String nome, String email, String senha, Date dataNascimento, String idEndereco){
        Usuario usuario = new Usuario(cpf, nome, email, senha, dataNascimento, idEndereco);
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

    public void listarUsuarios(){
        List<Usuario> usuariosCadastrados = new UsuarioDao().buscarUsuarios();
        
        for(int i = 0; i < usuariosCadastrados.size(); i++){
            System.out.println(usuariosCadastrados.get(i).getNome() + "-" + usuariosCadastrados.get(i).getEmail());
        }
    }
    
}
