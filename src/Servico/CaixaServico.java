/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import dao.CaixaDAO;
import entidades.Caixa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.DataUtilizador;

/**
 *
 * @author junito
 */
public class CaixaServico {

    private CaixaDAO dao;

    public CaixaServico() {
        dao = new CaixaDAO();
    }

    public void abrirCaixa(Caixa caixa) {
        try {
            dao.abrirCaixa(caixa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void FecharCaixa(Caixa caixa) {
        try {
            dao.FecharCaixa(caixa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<Caixa> ListaCaixa() {
        List<Caixa> caixas = new ArrayList<Caixa>();
        try {
            caixas = dao.listaCaixas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return caixas;
    }

    public Caixa ultimoCaixa() {
        List<Caixa> caixas = ListaCaixa();
        int pos;
        if (caixas.isEmpty()) {
            return new Caixa();
        } else {
            pos = caixas.size();
            pos--;
            return caixas.get(pos);
        }
    }

    public boolean isAberto() {
        boolean aberto = false;

        Caixa caixa = ultimoCaixa();
        if (caixa == null) {
            return aberto;
        } else {
            if (isHoje(caixa.getDatacaixa())) {
                if (caixa.isAberto()) {
                    aberto = true;
                }
            }
            return aberto;
        }
    }

    public boolean isHoje(DataUtilizador caixa) {
        boolean data = false;
        if (caixa == null) {
            return data;
        } else {
            int anoY = Calendar.getInstance().getTime().getYear() + 1900;
            int mesY = Calendar.getInstance().getTime().getMonth() + 1;
            int diaY = Calendar.getInstance().getTime().getDate();
            if ((caixa.getDia() + caixa.getMes() + caixa.getAno()) - (anoY + mesY + diaY) == 0) {
                data = true;
            }
            return data;
        }
    }

}
