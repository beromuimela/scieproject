/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Conexao.Conexao;
import Servico.EstudanteServico;
import Servico.InscricaoServico;
import Servico.MovimentosServico;
import entidades.Candidato;
import entidades.Estudante;
import entidades.Movimentos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import util.ReportUtils;
import vista.Efectuar_Pagamento;

/**
 *
 * @author junito
 */
public class EfectuarPagamentoControladora implements ActionListener, MouseListener, KeyListener {

    private Efectuar_Pagamento form;
    private DefaultTableModel estudanteModel;
    private String[] colunas;
    private List<Estudante> estudantes = new ArrayList<Estudante>();
    private EstudanteServico servico;
    private float valoractual;
    private float valor;

    public EfectuarPagamentoControladora(Efectuar_Pagamento form) {
        this.form = form;
        this.servico = new EstudanteServico();
        this.colunas = new String[]{"Numero", "Nome Completo"};
        this.estudanteModel = new DefaultTableModel(colunas, 1);
        adicionarListener();
        preencherTable();
    }

    public void adicionarListener() {
        form.getJtableEstudantes().addMouseListener(this);
        form.getJtValor().addKeyListener(this);
        form.getJbConfirmar().addActionListener(this);
        form.getJbConfirmar().setActionCommand("confirmar");
    }

    private void limparJTable() {
        DefaultTableModel Model = (DefaultTableModel) form.getJtableEstudantes().getModel();
        while (Model.getRowCount() > 0) {
            Model.removeRow(0);
        }
    }

    public void preencherTable() {
        this.estudantes = servico.listaEstudantesActivosComSaldo();
        preencherTable(estudantes);
    }

    public final void preencherTable(List<Estudante> estudantes) {
        limparJTable();
        if (estudantes.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Nao existem estudantes com dividas!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int linha = estudantes.size();
            estudanteModel.setRowCount(linha);
            for (int i = 0; i < linha; i++) {
                estudanteModel.setValueAt(estudantes.get(i).getIdestudante(), i, 0);
                estudanteModel.setValueAt(estudantes.get(i).getCandidato().getNome() + " " + estudantes.get(i).getCandidato().getApelido(), i, 1);
            }
            form.getJtableEstudantes().setModel(estudanteModel);
            form.getJtableEstudantes().getColumnModel().getColumn(0).setMaxWidth(50);
            renderer(form.getJtableEstudantes());
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

    public void Dados(Estudante est) {
        form.getJlabelNome().setText("Nome: " + est.getCandidato().getNome() + " " + est.getCandidato().getApelido());
        form.getJlabelSaldo().setText("Valor a Pagar: " + String.valueOf(est.getSaldo()));
        form.getJtSaldo().setText(String.valueOf(est.getSaldo()));
        valoractual = est.getSaldo();
    }

    public Movimentos formToMovimento() {
        Movimentos mov = new Movimentos();
        if (form.getJlabelNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Seleccione o estudante a cobrar!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if ((Integer) form.getJtValor().getValue() == 0) {
            JOptionPane.showMessageDialog(form, "Informe um valor superior a 0 !");
        } else {
            mov.setUtilizador(form.getUtil());
            String nome = form.getJlabelNome().getText();
            String replaceFirst = nome.replaceFirst("Nome: ", "");
            mov.setResponsavel(replaceFirst);
            mov.setTipoMovimento("PAGAMENTO");
            mov.setHistorico("PAGAMENTO DE INSCRICAO");

            this.valor = valoractual;
            float troco;
            troco = valor - (Float.valueOf(form.getJtValor().getValue().toString()));
            if (troco == 0) {
                mov.setValor(valor);
            } else {
                mov.setValor(valor);
                JOptionPane.showMessageDialog(form, "Troco: " + (troco * (-1)) + " MT", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
           // mov.setValor(Float.valueOf(form.getJtValor().getValue().toString()));
            for (int i = 0; i < estudanteModel.getRowCount(); i++) {
                if (estudanteModel.getValueAt(i, 1).toString().equals(replaceFirst)) {
                    mov.setT((Integer) estudanteModel.getValueAt(i, 0));
                }
            }
        }
        return mov;
    }

    public void abrirRelatorio(String arquivoJasper, int id) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("idmatricula", id);

        try {
            ReportUtils.openReport("Ficha de Inscricao", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(PagamentoControladora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("confirmar")) {
            Movimentos m = formToMovimento();
            if (m.getResponsavel() != null && m.getValor() != 0) {
                new MovimentosServico().inserir_Movimentos(m);
                JOptionPane.showMessageDialog(form, "Pagamento efectuado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                
                Candidato novo=new InscricaoServico().ObterCandidato(m.getResponsavel());
                abrirRelatorio("/ReciboInscricao.jasper", new InscricaoServico().nrNumeroInscricaoPorCand(novo));
                preencherTable();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getJtableEstudantes())) {
            int id = (Integer) estudanteModel.getValueAt(form.getJtableEstudantes().getSelectedRow(), 0);
            Estudante c = servico.obterEstudante(id);
            Dados(c);
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
    public void keyTyped(KeyEvent e) {
        if (e.getSource().equals(form.getJtValor())) {
            int valor = (int) form.getJtValor().getValue();
            valoractual = valoractual - valor;
            form.getJtSaldo().setText(String.valueOf(valoractual));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource().equals(form.getJtValor())) {
            int valor = (int) form.getJtValor().getValue();
            valoractual = valoractual - valor;
            form.getJtSaldo().setText(String.valueOf(valoractual));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
