package com.example;


import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.example.dao.UsuarioDao;
import com.example.destino.Funcionario;
import com.example.destino.Livro;
import com.example.destino.Usuario;
import com.example.visao.UsuarioForm;

public class App 
{
    static List<Funcionario> funcionarios = new ArrayList<>();
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

    public static int menuFuncionario(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Adicionar usuário \n2. Adicionar livro \n3. Alterar livro \n4. Remover livro \n5. Listar livros \n6. Emprestimo \n7. Sair",
                "Menu do Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    // Login funcionário
    public static void funcionario() throws ParseException{
        if(funcionarios.size() > 0){
            String entrar = JOptionPane.showInputDialog("Seu id: ");
            String senha = JOptionPane.showInputDialog("Senha: ");

            for(Funcionario funcionario: funcionarios){
                if(entrar.equals(funcionario.getId()) && senha.equals(funcionario.getSenha())){
                    List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
                    menu.add(5);
                    menu.add(6);
                    menu.add(7);

                    int menuSelecionado = 1;
                    while (menu.get(menuSelecionado) != 7) {
                        menuSelecionado = menuFuncionario(menu);
                        if (menu.get(menuSelecionado) == 1) {
                            funcionario.adicionarUsuario(usuarios);
                        } else if (menu.get(menuSelecionado) == 2) {
                            funcionario.adicionarLivro(livros);
                        }else if (menu.get(menuSelecionado) == 3) {
                            funcionario.alterarLivro(livros);
                        }else if (menu.get(menuSelecionado) == 4) {
                            funcionario.removerLivro(livros);
                        }else if (menu.get(menuSelecionado) == 5) {
                            funcionario.listarLivros(livros);
                        }else if (menu.get(menuSelecionado) == 6) {
                            funcionario.emprestimo(usuarios, livros);     
                        }
        }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado!");
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
                    Random geradorConta = new Random();

                    int num1 = geradorConta.nextInt(9);
                    int num2 = geradorConta.nextInt(9);
                    int num3 = geradorConta.nextInt(9);
                    int num4 = geradorConta.nextInt(9);
                    int num5 = geradorConta.nextInt(9);

                    String id_f = "" + num1 + num2 + num3 + num4 + num5;

                    String nome_f = JOptionPane.showInputDialog("Seu nome: ");
                    String cpf_f = JOptionPane.showInputDialog("Seu CPF: ");
                    String senha_f = JOptionPane.showInputDialog("Crie uma senha: ");

                    Funcionario funcionario = new Funcionario(nome_f, cpf_f, senha_f, id_f);
                    funcionarios.add(funcionario);
                    JOptionPane.showMessageDialog(null, "Seu id de funcionário é: " + id_f);
                }
           
        }
            
        }else{
            JOptionPane.showMessageDialog(null, "Código errado!");
        }
    }

    public static int menuAdmin(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Cadastrar funcionário \n2. Gerir \n3. Sair",
                "Menu do Admin",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }
}

/**/
