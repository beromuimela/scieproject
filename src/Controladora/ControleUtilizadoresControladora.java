/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.UtilizadorServico;
import entidades.Utilizador;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
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
import util.FormadorParaRelatorio;
import util.ReportUtils;
import util.UtilizadorParaRelatorio;
import vista.ControleUtilizadores;
import vista.EditarUtilizadorForm;
import vista.UtilizadorForm;

/**
 *
 * @author junito
 */
public class ControleUtilizadoresControladora implements ActionListener, MouseListener {

    private ControleUtilizadores form;
    private UtilizadorServico servico;
    private DefaultTableModel utilizadorModel;
    private String[] colunas;
    private List utilizadores;

    public ControleUtilizadoresControladora(ControleUtilizadores form) {
        this.form = form;
        this.colunas = new String[]{"Numero", "Nome", "Estado"};
        this.utilizadorModel = new DefaultTableModel(colunas, 2);
        this.servico = new UtilizadorServico();
        adiconarListener();
        preencherTable();
    }

    public final void adiconarListener() {
        form.getJtableUtilizadores().addMouseListener(this);
        form.getJbbuscar().addActionListener(this);
//        form.getJbfechar().addActionListener(this);
        form.getJbregistar().addActionListener(this);
        form.getRbnumero().addActionListener(this);
        form.getjRNome().addActionListener(this);
        form.getJbactualizar().addActionListener(this);
        form.getjBimprimir().addActionListener(this);
        form.getjBimprimir().setActionCommand("imprimir");
        form.getJbactualizar().setActionCommand("actualizar");
        form.getRbnumero().setActionCommand("rnumero");
        form.getjRNome().setActionCommand("rnome");
        form.getJbbuscar().setActionCommand("buscar");
//        form.getJbfechar().setActionCommand("fechar");
        form.getJbregistar().setActionCommand("registar");
    }

    public String estado(boolean estado) {
        if (estado == true) {
            return "INACTIVO";
        } else {
            return "ACTIVO";
        }
    }
    

    public final void preencherTable() {
        List<Utilizador> utilizadores = servico.listaTodosUtilizadores();
        if (utilizadores.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem utilizadores registados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = utilizadores.size();
            utilizadorModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                utilizadorModel.setValueAt(utilizadores.get(i).getIdutilizador(), i, 0);
                utilizadorModel.setValueAt(utilizadores.get(i).getNome(), i, 1);
                utilizadorModel.setValueAt(estado(utilizadores.get(i).isIsdesactivado()), i, 2);
            }
            form.getJtableUtilizadores().setModel(utilizadorModel);
            form.getJtableUtilizadores().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getJtableUtilizadores());
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


    public void pesquisar() {
        DefaultTableModel tabelaUtilizadores = (DefaultTableModel) form.getJtableUtilizadores().getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaUtilizadores);
        form.getJtableUtilizadores().setRowSorter(sorter);
        String text = form.getJtPesquisar().getText();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "rnome":
                if (form.getjRNome().isSelected()) {
                    form.getRbnumero().setSelected(false);
                }
                break;
            case "rnumero":
                if (form.getRbnumero().isSelected()) {
                    form.getjRNome().setSelected(false);
                }
                break;
            case "buscar":
                pesquisar();
                break;
            case "fechar":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "registar":
                new UtilizadorForm(form, true).setVisible(true);
                break;
            case "actualizar":
                preencherTable();
                break;
            case "imprimir":
                 utilizadores = new ArrayList();
                for (int i = 0; i < form.getJtableUtilizadores().getRowCount(); i++) {
                    UtilizadorParaRelatorio u=new UtilizadorParaRelatorio();
                    u.setId((Integer) form.getJtableUtilizadores().getValueAt(i, 0));
                    u.setNome((String) form.getJtableUtilizadores().getValueAt(i, 1));
                    u.setEstado((String) form.getJtableUtilizadores().getValueAt(i, 2));
                    utilizadores.add(u);
                }
                InputStream inputStream = getClass().getResourceAsStream("/Utilizadores.jasper");
                Map parametros = new HashMap();
                parametros.put("util",form.getUtil().getNome());
                JRDataSource ds = new JRBeanCollectionDataSource(utilizadores);
                try {
                    // passando o datasource para o método de criação e exibição do relatório
                    ReportUtils.openReport("Utilizadores", inputStream, parametros, ds,form);
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
        if (e.getSource().equals(form.getJtableUtilizadores())) {
            int id = (Integer) utilizadorModel.getValueAt(form.getJtableUtilizadores().getSelectedRow(), 0);
            Utilizador util = servico.ObterUtilizadorAll(id);
            new EditarUtilizadorForm(form, true, util).setVisible(true);
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

}
