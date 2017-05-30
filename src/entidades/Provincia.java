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
public class Provincia {
    private int idprovincia;
    private Pais pais;
    private String nome;

    public Provincia() {
    }

    public Provincia(int idprovincia, String nome) {
        this.idprovincia = idprovincia;
        this.nome = nome;
    }

    public Provincia(int idprovincia, Pais pais, String nome) {
        this.idprovincia = idprovincia;
        this.pais = pais;
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
