/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Servico.CaixaServico;
import entidades.Caixa;
import entidades.Utilizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import vista.AulasForm;
import vista.Autenticacao;
import vista.CaixaForm;
import vista.ControleCandidatos;
import vista.ControleEstudantes;
import vista.ControleFormadores;
import vista.ControlePeriodo;
import vista.ControleUtilizadores;
import vista.CursoForm;
import vista.FecharCaixa;
import vista.FormadorForm;
import vista.Honorarios;
import vista.InscricaoForm;
import vista.Localizacao;
import vista.MovimentosForm;
import vista.NovoCandidato;
import vista.PeriodoForm;
import vista.Principal;
import vista.RelatorioInscricoes;

/**
 *
 * @author junito
 */
public class PrincipalControladora implements ActionListener, MouseListener {

    private Principal form;
    private CaixaServico caixaServico = new CaixaServico();
    private RelatorioInscricoes relatorios;
    private Honorarios honorarios;

    public PrincipalControladora(Principal form) {
        this.form = form;
        form.getJmutil().setText(form.getUtil().getNome());
        adicionarListener();
        acesso(form.getUtil());
    }

    public void mostrarHoras() {
    }

    public final void adicionarListener() {
        form.getNovoCandidato().addActionListener(this);
        form.getNovoUtilizador().addActionListener(this);
        form.getSair().addActionListener(this);
        form.getJmFecharCaixa().addActionListener(this);
        form.getControleCandidatos().addActionListener(this);
        form.getAbrirCaixa().addActionListener(this);
        form.getjLencerrarSessao().addMouseListener(this);
        form.getLocalizacao().addActionListener(this);
        form.getjMovimentos().addActionListener(this);
        form.getJmControleUtilizadores().addActionListener(this);
        form.getJmFormador().addActionListener(this);
        form.getJmControleFormadores().addActionListener(this);
        form.getJmPeriodo().addActionListener(this);
        form.getJmCntrlPeriodo().addActionListener(this);
        form.getJmAulas().addActionListener(this);
        form.getJmInscricao().addActionListener(this);
        form.getJmEstudantes().addActionListener(this);
        form.getJmRelatorioInscricoes().addActionListener(this);
        form.getJmHonorarios().addActionListener(this);
        form.getJmCurso().addActionListener(this);
        form.getJmCurso().setActionCommand("curso");
        form.getJmHonorarios().setActionCommand("honorarios");
        form.getJmFecharCaixa().setActionCommand("fecharcaixa");
        form.getJmCntrlPeriodo().setActionCommand("ctrlperiodo");
        form.getJmRelatorioInscricoes().setActionCommand("relatorioinscricoes");
        form.getJmAulas().setActionCommand("aulas");
        form.getJmEstudantes().setActionCommand("ctrlEstudantes");
        form.getJmInscricao().setActionCommand("inscricao");
        form.getJmPeriodo().setActionCommand("periodo");
        form.getJmControleUtilizadores().setActionCommand("ctrlutilizadores");
        form.getJmFormador().setActionCommand("formador");
        form.getJmControleFormadores().setActionCommand("ctrlformador");
        form.getNovoCandidato().setActionCommand("candidato");
        form.getSair().setActionCommand("sair");
        form.getControleCandidatos().setActionCommand("controleCandidatos");
        form.getAbrirCaixa().setActionCommand("abrirCaixa");
        form.getLocalizacao().setActionCommand("localizacao");
        form.getNovoUtilizador().setActionCommand("utilizador");
        form.getjMovimentos().setActionCommand("movimento");
    }

