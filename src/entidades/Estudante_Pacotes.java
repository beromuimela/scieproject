/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author junito
 */
public class Estudante_Pacotes {
    private Pacotes pacotes;
    private Estudante estudante;
    private Date data;
    private float nota;
    private int numerofaltas;

    public Estudante_Pacotes() {
    }

    public Estudante_Pacotes(Pacotes pacotes, Estudante estudante, Date data, float nota, int numerofaltas) {
        this.pacotes = pacotes;
        this.estudante = estudante;
        this.data = data;
        this.nota = nota;
        this.numerofaltas = numerofaltas;
    }

    public Estudante_Pacotes(Pacotes pacotes, Estudante estudante, Date data) {
        this.pacotes = pacotes;
        this.estudante = estudante;
        this.data = data;
    }
    

    public Pacotes getPacotes() {
        return pacotes;
    }

    public void setPacotes(Pacotes pacotes) {
        this.pacotes = pacotes;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getNumerofaltas() {
        return numerofaltas;
    }

    public void setNumerofaltas(int numerofaltas) {
        this.numerofaltas = numerofaltas;
    }
    
    
    
}
