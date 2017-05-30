/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.PeriodoServico;
import entidades.Nome_periodo;
import entidades.Periodo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import vista.ControlePeriodo;

/**
 *
 * @author junito
 */
public class ControlePeriodoControladora implements ActionListener, MouseListener, ItemListener {

    private ControlePeriodo form;
    private DefaultTableModel periodoModel;
    private String[] colunas;
    private PeriodoServico servico;
    private Periodo periodoFinal;

    public ControlePeriodoControladora(ControlePeriodo form) {
        this.form = form;
        this.colunas = new String[]{"Periodo", "Data de Inicio", "Estado"};
        this.periodoModel = new DefaultTableModel(colunas, 2);
        this.servico = new PeriodoServico();
        this.periodoFinal = new Periodo();
        adicionarListener();
        preencherTable();
        form.getJcTodos().setSelected(true);
    }

    public final void adicionarListener() {
        form.getJbactualizar().addActionListener(this);
        form.getJbencerrar().addActionListener(this);
        form.getJtPeriodo().addMouseListener(this);
        form.getJcActivos().addActionListener(this);
        form.getJcInactivos().addActionListener(this);
        form.getJcTodos().addActionListener(this);
        form.getJcActivos().setActionCommand("activos");
        form.getJbactualizar().setActionCommand("refresh");
        form.getJbencerrar().setActionCommand("encerrar");
        form.getJcInactivos().setActionCommand("inactivos");
        form.getJcTodos().setActionCommand("todos");

    }

    public String estado(Date estado) {
        if (estado == null) {
            return "ACTIVO";
        } else {
            return "INACTIVO";
        }
    }

    public void fillJcActivos() {
        form.getJtPeriodo().clearSelection();
        form.getJcInactivos().setSelected(false);
//        form.getJcActivos().setSelected(true);
        form.getJcTodos().setSelected(false);
        form.getJlabelPeriodo().setText("");
        preencherTable(servico.periodosActivos());
    }

    public void fillJcInactivos() {
        form.getJtPeriodo().clearSelection();
        form.getJcActivos().setSelected(false);
        form.getJcTodos().setSelected(false);
        form.getJlabelPeriodo().setText("");
//        form.getJcInactivos().setSelected(true);
        preencherTable(servico.periodosInactivos());
    }

    public void fillJcTodos() {
        form.getJtPeriodo().clearSelection();
        form.getJcActivos().setSelected(false);
        form.getJcInactivos().setSelected(false);
        form.getJlabelPeriodo().setText("");
//        form.getJcTodos().setSelected(true);
        preencherTable(servico.listaPeriodos());
    }

    public final void preencherTable() {
        preencherTable(servico.listaPeriodos());
    }

    public final void preencherTable(List<Periodo> periodos) {
        if (periodos.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem periodos registados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = periodos.size();
            periodoModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                periodoModel.setValueAt(periodos.get(i).getNomePeriodo().getNome(), i, 0);
                periodoModel.setValueAt(periodos.get(i).getDatainicio(), i, 1);
                periodoModel.setValueAt(estado(periodos.get(i).getDatatermino()), i, 2);
            }
            form.getJtPeriodo().setModel(periodoModel);
            form.getJtPeriodo().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getJtPeriodo());
//            TableColumn numero=form.getJtableUtilizadores().getColumnModel().getColumn(0);
//            
//            form.getJtableUtilizadores().getColumnModel().getColumn(0).set
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

    public void refresh() {
        form.getJcActivos().setSelected(false);
        form.getJcInactivos().setSelected(false);
        form.getJcTodos().setSelected(true);
        form.getJtPeriodo().clearSelection();
        form.getJlabelPeriodo().setText("");
        preencherTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("activos")) {
            if (form.getJcActivos().isSelected()) {
                fillJcActivos();
            }
        } else if (e.getActionCommand().equals("inactivos")) {
            if (form.getJcInactivos().isSelected()) {
                fillJcInactivos();
            }
        } else if (e.getActionCommand().equals("todos")) {
            if (form.getJcTodos().isSelected()) {
                fillJcTodos();
            }
        } else if (e.getActionCommand().equals("refresh")) {
            refresh();
        } else if (e.getActionCommand().equals("encerrar")) {
            if (servico.periodoIsTerminado(periodoFinal)) {
                JOptionPane.showMessageDialog(form, "O periodo seleccionado ja se encontra inactivo!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            } else {
                servico.encerrar(periodoFinal);
                JOptionPane.showMessageDialog(form, "O periodo encerrado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getJtPeriodo())) {
            String nome = (String) periodoModel.getValueAt(form.getJtPeriodo().getSelectedRow(), 0);
            Date data = (Date) periodoModel.getValueAt(form.getJtPeriodo().getSelectedRow(), 1);
            Nome_periodo nomep = servico.ObterNomePeriodo(nome);
            periodoFinal = servico.obterPeriodo(data, nomep);
            form.getJlabelPeriodo().setText("Periodo: " + nomep.getNome() + "         Data de Inicio:" + periodoFinal.getDatainicio());
//            new EditarUtilizadorForm(form, true, util).setVisible(true);
//            new EditarCandidato(form, true, c).setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
//        if (e.getSource().equals(form.getJcActivos())) {
//            fillJcActivos();
//        }else if(e.getSource().equals(form.getJcInactivos())){
//            fillJcInactivos();
//        }else if(e.getSource().equals(form.getJcTodos())){
//            fillJcTodos();
//        }
    }

}
