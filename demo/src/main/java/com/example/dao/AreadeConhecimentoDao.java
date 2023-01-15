package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.AreaConhecimento;

public class AreadeConhecimentoDao {
    
    Connection conexao;

    public AreadeConhecimentoDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void adicionarArea(AreaConhecimento area){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into areas_conhecimento (titulo, descricao) values ('"+area.getTitulo()+"', '"+area.getDescricao()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean buscarArea(String titulo){

        String sql = "select titulo from areas_conhecimento where areas_conhecimento.titulo = '"+ titulo +"' ";

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            if(result.next()){
                return true;
            }else{
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public void deletarArea(String titulo){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from areas_conhecimento where areas_conhecimento.titulo = '"+titulo+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<AreaConhecimento> buscarAreas(){
        String sql = "select * from areas_conhecimento";
        List<AreaConhecimento> areas = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){;
                areas.add(new AreaConhecimento(result.getString("titulo"), result.getString("descricao")));
            }

            return areas;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
