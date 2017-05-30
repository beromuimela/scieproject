/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CursoServico;
import Servico.FormadorServico;
import Servico.PeriodoServico;
import entidades.Curso;
import entidades.Formador;
import entidades.Nome_periodo;
import entidades.Periodo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.PeriodoForm;

/**
 *
 * @author junito
 */
public class PeriodoControladora implements ActionListener, ItemListener {

    private final PeriodoForm form;
    private Nome_periodo nomePeriodo;
    private Formador formador;
    private Curso curso;
    private final PeriodoServico servico;
    private final DefaultComboBoxModel periodoModel;
    private final DefaultComboBoxModel formadorModel;
    private final DefaultComboBoxModel cursoModel;

    public PeriodoControladora(PeriodoForm form) {
        this.form = form;
        this.periodoModel = new DefaultComboBoxModel();
        this.formadorModel = new DefaultComboBoxModel();
        this.cursoModel = new DefaultComboBoxModel();
        this.servico = new PeriodoServico();
        adicionarListener();
        adicionaNomePeriodo();
        adicionaCurso();
        adicionaFormadores();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbSalvar().addActionListener(this);
        form.getJcCurso().addItemListener(this);
        form.getJcFormador().addItemListener(this);
        form.getJcNomePeriodo().addItemListener(this);
        form.getJbFechar().setActionCommand("fechar");
        form.getJbSalvar().setActionCommand("salvar");
    }

    public final void adicionaNomePeriodo() {
        List<Nome_periodo> np = new PeriodoServico().listaNomePeriodos();
        if (np != null) {
            for (int i = 0; i < np.size(); i++) {
                periodoModel.insertElementAt(np.get(i).getNome(), i);
            }
            form.getJcNomePeriodo().setModel(periodoModel);
            form.getJcNomePeriodo().setSelectedIndex(0);
        } else {
            form.getJcNomePeriodo().setModel(periodoModel);
        }
    }

    public final void adicionaCurso() {
        List<Curso> cursos = new CursoServico().listaCursos();
        if (cursos != null) {
            for (int i = 0; i < cursos.size(); i++) {
                cursoModel.insertElementAt(cursos.get(i).getNome(), i);
            }
            form.getJcCurso().setModel(cursoModel);
            form.getJcCurso().setSelectedIndex(0);
        } else {
            form.getJcCurso().setModel(cursoModel);
        }
    }

    public final void adicionaFormadores() {
        List<Formador> formadores = new FormadorServico().listaFormadores();
        if (!formadores.isEmpty()) {
            for (int i = 0; i < formadores.size(); i++) {
                formadorModel.insertElementAt(formadores.get(i).getNome(), i);
            }
            form.getJcFormador().setModel(formadorModel);
            form.getJcFormador().setSelectedIndex(0);
        } else {
            form.getJcFormador().setModel(formadorModel);
        }
    }

    public Periodo formToPeriodo() {
        Periodo p = new Periodo();
        if (form.getJdDataInicio().getDate() == null) {
            JOptionPane.showMessageDialog(form, "Informe a data de inicio!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (formador == null) {
            JOptionPane.showMessageDialog(form, "Seleccione um formador valido!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            p.setCurso(curso);
            p.setDatainicio(form.getJdDataInicio().getDate());
            p.setFormador(formador);
            p.setNomePeriodo(nomePeriodo);
        }
        return p;
    }

    public void limparCampos() {
        adicionaNomePeriodo();
        adicionaFormadores();
        form.getJdDataInicio().setDate(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        } else if (e.getActionCommand().equals("salvar")) {
            Periodo perio = formToPeriodo();
            if (perio.getDatainicio() != null && formador != null) {
                if (servico.Existe(perio)) {
                    JOptionPane.showMessageDialog(form, "Este periodo ja se encontra registado", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    servico.salvar(perio);
                    JOptionPane.showMessageDialog(form, "Periodo registado com sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                }
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcCurso())) {
            curso = new CursoServico().ObterCurso((String) form.getJcCurso().getSelectedItem());
        } else if (e.getSource().equals(form.getJcFormador())) {
            formador = new FormadorServico().obterFormador((String) form.getJcFormador().getSelectedItem());
        } else if (e.getSource().equals(form.getJcNomePeriodo())) {
            nomePeriodo = new PeriodoServico().ObterNomePeriodo((String) form.getJcNomePeriodo().getSelectedItem());
        }
    }

}
