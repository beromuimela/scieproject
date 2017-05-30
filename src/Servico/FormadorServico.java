/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.FormadorDAO;
import entidades.Formador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class FormadorServico {

    private FormadorDAO dao;

    public FormadorServico() {
        dao = new FormadorDAO();
    }

    public void salvar(Formador formador) {
        try {
            dao.salvar(formador);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void actualizar(Formador formador) {
        try {
            dao.actualizar(formador);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public boolean Existe(Formador f) {
        boolean teste = false;
        try {
            teste = dao.Exists(f);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return teste;
    }

    public List<Formador> listaFormadores() {
        List<Formador> formadores = new ArrayList<Formador>();
        try {
            formadores = dao.listarFormadores();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return formadores;
    }
    
    public Formador obterFormador(int id){
        for(Formador f:listaFormadores())
            if(f.getIdformador()==id)
                return f;
        return null;
    }
    
    public Formador obterFormador(String nome){
        for(Formador f:listaFormadores())
            if(f.getNome().equals(nome))
                return f;
        return null;
    }

}
