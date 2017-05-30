/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import util.DataUtilizador;

/**
 *
 * @author junito
 */
public class Movimentos {
    private int idmovimento;
    private DataUtilizador datamovimento;
    private String tipoMovimento;
    private float valor;
    private String responsavel;
    private String historico;
    private Utilizador utilizador;
    private int t;

    public Movimentos() {
    }
    
    public Movimentos(int idmovimento, DataUtilizador datamovimento, String tipoMovimento, float valor, String responsavel, String historico, Utilizador utilizador) {
        this.idmovimento = idmovimento;
        this.datamovimento = datamovimento;
        this.tipoMovimento = tipoMovimento;
        this.valor = valor;
        this.responsavel = responsavel;
        this.historico = historico;
        this.utilizador = utilizador;
    }

    public int getIdmovimento() {
        return idmovimento;
    }

    public void setIdmovimento(int idmovimento) {
        this.idmovimento = idmovimento;
    }

    public DataUtilizador getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(DataUtilizador datamovimento) {
        this.datamovimento = datamovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
}
