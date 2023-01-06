package com.example.visao;

import java.util.List;

import com.example.dao.AreadeConhecimentoDao;
import com.example.dao.LivroDao;
import com.example.destino.AreaConhecimento;
import com.example.destino.Livro;

public class AreaConhecimentoForm {
    
    public void cadastrarAreadeConhecimento(String titulo, String descricao, int id){
        AreaConhecimento area = new AreaConhecimento(titulo, descricao, id);
        new AreadeConhecimentoDao().adicionarUsuario(area);
    }

    public boolean encontrarAreaConhecimento(String titulo){
        return new AreadeConhecimentoDao().buscarArea(titulo);
    }

    public List<AreaConhecimento> listarAreaConhecimento(){
        return new AreadeConhecimentoDao().buscarAreas();
    }

    public void listarConhecimento(){
        List<Livro> livroCadastrados = new LivroDao().buscarlivros();
        
        for(int i = 0; i < livroCadastrados.size(); i++){
            System.out.println(livroCadastrados.get(i).getTitulo());
        }
    }

}
