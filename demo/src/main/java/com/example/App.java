package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.example.destino.Endereco;
import com.example.destino.Funcionario;
import com.example.destino.Usuario;

public class App 
{
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Funcionario> funcionarios = new ArrayList<>();


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
                cadastrar_funcionario();
            } else if (menu.get(menuSelecionado) == 2) {
                entra();
            }

        }
    }

    public static int verMenu(List<Integer> menu) {
        Object[] menusArray = menu.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Cadastrar Funcionário \n2. Entrar \n3. Sair",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
        return opcaoSelecionad;
    }

    public static void entra(){
        if(usuarios.size() > 0 || funcionarios.size() > 0){
            String entrar = JOptionPane.showInputDialog("Seu id: ");
            String senha = JOptionPane.showInputDialog("Senha: ");


            for(Funcionario funcionario: funcionarios){
                if(entrar.equals(funcionario.getId()) && senha.equals(funcionario.getsenha())){

                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado!");
        }

}

   /*  public static void cadastrar_cliente(){
        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        for (Usuario usuario : usuarios) {
            // Autenticando o cliente que será acessado
            if (CPF_p.equals(usuario.getcpf())) {
                JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado!");
                entra();
                }
        }

        String senha_p = JOptionPane.showInputDialog("Crie uma senha: ");
        String email_p = JOptionPane.showInputDialog("Seu e-mail: ");
        String bairro_p = JOptionPane.showInputDialog("Seu bairro: ");
        String rua_p = JOptionPane.showInputDialog("Sua rua: ");
        String numero_p = JOptionPane.showInputDialog("Número da rua: ");
        String cep_p = JOptionPane.showInputDialog("Seu CEP: ");

        int convertor_n = Integer.parseInt(cep_p);
        int convertor_nu = Integer.parseInt(numero_p);
        Endereco endereco = new Endereco(bairro_p,rua_p,convertor_nu,convertor_n);
        Usuario Usuario = new Usuario(Nome_p, email_p, senha_p, CPF_p, endereco);
        usuarios.add(Usuario);
    } */
    

    public static void cadastrar_funcionario(){
        String pergunta = JOptionPane.showInputDialog("Código da empresa");
        int convertor_pergunta = Integer.parseInt(pergunta);
        if(convertor_pergunta == 12345){
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

        }else{
            JOptionPane.showMessageDialog(null, "Código errado!");
        }
    }
}
