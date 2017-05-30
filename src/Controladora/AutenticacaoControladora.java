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
import javax.swing.JOptionPane;
import vista.Autenticacao;
import vista.Principal;

/**
 *
 * @author junito
 */
public class AutenticacaoControladora implements ActionListener {

    private Autenticacao form;

    public AutenticacaoControladora(Autenticacao form) {
        this.form = form;
        adicionarListener();
    }

    public final void adicionarListener() {
        form.getJbFehar().addActionListener(this);
        form.getjBok().addActionListener(this);

        form.getJbFehar().setActionCommand("fechar");
        form.getjBok().setActionCommand("ok");

    }

    public void limparCampos(){
        form.getJtLogin().setText("");
        form.getJpSenha().setText("");
    }
    
    public Utilizador formToUtilizador() {
        Utilizador util = new Utilizador();
        if (form.getJtLogin().getText().isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe o Login!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else if (String.valueOf(form.getJpSenha().getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(form, "Informe a Senha!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            util.setLogin(form.getJtLogin().getText());
            util.setSenha(form.getJpSenha().getText());
        }
        return util;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ok")){
            Utilizador util=formToUtilizador();
            if(form.getJtLogin().getText()!=null && form.getJpSenha().getPassword().length!=0){
                if(new UtilizadorServico().verificarUtilizador(util)){
                    Utilizador novo=new UtilizadorServico().ObterUtilizador(util);
                    new Principal(novo).setVisible(true);
                    form.dispose();
                }else{
                    JOptionPane.showMessageDialog(form, "Utilizador nao encontrado!","Erro",JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                }
            }
        }else if(e.getActionCommand().equals("fechar")){
            if(JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar a aplicacao?","Confirmar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                form.dispose();
            }
        }
    }

}
