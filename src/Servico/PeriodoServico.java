/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.PeriodoDAO;
import entidades.Nome_periodo;
import entidades.Periodo;
import entidades.Periodo_Pacotes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class PeriodoServico {

    private final PeriodoDAO dao;

    public PeriodoServico() {
        dao = new PeriodoDAO();
    }

    public List<Nome_periodo> listaNomePeriodos() {
        List<Nome_periodo> nomePeriodos = new ArrayList<Nome_periodo>();
        try {
            nomePeriodos = dao.listaNomePeriodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return nomePeriodos;
    }

    public List<Date> listaDatasPeriodos(Nome_periodo n) {
        List<Date> datas = new ArrayList<Date>();
        try {
            datas = dao.listaDatasPeriodo(n);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return datas;
    }
    
    public List<Date> listaTodasDatasPeriodos(Nome_periodo n) {
        List<Date> datas = new ArrayList<Date>();
        try {
            datas = dao.listaTodasDatasPeriodo(n);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return datas;
    }

    public Date obterData(String data, Nome_periodo n) {
        for (Date d : listaDatasPeriodos(n)) {
            int ano = d.getYear();
            int mes = d.getMonth();
            int dia = d.getDate();
            String novaData = ano + "-" + mes + "-" + dia;
            if (novaData.equals(data)) {
                return d;
            }
        }
        return null;
    }

    public List<Periodo> listaPeriodos() {
        List<Periodo> periodos = new ArrayList<Periodo>();
        try {
            periodos = dao.listaPeriodo();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return periodos;
    }

    public List<Periodo> periodosActivos(){
        List<Periodo> periodos=new ArrayList<Periodo>();
        for(Periodo p:listaPeriodos())
            if(p.getDatatermino()==null)
                periodos.add(p);
        return periodos;
    }
    
    public List<Periodo> periodosInactivos(){
        List<Periodo> periodos=new ArrayList<Periodo>();
        for(Periodo p:listaPeriodos())
            if(p.getDatatermino()!=null)
                periodos.add(p);
        return periodos;
    }
    
    public boolean mesmaData(Date data1,Date data2){
        boolean teste=false;
        int anox=data1.getYear();
        int mesx=data1.getMonth();
        int diax=data1.getDate();
        int anoy=data2.getYear();
        int mesy=data2.getMonth();
        int diay=data2.getDate();
        if((anox+mesx+diax)-(anoy+mesy+diay)==0)
            teste=true;
        return teste;
    }
    
    public Periodo obterPeriodo(Date data, Nome_periodo nomep) {
        for (Periodo p : listaPeriodos()) {
            if ((p.getNomePeriodo().getId()==nomep.getId()&& mesmaData(p.getDatainicio(), data))) {
                return p;
            }
        }
        return null;
    }

    public void salvar(Periodo periodo) {
        try {
            dao.salvar(periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void encerrar(Periodo periodo) {
        try {
            dao.encerrar(periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Nome_periodo ObterNomePeriodo(String nome) {
        for (Nome_periodo p : listaNomePeriodos()) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public Nome_periodo ObterNomePeriodo(int id) {
        for (Nome_periodo p : listaNomePeriodos()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     *
     * @param periodo
     * @return
     */
    public boolean Existe(Periodo periodo) {
        boolean teste = false;
        try {
            teste = dao.Exists(periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }
    
    public boolean periodoIsTerminado(Periodo periodo) {
        boolean teste = false;
        try {
            teste = dao.periodoIsTerminado(periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }
    
   
}
