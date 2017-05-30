/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import util.Imagem;

/**
 *
 * @author junito
 */
public class Estudante {
    private int idestudante;
    private Candidato candidato;
    private float saldo;
    private float notaexame;
    private boolean activo;
    private String motivo;
    private Periodo periodo;
    private boolean terminouCurso;

    public Estudante() {
    }

    public Estudante(int idestudante, Candidato candidato, float saldo, float notaexame, boolean activo, String motivo, Periodo periodo, boolean terminouCurso) {
        this.idestudante = idestudante;
        this.candidato = candidato;
        this.saldo = saldo;
        this.notaexame = notaexame;
        this.activo = activo;
        this.motivo = motivo;
        this.periodo = periodo;
        this.terminouCurso = terminouCurso;
    }

    public int getIdestudante() {
        return idestudante;
    }

    public void setIdestudante(int idestudante) {
        this.idestudante = idestudante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getNotaexame() {
        return notaexame;
    }

    public void setNotaexame(float notaexame) {
        this.notaexame = notaexame;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public boolean isTerminouCurso() {
        return terminouCurso;
    }

    public void setTerminouCurso(boolean terminouCurso) {
        this.terminouCurso = terminouCurso;
    }
}
