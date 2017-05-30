/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CursoServico;
import entidades.Curso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import vista.CursoForm;

/**
 *
 * @author junito
 */
public class CursoControladora implements ActionListener, MouseListener {

    private CursoForm form;
    private CursoServico servico;

    public CursoControladora(CursoForm Form) {
        this.form = Form;
        this.servico = new CursoServico();
        adicionarListener();
        cursoToForm();
        disableFields();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbsalvar().addActionListener(this);
        form.getJbEditar().addActionListener(this);
        form.getJbEditar().setActionCommand("editar");
        form.getJbFechar().setActionCommand("fechar");
        form.getJbsalvar().setActionCommand("salvar");

    }

    public void disableFields() {
        form.getJsEstudantesSala().setEnabled(false);
        form.getJsFaltas().setEnabled(false);
        form.getJsInstituicao().setEnabled(false);
        form.getJsSingular().setEnabled(false);
        form.getJbsalvar().setVisible(false);
        form.getJbEditar().setVisible(true);
    }

    public void enableFields() {
        form.getJsEstudantesSala().setEnabled(true);
        form.getJsFaltas().setEnabled(true);
        form.getJsInstituicao().setEnabled(true);
        form.getJsSingular().setEnabled(true);
        form.getJbsalvar().setVisible(true);
        form.getJbEditar().setVisible(false);
    }

    public final void cursoToForm() {
        Curso curso = servico.ObterCurso(1);
        form.getJsEstudantesSala().setValue(curso.getNrestudantesSala());
        form.getJsFaltas().setValue(curso.getNrFaltas());
        form.getJsInstituicao().setValue(curso.getPrecoEmp());
        form.getJsSingular().setValue(curso.getPreco());
    }

    public Curso FormToCurso() {
        Curso c = new Curso();
//        if (form.getJsEstudantesSala().getValue() == null) {
//            JOptionPane.showMessageDialog(form, "Informe o numero maximo de estudantes por sala!","Mensagem",JOptionPane.INFORMATION_MESSAGE);
//        } else if (form.getJsFaltas().getValue() == null) {
//            JOptionPane.showMessageDialog(form, "Informe o numero maximo de faltas","Mensagem",JOptionPane.INFORMATION_MESSAGE);
//        }else if(form.getJsInstituicao().getValue()==null){
//            JOptionPane.showMessageDialog(form, "Informe o preco para instituicoes!","Mensagem",JOptionPane.INFORMATION_MESSAGE);
//        }else if(form.getJsSingular().getValue()==null){
//            JOptionPane.showMessageDialog(form, "Informe o preco para singulares!","Mensagem",JOptionPane.INFORMATION_MESSAGE);
//        }
        c.setNrFaltas((Integer) form.getJsFaltas().getValue());
        c.setNrestudantesSala((Integer) form.getJsEstudantesSala().getValue());
        c.setPreco(Float.valueOf(form.getJsSingular().getValue().toString()));
        c.setPrecoEmp(Float.valueOf(form.getJsInstituicao().getValue().toString()));
        c.setNome("Informatica");
        return c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("editar")) {
            enableFields();
        } else if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        } else if (e.getActionCommand().equals("salvar")) {
            Curso c = FormToCurso();
            servico.UpdateCurso(c);
            JOptionPane.showMessageDialog(form, "Informacoes alteradas com sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
            disableFields();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
