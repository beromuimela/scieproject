/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.Tipo_IdDAO;
import entidades.Tipo_Id;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class Tipo_idServico {

    private Tipo_IdDAO dao;

    public Tipo_idServico() {
        dao = new Tipo_IdDAO();
    }

    public List<Tipo_Id> listaID() {
        List<Tipo_Id> ids = new ArrayList<Tipo_Id>();
        try {
            ids = dao.listaTipoId();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return ids;
    }
    
    public Tipo_Id ObterId(String nome){
        for(Tipo_Id id:listaID())
            if(id.getNome().equals(nome))
                return id;
        return null;
    }
    
    public Tipo_Id ObterId(int i){
        for(Tipo_Id id:listaID())
            if(id.getIdtipo()==i)
                return id;
        return null;
    }

}
