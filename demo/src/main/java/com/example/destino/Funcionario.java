package com.example.destino;

//import java.time.LocalDateTime;
//import java.sql.Date;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Funcionario{
    private String nome;
    private String CPF;
    private String senha;
    private String id;

    static List<String> liv = new ArrayList<>();
    static List<Livro> livrosList = new ArrayList<>();

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

    public void adicionarUsuario(List<Usuario> usuarios){
        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        for (Usuario usuario : usuarios) {
            // Autenticando o cliente que será acessado
            if (CPF_p.equals(usuario.getCpf())) {
                JOptionPane.showMessageDialog(null, "Esse CPF já está cadastrado!");
                adicionarUsuario(usuarios);
                }
        }

        String senha_p = JOptionPane.showInputDialog("Crie uma senha: ");
        String email_p = JOptionPane.showInputDialog("Seu e-mail: ");
        String bairro_p = JOptionPane.showInputDialog("Seu bairro: ");
        String rua_p = JOptionPane.showInputDialog("Sua rua: ");
        String numero_p = JOptionPane.showInputDialog("Número da casa: ");
        String cep_p = JOptionPane.showInputDialog("Seu CEP: ");

        int convertor_n = Integer.parseInt(cep_p);
        int convertor_nu = Integer.parseInt(numero_p);
        Endereco endereco = new Endereco(bairro_p,rua_p,convertor_nu,convertor_n);
        Usuario Usuario = new Usuario(Nome_p, email_p, senha_p, CPF_p, endereco);
        usuarios.add(Usuario);
    }

    public void adicionarLivro(List<Livro> livros){
        String Nome_l = JOptionPane.showInputDialog("Nome do livro: ");
        String autor_nome = JOptionPane.showInputDialog("Nome do autor do livro: ");
        //String Data_l = JOptionPane.showInputDialog("Data de publicação: ");
        String quant_l = JOptionPane.showInputDialog("Quantos livros estão sendo adicionados? ");
        Integer quant = Integer.parseInt(quant_l);
        String titulo = JOptionPane.showInputDialog("Título da área do livro: ");
        String descricao = JOptionPane.showInputDialog("Descrição do tipo do livro: ");
        AreaConhecimento infor = new AreaConhecimento(titulo,descricao);
        Livro livro = new Livro(Nome_l,autor_nome, quant, infor);
        livros.add(livro);
        livrosList.add(livro);
    }

    public void removerLivro(List<Livro> livros){
        //Estamos removendo só um livro
        String Nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autornome = JOptionPane.showInputDialog("Nome do autor do livro: ");
        for (Livro livro : livros){
            if(Nome.equals(livro.getTitulo()) && autornome.equals(livro.getAutor())){
                livrosList.remove(livro);
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");
            }
        }
    }

    public void alterarLivro(List<Livro> livros){
        String Nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autornome = JOptionPane.showInputDialog("Nome do autor do livro: ");
       // String Data = JOptionPane.showInputDialog("Data de publicação: ");
        for (Livro livro : livros){
            if(Nome.equals(livro.getTitulo()) && autornome.equals(livro.getAutor())){
                livro.setTitulo(Nome);
                livro.setAutor(autornome);
                //livro.setData(null);""
            }
        }
    }

    public void listarLivros(List<Livro> livros){
        
        liv.clear();
        for(Livro livro : livrosList){
            liv.add("Título: " + livro.getTitulo() + ", Autor: "+ livro.getAutor() + ", Cópias: " + livro.getNumCopias() + ".");
        }

        String nomes = "";
		for(String nome : liv){
			nomes += nome + "\n";
		}
		JOptionPane.showMessageDialog(null, nomes);
    }

    public void emprestimo(List<Usuario> usuarios, List<Livro> livros){
        String cpf = JOptionPane.showInputDialog("CPF do usuário: ");
        String senha = JOptionPane.showInputDialog("Senha do usuário: ");
        for(Usuario uso : usuarios){
            if(cpf.equals(uso.getCpf()) && senha.equals(uso.getSenha())){
                String nome_l = JOptionPane.showInputDialog("Nome do livro: ");
                String autor_l = JOptionPane.showInputDialog("Nome do autor do livro: ");
                for(Livro livro : livros){
                    if(nome_l.equals(livro.getTitulo()) && autor_l.equals(livro.getAutor())){
                        if(livro.getNumCopias() > 0){
                            //LocalDateTime now = LocalDateTime.now();
                            String valor = JOptionPane.showInputDialog("Qual o valor do empréstimo? ");
                            String tempo_com_livro = JOptionPane.showInputDialog("Quanto tempo vai ficar com o livro? ");
                            Float valor_e = Float.parseFloat(valor);
                            Integer tempo = Integer.parseInt(tempo_com_livro);
                            Emprestimo empres = new Emprestimo(/*now,*/livro,uso,valor_e,tempo);
                            uso.setEmprestimo(empres);
                            livro.setNumCopias(livro.getNumCopias() - 1);
                        }else{
                            JOptionPane.showMessageDialog(null, "Livro sem estoque!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Livro não cadastrado!");
                    }
                }

            }else{
                JOptionPane.showMessageDialog(null, "CPF ou senha incorretos!");
            }
        }
    }
}

/* Object[] livrosArray = liv.toArray();
        int escolhido = JOptionPane.showOptionDialog(null,
                "Livros:",
                "Menu",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                livrosArray, null);
        System.out.println(escolhido); */