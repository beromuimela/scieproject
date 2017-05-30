/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CaixaServico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.CaixaForm;

/**
 *
 * @author junito
 */
public final class CaixaControladora implements ActionListener{
    private CaixaForm form;

    public CaixaControladora(CaixaForm form) {
        this.form = form;
        adicionarListener();
        form.getUtilizador().setText(form.getUtil().getNome());
        activarSpinner(form.getJcModo().getSelectedIndex());
    }
    
    public void adicionarListener(){
        form.getJcModo().addActionListener(this);
        form.getFechar().addActionListener(this);
        form.getAbrir().addActionListener(this);
        form.getFechar().setActionCommand("fechar");
        form.getAbrir().setActionCommand("abrir");
        form.getJcModo().setActionCommand("modo");
    }    
    
    public entidades.Caixa formToCaixa(){
        entidades.Caixa caixa=new entidades.Caixa();
        caixa.setAbertura(Float.valueOf(form.getJsValor().getValue().toString()));
        caixa.setUtilizador(form.getUtil());
        return caixa;
    }
    
    public void activarSpinner(int selecionado){
        if(selecionado==0)
            form.getJsValor().setEnabled(false);
        else
            form.getJsValor().setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "modo":
                activarSpinner(form.getJcModo().getSelectedIndex());
                break;
            case "fechar":
                if( JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar esta janela?","Confirmar",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    form.dispose();
                }    break;
            case "abrir":
                entidades.Caixa caixa=formToCaixa();
                new CaixaServico().abrirCaixa(caixa);
                form.dispose();
                break;
            default:
                break;
        }
    }
    
}
