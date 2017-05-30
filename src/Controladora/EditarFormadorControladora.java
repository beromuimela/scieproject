/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.FormadorServico;
import Servico.SexoServico;
import entidades.Formador;
import entidades.Sexo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.EditarFormador;

/**
 *
 * @author junito
 */
public class EditarFormadorControladora implements ActionListener, ItemListener {

    private final EditarFormador form;
    private final SexoServico sSexo;
    private final FormadorServico servico;
    private Sexo sexo;
    private final DefaultComboBoxModel sexoModel = new DefaultComboBoxModel();

    public EditarFormadorControladora(EditarFormador form) {
        this.form = form;
        this.sSexo = new SexoServico();
        this.servico = new FormadorServico();
        this.sexo = new Sexo();
        adicionarListener();
        adicionaSexo();
        formadorToForm();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbSalvar().addActionListener(this);
        form.getJcSexo().addItemListener(this);
        form.getJbFechar().setActionCommand("fechar");
        form.getJbSalvar().setActionCommand("salvar");

    }

    public void adicionaSexo() {
        List<Sexo> sexos = new Servico.SexoServico().listaDeSexo();
        if (sexos != null) {
            for (int i = 0; i < sexos.size(); i++) {
                sexoModel.insertElementAt(sexos.get(i).getNome(), i);
            }
            form.getJcSexo().setModel(sexoModel);
            form.getJcSexo().setSelectedIndex(0);
        } else {
            form.getJcSexo().setModel(sexoModel);
        }
    }

    public void limparCampos() {
        form.getJtNome().setText("");
        form.getJtEmail().setText("");
        form.getJtMorada().setText("");
        form.getJtTelefone().setText("");
        form.getJdNascimento().setDate(null);
        adicionaSexo();
    }

    public Formador formToFormador() {
        Formador formador = new Formador();
        if (form.getJtNome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getJdNascimento().getDate() == null) {
            JOptionPane.showMessageDialog(form, "Informe a data de nascimento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getJtMorada().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe a morada!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getJtTelefone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o numero de telefone!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getJtEmail().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o email!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            formador.setDatacadastro(Calendar.getInstance().getTime());
            formador.setDatanascimento(form.getJdNascimento().getDate());
            formador.setNome(form.getJtNome().getText());
            formador.setSexo(sexo);
            formador.setMorada(form.getJtMorada().getText());
            formador.setEmail(form.getJtEmail().getText());
            formador.setTelefone(form.getJtTelefone().getText());
        }
        return formador;
    }

    public final void formadorToForm() {
        form.getJtNome().setText(form.getFormador().getNome());
        form.getJdNascimento().setDate(form.getFormador().getDatanascimento());
        form.getJtMorada().setText(form.getFormador().getMorada());
        form.getJtTelefone().setText(form.getFormador().getTelefone());
        form.getJtEmail().setText(form.getFormador().getEmail());
        form.getJcSexo().setSelectedIndex(form.getFormador().getSexo().getIdsexo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        } else if (e.getActionCommand().equals("salvar")) {
            Formador f = formToFormador();
            if (f.getNome() != null && f.getEmail() != null && f.getMorada() != null && f.getTelefone() != null && f.getDatanascimento() != null) {
                f.setIdformador(form.getFormador().getIdformador());
                servico.actualizar(f);
                JOptionPane.showMessageDialog(form, "Formador actualizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcSexo())) {
            sexo = new SexoServico().ObterSexo((String) form.getJcSexo().getSelectedItem());
        }
    }
}
