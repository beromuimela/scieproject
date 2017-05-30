/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.PacoteDAO;
import entidades.Pacotes;
import entidades.Periodo;
import entidades.Periodo_Pacotes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class PacotesServico {
    private final PacoteDAO dao;

    public PacotesServico() {
        this.dao = new PacoteDAO();
    }
    
    public List<Pacotes> listaPacoteses(){
        List<Pacotes> pacotes=new ArrayList<Pacotes>();
        try {
            pacotes=dao.listaPacotes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return pacotes;
    }
    
    public Pacotes Obter(int id){
        for(Pacotes p:listaPacoteses())
            if(p.getIdpacotes()==id)
                return p;
        return null;
    }
    public Pacotes Obter(String nome){
        for(Pacotes p:listaPacoteses())
            if(p.getNome().equals(nome))
                return p;
        return null;
    }
    
     public boolean verificar_periodoPacotes(Periodo p,Pacotes paco) {
        boolean teste = false;
        try {
            teste = dao.verificarPeriodoPacotes(p, paco);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }

    
}
