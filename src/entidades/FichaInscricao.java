/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Lucinda
 */
public class FichaInscricao {
    private int idmatricula;
    private Candidato candidato;
    private Utilizador unicaP;
    private Utilizador duplaFirst;
    private Utilizador duplaSecond;
    private Date data;

    public FichaInscricao() {
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Utilizador getUnicaP() {
        return unicaP;
    }

    public void setUnicaP(Utilizador unicaP) {
        this.unicaP = unicaP;
    }

    public Utilizador getDuplaFirst() {
        return duplaFirst;
    }

    public void setDuplaFirst(Utilizador duplaFirst) {
        this.duplaFirst = duplaFirst;
    }

    public Utilizador getDuplaSecond() {
        return duplaSecond;
    }

    public void setDuplaSecond(Utilizador duplaSecond) {
        this.duplaSecond = duplaSecond;
    }  

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
