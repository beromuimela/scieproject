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
public class Sexo {
    private int idsexo;
    private String nome;

    public Sexo() {
    }

    public Sexo(int idsexo) {
        this.idsexo = idsexo;
    }

    public Sexo(int idsexo, String nome) {
        this.idsexo = idsexo;
        this.nome = nome;
    }

    public int getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(int idsexo) {
        this.idsexo = idsexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
