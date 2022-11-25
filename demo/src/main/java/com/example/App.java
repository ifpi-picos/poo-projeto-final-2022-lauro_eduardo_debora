package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.destino.usuario;

public class App 
{
    static List<usuario> usuarios = new ArrayList<>();


    public static void main( String[] args )
    {
        List<Integer> menu = new ArrayList<>();
        menu.add(1);
        menu.add(2);
        menu.add(3);

        int menuSelecionado = 1;
        while (menu.get(menuSelecionado) != 3) {
            menuSelecionado = verMenu(menu);
            if (menu.get(menuSelecionado) == 1) {
                cadastrar();
            } else if (menu.get(menuSelecionado) == 2) {
                entra();
            }

        }
    }

    public static int verMenu(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Cadastrar \n2. Entrar \n3. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static void entra(){

}

    public static void cadastrar(){
        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        for (usuario usuario : usuarios) {
            // Autenticando o cliente que será acessado
            if (CPF_p.equals(usuario.getcpf())) {
                JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado!");
                entra();
                }
        }

        String senha_p = JOptionPane.showInputDialog("Sua senha: ");
        String email_p = JOptionPane.showInputDialog("Seu e-mail: ");

        int convertor_num = Integer.parseInt(senha_p);
        usuario usuario = new usuario(Nome_p, email_p, convertor_num, CPF_p);
        usuarios.add(usuario);
    }

}
