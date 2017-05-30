/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.MovimentosDAO;
import entidades.Caixa;
import entidades.Movimentos;
import java.sql.CallableStatement;
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
public class MovimentosServico {

    private MovimentosDAO dao;
    private Float entrada = 0.0f;
    private Float saida = 0.0f;
    private Float saldo = 0.0f;

    public MovimentosServico() {
        dao = new MovimentosDAO();
    }

    public List<Movimentos> listaTodosMovimetosPorCaixa(Caixa caixa) {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        try {
            movimentos = dao.listaMovimentosPorCaixa(caixa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return movimentos;
    }

    public void valoresDoCaixa(List<Movimentos> movimentos) {
        this.entrada = 0.0f;
        this.saida = 0.0f;
        this.saldo = 0.0f;
        for (Movimentos m : movimentos) {
            if (m.getTipoMovimento().equals("PAGAMENTO")) {
                this.entrada += m.getValor();
            } else {
                this.saida += m.getValor();
            }
        }
        this.saldo = this.entrada - this.saida;
    }

    public List<Movimentos> listaTodosMovimetos() {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        try {
            movimentos = dao.listaTodosMovimentos();
        } catch (SQLException ex) {
        }
        return movimentos;
    }

    public List<Movimentos> listarMovimentosPorresponsavel(String responsavel) {
        List<Movimentos> mov = new ArrayList<Movimentos>();
        for (Movimentos m : listaTodosMovimetos()) {
            if (m.getResponsavel().equals(responsavel)) {
                mov.add(m);
            }
        }
        return mov;
    }

    public List<Movimentos> listaMovimetosEntradaPorCaixa(Caixa caixa) {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        for (Movimentos m : listaTodosMovimetosPorCaixa(caixa)) {
            if (m.getTipoMovimento().equals("PAGAMENTO")) {
                movimentos.add(m);
            }
        }
        return movimentos;
    }

    public List<Movimentos> listaMovimetosEntrada() {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        for (Movimentos m : listaTodosMovimetos()) {
            if (m.getTipoMovimento().equals("PAGAMENTO")) {
                movimentos.add(m);
            }
        }
        return movimentos;
    }

    public void inserir_Movimentos(Movimentos mov) {
        try {
            dao.inserirMovimento(mov);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<Movimentos> listaMovimetosSaida() {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        for (Movimentos m : listaTodosMovimetos()) {
            if (m.getTipoMovimento().equals("RETIRADA")) {
                movimentos.add(m);
            }
        }
        return movimentos;
    }

    public List<Movimentos> listaMovimetosSaidaPorCaixa(Caixa caixa) {
        List<Movimentos> movimentos = new ArrayList<Movimentos>();
        for (Movimentos m : listaTodosMovimetosPorCaixa(caixa)) {
            if (m.getTipoMovimento().equals("RETIRADA")) {
                movimentos.add(m);
            }
        }
        return movimentos;
    }

    public Float getEntrada() {
        return entrada;
    }

    public void setEntrada(Float entrada) {
        this.entrada = entrada;
    }

    public Float getSaida() {
        return saida;
    }

    public void setSaida(Float saida) {
        this.saida = saida;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

}
