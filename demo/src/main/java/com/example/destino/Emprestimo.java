package com.example.destino;

import java.util.Date;

public class Emprestimo{
    private Date dataEmp;
    private Livro livroEmp;
    private Usuario usuarioEmp;
    private float valorEmp;
    private int tempoEmp;

    public Emprestimo(/*Date dataEmp,*/ Livro livroEmp, Usuario usuarioEmp, float valorEmp, int tempoEmp){
        //this.dataEmp = dataEmp;
        this.livroEmp = livroEmp;
        this.usuarioEmp = usuarioEmp;
        this.valorEmp = valorEmp;
        this.tempoEmp = tempoEmp;
    }

    public Date getDataEmp() {
        return dataEmp;
    }

    public Livro getLivroEmp() {
        return livroEmp;
    }

    public Usuario getUsuarioEmp() {
        return usuarioEmp;
    }

    public float getValorEmp() {
        return valorEmp;
    }

    public float getTempoEmp() {
        return tempoEmp;
    }
}
