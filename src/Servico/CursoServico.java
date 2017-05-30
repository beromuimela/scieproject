/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.CursoDAO;
import entidades.Curso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class CursoServico {
    private final CursoDAO dao;

    public CursoServico() {
        dao=new CursoDAO();
    }
    
    public List<Curso> listaCursos(){
        List<Curso> cursos=new ArrayList<Curso>();
        try {
            cursos=dao.listaCursos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cursos;
    }
    
    public void UpdateCurso(Curso c){
        try {
            dao.updateCurso(c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Curso ObterCurso(String nome){
        for(Curso c:listaCursos())
            if(c.getNome().equals(nome))
                return c;
        return null;
    }
    
    public Curso ObterCurso(int id){
        for(Curso c:listaCursos())
            if(c.getIdcurso()==id)
                return c;
        return null;
    }
    
    public int qtdEstudantes(){
        for(Curso c:listaCursos())
            if(c.getNome().equals("Informatica"))
                return c.getNrestudantesSala();
        return 0;
    }
    
    public int nrdeFaltas(){
        for(Curso c:listaCursos())
            if(c.getNome().equals("Informatica"))
                return c.getNrFaltas();
        return 0;
    }
    
}
