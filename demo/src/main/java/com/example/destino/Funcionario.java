package com.example.destino;

//import java.time.LocalDateTime;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.example.visao.EnderecoForm;
import com.example.visao.UsuarioForm;

public class Funcionario{
    private String nome;
    private String CPF;
    private String senha;
    private String id;

    static List<String> liv = new ArrayList<>();
    // static List<Livro> livrosList = new ArrayList<>();

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

    public void adicionarUsuario(List<Usuario> usuarios) throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");
        String dataNascimento_p = JOptionPane.showInputDialog("Data de Nascimento: ");
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

        long convertor_cep = Long.parseLong(cep_p);
        int convertor_num = Integer.parseInt(numero_p);
        Date dataNascimento = formatter.parse(dataNascimento_p);

        Random geradorConta = new Random();
        int num1 = geradorConta.nextInt(9);
        int num2 = geradorConta.nextInt(9);
        int num3 = geradorConta.nextInt(9);
        int num4 = geradorConta.nextInt(9);

        String id_endere = "" + num1 + num2 + num3 + num4;

        new EnderecoForm().cadastrarEndereco(id_endere, bairro_p, rua_p, convertor_num, convertor_cep);
        new UsuarioForm().cadastrarUsuario(CPF_p, Nome_p, email_p, senha_p, dataNascimento, id_endere);

        // Endereco endereco = new Endereco(bairro_p,rua_p,convertor_nu,convertor_n);
        // Usuario Usuario = new Usuario(Nome_p, email_p, senha_p, CPF_p, endereco);
        // usuarios.add(Usuario);
    }

    public void alterarUsuario(){

        String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário: ");

        boolean userExist = new UsuarioForm().encontrarUsuario(cpf);

        if(userExist){
            System.out.println("Existe!");
        }else{
            System.out.println("Não existe!");
        }

    }
    public void removerUsuario(){

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
        // livrosList.add(livro);
    }

    // Removendo livro do sistema
    public void removerLivro(List<Livro> livros){
        String Nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autornome = JOptionPane.showInputDialog("Nome do autor do livro: ");
        for (Livro livro : livros){
            if(Nome.equals(livro.getTitulo()) && autornome.equals(livro.getAutor())){
                livros.remove(livro);
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
        for(Livro livro : livros){
            liv.add("Título: " + livro.getTitulo() + ", Autor: "+ livro.getAutor() + ", Cópias: " + livro.getNumCopias() + ".");
        }

        String nomes = "";
		for(String nome : liv){
			nomes += nome + "\n";
		}
		JOptionPane.showMessageDialog(null, nomes);
    }

    public void emprestimo(List<Usuario> usuarios, List<Livro> livros){

        List<String> users = new ArrayList<>();
        List<String> books = new ArrayList<>(); 

        for(Usuario user : usuarios){
            users.add(user.getCpf() + user.getSenha());
        }
        for(Livro book : livros){
            books.add(book.getTitulo() + book.getAutor());
        }


        String cpf = JOptionPane.showInputDialog("CPF do usuário: ");
        String senha = JOptionPane.showInputDialog("Senha do usuário: ");

        if(users.contains(cpf+senha)){

            for(Usuario uso : usuarios){

                if(cpf.equals(uso.getCpf()) && senha.equals(uso.getSenha())){
                    String nome_l = JOptionPane.showInputDialog("Nome do livro: ");
                    String autor_l = JOptionPane.showInputDialog("Nome do autor do livro: ");

                    if(books.contains(nome_l+autor_l)){

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
                            }
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Livro não cadastrado!");
                    }
                    

                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
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