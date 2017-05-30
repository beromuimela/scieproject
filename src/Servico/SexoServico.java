/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.SexoDAO;
import entidades.Sexo;
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
public class SexoServico {
    private SexoDAO dao;

    public SexoServico() {
        dao=new SexoDAO();
    }
    
    public List<Sexo> listaDeSexo(){
        List<Sexo> sexo=new ArrayList<Sexo>();
        try {
            sexo=dao.ListaSexo();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return sexo;
    }
    
    public Sexo ObterSexo(String nome){
        for(Sexo s:listaDeSexo())
            if(s.getNome().equals(nome))
                return s;
        return null;
    }
    
    public Sexo ObterSexo(int id){
        for(Sexo s:listaDeSexo())
            if(s.getIdsexo()==id)
                return s;
        return null;
    }
}
