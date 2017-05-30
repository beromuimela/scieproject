/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.SituacaoProfissionalDAO;
import entidades.SitP;
import entidades.Situacao_Profissional;
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
public class SituacaoProfServico {

    private SituacaoProfissionalDAO dao;

    public SituacaoProfServico() {
        dao = new SituacaoProfissionalDAO();
    }
    
    public List<Situacao_Profissional> listaSituacaoP(){
        List<Situacao_Profissional> situacao=new ArrayList<Situacao_Profissional>();
        try {
            situacao=dao.listaSituacaoProf();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return situacao;
    }
    
    public List<SitP> listaSitP(){
        List<SitP> situacao=new ArrayList<SitP>();
        try {
            situacao=dao.listaSitP();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return situacao;
    }

    public Situacao_Profissional ObterSituacao(String nome){
        for(Situacao_Profissional s:listaSituacaoP())
            if(s.getNome().equals(nome))
                return s;
        return null;
    }
    
    public SitP ObterSitP(String nome){
        for(SitP s:listaSitP())
            if(s.getNome().equals(nome))
                return s;
        return null;
    }
}
