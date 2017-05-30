/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.UtilizadorDAO;
import entidades.Utilizador;
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
public class UtilizadorServico {

    private UtilizadorDAO dao;

    public UtilizadorServico() {
        dao = new UtilizadorDAO();
    }

    public boolean verificarUtilizador(Utilizador util) {
        boolean teste = false;
        try {
            teste = dao.verificarUtilizador(util);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (java.lang.NullPointerException e) {
        }
        return teste;
    }

    public boolean verificarUtil(Utilizador util) {
        boolean teste = false;
        try {
            teste = dao.verificarUtil(util);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }

    public void salvar(Utilizador util) {
        try {
            dao.salvar(util);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void editar(Utilizador util) {
        try {
            dao.editar(util);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void desabilitar(Utilizador util) {
        try {
            dao.Desabilitar(util);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<Utilizador> listaUtilizadoresActivos() {
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();

        try {
            utilizadores = dao.listarUtilizadoresActivos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return utilizadores;
    }

    public List<Utilizador> listaTodosUtilizadores() {
        List<Utilizador> utilizadores = new ArrayList<Utilizador>();

        try {
            utilizadores = dao.listarTodosUtilizadores();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return utilizadores;
    }

    public Utilizador ObterUtilizador(Utilizador util) {
        Utilizador utilizador = null;
        Iterator<Utilizador> iter = listaUtilizadoresActivos().iterator();
        while (iter.hasNext()) {
            Utilizador novo = iter.next();
            if ((novo.getLogin().equals(util.getLogin())) && (novo.getSenha().equals(util.getSenha()))) {
                utilizador = novo;
            }
        }
        return utilizador;
    }

    public Utilizador ObterUtilizador(int id) {
        Utilizador utilizador = null;
        Iterator<Utilizador> iter = listaUtilizadoresActivos().iterator();
        while (iter.hasNext()) {
            Utilizador novo = iter.next();
            if (novo.getIdutilizador() == id) {
                utilizador = novo;
            }
        }
        return utilizador;
    }

    public Utilizador ObterUtilizadorAll(int id) {
        Utilizador utilizador = null;
        Iterator<Utilizador> iter = listaTodosUtilizadores().iterator();
        while (iter.hasNext()) {
            Utilizador novo = iter.next();
            if (novo.getIdutilizador() == id) {
                utilizador = novo;
            }
        }
        return utilizador;
    }

}
