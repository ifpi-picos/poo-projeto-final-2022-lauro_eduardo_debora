package com.example.destino;

import java.util.Date;

public class Emprestimo{
    private Date dataEmp;
    private int livroEmp;
    private String usuarioEmp;
    private float valorEmp;
    private int tempoEmp;

    public Emprestimo(Date dataEm, int livroEmp, String usuarioEmp, float valorEmp, int tempoEmp){
        this.dataEmp = dataEm;
        this.livroEmp = livroEmp;
        this.usuarioEmp = usuarioEmp;
        this.valorEmp = valorEmp;
        this.tempoEmp = tempoEmp;
    }

    public Date getDataEmp() {
        return dataEmp;
    }

    public int getLivroEmp() {
        return livroEmp;
    }

    public String getUsuarioEmp() {
        return usuarioEmp;
    }

    public float getValorEmp() {
        return valorEmp;
    }

    public float getTempoEmp() {
        return tempoEmp;
    }
}
