package com.example.destino;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Funcionario{
    private String nome;
    private String CPF;
    private String senha;
    private String id;
    static List<String> liv = new ArrayList<>();

    public Funcionario(String nome, String CPF, String senha, String id){
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.id = id;
        
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getId(){
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionar_usuario(List<Usuario> usuarios){
        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        for (Usuario usuario : usuarios) {
            // Autenticando o cliente que será acessado
            if (CPF_p.equals(usuario.getCpf())) {
                JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado!");
                adicionar_usuario(usuarios);
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
    }

    public void adicionar_livro(List<Livro> livros){
        String Nome_l = JOptionPane.showInputDialog("Nome do livro: ");
        String autor_nome = JOptionPane.showInputDialog("Nome do autor do livro: ");
        //String Data_l = JOptionPane.showInputDialog("Data de publicação: ");
        String quant_l = JOptionPane.showInputDialog("Quantos livros estão sendo adicionados? ");
        Integer quant = Integer.parseInt(quant_l);
        Livro livro = new Livro(Nome_l,autor_nome, quant);
        livros.add(livro);
        liv.add(Nome_l);

    }

    public void remover_livro(List<Livro> livros){
        String Nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autornome = JOptionPane.showInputDialog("Nome do autor do livro: ");
        for (Livro livro : livros){
            if(Nome.equals(livro.getTitulo()) && autornome.equals(livro.getAutor())){
                if(livro.getNumCopias() == 0){
                    JOptionPane.showMessageDialog(null, "Esse livro não está tendo no estoque");
                }else{
                    livro.setNumCopias(livro.getNumCopias() - 1);
                }
            }
        }
    }

    public void alterar_livro(List<Livro> livros){
        String Nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autornome = JOptionPane.showInputDialog("Nome do autor do livro: ");
       // String Data = JOptionPane.showInputDialog("Data de publicação: ");
        for (Livro livro : livros){
            if(Nome.equals(livro.getTitulo()) && autornome.equals(livro.getAutor())){
                livro.setTitulo(Nome);
                livro.setAutor(autornome);
                //livro.setData(null);
            }
        }
    }

    public void listar_livros(){
        Object[] livrosArray = liv.toArray();
        int escolhido = JOptionPane.showOptionDialog(null,
                "Livros:",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                livrosArray, null);
        System.out.println(escolhido);
    }
}
