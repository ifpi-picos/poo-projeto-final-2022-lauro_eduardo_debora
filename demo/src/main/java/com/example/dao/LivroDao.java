package com.example.dao;

import java.sql.Connection;
import java.util.Date;
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

    public int quantLivro(String titulo, String autor){
        String sql = "Select num_copias from livros where livros.titulo = '"+titulo+"' and livros.autor = '"+autor+"'";

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            if(result.next()){
                System.out.println("Entrou no true");
                System.out.println(result.getInt("num_copias"));
                return result.getInt("num_copias");
            }else{
                System.out.println("Entrou no false");
                return 0;
            } 

        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean buscarLivro(String titulo, String autor, Date datapublica){

        String sql = "select titulo from livros where livros.titulo = '"+ titulo +"' and livros.autor = '"+ autor +"' and livros.data_publicacao = '"+ datapublica +"' ";

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

    public int buscarIdLivro(String titulo, String autor, Date datapublica){

        String sql = "select id_livro from livros where livros.titulo = '"+ titulo +"' and livros.autor = '"+ autor +"' and livros.data_publicacao = '"+ datapublica +"' ";

        try { 
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            if(result.next()){
                System.out.println("Entrou no true");
                System.out.println(result.getInt("id_livro"));
                return result.getInt("id_livro");
            }else{
                System.out.println("Entrou no false");
                return 0;
            } 

        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    public void alterarTituloLivro(String antTitulo, String titulo, String autor, Date dataPublicacao){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update livros set titulo = '"+titulo+"' where titulo = '"+antTitulo+"' and autor = '"+autor+"' and data_publicacao = '"+dataPublicacao+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterarAutorLivro(String antAutor, String titulo, String autor, Date dataPublicacao){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update livros set autor = '"+autor+"' where titulo = '"+titulo+"' and autor = '"+antAutor+"' and data_publicacao = '"+dataPublicacao+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterarDataLivro(Date antData, String titulo, String autor, Date dataPublicacao){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update livros set data_publicacao = '"+dataPublicacao+"' where titulo = '"+titulo+"' and autor = '"+autor+"' and data_publicacao = '"+antData+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterarNumCopiasLivro(String titulo, String autor, Date dataPublicacao, int num){
        try {
            Statement stm = conexao.createStatement();
            String sql = "update livros set num_copias = '"+num+"' where titulo = '"+titulo+"' and autor = '"+autor+"' and data_publicacao = '"+dataPublicacao+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletarLivro(String titulo, String autor, Date dataPubli){
        try {
            Statement stm = conexao.createStatement();
            String sql = "delete from livros where livros.titulo = '"+titulo+"' and autor = '"+autor+"' and data_publicacao = '"+dataPubli+"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Livro> buscarlivros(){
        String sql = "select id_livro, titulo, autor, data_publicacao, num_copias, cpf_funcionario, area from livros";
        List<Livro> livros = new ArrayList<>();

        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);

            while(result.next()){;
                livros.add(new Livro(result.getInt("id_livro"), result.getString("titulo"), result.getString("autor"), result.getDate("data_publicacao"), result.getInt("num_copias"), result.getString("cpf_funcionario"), result.getString("area")));
            }
            
            return livros;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

}
