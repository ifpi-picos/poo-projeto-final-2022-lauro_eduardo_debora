package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    public static Connection getConexao(){
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/if_lib", "postgres", "xFlax@00");
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
