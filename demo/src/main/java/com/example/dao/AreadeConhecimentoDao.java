package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
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

    public void adicionarUsuario(AreaConhecimento area){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into areas_conhecimento (titulo, descricao) values ('"+area.gettitulo()+"', '"+area.getdescricao()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean buscarArea(String titulo){

        String sql = "select titulo from areas_conhecimento where areas_conhecimento.titulo = '"+ titulo +"' ";

        System.out.println("titulo: " + titulo);

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            // System.out.println("result: " + result);

            if(result.next()){
                // System.out.println("Entrou no true");
                return true;
            }else{
                // System.out.println("Entrou no false");
                return false;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public List<AreaConhecimento> buscarAreas(){
        String sql = "select titulo, descricao from areas_conhecimento";
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
