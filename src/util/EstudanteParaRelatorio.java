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
public class EstudanteParaRelatorio {
    private int id;
    private String nome;
    private String documento;
    private String numero;

    public EstudanteParaRelatorio() {
    }

    public EstudanteParaRelatorio(int id, String nome, String documento, String numero) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}
