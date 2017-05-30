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
public class Utilizador {
    private int idutilizador;
    private String nome;
    private String senha;
    private String login;
    private boolean acessoCandidato;
    private boolean isdesactivado;
    private boolean acessoInscricao;
    private boolean acessoRelatorioHonorario;
    private boolean acessoRelatorioInscricoes;
    private boolean acessoAvancado;
    private boolean acessoCcandidato;
    private boolean acessoCestudante;
    private boolean acessoCaulas;
    private boolean acessoCfaltas;
    private boolean acessoCnotas;
    private boolean acessoFormadores;
    private boolean acessoCformadores;
    private boolean acessoCperiodo;
    private boolean acessoPeriodo;
    private boolean acessoEfectuarPagamento;
    private boolean acessoCutilizadores;
    private boolean acessoRegistarUtilizador;
    private boolean acessoCurso;
    private boolean acessoAberturaCaixa;
    private boolean acessoMovimentoCaixa;
    private boolean acessoLocalizacao;
    private boolean acessoRetirarValor;
    private boolean acessoFechocaixa;
    
    public Utilizador() {
    }

    public Utilizador(int idutilizador, boolean acessoRelatorioHonorario,boolean acessoRetirarValor,boolean acessoFechoCaixa,String nome, String senha, String login, boolean acessoRegistarUtilizador,boolean acessoCandidato, boolean isdesactivado, boolean acessoInscricao, boolean acessoRelatorioCaixa, boolean acessoAvancado, boolean acessoCcandidato, boolean acessoCestudante, boolean acessoCaulas, boolean acessoCfaltas, boolean acessoCnotas, boolean acessoFormadores, boolean acessoCformadores, boolean acessoCperiodo, boolean acessoPeriodo, boolean acessoEfectuarPagamento, boolean acessoCutilizadores, boolean acessoCurso, boolean acessoAberturaCaixa, boolean acessoMovimentoCaixa, boolean acessoLocalizacao) {
        this.idutilizador = idutilizador;
        this.acessoRetirarValor= acessoRetirarValor;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.acessoCandidato = acessoCandidato;
        this.isdesactivado = isdesactivado;
        this.acessoInscricao = acessoInscricao;
        this.acessoRelatorioHonorario = acessoRelatorioHonorario;
        this.acessoAvancado = acessoAvancado;
        this.acessoCcandidato = acessoCcandidato;
        this.acessoCestudante = acessoCestudante;
        this.acessoCaulas = acessoCaulas;
        this.acessoCfaltas = acessoCfaltas;
        this.acessoCnotas = acessoCnotas;
        this.acessoFormadores = acessoFormadores;
        this.acessoCformadores = acessoCformadores;
        this.acessoCperiodo = acessoCperiodo;
        this.acessoPeriodo = acessoPeriodo;
        this.acessoEfectuarPagamento = acessoEfectuarPagamento;
        this.acessoCutilizadores = acessoCutilizadores;
        this.acessoCurso = acessoCurso;
        this.acessoAberturaCaixa = acessoAberturaCaixa;
        this.acessoMovimentoCaixa = acessoMovimentoCaixa;
        this.acessoLocalizacao = acessoLocalizacao;
        this.acessoRegistarUtilizador=acessoRegistarUtilizador;
        this.acessoFechocaixa=acessoFechoCaixa;
    }

    public int getIdutilizador() {
        return idutilizador;
    }

    public boolean isAcessoFechocaixa() {
        return acessoFechocaixa;
    }

    public void setAcessoFechocaixa(boolean acessoFechocaixa) {
        this.acessoFechocaixa = acessoFechocaixa;
    }

