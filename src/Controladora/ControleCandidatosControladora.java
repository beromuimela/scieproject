
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CandidatoServico;
import Servico.Tipo_idServico;
import entidades.Candidato;
import entidades.Tipo_Id;
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
import util.CandidatoParaRelatorio;
import util.ReportUtils;
import vista.ControleCandidatos;
import vista.EditarCandidato;
import vista.NovoCandidato;

/**
 *
 * @author junito
 */
public class ControleCandidatosControladora implements ActionListener, MouseListener {

    private ControleCandidatos form;
    private DefaultTableModel candidatoModel;
    private CandidatoServico servico = new CandidatoServico();
    private String[] colunas;
    private List candidatos;

    public ControleCandidatosControladora(ControleCandidatos form) {
        this.colunas = new String[]{"Numero", "Nome Completo", "Tipo de Documento", "Numero Documento"};
        this.candidatoModel = new DefaultTableModel(colunas, 3);
        this.form = form;
        adicionarListener();
        preencherTable();
    }

    public void pesquisar() {
        DefaultTableModel tabelaCandidatos = (DefaultTableModel) form.getTableCandidatos().getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaCandidatos);
        form.getTableCandidatos().setRowSorter(sorter);
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
        DefaultTableModel Model = (DefaultTableModel) form.getTableCandidatos().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public final void preencherTable() {
        List<Candidato> candidatos = servico.listaCandidatos();
        limparJTable();
        if (candidatos.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem novos candidatos cadastrados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = candidatos.size();
            candidatoModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                candidatoModel.setValueAt(candidatos.get(i).getIdcandidato(), i, 0);
                candidatoModel.setValueAt(candidatos.get(i).getNome() + " " + candidatos.get(i).getApelido(), i, 1);
                candidatoModel.setValueAt(new Tipo_idServico().ObterId(candidatos.get(i).getTipoid().getIdtipo()).getNome(), i, 2);
                candidatoModel.setValueAt(candidatos.get(i).getNumerodocumento(), i, 3);
            }
            form.getTableCandidatos().setModel(candidatoModel);
            form.getTableCandidatos().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getTableCandidatos());
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

    public final void adicionarListener() {
        form.getCadastrar().addActionListener(this);
        form.getBuscar().addActionListener(this);
        form.getJbImprimir().addActionListener(this);
//        form.getFechar().addActionListener(this);
        form.getRbnumero().addActionListener(this);
        form.getjRNome().addActionListener(this);
//        form.getImprimir().addActionListener(this);
        form.getTableCandidatos().addMouseListener(this);
        form.getActualizarTabela().addActionListener(this);
        form.getBuscar().setActionCommand("buscar");
        form.getJbImprimir().setActionCommand("imprimir");
        form.getjRNome().setActionCommand("rbnome");
        form.getRbnumero().setActionCommand("rbnumero");
//        form.getFechar().setActionCommand("fechar");
        form.getActualizarTabela().setActionCommand("actualizar");
//        form.getImprimir().setActionCommand("imprimir");
        form.getCadastrar().setActionCommand("cadastrar");
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
                }
                break;
            case "rbnumero":
                if (form.getRbnumero().isSelected()) {
                    form.getjRNome().setSelected(false);
                }
                break;
            case "fechar":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "actualizar":
                preencherTable();
                break;
            case "cadastrar":
                new NovoCandidato(form, true).setVisible(true);
                break;
            case "imprimir":
                candidatos = new ArrayList();
                for (int i = 0; i < form.getTableCandidatos().getRowCount(); i++) {
                    CandidatoParaRelatorio c=new CandidatoParaRelatorio();
                    c.setIdcandidato((Integer) form.getTableCandidatos().getValueAt(i, 0));
                    c.setNome((String) form.getTableCandidatos().getValueAt(i, 1));
                    c.setDocumento((String) form.getTableCandidatos().getValueAt(i, 2));
                    c.setNumero((String) form.getTableCandidatos().getValueAt(i, 3));
                    candidatos.add(c);
                }
                InputStream inputStream = getClass().getResourceAsStream("/Candidatos.jasper");
                Map parametros = new HashMap();
                parametros.put("util",form.getUtil().getNome());
                JRDataSource ds = new JRBeanCollectionDataSource(candidatos);
                try {
                    // passando o datasource para o método de criação e exibição do relatório
                    ReportUtils.openReport("Candidatos", inputStream, parametros, ds,form);
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
        if (e.getSource().equals(form.getTableCandidatos())) {
            int id = (Integer) candidatoModel.getValueAt(form.getTableCandidatos().getSelectedRow(), 0);
            Candidato c = servico.CandidatoPorId(id);
            new EditarCandidato(form, true, c).setVisible(true);
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
