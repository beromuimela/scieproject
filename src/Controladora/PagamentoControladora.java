/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Conexao.Conexao;
import Servico.InscricaoServico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import util.ReportUtils;
import vista.Pagamento;

/**
 *
 * @author junito
 */
public class PagamentoControladora implements ActionListener {

    private Pagamento form;
    private InscricaoServico servico;

    public PagamentoControladora(Pagamento form) {
        this.form = form;
        this.servico = new InscricaoServico();
        adicionarListener();
        InscricaoToForm();
    }

    public void InscricaoToForm() {
        form.getJlCandidato().setText(form.getInscricao().getCandidato().getNome() + " " + form.getInscricao().getCandidato().getApelido());
        String valor = String.valueOf(form.getInscricao().getValor());
        form.getJlValorPago().setText(valor);
        String custo;
        float troco;
        if (form.getInscricao().getCandidato().isIsSingular()) {
            custo = String.valueOf(form.getInscricao().getCurso().getPreco());
            form.getJlPreco().setText(custo);
            troco = form.getInscricao().getCurso().getPreco() - form.getInscricao().getValor();
        } else {
            custo = String.valueOf(form.getInscricao().getCurso().getPrecoEmp());
            form.getJlPreco().setText(custo);
            troco = form.getInscricao().getCurso().getPrecoEmp() - form.getInscricao().getValor();
        }
        if (troco >= 0) {
            form.getJlTroco().setText("0");
            form.getInscricao().setTroco(troco);
        } else {
            troco *= -1;
            form.getJlTroco().setText(String.valueOf(troco));
            form.getInscricao().setValor(form.getInscricao().getValor() - troco);
        }
        form.getJlUtilizador().setText(form.getInscricao().getUtilizador().getNome());

    }

    public final void adicionarListener() {
        form.getJbCancelar().addActionListener(this);
        form.getJbConfirmar().addActionListener(this);
        form.getJbCancelar().setActionCommand("cancelar");
        form.getJbConfirmar().setActionCommand("confirmar");
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
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cancelar")) {
            form.dispose();
        } else if (e.getActionCommand().equals("confirmar")) {
            servico.inscrever(form.getInscricao());
            JOptionPane.showMessageDialog(form, "Inscricao efectuada com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            abrirRelatorio("/ReciboInscricao.jasper", new InscricaoServico().nrNumeroInscricaoPorCand(form.getInscricao().getCandidato()));
            form.dispose();
        }
    }

}