    public void setIdutilizador(int idutilizador) {
        this.idutilizador = idutilizador;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAcessoRetirarValor() {
        return acessoRetirarValor;
    }

    public void setAcessoRetirarValor(boolean acessoRetirarValor) {
        this.acessoRetirarValor = acessoRetirarValor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isAcessoCandidato() {
        return acessoCandidato;
    }

    public void setAcessoCandidato(boolean acessoCandidato) {
        this.acessoCandidato = acessoCandidato;
    }

    public boolean isIsdesactivado() {
        return isdesactivado;
    }

    public void setIsdesactivado(boolean isdesactivado) {
        this.isdesactivado = isdesactivado;
    }

    public boolean isAcessoInscricao() {
        return acessoInscricao;
    }

    public void setAcessoInscricao(boolean acessoInscricao) {
        this.acessoInscricao = acessoInscricao;
    }

    public boolean isAcessoRelatorioHonorario() {
        return acessoRelatorioHonorario;
    }

    public void setAcessoRelatorioHonorario(boolean acessoRelatorioHonorario) {
        this.acessoRelatorioHonorario = acessoRelatorioHonorario;
    }

    public boolean isAcessoRelatorioInscricoes() {
        return acessoRelatorioInscricoes;
    }

    public void setAcessoRelatorioInscricoes(boolean acessoRelatorioInscricoes) {
        this.acessoRelatorioInscricoes = acessoRelatorioInscricoes;
    }

    public boolean isAcessoAvancado() {
        return acessoAvancado;
    }

    public void setAcessoAvancado(boolean acessoAvancado) {
        this.acessoAvancado = acessoAvancado;
    }

    public boolean isAcessoCcandidato() {
        return acessoCcandidato;
    }

    public void setAcessoCcandidato(boolean acessoCcandidato) {
        this.acessoCcandidato = acessoCcandidato;
    }

    public boolean isAcessoCestudante() {
        return acessoCestudante;
    }

    public void setAcessoCestudante(boolean acessoCestudante) {
        this.acessoCestudante = acessoCestudante;
    }

    public boolean isAcessoCaulas() {
        return acessoCaulas;
    }

    public void setAcessoCaulas(boolean acessoCaulas) {
        this.acessoCaulas = acessoCaulas;
    }

    public boolean isAcessoCfaltas() {
        return acessoCfaltas;
    }

    public void setAcessoCfaltas(boolean acessoCfaltas) {
        this.acessoCfaltas = acessoCfaltas;
    }

    public boolean isAcessoCnotas() {
        return acessoCnotas;
    }

    public void setAcessoCnotas(boolean acessoCnotas) {
        this.acessoCnotas = acessoCnotas;
    }

    public boolean isAcessoFormadores() {
        return acessoFormadores;
    }

    public void setAcessoFormadores(boolean acessoFormadores) {
        this.acessoFormadores = acessoFormadores;
    }

    public boolean isAcessoCformadores() {
        return acessoCformadores;
    }

    public void setAcessoCformadores(boolean acessoCformadores) {
        this.acessoCformadores = acessoCformadores;
    }

    public boolean isAcessoCperiodo() {
        return acessoCperiodo;
    }

    public void setAcessoCperiodo(boolean acessoCperiodo) {
        this.acessoCperiodo = acessoCperiodo;
    }

    public boolean isAcessoPeriodo() {
        return acessoPeriodo;
    }

    public void setAcessoPeriodo(boolean acessoPeriodo) {
        this.acessoPeriodo = acessoPeriodo;
    }

    public boolean isAcessoEfectuarPagamento() {
        return acessoEfectuarPagamento;
    }

    public void setAcessoEfectuarPagamento(boolean acessoEfectuarPagamento) {
        this.acessoEfectuarPagamento = acessoEfectuarPagamento;
    }

    public boolean isAcessoCutilizadores() {
        return acessoCutilizadores;
    }

    public void setAcessoCutilizadores(boolean acessoCutilizadores) {
        this.acessoCutilizadores = acessoCutilizadores;
    }

    public boolean isAcessoCurso() {
        return acessoCurso;
    }

    public void setAcessoCurso(boolean acessoCurso) {
        this.acessoCurso = acessoCurso;
    }

    public boolean isAcessoAberturaCaixa() {
        return acessoAberturaCaixa;
    }

    public void setAcessoAberturaCaixa(boolean acessoAberturaCaixa) {
        this.acessoAberturaCaixa = acessoAberturaCaixa;
    }

    public boolean isAcessoMovimentoCaixa() {
        return acessoMovimentoCaixa;
    }

    public void setAcessoMovimentoCaixa(boolean acessoMovimentoCaixa) {
        this.acessoMovimentoCaixa = acessoMovimentoCaixa;
    }

    public boolean isAcessoLocalizacao() {
        return acessoLocalizacao;
    }

    public void setAcessoLocalizacao(boolean acessoLocalizacao) {
        this.acessoLocalizacao = acessoLocalizacao;
    }

    public boolean isAcessoRegistarUtilizador() {
        return acessoRegistarUtilizador;
    }

    public void setAcessoRegistarUtilizador(boolean acessoRegistarUtilizador) {
        this.acessoRegistarUtilizador = acessoRegistarUtilizador;
    }

    
}
