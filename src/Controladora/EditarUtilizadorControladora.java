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
import vista.EditarUtilizadorForm;

/**
 *
 * @author junito
 */
public class EditarUtilizadorControladora implements ActionListener {

    private EditarUtilizadorForm form;
    private UtilizadorServico servico;

    public EditarUtilizadorControladora(EditarUtilizadorForm form) {
        this.form = form;
        this.servico=new UtilizadorServico();
        adicionarListener();
        UtilizadorToFormulario();
    }

    public final void adicionarListener() {
        form.getJbFechar().addActionListener(this);
        form.getJbSalvar().addActionListener(this);
        form.getJcMostrarSenha().addActionListener(this);
        form.getJcInactivo().addActionListener(this);
        form.getJcActivo().addActionListener(this);
        form.getJcInactivo().setActionCommand("inactivo");
        form.getJcActivo().setActionCommand("activo");
        form.getJcMostrarSenha().setActionCommand("mostrar");
        form.getJbSalvar().setActionCommand("salvar");
        form.getJbFechar().setActionCommand("fechar");
    }

    public void estado(boolean estado) {
        if (estado == true) {
            form.getJcInactivo().setSelected(true);
        } else {
            form.getJcActivo().setSelected(true);
        }
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
        } else if (form.getJcActivo().isSelected() == false && form.getJcInactivo().isSelected() == false) {
            JOptionPane.showMessageDialog(form, "Seleccione um estado!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            utilizador.setIdutilizador(form.getUtil().getIdutilizador());
            utilizador.setNome(form.getJtnome().getText());
            utilizador.setLogin(form.getJtLogin().getText());
            utilizador.setSenha(form.getJpSenha().getText());
           
            if (form.getJcActivo().isSelected()) {
                utilizador.setIsdesactivado(false);
            }else if(form.getJcInactivo().isSelected()){
                utilizador.setIsdesactivado(true);
            }
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
            utilizador.setAcessoRetirarValor(form.getJcRetirarValorCaixa().isSelected());
            utilizador.setAcessoRelatorioHonorario(form.getJcHonorarios().isSelected());
            utilizador.setAcessoRelatorioInscricoes(form.getJcInscricoes().isSelected());
            utilizador.setAcessoFechocaixa(form.getJcFechoCaixa().isSelected());
        }
        return utilizador;
    }

    public final void UtilizadorToFormulario() {
        form.getJtnome().setText(form.getUtil().getNome());
        form.getJtLogin().setText(form.getUtil().getLogin());
        estado(form.getUtil().isIsdesactivado());
        form.getJpSenha().setText(form.getUtil().getSenha());
        form.getJpConfirmarsenha().setText(form.getUtil().getSenha());
        form.getJcAberturaCaixa().setSelected(form.getUtil().isAcessoAberturaCaixa());
        form.getJcControleAulas().setSelected(form.getUtil().isAcessoCaulas());
        form.getJcControleCandidato().setSelected(form.getUtil().isAcessoCcandidato());
        form.getJcControleEstudante().setSelected(form.getUtil().isAcessoCestudante());
        form.getJcControleFaltas().setSelected(form.getUtil().isAcessoCfaltas());
        form.getJcControleFormadores().setSelected(form.getUtil().isAcessoCformadores());
        form.getJcControleNotas().setSelected(form.getUtil().isAcessoCnotas());
        form.getJcControlePeriodo().setSelected(form.getUtil().isAcessoCperiodo());
        form.getJcCurso().setSelected(form.getUtil().isAcessoCurso());
        form.getJcEfectuarInscricao().setSelected(form.getUtil().isAcessoInscricao());
        form.getJcEfectuarPagamento().setSelected(form.getUtil().isAcessoEfectuarPagamento());
        form.getJcLocalizacao().setSelected(form.getUtil().isAcessoLocalizacao());
        form.getJcMovimentoCaixa().setSelected(form.getUtil().isAcessoMovimentoCaixa());
        form.getJcRegistarCandidato().setSelected(form.getUtil().isAcessoCandidato());
        form.getJcRegistarFormador().setSelected(form.getUtil().isAcessoFormadores());
        form.getJcRegistarPeriodo().setSelected(form.getUtil().isAcessoPeriodo());
        form.getJcRegistarUtilizador().setSelected(form.getUtil().isAcessoRegistarUtilizador());
        form.getJcControleUtilizadores().setSelected(form.getUtil().isAcessoCutilizadores());
        form.getJcRetirarValorCaixa().setSelected(form.getUtil().isAcessoRetirarValor());
        form.getJcHonorarios().setSelected(form.getUtil().isAcessoRelatorioHonorario());
        form.getJcInscricoes().setSelected(form.getUtil().isAcessoRelatorioInscricoes());
        form.getJcFechoCaixa().setSelected(form.getUtil().isAcessoFechocaixa());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "fechar":
                if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a janela?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "salvar":
                Utilizador util = formToUtilizador();
                if (form.getJtnome().getText() != null && form.getJtLogin().getText() != null && form.getJpSenha().getPassword().length != 0 && form.getJpConfirmarsenha().getPassword().length != 0 && (Arrays.equals(form.getJpSenha().getPassword(), form.getJpConfirmarsenha().getPassword()))&&(form.getJcActivo().isSelected()!=false||form.getJcInactivo().isSelected()!=false)) {
                    servico.editar(util);
                    JOptionPane.showMessageDialog(form, "Utilizador actualizado com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "mostrar":
                mostrarSenha();
                break;
            case "activo":
                if(form.getJcActivo().isSelected()){
                    form.getJcInactivo().setSelected(false);
                }
                break;
            case "inactivo":
                if(form.getJcInactivo().isSelected()){
                    form.getJcActivo().setSelected(false);
                }
                break;
            default:
                break;
        }
    }
}
