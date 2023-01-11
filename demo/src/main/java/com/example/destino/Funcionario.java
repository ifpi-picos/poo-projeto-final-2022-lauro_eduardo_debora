package com.example.destino;

//import java.time.LocalDateTime;
import java.util.Date;
import java.io.Console;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.example.dao.AreadeConhecimentoDao;
import com.example.dao.LivroDao;
import com.example.dao.UsuarioDao;
import com.example.visao.AreaConhecimentoForm;
import com.example.visao.EmprestimoForm;
import com.example.visao.EnderecoForm;
import com.example.visao.LivroForm;
import com.example.visao.UsuarioForm;

public class Funcionario{
    private String CPF;
    private String nome;
    private String senha;

    static List<String> liv = new ArrayList<>();

    public Funcionario(String CPF, String nome, String senha){
        this.CPF = CPF;
        this.nome = nome;
        this.senha = senha;
        
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    /* Funcionalidades - Usuário */
    public void adicionarUsuario(String cpfFuncionario) throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String CPF_p = JOptionPane.showInputDialog("Seu CPF: ");

        if(new UsuarioForm().encontrarUsuario(CPF_p)){
            JOptionPane.showMessageDialog(null,"CPF já cadastrado!");      
        }else{
            try {
                String Nome_p = JOptionPane.showInputDialog("Seu nome: ");
                String dataNascimento_p = JOptionPane.showInputDialog("Data de Nascimento: ");
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
                new UsuarioForm().cadastrarUsuario(CPF_p, Nome_p, email_p, senha_p, dataNascimento, id_endere, cpfFuncionario);

                JOptionPane.showMessageDialog(null,"Usuário cadastrado com sucesso!"); 
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Dados inseridos incorretos!");
            }
        }
    }

    public void alterarUsuario(){

        String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário: ");

        if(new UsuarioForm().encontrarUsuario(cpf)){
            System.out.println("Existe!");
                
            List<Integer> menu = new ArrayList<>();
            menu.add(1);
            menu.add(2);
            menu.add(3);
            menu.add(4);
            menu.add(5);
            Object[] menusArray = menu.toArray();

            int opcaoSelecionad = 1;
            while(opcaoSelecionad != 5){
                
                opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Alterar nome \n2. Alterar email \n3. Alterar senha \n4. Alterar data de nascimento \n5. Sair",
                "O que deseja alterar?",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
    
                if(opcaoSelecionad + 1 == 1){
                    String newNome = JOptionPane.showInputDialog("Novo nome: ");
                    new UsuarioForm().alterarNome(newNome, cpf);
                    JOptionPane.showMessageDialog(null,"Nome alterado com sucesso!");
                }else if(opcaoSelecionad + 1 == 2){
                    String newEmail = JOptionPane.showInputDialog("Novo email: ");
                    new UsuarioForm().alterarEmail(newEmail, cpf);
                    JOptionPane.showMessageDialog(null,"Email alterado com sucesso!");
                }else if(opcaoSelecionad + 1 == 3){
                    String newSenha = JOptionPane.showInputDialog("Nova senha: ");
                    new UsuarioForm().alterarSenha(newSenha, cpf);
                    JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!");
                }else if(opcaoSelecionad + 1 == 4){
                    String newData = JOptionPane.showInputDialog("Nova data de nascimento: ");
                    new UsuarioForm().alterarDataUsuario(newData, cpf);
                    JOptionPane.showMessageDialog(null,"Data de nascimento alterada com sucesso!");
                }else if(opcaoSelecionad + 1 == 5){
                    break;
            }
            }

        }else{
            JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
        }

    }

    public void removerUsuario(){

        String cpf = JOptionPane.showInputDialog("Digite o CPF do usuário: ");

        if(new UsuarioForm().encontrarUsuario(cpf)){
            new UsuarioForm().removerUsuario(cpf);
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
        }  

    }

    public void listarUsuarios(){
        new UsuarioForm().listarUsuarios();
    }

    // Funcionalidades - Livro
    public void adicionarLivro(String cpfFunc) throws ParseException{

        new AreaConhecimentoForm().listarAreas();

        if(new AreaConhecimentoForm().listarAreaConhecimento()){
            String titulo = JOptionPane.showInputDialog("Título da área do livro: ");

            if(new AreaConhecimentoForm().encontrarAreaConhecimento(titulo)){
                Random geradorConta = new Random();
                int num1 = geradorConta.nextInt(9);
                int num2 = geradorConta.nextInt(9);
                int num3 = geradorConta.nextInt(9);
                int num4 = geradorConta.nextInt(9);

                String id_livro = "" + num1 + num2 + num3 + num4;
                Integer id_l = Integer.parseInt(id_livro);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String Nome_l = JOptionPane.showInputDialog("Nome do livro: ");
                String autor_nome = JOptionPane.showInputDialog("Nome do autor do livro: ");
                String data_l = JOptionPane.showInputDialog("Data de publicação: ");
                String quant_l = JOptionPane.showInputDialog("Quantos livros estão sendo adicionados? ");
                Integer quant = Integer.parseInt(quant_l);
                Date data = formatter.parse(data_l);

                new LivroForm().cadastrarlivro(id_l, Nome_l, autor_nome, data, quant, cpfFunc, titulo);

                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Área de conhecimento não cadastrada!");
            }
        }
    }

