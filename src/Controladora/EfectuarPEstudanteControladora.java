/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Conexao.Conexao;
import Servico.InscricaoServico;
import Servico.MovimentosServico;
import entidades.Candidato;
import entidades.Movimentos;
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
import vista.EfectuarPagamentoEstudante;

/**
 *
 * @author junito
 */
public class EfectuarPEstudanteControladora implements ActionListener {

    private EfectuarPagamentoEstudante form;
    private float valor;

    public EfectuarPEstudanteControladora(EfectuarPagamentoEstudante form) {
        this.form = form;
        this.valor = form.getEstudante().getSaldo();
        adicionarListener();
        fill();
    }

    public void adicionarListener() {
        form.getJbConfirmar().addActionListener(this);
        form.getJbConfirmar().setActionCommand("confirmar");
    }

    public void fill() {
        form.getJLNome().setText(form.getEstudante().getCandidato().getNome() + " " + form.getEstudante().getCandidato().getApelido());
        form.getjLsaldo().setText("Valor a Pagar: " + (String.valueOf(form.getEstudante().getSaldo())));
    }

    public Movimentos formToMovimento() {
        Movimentos mov = new Movimentos();
        if ((Integer) form.getJsValorPago().getValue() == 0) {
            JOptionPane.showMessageDialog(form, "Informe um valor superior a 0 !");
        } else {
            mov.setUtilizador(form.getUtil());
            String nome = form.getJLNome().getText();
            mov.setResponsavel(nome);
            mov.setTipoMovimento("PAGAMENTO");
            mov.setHistorico("PAGAMENTO DE INSCRICAO");
            float troco;
            troco = valor - (Float.valueOf(form.getJsValorPago().getValue().toString()));
            if (troco == 0) {
                mov.setValor(valor);
            } else {
                mov.setValor(valor);
                JOptionPane.showMessageDialog(form, "Troco: "+(troco*(-1))+" MT", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
            mov.setT(form.getEstudante().getIdestudante());
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
            if (m.getValor() != 0) {
                new MovimentosServico().inserir_Movimentos(m);
                JOptionPane.showMessageDialog(form, "Pagamento efectuado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                Candidato novo=new InscricaoServico().ObterCandidato(m.getResponsavel());
                abrirRelatorio("/ReciboInscricao.jasper", new InscricaoServico().nrNumeroInscricaoPorCand(novo));
                form.dispose();
            }
        }
    }

}
