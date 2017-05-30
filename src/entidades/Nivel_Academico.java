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
public class Nivel_Academico {
    private int idnivelacademico;
    private String nome;

    public Nivel_Academico() {
    }

    public Nivel_Academico(int idnivelacademico, String nome) {
        this.idnivelacademico = idnivelacademico;
        this.nome = nome;
    }

    public int getIdnivelacademico() {
        return idnivelacademico;
    }

    public void setIdnivelacademico(int idnivelacademico) {
        this.idnivelacademico = idnivelacademico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
