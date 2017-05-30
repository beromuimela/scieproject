/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author junito
 */
public class Curso {
    private int idcurso;
    private String nome;
    private float precoEmp;
    private float preco;
    private int nrestudantesSala;
    private int nrFaltas;

    public Curso() {
    }

    public Curso(int idcurso, String nome, float precoEmp, float preco, int nrestudantesSala, int nrFaltas) {
        this.idcurso = idcurso;
        this.nome = nome;
        this.precoEmp = precoEmp;
        this.preco = preco;
        this.nrestudantesSala = nrestudantesSala;
        this.nrFaltas = nrFaltas;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoEmp() {
        return precoEmp;
    }

    public void setPrecoEmp(float precoEmp) {
        this.precoEmp = precoEmp;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNrestudantesSala() {
        return nrestudantesSala;
    }

    public void setNrestudantesSala(int nrestudantesSala) {
        this.nrestudantesSala = nrestudantesSala;
    }

    public int getNrFaltas() {
        return nrFaltas;
    }

    public void setNrFaltas(int nrFaltas) {
        this.nrFaltas = nrFaltas;
    }
    
    
    
}