    public final void acesso(Utilizador util) {
        /*
        Arquivo
         */
        int arquivo = 4;
        if (util.isAcessoCandidato()) {
            form.getNovoCandidato().setVisible(true);
        } else {
            form.getNovoCandidato().setVisible(false);
            arquivo--;
        }
        if (util.isAcessoInscricao()) {
            form.getJmInscricao().setVisible(true);
        } else {
            form.getJmInscricao().setVisible(false);
            arquivo--;
        }
        if (util.isAcessoFormadores()) {
            form.getJmFormador().setVisible(true);
        } else {
            form.getJmFormador().setVisible(false);
            arquivo--;
        }
        if (util.isAcessoLocalizacao()) {
            form.getLocalizacao().setVisible(true);
        } else {
            form.getLocalizacao().setVisible(false);
            arquivo--;
        }
        if (arquivo == 0) {
            form.getjMArquivo().setVisible(false);
        }
        /*
        Controlo
         */
        int controlo = 4;
        if (util.isAcessoCcandidato()) {
            form.getControleCandidatos().setVisible(true);
        } else {
            form.getControleCandidatos().setVisible(false);
            controlo--;
        }
        if (util.isAcessoCestudante()) {
            form.getJmEstudantes().setVisible(true);
        } else {
            form.getJmEstudantes().setVisible(false);
            controlo--;
        }
        if (util.isAcessoCaulas()) {
            form.getJmAulas().setVisible(true);
        } else {
            form.getJmAulas().setVisible(false);
            controlo--;
        }
        if (util.isAcessoCformadores()) {
            form.getJmControleFormadores().setVisible(true);
        } else {
            form.getJmControleFormadores().setVisible(false);
            controlo--;
        }
        if (controlo == 0) {
            form.getJMControlo().setVisible(false);
        }
        /*
        Caixa
         */
        int caixa = 3;
        if (util.isAcessoAberturaCaixa()) {
            form.getAbrirCaixa().setVisible(true);
        } else {
            form.getAbrirCaixa().setVisible(false);
            caixa--;
        }
        if (util.isAcessoMovimentoCaixa()) {
            form.getjMovimentos().setVisible(true);
        } else {
            form.getjMovimentos().setVisible(false);
            caixa--;
        }
        if (util.isAcessoFechocaixa()) {
            form.getJmFecharCaixa().setVisible(true);
        } else {
            form.getJmFecharCaixa().setVisible(false);
            caixa--;
        }
        if (caixa == 0) {
            form.getJMCaixa().setVisible(false);
        }
        /*
        Confiiguracoes
         */
        int configuracoes = 5;
        if (util.isAcessoRegistarUtilizador()) {
            form.getNovoUtilizador().setEnabled(true);
        } else {
            form.getNovoUtilizador().setVisible(false);
            configuracoes--;
        }
        if(util.isAcessoCurso()){
            form.getJmCurso().setVisible(true);
        }else{
            form.getJmCurso().setVisible(false);
            configuracoes--;
        }
        if (util.isAcessoCutilizadores()) {
            form.getJmControleUtilizadores().setVisible(true);
        } else {
            form.getJmControleUtilizadores().setVisible(false);
            configuracoes--;
        }
        if (util.isAcessoCperiodo()) {
            form.getJmCntrlPeriodo().setVisible(true);
        } else {
            form.getJmCntrlPeriodo().setVisible(false);
            configuracoes--;
        }
        if (util.isAcessoPeriodo()) {
            form.getJmPeriodo().setVisible(true);
        } else {
            form.getJmPeriodo().setVisible(false);
            configuracoes--;
        }
        if (configuracoes == 0) {
            form.getJMConfiguracoes().setVisible(false);
        }
        /*
        Relatorio
         */
        int relatorio = 2;
        if (util.isAcessoRelatorioHonorario()) {
            form.getJmHonorarios().setVisible(true);
        } else {
            form.getJmHonorarios().setVisible(false);
            relatorio--;
        }
        if (util.isAcessoRelatorioInscricoes()) {
            form.getJmRelatorioInscricoes().setVisible(true);
        } else {
            form.getJmRelatorioInscricoes().setVisible(false);
            relatorio--;
        }
        if (relatorio == 0) {
            form.getJMRelatorios().setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "candidato":
                NovoCandidato cand = new NovoCandidato(form, true);
                cand.setVisible(true);
                break;
            case "sair":
                if (JOptionPane.showConfirmDialog(form, "Pretende fechar a aplicacao?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    form.dispose();
                }
                break;
            case "controleCandidatos":
                new ControleCandidatos(form, true,form.getUtil()).setVisible(true);
                break;
            case "abrirCaixa":
                Caixa ultimoCaixa = caixaServico.ultimoCaixa();
                if (caixaServico.isHoje(ultimoCaixa.getDatacaixa())) {
                    if (ultimoCaixa.isAberto()) {
                        JOptionPane.showMessageDialog(null, "O caixa se encontra aberto!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        new CaixaForm(form, true, form.getUtil()).setVisible(true);
                    }
                } else {
                    new CaixaForm(form, true, form.getUtil()).setVisible(true);
                }
                break;
            case "localizacao":
                new Localizacao(form, true).setVisible(true);
                break;
            case "utilizador":
                new vista.UtilizadorForm(form, true).setVisible(true);
                break;
            case "movimento":
                if (new CaixaServico().isAberto()) {
                    new MovimentosForm(form, true, form.getUtil()).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(form, "O caixa nao esta aberto!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "ctrlutilizadores":
                new ControleUtilizadores(form, true,form.getUtil()).setVisible(true);
                break;
            case "formador":
                new FormadorForm(form, true).setVisible(true);
                break;
            case "ctrlformador":
                new ControleFormadores(form, true,form.getUtil()).setVisible(true);
                break;
            case "periodo":
                new PeriodoForm(form, true).setVisible(true);
                break;
            case "aulas":
                new AulasForm(form, true).setVisible(true);
                break;
            case "inscricao":
                new InscricaoForm(form, true, form.getUtil()).setVisible(true);
                break;
            case "ctrlEstudantes":
                new ControleEstudantes(form, true,form.getUtil()).setVisible(true);
                break;
            case "relatorioinscricoes":
                this.relatorios = new RelatorioInscricoes(form, form.getjDesktopPane1(), form.getUtil(), true);
                relatorios.setVisible(true);
                break;
            case "honorarios":
                this.honorarios = new Honorarios(form, form.getjDesktopPane1(), form.getUtil(), true);
                honorarios.setVisible(true);
                break;
            case "ctrlperiodo":
                new ControlePeriodo(form, true).setVisible(true);
                break;
            case "fecharcaixa":
                if (new CaixaServico().isAberto()) {
                    if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende fechar o caixa?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        ultimoCaixa = caixaServico.ultimoCaixa();
                        caixaServico.FecharCaixa(ultimoCaixa);
                        new FecharCaixa(form, true, ultimoCaixa).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Nao tem um caixa aberto!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "curso":
                new CursoForm(form, true, form.getUtil()).setVisible(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(form.getjLencerrarSessao())) {
            if (JOptionPane.showConfirmDialog(form, "Tem a certeza que pretende terminar a sessao?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                form.dispose();
                new Autenticacao().setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(form.getjLencerrarSessao())) {
            form.getjLencerrarSessao().setComponentPopupMenu(new JPopupMenu("Encerrar Sessao"));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
