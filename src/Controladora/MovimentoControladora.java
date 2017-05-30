/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CaixaServico;
import Servico.MovimentosServico;
import entidades.Movimentos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import vista.Efectuar_Pagamento;
import vista.MovimentosForm;

/**
 *
 * @author junito
 */
public class MovimentoControladora implements ActionListener {

    private MovimentosForm form;
    private MovimentosServico servico;
    private DefaultTableModel movimentosModel;
    String[] colunas;

    public MovimentoControladora(MovimentosForm form) {
        this.form = form;
        this.colunas = new String[]{"Data do Movimento", "Valor", "Tipo de Movimento", "Responsavel", "Historico"};
        this.movimentosModel = new DefaultTableModel(colunas, 4);
        this.servico = new MovimentosServico();
        adicionarListener();
        FiltrarMovimentos();
    }

    public final void adicionarListener() {
        form.getJcomboCaixa().addActionListener(this);
        form.getJcomboFiltro().addActionListener(this);
        form.getJbReceberPagamento().addActionListener(this);
        form.getJbReceberPagamento().setActionCommand("pagamento");
//        form.getJbFechar().addActionListener(this);
//        form.getJbFechar().setActionCommand("fechar");
        form.getJcomboCaixa().setActionCommand("caixa");
        form.getJcomboFiltro().setActionCommand("filtro");

    }

    public void cash() {
        form.getJsEntradas().setValue(servico.getEntrada());
        form.getJsSaidas().setValue(servico.getSaida());
        form.getJsSaldo().setValue(servico.getSaldo());
    }

    public final void FiltrarMovimentos() {
        List<Movimentos> m =new ArrayList<Movimentos>();
        if (form.getJcomboCaixa().getSelectedIndex() == 0) {
            switch (form.getJcomboFiltro().getSelectedIndex()) {
                case 0:
                    m=servico.listaTodosMovimetosPorCaixa(new CaixaServico().ultimoCaixa());
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
                case 1:
                    m=servico.listaMovimetosEntradaPorCaixa(new CaixaServico().ultimoCaixa());
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
                default:
                    m=servico.listaMovimetosSaidaPorCaixa(new CaixaServico().ultimoCaixa());
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
            }
        } else {
            switch (form.getJcomboFiltro().getSelectedIndex()) {
                case 0:
                    m=servico.listaTodosMovimetos();
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
                case 1:
                    m=servico.listaMovimetosEntrada();
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
                default:
                    m=servico.listaMovimetosSaida();
                    preencherTable(m);
                    servico.valoresDoCaixa(m);
                    cash();
                    break;
            }
        }
    }

    private void limparJTable() {
        DefaultTableModel Model = (DefaultTableModel) form.getjTMovimentos().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }


    public final void preencherTable(List<Movimentos> movimentos) {
        limparJTable();
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
            form.getjTMovimentos().setModel(movimentosModel);
            form.getjTMovimentos().getColumnModel().getColumn(1).setMaxWidth(75);
            form.getjTMovimentos().getColumnModel().getColumn(2).setMaxWidth(200);
            form.getjTMovimentos().getColumnModel().getColumn(2).setMinWidth(100);
            renderer(form.getjTMovimentos());
        }
    }

    public void renderer(JTable tabela) {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
//        tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        JTableHeader header = tabela.getTableHeader();
        header.setPreferredSize(new Dimension(100, 32));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("filtro")) {
            FiltrarMovimentos();
        } else if (e.getActionCommand().equals("caixa")) {
            FiltrarMovimentos();
        }else if(e.getActionCommand().equals("fechar")){
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        }else if(e.getActionCommand().equals("pagamento")){
            new Efectuar_Pagamento(form, true,form.getUtil()).setVisible(true);
        }
    }

}
