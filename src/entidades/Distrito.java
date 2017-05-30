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
public class Distrito {
    private int iddistrito;
    private Provincia provincia;
    private String nome;

    public Distrito() {
    }

    public Distrito(int iddistrito, Provincia provincia, String nome) {
        this.iddistrito = iddistrito;
        this.provincia = provincia;
        this.nome = nome;
    }
 
    public Distrito(int iddistrito, String nome) {
        this.iddistrito = iddistrito;
        this.nome = nome;
    }

    public int getIddistrito() {
        return iddistrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public void setIddistrito(int iddistrito) {
        this.iddistrito = iddistrito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
