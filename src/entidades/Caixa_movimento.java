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
public class Caixa_movimento {
    private Caixa caixa;
    private Movimentos movimento;

    public Caixa_movimento() {
    }

    public Caixa_movimento(Caixa caixa, Movimentos movimento) {
        this.caixa = caixa;
        this.movimento = movimento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Movimentos getMovimento() {
        return movimento;
    }

    public void setMovimento(Movimentos movimento) {
        this.movimento = movimento;
    }
    
    
    
}
