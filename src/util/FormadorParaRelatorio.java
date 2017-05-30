/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author junito
 */
public class FormadorParaRelatorio {
    /*
    "Numero", "Data de Cadastro", "Nome Completo", "Sexo"
    */
    private int id;
    private String datacadastro;
    private String nomeCompleto;
    private String sexo;

    public FormadorParaRelatorio(int id, String datacadastro, String nomeCompleto, String sexo) {
        this.id = id;
        this.datacadastro = datacadastro;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
    }

    public FormadorParaRelatorio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
