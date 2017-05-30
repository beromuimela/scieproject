/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import util.Imagem;
import java.util.Date;
import javafx.scene.Camera;

/**
 *
 * @author junito
 */
public class Candidato {
    private int idcandidato;
    private String nome;
    private Date datanascimento;
    private Imagem foto;
    private Sexo sexo;
    private Distrito distrito;
    private Provincia provincia;
    private Pais pais;
    private String nomepai;
    private String nomemae;
    private Tipo_Id tipoid;
    private String numerodocumento;
    private Date dataemissao;
    private String localemissao;
    private String morada;
    private String telefone;
    private String email;
    private Situacao_Profissional situacaoprof;
    private String profissao;
    private String localdetrabalho;
    private String telefoneTrabalho;
    private String emailTrabalho;
    private Nivel_Academico nivelAcademico;
    private String apelido;
    private Date datacadastro;
    private boolean isSingular;
    private String habilidades;
    private SitP sitP;

    public Candidato() {
    }
    

    public Candidato(int idcandidato, String nome, Date datanascimento, Imagem foto, Sexo sexo, Distrito distrito, String habilidades,Provincia provincia, Pais pais, String nomepai, String nomemae, Tipo_Id tipoid, String numerodocumento, Date dataemissao, String localemissao, String morada, String telefone, String email, Situacao_Profissional situacaoprof, String profissao, String localdetrabalho, String telefoneTrabalho, String emailTrabalho, Nivel_Academico nivelAcademico, String apelido, Date datacadastro, boolean isSingular, String nomedaimagem,SitP sitP) {
        this.idcandidato = idcandidato;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.foto = foto;
        this.sexo = sexo;
        this.distrito = distrito;
        this.provincia = provincia;
        this.pais = pais;
        this.nomepai = nomepai;
        this.nomemae = nomemae;
        this.tipoid = tipoid;
        this.numerodocumento = numerodocumento;
        this.dataemissao = dataemissao;
        this.localemissao = localemissao;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.situacaoprof = situacaoprof;
        this.profissao = profissao;
        this.localdetrabalho = localdetrabalho;
        this.telefoneTrabalho = telefoneTrabalho;
        this.emailTrabalho = emailTrabalho;
        this.nivelAcademico = nivelAcademico;
        this.apelido = apelido;
        this.datacadastro = datacadastro;
        this.isSingular = isSingular;
        this.habilidades=habilidades;
        this.sitP=sitP;
    }
    public Candidato( String nome, Date datanascimento, Imagem foto, Sexo sexo,String habilidades, Distrito distrito, Provincia provincia, Pais pais, String nomepai, String nomemae, Tipo_Id tipoid, String numerodocumento, Date dataemissao, String localemissao, String morada, String telefone, String email, Situacao_Profissional situacaoprof, String profissao, String localdetrabalho, String telefoneTrabalho, String emailTrabalho, Nivel_Academico nivelAcademico, String apelido, Date datacadastro, boolean isSingular, String nomedaimagem,SitP sitP) {
        this.nome = nome;
        this.habilidades=habilidades;
        this.datanascimento = datanascimento;
        this.foto = foto;
        this.sexo = sexo;
        this.distrito = distrito;
        this.provincia = provincia;
        this.pais = pais;
        this.nomepai = nomepai;
        this.nomemae = nomemae;
        this.tipoid = tipoid;
        this.numerodocumento = numerodocumento;
        this.dataemissao = dataemissao;
        this.localemissao = localemissao;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.situacaoprof = situacaoprof;
        this.profissao = profissao;
        this.localdetrabalho = localdetrabalho;
        this.telefoneTrabalho = telefoneTrabalho;
        this.emailTrabalho = emailTrabalho;
        this.nivelAcademico = nivelAcademico;
        this.apelido = apelido;
        this.datacadastro = datacadastro;
        this.isSingular = isSingular;
        this.sitP=sitP;
    }

    
    public int getIdcandidato() {
        return idcandidato;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public void setIdcandidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Imagem getFoto() {
        return foto;
    }

    public void setFoto(Imagem foto) {
        this.foto = foto;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNomepai() {
        return nomepai;
    }

    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }

    public String getNomemae() {
        return nomemae;
    }

    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    public Tipo_Id getTipoid() {
        return tipoid;
    }

    public void setTipoid(Tipo_Id tipoid) {
        this.tipoid = tipoid;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getLocalemissao() {
        return localemissao;
    }

    public void setLocalemissao(String localemissao) {
        this.localemissao = localemissao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Situacao_Profissional getSituacaoprof() {
        return situacaoprof;
    }

    public void setSituacaoprof(Situacao_Profissional situacaoprof) {
        this.situacaoprof = situacaoprof;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getLocaldetrabalho() {
        return localdetrabalho;
    }

    public void setLocaldetrabalho(String localdetrabalho) {
        this.localdetrabalho = localdetrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    public String getEmailTrabalho() {
        return emailTrabalho;
    }

    public void setEmailTrabalho(String emailTrabalho) {
        this.emailTrabalho = emailTrabalho;
    }

    public Nivel_Academico getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(Nivel_Academico nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public boolean isIsSingular() {
        return isSingular;
    }

    public void setIsSingular(boolean isSingular) {
        this.isSingular = isSingular;
    }

    public SitP getSitP() {
        return sitP;
    }

    public void setSitP(SitP sitP) {
        this.sitP = sitP;
    }

   
    
    
    
    
}
