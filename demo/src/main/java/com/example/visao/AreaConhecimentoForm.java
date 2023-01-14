package com.example.visao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.dao.AreadeConhecimentoDao;
import com.example.dao.LivroDao;
import com.example.destino.AreaConhecimento;
import com.example.destino.Livro;

public class AreaConhecimentoForm {
    
    public void cadastrarAreadeConhecimento(String titulo, String descricao){
        AreaConhecimento area = new AreaConhecimento(titulo, descricao);
        new AreadeConhecimentoDao().adicionarArea(area);
    }

    public boolean encontrarAreaConhecimento(String titulo){
        return new AreadeConhecimentoDao().buscarArea(titulo);
    }

    public void removerArea(String titulo){
        new AreadeConhecimentoDao().deletarArea(titulo);;
    }

    public boolean listarAreaConhecimento(){
        List<AreaConhecimento> areasCadastradas = new AreadeConhecimentoDao().buscarAreas();

        if(areasCadastradas.size() == 0){
            return false;
        }

        return true;
    }

    public void listarAreas(){
        List<AreaConhecimento> areasCadastradas = new AreadeConhecimentoDao().buscarAreas();
        List<String> listAreas = new ArrayList<>();
        
        for(int i = 0; i < areasCadastradas.size(); i++){
            listAreas.add("Título: " + areasCadastradas.get(i).getTitulo() + ", " + "Descrição: " + areasCadastradas.get(i).getDescricao());
        }

        String areas = "Áreas cadastradas: \n";
        for(String item : listAreas){
            areas += item + "\n";
        }

        if(areas == "Áreas cadastradas: \n"){
            JOptionPane.showMessageDialog(null, "Nenhuma área de conhecimento cadastrada!");
        }else{
            JOptionPane.showMessageDialog(null, areas);
        }
    }

}
