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
public class Situacao_Profissional {
    private int idsituacaoprofissional;
    private String nome;

    public Situacao_Profissional(int idsituacaoprofissional, String nome) {
        this.idsituacaoprofissional = idsituacaoprofissional;
        this.nome = nome;
    }

    public Situacao_Profissional() {
    }

    public int getIdsituacaoprofissional() {
        return idsituacaoprofissional;
    }

    public void setIdsituacaoprofissional(int idsituacaoprofissional) {
        this.idsituacaoprofissional = idsituacaoprofissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
