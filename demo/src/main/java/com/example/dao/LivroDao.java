package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.destino.Livro;


public class LivroDao {
    
    Connection conexao;

    public LivroDao(){
        conexao = ConexaoDao.getConexao();
    }

     public void adicionarLivro(Livro livro){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into livros (id_livro, titulo, autor, data_publicacao, num_copias, cpf_funcionario, area) values ('"+livro.getId_livro()+"','"+livro.getTitulo()+"', '"+livro.getAutor()+"', '"+livro.getDataPublicacao()+"', '"+livro.getNumCopias()+"', '"+livro.getCpfFunc()+"', '"+livro.getArea()+"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean buscarLivro(String titulo, String autor, Date datapublica){

        String sql = "select titulo from livros where livros.titulo = '"+ titulo +"' and livros.autor = '"+ autor +"' and livros.data_publicacao = '"+ datapublica +"' ";

        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Data: " + datapublica);

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

    public List<Livro> buscarlivros(){
        String sql = "select id_livro, titulo, autor, data_publicacao, num_copias, cpf_funcionario, area from usuarios";
        List<Livro> livros = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){;
                livros.add(new Livro(result.getInt("id_livro"), result.getString("titulo"), result.getString("autor"), result.getDate("data_publicacao"), result.getInt("num_copias"), result.getString("cpf_funcionario"), result.getString("area")));
            }
//String String String int Date String int 
            return livros;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
