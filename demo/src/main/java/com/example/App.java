package com.example;



import java.text.ParseException;

import java.util.ArrayList;

import java.util.List;


import javax.swing.JOptionPane;

import com.example.dao.FuncionarioDao;
import com.example.destino.Funcionario;
import com.example.destino.Livro;
import com.example.destino.Usuario;
import com.example.visao.FuncionarioForm;


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
                "1. Opções usuários \n2. Opções livros \n3. Opções empréstimos \n4. Sair",
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
                    menu.add(8);

        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Adicionar livro \n2. Alterar livro \n3. Remover livro \n4. Listar livros \n5. Adicionar área de conhecimento \n6. Remover área de conhecimento \n7. Listar áreas \n8. Sair",
                "Opções livros",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static int menuFuncEmprestimo() {
        List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
                    

        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Realizar empréstimo \n2. Cancelar empréstimo \n3. Ver empréstimos \n4. Sair",
                "Opções empréstimos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }
    

    public static void funcionario() throws ParseException{
        
        String entrar = JOptionPane.showInputDialog("CPF do funcionário: ");
        String senha = JOptionPane.showInputDialog("Senha: ");
        List<Funcionario> funcionarios = new FuncionarioForm().listarFuncionarios();
        
        if(new FuncionarioForm().encontrarFuncionario(entrar, senha)){
            // System.out.println("Passou do banco");
            for(Funcionario funcionario : funcionarios){
                if(entrar.equals(funcionario.getCPF()) && senha.equals(funcionario.getSenha())){
                    System.out.println("Passou da lista");
                    List<Integer> menu = new ArrayList<>();
                    menu.add(1);
                    menu.add(2);
                    menu.add(3);
                    menu.add(4);
        
                    int menuSelecionado = 0;
                    while (menu.get(menuSelecionado) != 4) {
                        menuSelecionado = menuFuncOpt(menu);
                        if (menuSelecionado+1 == 1) {
                            System.out.println("Entrada: " + menuSelecionado);
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
                        } else if (menuSelecionado+1 == 2) {
                            int option = 0;
                            while(option != 7){
                                option = menuFuncLivro();
                                if(option == 0){
                                    funcionario.adicionarLivro(entrar);
                                }else if(option == 1){
                                    funcionario.alterarLivro();
                                }else if(option == 2){
                                    funcionario.removerLivro();
                                }else if(option == 3){
                                    funcionario.listarLivros();
                                }else if(option == 4){
                                    funcionario.cadastrarAreaDeConhecimento();
                                }else if(option == 5){
                                  funcionario.removerArea();
                                }else if(option == 6){
                                    funcionario.listarAreas();
                                }
                                
                            }
                        }else if (menuSelecionado+1 == 3) {
                            int option = 0;
                            while(option != 3){
                                option = menuFuncEmprestimo();
                                if(option == 0){
                                    funcionario.realizarEmprestimo(senha);
                                }else if(option == 1){
                                    funcionario.removerEmprestimo();
                                }else if(option == 2){
                                    funcionario.listarEmprestimos();
                                }
                            }
                            
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
                    String cpf_f = JOptionPane.showInputDialog("Seu CPF: ");

                    if(new FuncionarioDao().encontrarFuncionarioCPF(cpf_f)){
                        JOptionPane.showMessageDialog(null, "Funcionário já cadastrado!");
                    }else if(cpf_f.equals("")){
                        JOptionPane.showMessageDialog(null, "Obrigatório adicionar CPF!");
                    }else{
                        String nome_f = JOptionPane.showInputDialog("Seu nome: ");
                        String senha_f = JOptionPane.showInputDialog("Crie uma senha: ");

                        new FuncionarioForm().cadastrarFuncionario(cpf_f,nome_f,senha_f);

                        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");
                    }
                    

                }else if (menu_interativo.get(menuSelecionado) == 2){
                    String cpf = JOptionPane.showInputDialog("CPF: ");
                    // String senha = JOptionPane.showInputDialog("Senha: ");

                    if(new FuncionarioDao().encontrarFuncionarioCPF(cpf)){
                        new FuncionarioDao().removerFuncionario(cpf);

                        JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
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