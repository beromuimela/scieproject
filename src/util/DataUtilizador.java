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
public class DataUtilizador {
    int dia;
    int mes;
    int ano;
    int hora;
    int minuto;
    int segundos;

    public DataUtilizador() {
    }

    public DataUtilizador(int dia, int mes, int ano, int hora, int minuto, int segundos) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
        this.segundos = segundos;
    }

    public String mostrarData(){
        return this.dia+"-"+this.mes+"-"+this.ano;
    }
    
    public String mostrarHora(){
        return this.hora+":"+this.minuto+":"+this.segundos;
    }
    
    public String mostrarDataHora(){
        return this.dia+"-"+this.mes+"-"+this.ano+"   "+this.hora+":"+this.minuto+":"+this.segundos;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    
    
}
