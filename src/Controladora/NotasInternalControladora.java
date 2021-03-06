/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.EstudanteServico;
import Servico.PacotesServico;
import Servico.PeriodoServico;
import entidades.Estudante_Pacotes;
import entidades.Nome_periodo;
import entidades.Pacotes;
import entidades.Periodo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import vista.NotasInternal;

/**
 *
 * @author junito
 */
public class NotasInternalControladora implements ActionListener, ItemListener {

    private final NotasInternal form;
    private Nome_periodo nomeperiodo;
    private Periodo periodo;
    private DefaultComboBoxModel nomepModel;
    private Pacotes pacotes;
    private DefaultComboBoxModel pacotesModel;
    private DefaultComboBoxModel datasModel;
    private DefaultTableModel estudanteModel;
    private String[] colunas;
    private Date data;
    private List<Estudante_Pacotes> Lista = new ArrayList<Estudante_Pacotes>();

    public NotasInternalControladora(NotasInternal form) {
        this.form = form;
        this.colunas = new String[]{"Nr", "Nome Completo", "Sexo", "Notas"};
        this.estudanteModel = new DefaultTableModel(colunas, 3);
        this.nomepModel = new DefaultComboBoxModel();
        this.nomeperiodo = new Nome_periodo();
        this.pacotesModel = new DefaultComboBoxModel();
        adicionarListener();
        adicionaPeriodo();
        adicionaPacotes();
    }

    public final void adicionarListener() {
        form.getJcPacotes().addItemListener(this);
        form.getJcPeriodo().addItemListener(this);
        form.getJcDataInicio().addItemListener(this);
    }

    public final void adicionaPeriodo() {
        List<Nome_periodo> nomeP = new PeriodoServico().listaNomePeriodos();
        if (nomeP != null) {
            for (int i = 0; i < nomeP.size(); i++) {
                nomepModel.insertElementAt(nomeP.get(i).getNome(), i);
            }
            form.getJcPeriodo().setModel(nomepModel);
            form.getJcPeriodo().setSelectedIndex(0);
        } else {
            form.getJcPeriodo().setModel(nomepModel);
        }
    }

    public final void adicionaPacotes() {
        List<Pacotes> paco = new PacotesServico().listaPacoteses();
        if (!paco.isEmpty()) {
            for (int i = 0; i < paco.size(); i++) {
                pacotesModel.insertElementAt(paco.get(i).getNome(), i);
            }
            form.getJcPacotes().setModel(pacotesModel);
            form.getJcPacotes().setSelectedIndex(0);
        } else {
            form.getJcPacotes().setModel(pacotesModel);
        }
    }

    public void adicionaDatas(Nome_periodo nomeperiodo) {
        List<Date> datas = new PeriodoServico().listaDatasPeriodos(nomeperiodo);
        this.datasModel = new DefaultComboBoxModel();
        if (!datas.isEmpty()) {
            for (int i = 0; i < datas.size(); i++) {
                datasModel.insertElementAt(datas.get(i), i);
            }
            form.getJcDataInicio().setModel(datasModel);
            form.getJcDataInicio().setSelectedIndex(0);
        } else {
            form.getJcDataInicio().setModel(datasModel);
            periodo = new Periodo();
            form.setPeriodo(periodo);
            Lista = new ArrayList<Estudante_Pacotes>();
            preencherTable(Lista);
            form.setListaestudante_pacotes(Lista);
            data = new Date();
        }
    }

    private void limparJTable() {
        DefaultTableModel Model = (DefaultTableModel) form.getJtEstudantes().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public final void preencherTable(List<Estudante_Pacotes> estudantes) {
        limparJTable();
        if (estudantes.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem estudantes a assistir o pacote informado!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = estudantes.size();
            estudanteModel.setRowCount(linha);
            
            for (int i = 0; i < linha; i++) {
//                Estudante e=new EstudanteServico().obterEstudante(estudantes.get(i).getEstudante().getIdestudante());
                estudanteModel.setValueAt(estudantes.get(i).getEstudante().getIdestudante(), i, 0);
                estudanteModel.setValueAt(estudantes.get(i).getEstudante().getCandidato().getNome() + " " + estudantes.get(i).getEstudante().getCandidato().getApelido(), i, 1);
                estudanteModel.setValueAt(estudantes.get(i).getEstudante().getCandidato().getSexo().getNome(), i, 2);
                estudanteModel.setValueAt(estudantes.get(i).getNota(), i, 3);
            }
            form.getJtEstudantes().setModel(estudanteModel);
            form.getJtEstudantes().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getJtEstudantes());
//            form.getJtEstudantes().getColumnModel().getColumn(0).setCellRenderer(n);
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

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcPeriodo())) {
            nomeperiodo = new PeriodoServico().ObterNomePeriodo((String) form.getJcPeriodo().getSelectedItem());
            adicionaDatas(nomeperiodo);
        } else if (e.getSource().equals(form.getJcDataInicio())) {
            data = (Date) form.getJcDataInicio().getSelectedItem();
            periodo = new PeriodoServico().obterPeriodo(data, nomeperiodo);
            form.setPeriodo(periodo);
            if (pacotes != null) {
                Lista = new EstudanteServico().listaEstudantesPacotes(periodo, pacotes);
                preencherTable(Lista);
                form.setCandModel(estudanteModel);
                form.setListaestudante_pacotes(Lista);
            }
        } else if (e.getSource().equals(form.getJcPacotes())) {
            pacotes = new PacotesServico().Obter((String) form.getJcPacotes().getSelectedItem());
            form.setPacotes(pacotes);
            Lista = new EstudanteServico().listaEstudantesPacotes(periodo, pacotes);
            preencherTable(Lista);
            form.setCandModel(estudanteModel);
            form.setListaestudante_pacotes(Lista);
        }
    }

}
