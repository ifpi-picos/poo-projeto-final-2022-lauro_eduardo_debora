package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    public static Connection getConexao(){
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://iflib.cchs3npr9zqj.us-east-1.rds.amazonaws.com:5432/iflib_db", "postgres", "iflib123");
            if(conexao != null){
                System.out.println("Banco de dados conectado com sucesso...");
            }else{
                System.out.println("Conexão falhou...");
            }

            return conexao;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
