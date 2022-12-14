package com.example;


import java.io.Console;
/*import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Random;

import javax.swing.JOptionPane;

import com.example.dao.FuncionarioDao;
//import com.example.dao.UsuarioDao;
import com.example.destino.Funcionario;
import com.example.destino.Livro;
import com.example.destino.Usuario;
import com.example.visao.FuncionarioForm;
//import com.example.visao.UsuarioForm;

public class App 
{
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Livro> livros = new ArrayList<>();

    public static void main( String[] args ) throws ParseException
    {

        List<Integer> menu = new ArrayList<>();
        menu.add(1);
        menu.add(2);
        menu.add(3);

        int menuSelecionado = 1;
        while (menu.get(menuSelecionado) != 3) {
            menuSelecionado = verMenu(menu);
            if (menu.get(menuSelecionado) == 1) {
                admin();
            } else if (menu.get(menuSelecionado) == 2) {
                funcionario();
            }

        }
    }

    // Menu inicial
    public static int verMenu(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Admin \n2. Funcionário \n3. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static int menuFuncOpt(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Opções usuários \n2. Opções livros \n3. Empréstimo \n4 Cancelar Empréstimo\n5. Sair",
                "Menu do Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static int menuFuncUsuario() {
        List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
                    menu.add(5);

        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Adicionar usuário \n2. Alterar usuário \n3. Remover usuário \n4. Listar usuários \n5. Sair",
                "Opções usuários",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static int menuFuncLivro(){
        List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
                    menu.add(5);
                    menu.add(6);
                    menu.add(7);

        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Adicionar livro \n2. Alterar livro \n3. Remover livro \n4. Listar livros \n5. Adicionar área de conhecimento \n6. Remover área de conhecimento \n7. Sair",
                "Opções livros",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }
    

    public static void funcionario() throws ParseException{
        
        String entrar = JOptionPane.showInputDialog("CPF do funcionário: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        List<Funcionario> funcionarios = new FuncionarioForm().listarFuncionarios();
        
        if(new FuncionarioForm().encontrarFuncionario(entrar, senha)){
            //System.out.println("Passou do banco");
            for(Funcionario funcionario : funcionarios){
                if(entrar.equals(funcionario.getCPF()) && senha.equals(funcionario.getSenha())){
                    //System.out.println("Passou da lista");
                    List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
        
                    int menuSelecionado = 1;
                    while (menu.get(menuSelecionado) != 5) {
                        menuSelecionado = menuFuncOpt(menu);
                        if (menu.get(menuSelecionado) == 1) {
                            int option = 0;
                            while(option != 4){
                                option = menuFuncUsuario();
                                if(option == 0){
                                    funcionario.adicionarUsuario(entrar);
                                }else if(option == 1){
                                    funcionario.alterarUsuario();
                                }else if(option == 2){
                                    funcionario.removerUsuario();
                                }else if(option == 3){
                                    funcionario.listarUsuarios();
                                }
                            }
                        } else if (menu.get(menuSelecionado) == 2) {
                            int option = 0;
                            while(option != 6){
                                option = menuFuncLivro();
                                if(option == 0){
                                    funcionario.adicionarLivro(entrar);
                                }else if(option == 1){
                                    funcionario.alterarLivro();
                                }else if(option == 2){
                                    funcionario.removerLivro();
                                }else if(option == 3){
                                    funcionario.listarLivros(livros);
                                }else if(option == 4){
                                    funcionario.cadastrarAreadeconhecimento();
                                }else if(option == 5){
                                  System.out.println("Remover area");
                                }
                            }
                        }else if (menu.get(menuSelecionado) == 3) {
                            funcionario.realizarEmprestimo(senha);
                        }else if(menu.get(menuSelecionado) == 4){
                            funcionario.removerEmprestimo();
                        }
                    }
                }else{
                    System.out.println("Não passou do banco");
                }
           
            }
        }else{
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
        }

    }

    // Login admin
    public static void admin(){
        String pergunta = JOptionPane.showInputDialog("Código da empresa");
        int convertor_pergunta = Integer.parseInt(pergunta);
        if(convertor_pergunta == 12345){
            List<Integer> menu_interativo = new ArrayList<>();
            menu_interativo.add(1);
            menu_interativo.add(2);
            menu_interativo.add(3);

            int menuSelecionado = 1;
            while (menu_interativo.get(menuSelecionado) != 3) {
                menuSelecionado = menuAdmin(menu_interativo);
                if (menu_interativo.get(menuSelecionado) == 1) {
                    String nome_f = JOptionPane.showInputDialog("Seu nome: ");
                    String cpf_f = JOptionPane.showInputDialog("Seu CPF: ");
                    String senha_f = JOptionPane.showInputDialog("Crie uma senha: ");

                    new FuncionarioForm().cadastrarFuncionario(cpf_f,nome_f,senha_f);
                }else if (menu_interativo.get(menuSelecionado) == 2){
                    String cpf = JOptionPane.showInputDialog("CPF: ");
                    String senha = JOptionPane.showInputDialog("Senha: ");

                    if(new FuncionarioForm().encontrarFuncionario(cpf, senha)){
                        new FuncionarioDao().removerFuncionario(cpf, senha);
                    }else{
                        JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
                    }
                }
           
        }
            
        }else{
            JOptionPane.showMessageDialog(null, "Código errado!");
        }
    }

    public static int menuAdmin(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Cadastrar funcionário \n2. Remover funcionário \n3. Sair",
                "Menu do Admin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }
}