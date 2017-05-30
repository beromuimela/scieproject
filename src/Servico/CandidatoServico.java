/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.CandidatoDAO;
import entidades.Candidato;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class CandidatoServico {

    private CandidatoDAO dao;

    public CandidatoServico() {
        dao = new CandidatoDAO();
    }

    public void guardarCandidato(Candidato candidato) {
        try {
            dao.guardarCandidato(candidato);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isCadastrado(Candidato candidato) {
        boolean teste = false;
        try {
            teste = dao.isCadastrado(candidato);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }

    public List<Candidato> listaCandidatos() {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            candidatos = dao.listarCandidatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return candidatos;
    }
    
    public List<Candidato> listaTodosCandidatos() {
        List<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            candidatos = dao.listarTodosCandidatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return candidatos;
    }

    public Candidato CandidatoPorId(int id) {
        for (Candidato c : listaCandidatos()) {
            if (c.getIdcandidato() == id) {
                return c;
            }
        }
        return null;
    }
    
    public Candidato ObterCandidatoEst(int id) {
        for (Candidato c : listaTodosCandidatos()) {
            if (c.getIdcandidato() == id) {
                return c;
            }
        }
        return null;
    }
    
    public Candidato CandidatoPorId(String id) {
        for (Candidato c : listaCandidatos()) {
            if ((c.getNome().toUpperCase()+" "+c.getApelido().toUpperCase()).equals(id)) {
                return c;
            }
        }
        return null;
    }
    
    public Candidato CandidatoPorIdParaInsc(String id) {
        for (Candidato c : listaTodosCandidatos()) {
            if ((c.getNome()+" "+c.getApelido()).equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void updateCandidato(Candidato candidato) {
        try {
            dao.updateCandidato(candidato);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void deleteCandidato(Candidato candidato) {
        try {
            dao.deleteCandidato(candidato);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
