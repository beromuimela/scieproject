/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.EstudanteServico;
import Servico.PeriodoServico;
import entidades.Estudante;
import entidades.Nome_periodo;
import entidades.Periodo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.EstudanteParaRelatorio;
import util.ReportUtils;
import vista.ControleEstudantes;
import vista.EditarEstudante;

/**
 *
 * @author junito
 */
public class ControleEstudantesControladora implements ActionListener, MouseListener, ItemListener {

    private ControleEstudantes form;
    private DefaultTableModel estudanteModel;
    private EstudanteServico servico = new EstudanteServico();
    private String[] colunas;
    private Nome_periodo nomeperiodo;
    private Periodo periodo;
    private Date data;
    private DefaultComboBoxModel nomepModel;
    private DefaultComboBoxModel datasModel;
    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private List estudantesRelatorio;

    public ControleEstudantesControladora(ControleEstudantes form) {
        this.form = form;
        this.colunas = new String[]{"Numero", "Nome Completo", "Tipo de Documento", "Numero de Documento"};
        this.estudanteModel = new DefaultTableModel(colunas, 3);
//        this.nomepModel = new DefaultComboBoxModel();
        this.nomeperiodo = new Nome_periodo();
        form.getJcData().setEnabled(false);
        form.getJcNomeP().setEnabled(false);
        adicionarListener();
        preencherTable();
    }

    public final void adicionaPeriodo() {
        List<Nome_periodo> nomeP = new PeriodoServico().listaNomePeriodos();
        this.nomepModel = new DefaultComboBoxModel();
        if (nomeP != null) {
            for (int i = 0; i < nomeP.size(); i++) {
                nomepModel.insertElementAt(nomeP.get(i).getNome(), i);
            }
            form.getJcNomeP().setModel(nomepModel);
//            form.getJcNomeP().setSelectedIndex(0);
        } else {
            form.getJcNomeP().setModel(nomepModel);
        }
    }

    public void adicionaDatas(Nome_periodo nomeperiodo) {
        List<Date> datas = new PeriodoServico().listaTodasDatasPeriodos(nomeperiodo);
        this.datasModel = new DefaultComboBoxModel();
        if (!datas.isEmpty()) {
            for (int i = 0; i < datas.size(); i++) {
                datasModel.insertElementAt(datas.get(i), i);
            }
            form.getJcData().setModel(datasModel);
            form.getJcData().setSelectedIndex(0);
        } else {
            form.getJcData().setModel(datasModel);
            data = new Date();
        }
    }

    public void adicionarListener() {
        form.getBuscar().addActionListener(this);
//        form.getFechar().addActionListener(this);
        form.getRbnumero().addActionListener(this);
        form.getjRNome().addActionListener(this);
//        form.getImprimir().addActionListener(this);
        form.getRbPeriodo().addActionListener(this);
        form.getTableEstudantes().addMouseListener(this);
        form.getActualizarTabela().addActionListener(this);
        form.getJbImprimir().addActionListener(this);
        form.getJcData().addItemListener(this);
        form.getJcNomeP().addItemListener(this);
        form.getJbImprimir().setActionCommand("imprimir");
        form.getBuscar().setActionCommand("buscar");
        form.getjRNome().setActionCommand("rbnome");
        form.getRbnumero().setActionCommand("rbnumero");
        form.getRbPeriodo().setActionCommand("rbperiodo");

//        form.getFechar().setActionCommand("fechar");
        form.getActualizarTabela().setActionCommand("actualizar");
//        form.getImprimir().setActionCommand("imprimir");
    }

