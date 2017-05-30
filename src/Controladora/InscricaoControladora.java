/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CaixaServico;
import Servico.CandidatoServico;
import Servico.CursoServico;
import Servico.InscricaoServico;
import Servico.PeriodoServico;
import entidades.Candidato;
import entidades.Inscricao;
import entidades.Nome_periodo;
import entidades.Periodo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.InscricaoForm;
import vista.Pagamento;

/**
 *
 * @author junito
 */
public class InscricaoControladora implements ActionListener, ItemListener {

    private final InscricaoForm form;
    private Candidato candidato;
    private DefaultComboBoxModel candidatoModel;
    private Date data;
    private DefaultComboBoxModel dataModel;
    private Nome_periodo nomeperiodo;
    private DefaultComboBoxModel nomeModel;
    private Periodo periodo;
    private final InscricaoServico servico;

    public InscricaoControladora(InscricaoForm form) {
        this.form = form;
        this.servico = new InscricaoServico();
        this.periodo = new Periodo();
        this.candidato = new Candidato();
        this.data = new Date();
        this.nomeModel = new DefaultComboBoxModel();
        this.nomeperiodo = new Nome_periodo();
        adicionarListener();
        adicionaCandidatos();
        adicionaNomeP();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbInscrever().addActionListener(this);
        form.getJcCandidato().addItemListener(this);
        form.getJcDataInicio().addItemListener(this);
        form.getJcNomePeriodo().addItemListener(this);
        form.getJbInscrever().setActionCommand("inscrever");
        form.getJbFechar().setActionCommand("fechar");
    }

    public Inscricao formToInscricao() {
        Inscricao inscricao = new Inscricao();
        if ((int) form.getjSValor().getValue() < 1000) {
            JOptionPane.showMessageDialog(form, "Informe um valor igual ou superior a 1000!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (data == null) {
            JOptionPane.showMessageDialog(form, "Seleccine uma data valida!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (candidato == null) {
            JOptionPane.showMessageDialog(form, "Seleccione um candidato!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            inscricao.setCandidato(candidato);
            inscricao.setCurso(new CursoServico().ObterCurso("Informatica"));
            inscricao.setPeriodo(periodo);
            inscricao.setUtilizador(form.getUtil());
            inscricao.setValor((int) form.getjSValor().getValue());
        }
        return inscricao;

    }

    public void adicionaCandidatos() {
        List<Candidato> candidatos = new CandidatoServico().listaCandidatos();
        if (!candidatos.isEmpty()) {
            this.candidatoModel = new DefaultComboBoxModel();
            for (int i = 0; i < candidatos.size(); i++) {
                candidatoModel.insertElementAt(candidatos.get(i).getNome().toUpperCase() + " " + candidatos.get(i).getApelido().toUpperCase(), i);
            }
            form.getJcCandidato().setModel(candidatoModel);
            form.getJcCandidato().setSelectedIndex(0);
        } else {
            form.getJcCandidato().setModel(new DefaultComboBoxModel());
            candidato = null;

        }
    }

    public final void adicionaNomeP() {
        List<Nome_periodo> nomes = new PeriodoServico().listaNomePeriodos();
        if (!nomes.isEmpty()) {
            for (int i = 0; i < nomes.size(); i++) {
                nomeModel.insertElementAt(nomes.get(i).getNome(), i);
            }
            form.getJcNomePeriodo().setModel(nomeModel);
            form.getJcNomePeriodo().setSelectedIndex(0);
        } else {
            form.getJcNomePeriodo().setModel(nomeModel);
        }
    }

    public final void adicionaDatas(Nome_periodo nomep) {
        List<Date> datas = new PeriodoServico().listaDatasPeriodos(nomep);
        if (!datas.isEmpty()) {
            this.dataModel = new DefaultComboBoxModel();
            for (int i = 0; i < datas.size(); i++) {
                dataModel.insertElementAt(datas.get(i), i);
            }
            form.getJcDataInicio().setModel(dataModel);
            form.getJcDataInicio().setSelectedIndex(0);
        } else {
            this.dataModel = new DefaultComboBoxModel();
            form.getJcDataInicio().setModel(dataModel);
            data = null;
        }
    }

    public void limparCampos() {
        adicionaCandidatos();
        adicionaNomeP();
        form.getjSValor().setValue(0);
        form.getJsqtdEstudantes().setValue((Integer) new InscricaoServico().nrEstudantesPorPeriodo(periodo));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("inscrever")) {
            Inscricao insc = formToInscricao();
            if (insc.getCandidato() != null && insc.getPeriodo().getDatainicio() != null && insc.getValor() >= 1000) {
                if (new CaixaServico().isAberto()) {
                    if (new InscricaoServico().nrEstudantesPorPeriodo(periodo) < insc.getCurso().getNrestudantesSala()) {
                        new Pagamento(form, true, insc).setVisible(true);
                        limparCampos();
                    }else{
                        JOptionPane.showMessageDialog(form, "Atingiu o numero maximo de inscricoes para o periodo seleccionado!\nInscreva o estudante num periodo diferente","Mensagem",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "O caixa nao esta aberto, abra o caixa para poder efectuar uma inscricao!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcNomePeriodo())) {
            nomeperiodo = new PeriodoServico().ObterNomePeriodo((String) form.getJcNomePeriodo().getSelectedItem());
            adicionaDatas(nomeperiodo);
        } else if (e.getSource().equals(form.getJcDataInicio())) {
            data = (Date) form.getJcDataInicio().getSelectedItem();
            periodo = new PeriodoServico().obterPeriodo(data, nomeperiodo);
            form.getJsqtdEstudantes().setValue((Integer) new InscricaoServico().nrEstudantesPorPeriodo(periodo));
        } else if (e.getSource().equals(form.getJcCandidato())) {
            candidato = new CandidatoServico().CandidatoPorId((String) form.getJcCandidato().getSelectedItem());
        }

    }

}
