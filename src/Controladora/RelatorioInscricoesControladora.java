/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Conexao.Conexao;
import Servico.InscricaoServico;
import entidades.FichaInscricao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import util.ReportUtils;
import vista.RelatorioInscricoes;
import entidades.Utilizador;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author junito
 */
public class RelatorioInscricoesControladora implements ActionListener, ItemListener,MouseListener {

    private RelatorioInscricoes form;
    private DefaultTableModel fichaModel;
    private String[] colunas;
    private List<FichaInscricao> fichas = new ArrayList<FichaInscricao>();
    private InscricaoServico servico;

    public RelatorioInscricoesControladora(RelatorioInscricoes form) {
        this.form = form;
        this.servico = new InscricaoServico();
        this.colunas = new String[]{"Nr. de Inscricao", "Candidato", "Data"};
        this.fichaModel = new DefaultTableModel(colunas, 2);
        MostrarFiltro();
        adicionarListener();
    }

    public void adicionarListener() {
        form.getJbRelatorio().addActionListener(this);
        form.getJcConsultas().addItemListener(this);
        form.getJbPesquisar().addActionListener(this);
        form.getJrCandidato().addActionListener(this);
        form.getJrData().addActionListener(this);
        form.getJrInscricao().addActionListener(this);
        form.getJtFichasInscricoes().addMouseListener(this);
        form.getJrCandidato().setActionCommand("candidato");
        form.getJrData().setActionCommand("data");
        form.getJbPesquisar().setActionCommand("pesquisar");
        form.getJrInscricao().setActionCommand("inscricao");
        form.getJbRelatorio().setActionCommand("relatorio");

    }

    public void MostrarFiltro() {
        if (form.getJcConsultas().getSelectedItem().equals("INSCRICOES NO MÊS")) {
            form.getJdFim().setVisible(true);
            form.getJdInicio().setVisible(true);
            form.getjLabel2().setVisible(true);
            form.getjLabel3().setVisible(true);
            form.getJdFim().setDate(null);
            form.getJdInicio().setDate(null);
            form.getJpanelDatas().setVisible(true);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES ACTIVOS")) {
            form.getJdFim().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getJpanelDatas().setVisible(false);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES QUE TERMINARAM O CURSO")) {
            form.getJdFim().setVisible(true);
            form.getJdInicio().setVisible(true);
            form.getjLabel2().setVisible(true);
            form.getjLabel3().setVisible(true);
            form.getJdFim().setDate(null);
            form.getJdInicio().setDate(null);
            form.getJpanelDatas().setVisible(true);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES INACTVOS")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("INSCRICOES POR UTILIZADOR")) {
            form.getJdFim().setVisible(true);
            form.getJdInicio().setVisible(true);
            form.getjLabel2().setVisible(true);
            form.getjLabel3().setVisible(true);
            form.getJdFim().setDate(null);
            form.getJdInicio().setDate(null);
            form.getJpanelDatas().setVisible(true);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("NOTAS DE ESTUDANTES POR PERIODO")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("FALTAS DE ESTUDANTES POR PERIODO")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
            form.getJtPesquisar().setVisible(false);
            form.getJbPesquisar().setVisible(false);
            form.getJpPesquisar().setVisible(false);
            form.getJrCandidato().setVisible(false);
            form.getJrData().setVisible(false);
            form.getJrInscricao().setVisible(false);
            form.getJDdataFinal().setVisible(false);
            form.getJbRelatorio().setVisible(true);
        } else if (form.getJcConsultas().getSelectedItem().equals("LISTA DE INCRICOES")) {
            form.getJdFim().setVisible(false);
            form.getJdInicio().setVisible(false);
            form.getjLabel2().setVisible(false);
            form.getjLabel3().setVisible(false);
            form.getJpanelDatas().setVisible(false);
            form.getJtPesquisar().setVisible(true);
            form.getJbPesquisar().setVisible(true);
            form.getJpPesquisar().setVisible(true);
            form.getJrCandidato().setVisible(true);
            form.getJrData().setVisible(true);
            form.getJrInscricao().setVisible(true);
            form.getJDdataFinal().setVisible(true);
            form.getJbRelatorio().setVisible(false);
            preencherTable();
        }
    }