    public void alterarLivro() throws ParseException{

        String nome = JOptionPane.showInputDialog("Nome do livro: ");
        String autor = JOptionPane.showInputDialog("Nome do autor do livro: ");
        String data = JOptionPane.showInputDialog("Data de publicação: ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataForm = formatter.parse(data);

        if(new LivroForm().encontrarLivro(nome, autor, dataForm)){
            System.out.println("Existe!");
                
            List<Integer> menu = new ArrayList<>();
            menu.add(1);
            menu.add(2);
            menu.add(3);
            menu.add(4);
            menu.add(5);
            Object[] menusArray = menu.toArray();

            int opcaoSelecionad = 1;
            while(opcaoSelecionad != 5){
                
                opcaoSelecionad = JOptionPane.showOptionDialog(null,
                "1. Alterar título \n2. Alterar autor \n3. Alterar data de publicação \n4. Alterar número de cópias \n5. Sair",
                "O que deseja alterar?",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                menusArray, null);
    
                if(opcaoSelecionad + 1 == 1){
                    String newNome = JOptionPane.showInputDialog("Novo título: ");
                    new LivroForm().alterarTitulo(nome, newNome, autor, dataForm);
                    JOptionPane.showMessageDialog(null,"Título alterado com sucesso!");
                    nome = newNome;

                }else if(opcaoSelecionad + 1 == 2){
                    String newAutor = JOptionPane.showInputDialog("Novo autor: ");
                    new LivroForm().alterarAutor(autor, nome, newAutor, dataForm);
                    JOptionPane.showMessageDialog(null,"Autor alterado com sucesso!");
                    autor = newAutor;

                }else if(opcaoSelecionad + 1 == 3){
                    String newData = JOptionPane.showInputDialog("Nova data de publicação: ");
                    Date newDataForm = formatter.parse(newData);
                    new LivroForm().alterarDataPub(dataForm, nome, autor, newDataForm);
                    JOptionPane.showMessageDialog(null,"Data de publicação alterada com sucesso!");
                    dataForm = newDataForm;

                }else if(opcaoSelecionad + 1 == 4){
                    String newCopias = JOptionPane.showInputDialog("Nova número de cópias: ");
                    Integer copias = Integer.parseInt(newCopias);
                    new LivroForm().alterarNumCop(nome, autor, dataForm, copias);
                    JOptionPane.showMessageDialog(null,"Número de cópias alterado com sucesso!");

                }else if(opcaoSelecionad + 1 == 5){
                    break;
                }
            }

        }else{
            JOptionPane.showMessageDialog(null,"Livro não cadastrado!");
        }

    }

    // Removendo livro do sistema
    public void removerLivro() throws ParseException{

        String titulo = JOptionPane.showInputDialog("Nome do livro: ");
        String autor = JOptionPane.showInputDialog("Nome do autor do livro: ");
        String data = JOptionPane.showInputDialog("Data de publicação: ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataForm = formatter.parse(data);

        if(new LivroForm().encontrarLivro(titulo, autor, dataForm)){
            new LivroForm().removerLivro(titulo, autor, dataForm);
            JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Livro não cadastrado!");
        }  

    }

    public void listarLivros(List<Livro> livros){
        new LivroForm().listarLivros();
    }

    /* Funcões - Empréstimo */
    public void realizarEmprestimo(String CPF) throws ParseException{

        String nomeLivro = JOptionPane.showInputDialog("Nome do livro: ");
        String nomeAutor = JOptionPane.showInputDialog("Nome do autor do livro: ");
        String dataPub = JOptionPane.showInputDialog("Data de publicação: ");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPubForm = formatter.parse(dataPub);

        if(new LivroForm().encontrarLivro(nomeLivro, nomeAutor, dataPubForm)){

            // Dados livro
            String tempoEmp = JOptionPane.showInputDialog("Tempo de empréstimo: ");
            String valorEmp = JOptionPane.showInputDialog("Valor empréstimo: ");
            int idLivro = new LivroDao().buscarIdLivro(nomeLivro, nomeAutor, dataPubForm);

            int tempoEmpForm = Integer.parseInt(tempoEmp);
            System.out.println(tempoEmpForm);

            double valorEmpForm = Double.parseDouble(valorEmp);
            System.out.println(valorEmpForm);


            String cpfUsuario = JOptionPane.showInputDialog("CPF do usuário: ");
            if(new UsuarioForm().encontrarUsuario(cpfUsuario)){

                // Adquirindo data atual e formatando
                Date date = new Date(System.currentTimeMillis());
                String dataS = formatter.format(date);
                Date dataAtual = formatter.parse(dataS);

                new EmprestimoForm().cadastrarEmprestimo(tempoEmpForm, valorEmpForm, dataAtual, idLivro, cpfUsuario);

                JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Livro não cadastrado!");
        }
        
    }

    public void removerEmprestimo(){
        String cpf = JOptionPane.showInputDialog("Qual o CPF do usuário?");
        new EmprestimoForm().removerEmprestimo(cpf);
    }

    public void cadastrarAreadeconhecimento(){
        String titulo = JOptionPane.showInputDialog("Qual o título?");

        if(new AreaConhecimentoForm().encontrarAreaConhecimento(titulo)){
            JOptionPane.showMessageDialog(null, "Área já cadastrada!");
        }else{
            String descricao = JOptionPane.showInputDialog("Escreva a descrição dessa área");

            new AreaConhecimentoForm().cadastrarAreadeConhecimento(titulo, descricao);

            JOptionPane.showMessageDialog(null, "Área cadastrada com sucesso!");
        }
    }
}
