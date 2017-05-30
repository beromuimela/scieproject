/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.ProvinciaDAO;
import entidades.Pais;
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
public class ProvinciaServico {

    private ProvinciaDAO dao;
    
    public ProvinciaServico() {
        dao = new ProvinciaDAO();
    }
    
    public List<Provincia> listaProvincias(Pais p) {
        List<Provincia> provincias = new ArrayList<Provincia>();
        try {
            provincias = dao.listaProvincias(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return provincias;
    }
    
    public List<Provincia> listaProvincias() {
        List<Provincia> provincias = new ArrayList<Provincia>();
        try {
            provincias = dao.listaProvincias();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return provincias;
    }

    /**
     *
     * @param nome
     * @param p
     * @return
     */
    public Provincia ObterProvincia(String nome, Pais p) {
        for (Provincia provincia : listaProvincias(p)) {
            if (provincia.getNome().equals(nome)) {
                return provincia;
            }
        }
        return null;
        
    }
    
    public String ObterProvincia(Pais p,int indice){
        for(Provincia d:listaProvincias(p))
            if(d.getIdprovincia()==indice)
                return d.getNome();
        return null;
    }
    
    public void salvar(Provincia provincia) {
        try {
            dao.salvar(provincia);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean Existe(Provincia p) {
        boolean teste = false;
        try {
            teste = dao.Exists(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }
    
    public void apagar(Provincia p) {
        try {
           dao.delete(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }


    public String ObterProvincia(int id) {
        for (Provincia provincia : listaProvincias()) {
            if (provincia.getIdprovincia() == id) {
                return provincia.getNome();
            }
        }
        return null;
    }
    
    public Provincia ObterProvincia(String nome) {
        for (Provincia provincia : listaProvincias()) {
            if (provincia.getNome().equals(nome)) {
                return provincia;
            }
        }
        return null;
    }
    
    public int utlimmoId(){
        List<Provincia> provincias=listaProvincias();
        int id=0;
        Iterator<Provincia> iter=provincias.iterator();
        while(iter.hasNext()){
            id=iter.next().getIdprovincia();
        }
        return id;
    }
    
}
