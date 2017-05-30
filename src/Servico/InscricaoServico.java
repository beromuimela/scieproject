/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.InscricaoDAO;
import entidades.Candidato;
import entidades.FichaInscricao;
import entidades.Inscricao;
import entidades.Periodo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class InscricaoServico {

    private InscricaoDAO dao;

    public InscricaoServico() {
        this.dao = new InscricaoDAO();
    }

    public void inscrever(Inscricao inscricao) {
        try {
            dao.increver(inscricao);
        } catch (SQLException ex) {
            Logger.getLogger(InscricaoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int nrEstudantesPorPeriodo(Periodo periodo) {
        int numero = 0;
        try {
            numero = dao.nrEstudantesPorPeriodo(periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return numero;
    }

    public int nrNumeroInscricaoPorCand(Candidato c) {
        int numero = 0;
        try {
            numero = dao.nrInscricaoByCand(c.getIdcandidato());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return numero;
    }

    public Candidato ObterCandidato(String nome) {
        Candidato candidato = new CandidatoServico().CandidatoPorIdParaInsc(nome);
        return candidato;
    }

    public List<FichaInscricao> listarFichaInscricao() {
        List<FichaInscricao> fichas = new ArrayList<FichaInscricao>();

        try {
            fichas = dao.listaFichaInscricao();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return fichas;
    }
}
