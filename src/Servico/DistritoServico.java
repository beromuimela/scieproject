/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.DistritoDAO;
import entidades.Distrito;
import entidades.Provincia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class DistritoServico {

    private DistritoDAO dao;

    public DistritoServico() {
        dao = new DistritoDAO();
    }

    public List<Distrito> listaDistritos(Provincia p) {
        List<Distrito> distritos = new ArrayList<Distrito>();
        try {
            distritos = dao.listaDistritos(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return distritos;
    }
    
    public List<Distrito> listaDistritos() {
        List<Distrito> distritos = new ArrayList<Distrito>();
        try {
            distritos = dao.listaDistritos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return distritos;
    }

    public void salvar(Distrito distrito){
        try {
            dao.salvar(distrito);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Distrito ObterDistrito(Provincia p,String nome){
        for(Distrito d:listaDistritos(p))
            if(d.getNome().equals(nome))
                return d;
        return null;
    }
    
    public String ObterDistrito(Provincia p,int indice){
        for(Distrito d:listaDistritos(p))
            if(d.getIddistrito()==indice)
                return d.getNome();
        return null;
    }
    
    public boolean Existe(Distrito d) {
        boolean teste = false;
        try {
            teste = dao.Exists(d);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }
    
    public void apagar(Distrito d) {
        try {
           dao.delete(d);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
    public int utlimoId(){
        List<Distrito> distrito=listaDistritos();
        int id=0;
        Iterator<Distrito> iter=distrito.iterator();
        while(iter.hasNext()){
            id=iter.next().getIddistrito();
        }
        return id;
    }
}
