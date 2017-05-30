/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import util.DataUtilizador;

/**
 *
 * @author junito
 */
public class Caixa {
    private int idcaixa;
    private float abertura;
    private entidades.Utilizador utilizador;
    private boolean aberto;
    private DataUtilizador datacaixa;

    public Caixa() {
    }

    public Caixa(int idcaixa, float abertura, Utilizador utilizador, boolean aberto, DataUtilizador datacaixa) {
        this.idcaixa = idcaixa;
        this.abertura = abertura;
        this.utilizador = utilizador;
        this.aberto = aberto;
        this.datacaixa = datacaixa;
    }

    public int getIdcaixa() {
        return idcaixa;
    }

    public void setIdcaixa(int idcaixa) {
        this.idcaixa = idcaixa;
    }

    public float getAbertura() {
        return abertura;
    }

    public void setAbertura(float abertura) {
        this.abertura = abertura;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public DataUtilizador getDatacaixa() {
        return datacaixa;
    }

    public void setDatacaixa(DataUtilizador datacaixa) {
        this.datacaixa = datacaixa;
    }
    
    
    
}
