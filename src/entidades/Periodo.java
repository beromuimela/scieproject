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
public class Periodo {
    private Curso curso;
    private Nome_periodo nomePeriodo;
    private Date datainicio;
    private Date datatermino;
    private Formador formador;

    public Periodo() {
    }

    public Periodo(Curso curso, Nome_periodo nomePeriodo, Date datainicio, Date datatermino, Formador formador) {
        this.curso = curso;
        this.nomePeriodo = nomePeriodo;
        this.datainicio = datainicio;
        this.datatermino = datatermino;
        this.formador = formador;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Nome_periodo getNomePeriodo() {
        return nomePeriodo;
    }

    public void setNomePeriodo(Nome_periodo nomePeriodo) {
        this.nomePeriodo = nomePeriodo;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public Formador getFormador() {
        return formador;
    }

    public void setFormador(Formador formador) {
        this.formador = formador;
    }
    
    
    
    
}
