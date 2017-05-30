/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import util.ReportUtils;
import vista.Honorarios;
import entidades.Utilizador;

/**
 *
 * @author junito
 */
public class HonorariosControladora implements ActionListener, ItemListener {

    private Honorarios form;

    public HonorariosControladora(Honorarios form) {
        this.form = form;
        MostrarFiltro();
        adicionarListener();
    }

    public void adicionarListener() {
        form.getJbRelatorio().addActionListener(this);
        form.getJcConsultas().addItemListener(this);
        form.getJbRelatorio().setActionCommand("relatorio");

    }

    public void MostrarFiltro() {
        if (form.getJcConsultas().getSelectedItem().equals("PAGAMENTOS EFECTUADOS")) {
            form.getJdFim().setVisible(true);
            form.getJdInicio().setVisible(true);
            form.getjLabel2().setVisible(true);
            form.getjLabel3().setVisible(true);
            form.getJdFim().setDate(null);
            form.getJdInicio().setDate(null);
            form.getJpanelDatas().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES COM PAGAMENTOS POR EFECTUAR")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES SEM PAGAMENTOS POR EFECTUAR")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
        } else if (form.getJcConsultas().getSelectedItem().equals("CAIXA")) {
            form.getJdFim().setVisible(true);
            form.getJdInicio().setVisible(true);
            form.getjLabel2().setVisible(true);
            form.getjLabel3().setVisible(true);
            form.getJdFim().setDate(null);
            form.getJdInicio().setDate(null);
            form.getJpanelDatas().setVisible(true);
        }
    }

    public void executarRelatorio() {
        if (form.getJcConsultas().getSelectedItem().equals("PAGAMENTOS EFECTUADOS")) {
            if (form.getJdInicio().getDate() != null && form.getJdFim().getDate() != null) {
                java.sql.Timestamp datai = new Timestamp(form.getJdInicio().getDate().getYear(), form.getJdInicio().getDate().getMonth(), form.getJdInicio().getDate().getDate(), 0, 0, 1, 0);
                java.sql.Timestamp dataf = new Timestamp(Calendar.getInstance().getTime().getYear(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getHours(), Calendar.getInstance().getTime().getMinutes(), Calendar.getInstance().getTime().getSeconds(), 0);
                abrirRelatorioComDatas("/PagamentosEfectuados.jasper", datai, dataf,form.getUtil());
            } else {
                JOptionPane.showMessageDialog(form, "Informe a data incial ou data final!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES COM PAGAMENTOS POR EFECTUAR")) {
            abrirRelatorio("/EstudantesComPagamentoPorEfectuar.jasper",form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES COM PAGAMENTOS POR EFECTUAR")) {
            abrirRelatorio("/EstudantesComPagamentoPorEfectuar.jasper",form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES SEM PAGAMENTOS POR EFECTUAR")) {
            abrirRelatorio("/EstudantesSemPagamentosPorEfectuar.jasper",form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("CAIXA")) {
            if (form.getJdInicio().getDate() != null && form.getJdFim().getDate() != null) {
                java.sql.Timestamp datai = new Timestamp(form.getJdInicio().getDate().getYear(), form.getJdInicio().getDate().getMonth(), form.getJdInicio().getDate().getDate(), 0, 0, 1, 0);
                java.sql.Timestamp dataf = new Timestamp(Calendar.getInstance().getTime().getYear(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getHours(), Calendar.getInstance().getTime().getMinutes(), Calendar.getInstance().getTime().getSeconds(), 0);
                abrirRelatorioComDatas("/Caixa.jasper", datai, dataf,form.getUtil());
            } else {
                JOptionPane.showMessageDialog(form, "Informe a data incial ou data final!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void abrirRelatorioComDatas(String arquivoJasper, Timestamp i, Timestamp f,Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();

        parametros.put("datai", i);
        parametros.put("dataf", f);
        parametros.put("util", util.getNome());
        
        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(HonorariosControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirRelatorioComDatas(String arquivoJasper, Date i, Date f,Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("datai", i);
        parametros.put("dataf", f);
        parametros.put("util", util.getNome());

        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(HonorariosControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirRelatorio(String arquivoJasper,Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("util",util.getNome());

        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(HonorariosControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("relatorio")) {
            executarRelatorio();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcConsultas())) {
            MostrarFiltro();
        }
    }

}
