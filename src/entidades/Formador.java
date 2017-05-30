/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author junito
 */
public class Formador {
    private int idformador;
    private String nome;
    private Sexo sexo;
    private Date datanascimento;
    private Date datacadastro;
    private String morada;
    private String email;
    private String telefone;

    public Formador() {
    }

    public Formador(int idformador, String nome, Sexo sexo, Date datanascimento, Date datacadastro, String morada, String email, String telefone) {
        this.idformador = idformador;
        this.nome = nome;
        this.sexo = sexo;
        this.datanascimento = datanascimento;
        this.datacadastro = datacadastro;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdformador() {
        return idformador;
    }

    public void setIdformador(int idformador) {
        this.idformador = idformador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
