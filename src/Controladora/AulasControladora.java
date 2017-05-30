/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CursoServico;
import Servico.EstudanteServico;
import Servico.PacotesServico;
import entidades.Estudante_Pacotes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import vista.AulasForm;
import vista.FaltasInternal;
import vista.NotasInternal;
import vista.PacotesInternal;

/**
 *
 * @author junito
 */
public class AulasControladora implements ActionListener, ItemListener {

    private final AulasForm form;
    private PacotesInternal formPacotes;
    private NotasInternal formNotas;
    private FaltasInternal formFaltas;
    private int internalactivo;

    public AulasControladora(AulasForm form) {
        this.form = form;
        adicionarListener();
        Mostrar();
    }

    public final void Mostrar() {
        switch (form.getJcFiltro().getSelectedIndex()) {
            case 0:
                this.formPacotes = new PacotesInternal();
                this.form.getJdPainel().add(formPacotes);
                formPacotes.setVisible(true);
                internalactivo = 0;
                break;
            case 1:
                this.formNotas = new NotasInternal();
                this.form.getJdPainel().add(formNotas);
                formNotas.setVisible(true);
                internalactivo = 1;
                break;
            case 2:
                this.formFaltas = new FaltasInternal();
                this.form.getJdPainel().add(formFaltas);
                formFaltas.setVisible(true);
                internalactivo = 2;
                break;
            default:
                break;
        }
    }

    public final void adicionarListener() {
        form.getJcFiltro().addItemListener(this);
//        form.getJbFechar().addActionListener(this);
        form.getJbSalvar().addActionListener(this);
//        form.getJbFechar().setActionCommand("fechar");
        form.getJbSalvar().setActionCommand("salvar");
    }

    public void transaccoesComInternalFrames() {
        switch (internalactivo) {
            case 0:
                if (formPacotes.getPacotes() != null && formPacotes.getPeriodo() != null && (formPacotes.getListaDestudantes().isEmpty() != true)) {
                    if (new PacotesServico().verificar_periodoPacotes(formPacotes.getPeriodo(), formPacotes.getPacotes())) {
                        JOptionPane.showMessageDialog(null, "As aulas deste pacote ja se encontram em andamento!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    } else if (formPacotes.getPacotes().getNome().equals("MICROSOFT OFFICE EXCEL")) {
                        if (JOptionPane.showConfirmDialog(null, "Os estudantes com os pagamentos atrasados nao poderam continuar com o curso!\nPretende adicionar?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                            new EstudanteServico().inserir_EstudantesPacotes(formPacotes.getListaestudante_pacotes(), formPacotes.getPeriodo());
                            JOptionPane.showMessageDialog(null, "Pacote adicionado ao periodo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        new EstudanteServico().inserir_EstudantesPacotes(formPacotes.getListaestudante_pacotes(), formPacotes.getPeriodo());
                        JOptionPane.showMessageDialog(null, "Pacote registado no periodo com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Informe data de periodo,pacote ou lista de estudantes validos!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 1:
                if (formNotas.getPacotes() != null && formNotas.getPeriodo() != null && (formNotas.getListaestudante_pacotes().isEmpty() != true) && formNotas.getCandModel() != null) {
                    if (JOptionPane.showConfirmDialog(null, "Os estudantes com notas inferiores a 10 nao poderam continuar com o curso!\nPretende adicionar?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        preencherNotas(formNotas.getListaestudante_pacotes());
                        new EstudanteServico().update_Notas(formNotas.getListaestudante_pacotes());
                        JOptionPane.showMessageDialog(null, "Notas inseridas com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Erro Notas");
                }
                break;
            case 2:
                if (formFaltas.getPacotes() != null && formFaltas.getPeriodo() != null && (formFaltas.getListaDestudantes().isEmpty() != true)) {
                   if (JOptionPane.showConfirmDialog(null, "Os estudantes com o numero de faltas superior a "+new CursoServico().nrdeFaltas() +"  nao poderam continuar com o curso!\nPretende adicionar?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        preencherFaltas(formFaltas.getListaDestudantes());
                        new EstudanteServico().update_Faltas(formFaltas.getListaDestudantes());
                        JOptionPane.showMessageDialog(null, "Faltas inseridas com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Erro faltas");
                }
                break;
            default:
                break;
        }
    }

    public void preencherNotas(List<Estudante_Pacotes> estp) {
        for (int i = 0; i < estp.size(); i++) {
//            float t = new FloatformNotas.getCandModel().getValueAt(i, 3);
            Object t=formNotas.getCandModel().getValueAt(i, 3);
            String nova=t.toString();
            estp.get(i).setNota(Float.valueOf(nova));
        }
    }
    
    public void preencherFaltas(List<Estudante_Pacotes> estp) {
        for (int i = 0; i < estp.size(); i++) {
            Object t=formFaltas.getCandModel().getValueAt(i, 3);
            String nova=t.toString();
            estp.get(i).setNumerofaltas(Integer.valueOf(nova));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        } else if (e.getActionCommand().equals("salvar")) {
            transaccoesComInternalFrames();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(form.getJcFiltro())) {
            Mostrar();
        }
    }

}
