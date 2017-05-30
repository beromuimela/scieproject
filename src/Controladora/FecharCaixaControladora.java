/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CaixaServico;
import Servico.MovimentosServico;
import entidades.Movimentos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.CaixaParaRelatorio;
import util.ReportUtils;
import vista.FecharCaixa;

/**
 *
 * @author junito
 */
public class FecharCaixaControladora implements ActionListener {

    private FecharCaixa form;
    private MovimentosServico servico;
    private DefaultTableModel movimentosModel;
    private String[] colunas;
    private List caixa;

    public FecharCaixaControladora(FecharCaixa form) {
        this.form = form;
        this.servico = new MovimentosServico();
        this.colunas = new String[]{"Data do Movimento", "Valor", "Tipo de Movimento", "Responsavel", "Historico"};
        this.movimentosModel = new DefaultTableModel(colunas, 4);
        adicionarListener();
        preencherTable();
        cash();
    }

    public void cash() {
        form.getJsEntradas().setValue(servico.getEntrada());
        form.getJsSaidas().setValue(servico.getSaida());
        form.getJsSaldo().setValue(servico.getSaldo());
    }

    public final void preencherTable() {
        List<Movimentos> movimentos = servico.listaMovimetosEntradaPorCaixa(form.getCaixa());
        servico.valoresDoCaixa(movimentos);
        if (movimentos.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem movimentos no caixa actual!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = movimentos.size();
            movimentosModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                movimentosModel.setValueAt(movimentos.get(i).getDatamovimento().mostrarDataHora(), i, 0);
                movimentosModel.setValueAt(movimentos.get(i).getValor(), i, 1);
                movimentosModel.setValueAt(movimentos.get(i).getTipoMovimento(), i, 2);
                movimentosModel.setValueAt(movimentos.get(i).getResponsavel(), i, 3);
                movimentosModel.setValueAt(movimentos.get(i).getHistorico(), i, 4);
            }
            form.getJtableFecho().setModel(movimentosModel);
            form.getJtableFecho().getColumnModel().getColumn(1).setMaxWidth(75);
            form.getJtableFecho().getColumnModel().getColumn(2).setMaxWidth(200);
            form.getJtableFecho().getColumnModel().getColumn(2).setMinWidth(100);
        }

    }

    public void adicionarListener() {
        form.getJbImprimir().addActionListener(this);
        form.getJbImprimir().setActionCommand("imprimir");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("imprimir")) {
            caixa = new ArrayList();
            for (int i = 0; i < form.getJtableFecho().getRowCount(); i++) {
                CaixaParaRelatorio c = new CaixaParaRelatorio();
                c.setDataMovimento((String) form.getJtableFecho().getValueAt(i, 0));
                c.setValor(Float.valueOf(form.getJtableFecho().getValueAt(i, 1).toString()));
                c.setTipoMovimento((String) form.getJtableFecho().getValueAt(i, 2));
                c.setResponsavel((String) form.getJtableFecho().getValueAt(i, 3));
                c.setHistorico((String) form.getJtableFecho().getValueAt(i, 4));
                c.setEntradas(servico.getEntrada());
                c.setSaidas(servico.getSaida());
                c.setSaldo(servico.getSaldo());
                caixa.add(c);
            }
            
            InputStream inputStream = getClass().getResourceAsStream("/FechoCaixa.jasper");
            Map parametros = new HashMap();
            java.sql.Timestamp datai = new Timestamp(Calendar.getInstance().getTime().getYear(), Calendar.getInstance().getTime().getMonth(), Calendar.getInstance().getTime().getDate(), Calendar.getInstance().getTime().getHours(), Calendar.getInstance().getTime().getMinutes(), Calendar.getInstance().getTime().getSeconds(), 0);
            parametros.put("dataactual", datai);
            JRDataSource ds = new JRBeanCollectionDataSource(caixa);
            try {
                // passando o datasource para o método de criação e exibição do relatório
                ReportUtils.openReport("Fecho de Caixa", inputStream, parametros, ds, form);
            } catch (JRException exc) {
                exc.printStackTrace();
            }
        }
    }

}
