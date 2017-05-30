/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.UtilizadorServico;
import entidades.Utilizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import vista.UtilizadorForm;

/**
 *
 * @author junito
 */
public class UtilizadorControladora implements ActionListener {

    private UtilizadorForm form;

    public UtilizadorControladora(UtilizadorForm form) {
        this.form = form;
        form.getJtEstado().setText("ACTIVO");
        adicionarListener();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbSalvar().addActionListener(this);
        form.getJcMostrarSenha().addActionListener(this);
        form.getJcMostrarSenha().setActionCommand("mostrar");
        form.getJbFechar().setActionCommand("fechar");
        form.getJbSalvar().setActionCommand("salvar");
    }
    
     public void mostrarSenha() {
        if (form.getJcMostrarSenha().isSelected()) {
            form.getJpSenha().setEchoChar((char)0);
            form.getJpConfirmarsenha().setEchoChar((char)0);
        } else {
            form.getJpSenha().setEchoChar('*');
            form.getJpConfirmarsenha().setEchoChar('*');
        }
    }

    public void limparCampos() {
        form.getJtnome().setText("");
        form.getJtLogin().setText("");
        form.getJtEstado().setText("ACTIVO");
        form.getJpSenha().setText("");
        form.getJpConfirmarsenha().setText("");
        form.getJcAberturaCaixa().setSelected(false);
        form.getJcControleAulas().setSelected(false);
        form.getJcControleCandidato().setSelected(false);
        form.getJcControleEstudante().setSelected(false);
        form.getJcControleFaltas().setSelected(false);
        form.getJcControleFormadores().setSelected(false);
        form.getJcControleNotas().setSelected(false);
        form.getJcControlePeriodo().setSelected(false);
        form.getJcControleUtilizadores().setSelected(false);
        form.getJcCurso().setSelected(false);
        form.getJcEfectuarInscricao().setSelected(false);
        form.getJcEfectuarPagamento().setSelected(false);
        form.getJcLocalizacao().setSelected(false);
        form.getJcMovimentoCaixa().setSelected(false);
        form.getJcRegistarCandidato().setSelected(false);
        form.getJcRegistarFormador().setSelected(false);
        form.getJcRegistarPeriodo().setSelected(false);
        form.getJcRetirarValorCaixa().setSelected(false);
        form.getJcRegistarUtilizador().setSelected(false);
        form.getJcHonorarios().setSelected(false);
        form.getJcInscricoes().setSelected(false);
        form.getJcFechoCaixa().setSelected(false);
    }

    public Utilizador formToUtilizador() {
        Utilizador utilizador = new Utilizador();
        if (form.getJtnome().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o nome!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (form.getJtLogin().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o login!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(form.getJpSenha().getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe a senha!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(form.getJpConfirmarsenha().getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(form, "confirme a senha!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (!form.getJpSenha().getText().matches(form.getJpConfirmarsenha().getText())) {
            JOptionPane.showMessageDialog(form, "O conteudo dos campos 'senha' e 'confirmar senha' nao eh igual!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            utilizador.setNome(form.getJtnome().getText());
            utilizador.setLogin(form.getJtLogin().getText());
            utilizador.setSenha(form.getJpSenha().getText());
            utilizador.setIsdesactivado(false);
            utilizador.setAcessoAberturaCaixa(form.getJcAberturaCaixa().isSelected());
            utilizador.setAcessoRegistarUtilizador(form.getJcRegistarUtilizador().isSelected());
            utilizador.setAcessoCandidato(form.getJcRegistarCandidato().isSelected());
            utilizador.setAcessoCaulas(form.getJcControleAulas().isSelected());
            utilizador.setAcessoCcandidato(form.getJcControleCandidato().isSelected());
            utilizador.setAcessoCestudante(form.getJcControleEstudante().isSelected());
            utilizador.setAcessoCfaltas(form.getJcControleFaltas().isSelected());
            utilizador.setAcessoCformadores(form.getJcControleFormadores().isSelected());
            utilizador.setAcessoCnotas(form.getJcControleNotas().isSelected());
            utilizador.setAcessoCperiodo(form.getJcControlePeriodo().isSelected());
            utilizador.setAcessoCurso(form.getJcCurso().isSelected());
            utilizador.setAcessoCutilizadores(form.getJcControleUtilizadores().isSelected());
            utilizador.setAcessoEfectuarPagamento(form.getJcEfectuarPagamento().isSelected());
            utilizador.setAcessoFormadores(form.getJcRegistarFormador().isSelected());
            utilizador.setAcessoInscricao(form.getJcEfectuarInscricao().isSelected());
            utilizador.setAcessoLocalizacao(form.getJcLocalizacao().isSelected());
            utilizador.setAcessoMovimentoCaixa(form.getJcMovimentoCaixa().isSelected());
            utilizador.setAcessoPeriodo(form.getJcRegistarPeriodo().isSelected());
            utilizador.setAcessoRelatorioHonorario(form.getJcHonorarios().isSelected());
            utilizador.setAcessoRelatorioInscricoes(form.getJcInscricoes().isSelected());
            utilizador.setAcessoFechocaixa(form.getJcFechoCaixa().isSelected());
        }
        return utilizador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("salvar")) {
            entidades.Utilizador util = formToUtilizador();
            if (form.getJtnome().getText() != null && form.getJtLogin().getText() != null && form.getJpSenha().getPassword().length != 0 && form.getJpConfirmarsenha().getPassword().length != 0 && (Arrays.equals(form.getJpSenha().getPassword(), form.getJpConfirmarsenha().getPassword()))) {
                if (new UtilizadorServico().verificarUtilizador(util)) {
                    JOptionPane.showMessageDialog(form, "Este utilizador ja foi cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    new UtilizadorServico().salvar(util);
                    JOptionPane.showMessageDialog(form, "Utilizador registado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                }
            }
        } else if (e.getActionCommand().equals("fechar")) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
            }
        }else if(e.getActionCommand().equals("mostrar")){
            mostrarSenha();
        }
    }
}