    public void pesquisar() {
        DefaultTableModel tabelaCandidatos = (DefaultTableModel) form.getTableEstudantes().getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaCandidatos);
        form.getTableEstudantes().setRowSorter(sorter);
        String text = form.getPesquisar().getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                if (form.getjRNome().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                } else if (form.getRbnumero().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                } else {
                    JOptionPane.showMessageDialog(form, "Para pesquisar marque o criterio de pesquisa\n 'Nome' ou 'Numero de Cadastro'", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PatternSyntaxException pse) {
                System.err.println("Erro");
            }
        }
    }

    private void limparJTable() {
        DefaultTableModel Model = (DefaultTableModel) form.getTableEstudantes().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public void preencherTable() {
        this.estudantes = servico.listaTodosEstudantes();
        preencherTable(estudantes);
    }

    public final void preencherTable(List<Estudante> estudantes) {
        limparJTable();
        if (estudantes.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem estudantes cadastrados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = estudantes.size();
            estudanteModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                estudanteModel.setValueAt(estudantes.get(i).getIdestudante(), i, 0);
                estudanteModel.setValueAt(estudantes.get(i).getCandidato().getNome() + " " + estudantes.get(i).getCandidato().getApelido(), i, 1);
                estudanteModel.setValueAt(estudantes.get(i).getCandidato().getTipoid().getNome(), i, 2);
                estudanteModel.setValueAt(estudantes.get(i).getCandidato().getNumerodocumento(), i, 3);
            }
            form.getTableEstudantes().setModel(estudanteModel);
            form.getTableEstudantes().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getTableEstudantes());
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
        switch (e.getActionCommand()) {
            case "buscar":
                pesquisar();
                break;
            case "rbnome":
                if (form.getjRNome().isSelected()) {
                    form.getRbnumero().setSelected(false);
                    form.getRbPeriodo().setSelected(false);
                    form.getJcData().setEnabled(false);
                    form.getJcNomeP().setEnabled(false);
                    form.getJcNomeP().setModel(new DefaultComboBoxModel());
                    form.getJcData().setModel(new DefaultComboBoxModel());
                }
                break;
            case "rbnumero":
                if (form.getRbnumero().isSelected()) {
                    form.getjRNome().setSelected(false);
                    form.getRbPeriodo().setSelected(false);
                    form.getJcData().setEnabled(false);
                    form.getJcNomeP().setEnabled(false);
                    form.getJcNomeP().setModel(new DefaultComboBoxModel());
                    form.getJcData().setModel(new DefaultComboBoxModel());
                }
                break;
            case "rbperiodo":
                if (form.getRbPeriodo().isSelected()) {
                    form.getjRNome().setSelected(false);
                    form.getRbnumero().setSelected(false);
                    form.getJcData().setEnabled(true);
                    form.getJcNomeP().setEnabled(true);
                    adicionaPeriodo();
                }
                break;
            case "fechar":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "actualizar":
                form.getRbPeriodo().setSelected(false);
                form.getRbnumero().setSelected(false);
                form.getjRNome().setSelected(false);
                form.getJcNomeP().setModel(new DefaultComboBoxModel());
                form.getJcData().setModel(new DefaultComboBoxModel());
                preencherTable();
                break;
            case "imprimir":
                estudantesRelatorio = new ArrayList();
                for (int i = 0; i < form.getTableEstudantes().getRowCount(); i++) {
                    EstudanteParaRelatorio estu = new EstudanteParaRelatorio();
                    estu.setId((Integer) form.getTableEstudantes().getValueAt(i, 0));
                    estu.setNome((String) form.getTableEstudantes().getValueAt(i, 1));
                    estu.setDocumento((String) form.getTableEstudantes().getValueAt(i, 2));
                    estu.setNumero((String) form.getTableEstudantes().getValueAt(i, 3));
                    estudantesRelatorio.add(estu);
                }
                InputStream inputStream = getClass().getResourceAsStream("/Estudante.jasper");
                Map parametros = new HashMap();
                parametros.put("util",form.getUtil().getNome());
                JRDataSource ds = new JRBeanCollectionDataSource(estudantesRelatorio);
                try {
                    // passando o datasource para o método de criação e exibição do relatório
                    ReportUtils.openReport("Estudantes", inputStream, parametros, ds, form);
                } catch (JRException exc) {
                    exc.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getTableEstudantes())) {
            int id = (Integer) estudanteModel.getValueAt(form.getTableEstudantes().getSelectedRow(), 0);
            Estudante c = servico.obterEstudanteTodos(id);
            if (!c.isActivo()) {
                JOptionPane.showMessageDialog(form, "Este estudante esta inactivo! Nao podera realizar nenhuma\n transacao ate que regularize a sua situacao.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                new EditarEstudante(form, true, c, form.getUtil()).setVisible(true);
            }else{
                new EditarEstudante(form, true, c,form.getUtil()).setVisible(true);
            }

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
        if (e.getSource().equals(form.getJcNomeP())) {
            nomeperiodo = new PeriodoServico().ObterNomePeriodo((String) form.getJcNomeP().getSelectedItem());
            adicionaDatas(nomeperiodo);
        } else if (e.getSource().equals(form.getJcData())) {
            data = (Date) form.getJcData().getSelectedItem();
            periodo = new PeriodoServico().obterPeriodo(data, nomeperiodo);
            estudantes = new EstudanteServico().listaTodosEstudantes(periodo);
            preencherTable(estudantes);
        }
    }

}
