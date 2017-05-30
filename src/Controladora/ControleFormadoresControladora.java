
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CandidatoServico;
import Servico.FormadorServico;
import Servico.Tipo_idServico;
import entidades.Candidato;
import entidades.Formador;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
import vista.ControleCandidatos;
import vista.ControleFormadores;
import vista.EditarCandidato;
import vista.EditarFormador;
import vista.FormadorForm;
import vista.NovoCandidato;

/**
 *
 * @author junito
 */
public class ControleFormadoresControladora implements ActionListener, MouseListener {

    private final ControleFormadores form;
    private final DefaultTableModel formadorModel;
    private final FormadorServico servico = new FormadorServico();
    private final String[] colunas;
    private List formadores;

    public ControleFormadoresControladora(ControleFormadores form) {
        this.colunas = new String[]{"Numero", "Data de Cadastro", "Nome Completo", "Sexo"};
        this.formadorModel = new DefaultTableModel(colunas, 3);
        this.form = form;
        adicionarListener();
        preencherTable();
    }

    public void pesquisar() {
        DefaultTableModel tabelaFormadores = (DefaultTableModel) form.getTableFormadores().getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaFormadores);
        form.getTableFormadores().setRowSorter(sorter);
        String text = form.getPesquisar().getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                if (form.getjRNome().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
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
        DefaultTableModel Model = (DefaultTableModel) form.getTableFormadores().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public String formatoData(Date date) {
        String data = date.getDate() + "-" + (date.getMonth() + 1) + "-" + (date.getYear() + 1900);
//        String Horas = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        return data;
    }

    public final void preencherTable() {
        List<Formador> formadores = servico.listaFormadores();
        limparJTable();
        if (formadores.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem formadores cadastrados!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = formadores.size();
            formadorModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                formadorModel.setValueAt(formadores.get(i).getIdformador(), i, 0);
                formadorModel.setValueAt(formatoData(formadores.get(i).getDatacadastro()), i, 1);
                formadorModel.setValueAt(formadores.get(i).getNome(), i, 2);
                formadorModel.setValueAt(formadores.get(i).getSexo().getNome(), i, 3);
            }
            form.getTableFormadores().setModel(formadorModel);
            form.getTableFormadores().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getTableFormadores());
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
//        form.getFechar().addActionListener(this);
        form.getRbnumero().addActionListener(this);
        form.getjRNome().addActionListener(this);
//        form.getImprimir().addActionListener(this);
        form.getTableFormadores().addMouseListener(this);
        form.getActualizarTabela().addActionListener(this);
        form.getJbImprimir().addActionListener(this);
        form.getBuscar().setActionCommand("buscar");
        form.getjRNome().setActionCommand("rbnome");
        form.getRbnumero().setActionCommand("rbnumero");
        form.getJbImprimir().setActionCommand("imprimir");
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
                new FormadorForm(form, true).setVisible(true);
                break;
            case "imprimir":
                formadores = new ArrayList();
                for (int i = 0; i < form.getTableFormadores().getRowCount(); i++) {
                    FormadorParaRelatorio f=new FormadorParaRelatorio();
                    f.setId((Integer) form.getTableFormadores().getValueAt(i, 0));
                    f.setNomeCompleto((String) form.getTableFormadores().getValueAt(i, 2));
                    f.setDatacadastro((String) form.getTableFormadores().getValueAt(i, 1));
                    f.setSexo((String) form.getTableFormadores().getValueAt(i, 3));
                    formadores.add(f);
                }
                InputStream inputStream = getClass().getResourceAsStream("/Formadores.jasper");
                Map parametros = new HashMap();
                parametros.put("util",form.getUtil().getNome());
                JRDataSource ds = new JRBeanCollectionDataSource(formadores);
                try {
                    // passando o datasource para o método de criação e exibição do relatório
                    ReportUtils.openReport("Formadores", inputStream, parametros, ds,form);
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
        if (e.getSource().equals(form.getTableFormadores())) {
            int id = (Integer) formadorModel.getValueAt(form.getTableFormadores().getSelectedRow(), 0);
            Formador f = servico.obterFormador(id);
            new EditarFormador(form, true, f).setVisible(true);
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
