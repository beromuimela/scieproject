/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.PaisDAO;
import entidades.Candidato;
import entidades.Pais;
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
public class PaisServico {

    private PaisDAO dao;

    public PaisServico() {
        dao = new PaisDAO();
    }

    public List<Pais> listadPaises() {
        List<Pais> paises = new ArrayList<Pais>();
        try {
            paises = dao.listaPaises();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return paises;
    }

    public void salvar(Pais pais) {
        try {
            dao.salvar(pais);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean Existe(Pais pai) {
        boolean teste = false;
        try {
            teste = dao.Exists(pai);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }

    public void apagar(Pais p) {
        try {
           dao.delete(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public Pais ObterPais(String nome) {
        for (Pais p : listadPaises()) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public String ObterPais(int id) {
        for (Pais p : listadPaises()) {
            if (p.getIdpais() == id) {
                return p.getNome();
            }
        }
        return null;
    }

    public int ultimoId() {
        List<Pais> paises = listadPaises();
        int id = 0;
        Iterator<Pais> iter=paises.iterator();
        while (iter.hasNext()) {
            id = iter.next().getIdpais();
        }
        return id;
    }

}
