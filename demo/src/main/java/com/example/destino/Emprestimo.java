package com.example.destino;

import java.util.Date;

public class Emprestimo{
    private int idEmprestimo;
    private int tempoEmp;
    private double valorEmp;
    private Date dataEmp;
    private int livroEmp;
    private String usuarioEmp;

    public Emprestimo(int id, int tempoEmp, double valorEmp, Date dataEm, int livroEmp, String usuarioEmp){
        this.idEmprestimo = id;
        this.tempoEmp = tempoEmp;
        this.valorEmp = valorEmp;
        this.dataEmp = dataEm;
        this.livroEmp = livroEmp;
        this.usuarioEmp = usuarioEmp;  
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
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

    public double getValorEmp() {
        return valorEmp;
    }

    public int getTempoEmp() {
        return tempoEmp;
    }
}