    public void executarRelatorio() {
        if (form.getJcConsultas().getSelectedItem().equals("INSCRICOES NO MÊS")) {
            if (form.getJdInicio().getDate() != null && form.getJdFim().getDate() != null) {
                abrirRelatorioComDatas("/InscricoesNoMes.jasper", form.getJdInicio().getDate(), form.getJdFim().getDate(), form.getUtil());
            } else {
                JOptionPane.showMessageDialog(form, "Informe a data incial ou data final!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES ACTIVOS")) {
            abrirRelatorio("/EstudantesAssistindoAulas.jasper", form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES QUE TERMINARAM O CURSO")) {
            if (form.getJdInicio().getDate() != null && form.getJdFim().getDate() != null) {
                abrirRelatorioComDatas("/EstudantesTesrminaramCurso.jasper", form.getJdInicio().getDate(), form.getJdFim().getDate(), form.getUtil());
            } else {
                JOptionPane.showMessageDialog(form, "Informe a data incial ou data final!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (form.getJcConsultas().getSelectedItem().equals("ESTUDANTES INACTVOS")) {
            abrirRelatorio("/EstudantesInactivos.jasper", form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("INSCRICOES POR UTILIZADOR")) {
            if (form.getJdInicio().getDate() != null && form.getJdFim().getDate() != null) {
                abrirRelatorioComDatas("/InscricoesPorUtilizador.jasper", form.getJdInicio().getDate(), form.getJdFim().getDate(), form.getUtil());
            } else {
                JOptionPane.showMessageDialog(form, "Informe a data incial ou data final!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (form.getJcConsultas().getSelectedItem().equals("NOTAS DE ESTUDANTES POR PERIODO")) {
            abrirRelatorio("/NotasPorPeriodo.jasper", form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("FALTAS DE ESTUDANTES POR PERIODO")) {
            abrirRelatorio("/FaltasPorPeriodo.jasper", form.getUtil());
        } else if (form.getJcConsultas().getSelectedItem().equals("LISTA DE INCRICOES")) {

        }
    }

    public void abrirRelatorioComDatas(String arquivoJasper, Timestamp i, Timestamp f, Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();

        parametros.put("datai", i);
        parametros.put("dataf", f);
        parametros.put("util", util.getNome());
        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioInscricoesControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirRelatorioComDatas(String arquivoJasper, Date i, Date f, Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("datai", i);
        parametros.put("dataf", f);
        parametros.put("util", util.getNome());

        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioInscricoesControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirRelatorio(String arquivoJasper, Utilizador util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("util", util.getNome());

        try {
            ReportUtils.openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioInscricoesControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "relatorio":
                executarRelatorio();
                break;
            case "pesquisar":
                pesquisar();
                break;
            case "inscricao":
                if(form.getJrInscricao().isSelected()){
                    form.getJrData().setSelected(false);
                    form.getJrCandidato().setSelected(false);
                }   break;
            case "candidato":
                if(form.getJrCandidato().isSelected()){
                    form.getJrData().setSelected(false);
                    form.getJrInscricao().setSelected(false);
                }   break;
            case "data":
                if(form.getJrData().isSelected()){
                    form.getJrInscricao().setSelected(false);
                    form.getJrCandidato().setSelected(false);
                }   break;
            default:
                break;
        }
    }

    private void limparJTable() {
        DefaultTableModel Model = (DefaultTableModel) form.getJtFichasInscricoes().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public void preencherTable() {
        this.fichas = servico.listarFichaInscricao();
        preencherTable(fichas);
    }

    public final void preencherTable(List<FichaInscricao> fichasInscricoes) {
        limparJTable();
        if (fichasInscricoes.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem fichas de inscricoes no sistema!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = fichasInscricoes.size();
            fichaModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                fichaModel.setValueAt(fichasInscricoes.get(i).getIdmatricula(), i, 0);
                fichaModel.setValueAt(fichasInscricoes.get(i).getCandidato().getNome() + " " + fichasInscricoes.get(i).getCandidato().getApelido(), i, 1);
//                fichaModel.setValueAt(fichasInscricoes.get(i).getUnicaP().getNome(), i, 2);
//                fichaModel.setValueAt(fichasInscricoes.get(i).getDuplaFirst().getNome(), i, 3);
//                fichaModel.setValueAt(fichasInscricoes.get(i).getDuplaSecond().getNome(), i, 4);
                fichaModel.setValueAt(fichasInscricoes.get(i).getData(), i, 2);
            }
            form.getJtFichasInscricoes().setModel(fichaModel);
            form.getJtFichasInscricoes().getColumnModel().getColumn(0).setMaxWidth(50);
            // renderer(form.getJtFichasInscricoes());
        }
    }

    public void pesquisar() {
        DefaultTableModel tabelaFicha = (DefaultTableModel) form.getJtFichasInscricoes().getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaFicha);
        form.getJtFichasInscricoes().setRowSorter(sorter);
        String text = form.getJtPesquisar().getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                if (form.getJrInscricao().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                } else if (form.getJrCandidato().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                } else if (form.getJrData().isSelected()) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + new Date(), 2));
                } else {
                    JOptionPane.showMessageDialog(form, "Para pesquisar marque o criterio de pesquisa\n 'Nr. de Incricao', 'Candidato' ou Data", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (PatternSyntaxException pse) {
                System.err.println("Erro");
            }
        }

    }
    
    public void abrirRelatorio(String arquivoJasper,int id) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("idmatricula",id);

        try {
            ReportUtils.openReport("Ficha de Inscricao", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(PagamentoControladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcConsultas())) {
            MostrarFiltro();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getJtFichasInscricoes())) {
            int id = (Integer) fichaModel.getValueAt(form.getJtFichasInscricoes().getSelectedRow(), 0);
            abrirRelatorio("/ReciboInscricao.jasper", id);
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
