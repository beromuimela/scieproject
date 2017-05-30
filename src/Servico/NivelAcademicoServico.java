/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.NivelAcademicoDAO;
import entidades.Nivel_Academico;
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
public class NivelAcademicoServico {

    private NivelAcademicoDAO dao;

    public NivelAcademicoServico() {
        dao = new NivelAcademicoDAO();
    }

    public List<Nivel_Academico> listaNivelAcademico() {
        List<Nivel_Academico> nivel = new ArrayList<Nivel_Academico>();
        try {
            nivel = dao.listaNivelAcademico();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return nivel;
    }

    public Nivel_Academico ObterNivelAcademico(String nome){
        for(Nivel_Academico n:listaNivelAcademico())
            if(n.getNome().equals(nome))
                return n;
        return null;
    }
}
