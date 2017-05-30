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
public class Inscricao {
    private int idinscricao;
    private Date datainscricao;
    private Candidato candidato;
    private Curso curso;
    private float valor;
    private boolean cancelado;
    private String motivo;
    private Utilizador utilizador;
    private Periodo periodo;
    private float troco; 

    public Inscricao() {
    }

    public Inscricao(int idinscricao, Date datainscricao, float troco,Candidato candidato, Curso curso, float valor, boolean cancelado, String motivo, Utilizador utilizador, Periodo periodo) {
        this.idinscricao = idinscricao;
        this.datainscricao = datainscricao;
        this.candidato = candidato;
        this.curso = curso;
        this.valor = valor;
        this.cancelado = cancelado;
        this.motivo = motivo;
        this.utilizador = utilizador;
        this.periodo = periodo;
        this.troco=troco;
    }

    public int getIdinscricao() {
        return idinscricao;
    }

    public void setIdinscricao(int idinscricao) {
        this.idinscricao = idinscricao;
    }

    public Date getDatainscricao() {
        return datainscricao;
    }

    public void setDatainscricao(Date datainscricao) {
        this.datainscricao = datainscricao;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    
    
}
