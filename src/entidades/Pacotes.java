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
public class Pacotes {
    private int idpacotes;
    private String nome;

    public Pacotes() {
    }

    public Pacotes(int idpacotes, String nome) {
        this.idpacotes = idpacotes;
        this.nome = nome;
    }

    public int getIdpacotes() {
        return idpacotes;
    }

    public void setIdpacotes(int idpacotes) {
        this.idpacotes = idpacotes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
