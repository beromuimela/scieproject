/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author junito
 */
public class CaixaParaRelatorio {
    private String dataMovimento;
    private float valor;
    private String tipoMovimento;
    private String responsavel;
    private String historico;
    private float entradas;
    private float saidas;
    private float saldo;

    public CaixaParaRelatorio() {
    }

    public CaixaParaRelatorio(String dataMovimento, float valor, String tipoMovimento, String responsavel, String historico, float entradas, float saidas, float saldo) {
        this.dataMovimento = dataMovimento;
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
        this.responsavel = responsavel;
        this.historico = historico;
        this.entradas = entradas;
        this.saidas = saidas;
        this.saldo = saldo;
    }

    public String getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
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

    public float getEntradas() {
        return entradas;
    }

    public void setEntradas(float entradas) {
        this.entradas = entradas;
    }

    public float getSaidas() {
        return saidas;
    }

    public void setSaidas(float saidas) {
        this.saidas = saidas;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    
}
