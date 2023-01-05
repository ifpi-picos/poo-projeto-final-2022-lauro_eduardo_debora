package com.example.visao;

import java.util.List;

import com.example.dao.AreadeConhecimentoDao;
import com.example.destino.AreaConhecimento;

public class AreaConhecimentoForm {
    
    public void cadastrarAreadeConhecimento(String titulo, String descricao){
        AreaConhecimento area = new AreaConhecimento(titulo, descricao);
        new AreadeConhecimentoDao().adicionarUsuario(area);
    }

    public boolean encontrarAreaConhecimento(String titulo){
        return new AreadeConhecimentoDao().buscarArea(titulo);
    }

    public List<AreaConhecimento> listarAreaConhecimento(){
        return new AreadeConhecimentoDao().buscarAreas();
    }

}
