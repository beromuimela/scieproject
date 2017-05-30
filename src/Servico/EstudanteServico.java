/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.EstudanteDAO;
import entidades.Estudante;
import entidades.Estudante_Pacotes;
import entidades.Pacotes;
import entidades.Periodo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author junito
 */
public class EstudanteServico {

    private final EstudanteDAO dao;

    public EstudanteServico() {
        dao = new EstudanteDAO();
    }

    public boolean mesmaData(Date data1, Date data2) {
        boolean teste = false;
        int anox = data1.getYear();
        int mesx = data1.getMonth();
        int diax = data1.getDate();
        int anoy = data2.getYear();
        int mesy = data2.getMonth();
        int diay = data2.getDate();
        if ((anox + mesx + diax) - (anoy + mesy + diay) == 0) {
            teste = true;
        }
        return teste;
    }

    public List<Estudante> listaEstudantes(Periodo periodo) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        for (Estudante e : listaEstudantesActivos()) {
            if (e.getPeriodo().getNomePeriodo().getNome().equals(periodo.getNomePeriodo().getNome()) && mesmaData(e.getPeriodo().getDatainicio(), periodo.getDatainicio())) {
                estudantes.add(e);
            }
        }
        return estudantes;
    }

    public List<Estudante> listaTodosEstudantes(Periodo periodo) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        for (Estudante e : listaTodosEstudantes()) {
            if (e.getPeriodo().getNomePeriodo().getNome().equals(periodo.getNomePeriodo().getNome()) && mesmaData(e.getPeriodo().getDatainicio(), periodo.getDatainicio())) {
                estudantes.add(e);
            }
        }
        return estudantes;
    }

    public List<Estudante> listaEstudantesActivos() {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        try {
            estudantes = dao.listarEstudantesActivos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public List<Estudante> listaEstudantesActivosComSaldo() {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        for (Estudante e : listaEstudantesActivos()) {
            if (e.getSaldo() > 0) {
                estudantes.add(e);
            }
        }
        return estudantes;
    }

    public List<Estudante> listaTodosEstudantes() {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        try {
            estudantes = dao.listarTodosEstudantes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public Estudante obterEstudante(int id) {
        for (Estudante e : listaEstudantesActivos()) {
            if (e.getIdestudante() == id) {
                return e;
            }
        }
        return null;
    }

    public Estudante obterEstudanteTodos(int id) {
        for (Estudante e : listaTodosEstudantes()) {
            if (e.getIdestudante() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Estudante_Pacotes> listaEstudantesPacotes(List<Estudante> est, Pacotes paco) {
        List<Estudante_Pacotes> estudantes = new ArrayList<Estudante_Pacotes>();
        try {
            estudantes = dao.listarEstudantesPacotes(est, paco);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public List<Estudante_Pacotes> listaEstudantesPacotes(Estudante est) {
        List<Estudante_Pacotes> estudantes = new ArrayList<Estudante_Pacotes>();
        try {
            estudantes = dao.listarEstudantesPacotes(est);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public List<Estudante_Pacotes> listaEstudantesPacotes(Periodo p, Pacotes paco) {
        List<Estudante_Pacotes> estudantes = new ArrayList<Estudante_Pacotes>();
        try {
            estudantes = dao.listarEstudantesPacotes(p, paco);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public void inserir_EstudantesPacotes(List<Estudante_Pacotes> estPac, Periodo periodo) {
        try {
            dao.inserir_EstudantesPacotes(estPac, periodo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public List<Estudante> listarDePeriodoDadoPacote(Periodo periodo, Pacotes pacotes) {
        List<Estudante> estudantes = new ArrayList<Estudante>();
        try {
            estudantes = dao.listarDePeriodoDadoPacote(periodo, pacotes);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return estudantes;
    }

    public void update_Notas(List<Estudante_Pacotes> e) {
        try {
            dao.updateNotas(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void update_Faltas(List<Estudante_Pacotes> e) {
        try {
            dao.updateFaltas(e);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
