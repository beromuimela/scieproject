/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controladora.EditarCandidatoControladora;
import Controladora.EditarUtilizadorControladora;
import Controladora.UtilizadorControladora;
import Servico.UtilizadorServico;
import entidades.Utilizador;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author junito
 */
public class EditarUtilizadorForm extends javax.swing.JDialog {

    private EditarUtilizadorControladora listener;
    private Utilizador util;

    public EditarUtilizadorForm() {
    }

    /**
     * Creates new form Utilizador
     */
    public EditarUtilizadorForm(JDialog parent, boolean modal, Utilizador util) {
        super(parent, modal);
        this.util = util;
        initComponents();
        listener = new EditarUtilizadorControladora(this);
        setLocationRelativeTo(parent);
    }

    public Utilizador getUtil() {
        return util;
    }

    public void setUtil(Utilizador util) {
        this.util = util;
    }

    public JButton getJbFechar() {
        return jbFechar;
    }

    public void setJbFechar(JButton jbFechar) {
        this.jbFechar = jbFechar;
    }

    public JButton getJbSalvar() {
        return jbSalvar;
    }

    public void setJbSalvar(JButton jbSalvar) {
        this.jbSalvar = jbSalvar;
    }

    public JCheckBox getJcAberturaCaixa() {
        return jcAberturaCaixa;
    }

    public void setJcAberturaCaixa(JCheckBox jcAberturaCaixa) {
        this.jcAberturaCaixa = jcAberturaCaixa;
    }

    public JCheckBox getJcFechoCaixa() {
        return jcFechoCaixa;
    }

    public void setJcFechoCaixa(JCheckBox jcFechoCaixa) {
        this.jcFechoCaixa = jcFechoCaixa;
    }

    public JCheckBox getJcActivo() {
        return jcActivo;
    }

    public void setJcActivo(JCheckBox jcActivo) {
        this.jcActivo = jcActivo;
    }

    public JCheckBox getJcControleAulas() {
        return jcControleAulas;
    }

    public void setJcControleAulas(JCheckBox jcControleAulas) {
        this.jcControleAulas = jcControleAulas;
    }

    public JCheckBox getJcControleCandidato() {
        return jcControleCandidato;
    }

    public void setJcControleCandidato(JCheckBox jcControleCandidato) {
        this.jcControleCandidato = jcControleCandidato;
    }

    public JCheckBox getJcControleEstudante() {
        return jcControleEstudante;
    }

    public void setJcControleEstudante(JCheckBox jcControleEstudante) {
        this.jcControleEstudante = jcControleEstudante;
    }

    public JCheckBox getJcHonorarios() {
        return jcHonorarios;
    }

    public void setJcHonorarios(JCheckBox jcHonorarios) {
        this.jcHonorarios = jcHonorarios;
    }

    public JCheckBox getJcInscricoes() {
        return jcInscricoes;
    }

    public void setJcInscricoes(JCheckBox jcInscricoes) {
        this.jcInscricoes = jcInscricoes;
    }

    public JCheckBox getJcControleFaltas() {
        return jcControleFaltas;
    }

    public void setJcControleFaltas(JCheckBox jcControleFaltas) {
        this.jcControleFaltas = jcControleFaltas;
    }

    public JCheckBox getJcControleFormadores() {
        return jcControleFormadores;
    }

    public void setJcControleFormadores(JCheckBox jcControleFormadores) {
        this.jcControleFormadores = jcControleFormadores;
    }

    public JCheckBox getJcControleNotas() {
        return jcControleNotas;
    }

    public void setJcControleNotas(JCheckBox jcControleNotas) {
        this.jcControleNotas = jcControleNotas;
    }

    public JCheckBox getJcControlePeriodo() {
        return jcControlePeriodo;
    }

    public void setJcControlePeriodo(JCheckBox jcControlePeriodo) {
        this.jcControlePeriodo = jcControlePeriodo;
    }

    public JCheckBox getJcControleUtilizadores() {
        return jcControleUtilizadores;
    }

    public void setJcControleUtilizadores(JCheckBox jcControleUtilizadores) {
        this.jcControleUtilizadores = jcControleUtilizadores;
    }

    public JCheckBox getJcCurso() {
        return jcCurso;
    }

    public void setJcCurso(JCheckBox jcCurso) {
        this.jcCurso = jcCurso;
    }

    public JCheckBox getJcEfectuarInscricao() {
        return jcEfectuarInscricao;
    }

    public void setJcEfectuarInscricao(JCheckBox jcEfectuarInscricao) {
        this.jcEfectuarInscricao = jcEfectuarInscricao;
    }

    public JCheckBox getJcEfectuarPagamento() {
        return jcEfectuarPagamento;
    }

    public void setJcEfectuarPagamento(JCheckBox jcEfectuarPagamento) {
        this.jcEfectuarPagamento = jcEfectuarPagamento;
    }

    public JCheckBox getJcInactivo() {
        return jcInactivo;
    }

    public void setJcInactivo(JCheckBox jcInactivo) {
        this.jcInactivo = jcInactivo;
    }

    public JCheckBox getJcLocalizacao() {
        return jcLocalizacao;
    }

    public void setJcLocalizacao(JCheckBox jcLocalizacao) {
        this.jcLocalizacao = jcLocalizacao;
    }

    public JCheckBox getJcMostrarSenha() {
        return jcMostrarSenha;
    }

    public void setJcMostrarSenha(JCheckBox jcMostrarSenha) {
        this.jcMostrarSenha = jcMostrarSenha;
    }

    public JCheckBox getJcMovimentoCaixa() {
        return jcMovimentoCaixa;
    }

    public void setJcMovimentoCaixa(JCheckBox jcMovimentoCaixa) {
        this.jcMovimentoCaixa = jcMovimentoCaixa;
    }

    public JCheckBox getJcRegistarCandidato() {
        return jcRegistarCandidato;
    }

    public void setJcRegistarCandidato(JCheckBox jcRegistarCandidato) {
        this.jcRegistarCandidato = jcRegistarCandidato;
    }

    public JCheckBox getJcRegistarFormador() {
        return jcRegistarFormador;
    }

    public void setJcRegistarFormador(JCheckBox jcRegistarFormador) {
        this.jcRegistarFormador = jcRegistarFormador;
    }

    public JCheckBox getJcRegistarPeriodo() {
        return jcRegistarPeriodo;
    }

    public void setJcRegistarPeriodo(JCheckBox jcRegistarPeriodo) {
        this.jcRegistarPeriodo = jcRegistarPeriodo;
    }

    public JCheckBox getJcRegistarUtilizador() {
        return jcRegistarUtilizador;
    }

    public void setJcRegistarUtilizador(JCheckBox jcRegistarUtilizador) {
        this.jcRegistarUtilizador = jcRegistarUtilizador;
    }

    public JCheckBox getJcRetirarValorCaixa() {
        return jcRetirarValorCaixa;
    }

    public void setJcRetirarValorCaixa(JCheckBox jcRetirarValorCaixa) {
        this.jcRetirarValorCaixa = jcRetirarValorCaixa;
    }

    public JPasswordField getJpConfirmarsenha() {
        return jpConfirmarsenha;
    }

    public void setJpConfirmarsenha(JPasswordField jpConfirmarsenha) {
        this.jpConfirmarsenha = jpConfirmarsenha;
    }

    public JPasswordField getJpSenha() {
        return jpSenha;
    }

    public void setJpSenha(JPasswordField jpSenha) {
        this.jpSenha = jpSenha;
    }

    public JTextField getJtLogin() {
        return jtLogin;
    }

    public void setJtLogin(JTextField jtLogin) {
        this.jtLogin = jtLogin;
    }

    public JTextField getJtnome() {
        return jtnome;
    }

    public void setJtnome(JTextField jtnome) {
        this.jtnome = jtnome;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtnome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jpConfirmarsenha = new javax.swing.JPasswordField();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcMostrarSenha = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jcActivo = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jcInactivo = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcRegistarCandidato = new javax.swing.JCheckBox();
        jcEfectuarInscricao = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jcLocalizacao = new javax.swing.JCheckBox();
        jcRegistarFormador = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jcControleCandidato = new javax.swing.JCheckBox();
        jcControleEstudante = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcControleAulas = new javax.swing.JCheckBox();
        jcControleFaltas = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcControleNotas = new javax.swing.JCheckBox();
        jcControleFormadores = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jcAberturaCaixa = new javax.swing.JCheckBox();
        jcMovimentoCaixa = new javax.swing.JCheckBox();
        jcRetirarValorCaixa = new javax.swing.JCheckBox();
        jcEfectuarPagamento = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jcFechoCaixa = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jcInscricoes = new javax.swing.JCheckBox();
        jcHonorarios = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jcControleUtilizadores = new javax.swing.JCheckBox();
        jcControlePeriodo = new javax.swing.JCheckBox();
        jcRegistarUtilizador = new javax.swing.JCheckBox();
        jcRegistarPeriodo = new javax.swing.JCheckBox();
        jcCurso = new javax.swing.JCheckBox();
        jbFechar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Nome");

        jLabel2.setText("Login");

        jLabel3.setText("Senha");

        jLabel4.setText("Confirmar Senha");

        jLabel26.setText("ESTADO");

        jLabel14.setText("Mostrar senha");

        jcMostrarSenha.setText(".");

        jLabel15.setText("Activar");

        jLabel17.setText("Inactivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtnome, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jpSenha)
                                    .addComponent(jpConfirmarsenha)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcMostrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcInactivo)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpConfirmarsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcMostrarSenha)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcActivo)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcInactivo)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("UTILIZADOR", jPanel2);

        jLabel5.setText("Registar novo candidato");

        jcRegistarCandidato.setText(".");

        jcEfectuarInscricao.setText(".");

        jLabel6.setText("Efectuar inscricao");

        jLabel12.setText("Registar novo Formador");

        jLabel22.setText("Localizacao");

        jcLocalizacao.setText(".");

        jcRegistarFormador.setText(".");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel22)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcRegistarFormador, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcLocalizacao, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jcEfectuarInscricao, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcRegistarCandidato))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcRegistarCandidato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcEfectuarInscricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jcRegistarFormador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jcLocalizacao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Arquivo", jPanel4);

        jLabel8.setText("Controlo de candidatos");

        jcControleCandidato.setText(".");

        jcControleEstudante.setText(".");

        jLabel7.setText("Controlo de estudantes");

        jLabel9.setText("Controlo de aulas");

        jcControleAulas.setText(".");

        jcControleFaltas.setText(".");

        jLabel10.setText("Controlo de faltas");

        jLabel11.setText("Controlo de notas");

        jcControleNotas.setText(".");

        jcControleFormadores.setText(".");

        jLabel13.setText("Controlo de Formadores");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcControleNotas))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(jcControleFormadores))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcControleFaltas))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcControleEstudante))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcControleAulas))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcControleCandidato)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcControleCandidato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcControleEstudante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcControleAulas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcControleFaltas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jcControleNotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcControleFormadores))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Controlo", jPanel5);

        jLabel16.setText("Efectuar Pagamento");

        jLabel25.setText("Retirar valor do caixa");

        jLabel21.setText("Movimento de caixa");

        jLabel19.setText("Abertura de caixa");

        jcAberturaCaixa.setText(".");

        jcMovimentoCaixa.setText(".");

        jcRetirarValorCaixa.setText(".");

        jcEfectuarPagamento.setText(".");

        jLabel24.setText("Fecho de caixa");

        jcFechoCaixa.setText(".");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addComponent(jLabel25)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcEfectuarPagamento)
                                .addComponent(jcRetirarValorCaixa)
                                .addComponent(jcAberturaCaixa, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jcMovimentoCaixa)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcFechoCaixa)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jcEfectuarPagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jcRetirarValorCaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jcMovimentoCaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jcAberturaCaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jcFechoCaixa))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Caixa", jPanel6);

        jLabel20.setText("Honorarios");

        jLabel23.setText("Inscricoes");

        jcInscricoes.setText(".");

        jcHonorarios.setText(".");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcHonorarios)
                    .addComponent(jcInscricoes))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jcHonorarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcInscricoes))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Relatorios", jPanel7);

        jLabel18.setText("Curso");

        jLabel30.setText("Registar Periodo");

        jLabel31.setText("Registar novo utilizador");

        jLabel32.setText("Controlo de Periodo");

        jLabel33.setText("Controlo de Utilizadores");

        jcControleUtilizadores.setText(".");

        jcControlePeriodo.setText(".");

        jcRegistarUtilizador.setText(".");

        jcRegistarPeriodo.setText(".");

        jcCurso.setText(".");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcRegistarPeriodo)
                    .addComponent(jcCurso)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcControlePeriodo)
                            .addComponent(jcRegistarUtilizador)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jcControleUtilizadores)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jcCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jcRegistarPeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jcRegistarUtilizador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jcControlePeriodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jcControleUtilizadores))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Avancados", jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ACESSOS", jPanel3);

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/remover.png"))); // NOI18N
        jbFechar.setText("Fechar");

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ok.png"))); // NOI18N
        jbSalvar.setText("Salvar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFechar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFechar)
                    .addComponent(jbSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarUtilizadorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarUtilizadorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarUtilizadorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarUtilizadorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarUtilizadorForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JCheckBox jcAberturaCaixa;
    private javax.swing.JCheckBox jcActivo;
    private javax.swing.JCheckBox jcControleAulas;
    private javax.swing.JCheckBox jcControleCandidato;
    private javax.swing.JCheckBox jcControleEstudante;
    private javax.swing.JCheckBox jcControleFaltas;
    private javax.swing.JCheckBox jcControleFormadores;
    private javax.swing.JCheckBox jcControleNotas;
    private javax.swing.JCheckBox jcControlePeriodo;
    private javax.swing.JCheckBox jcControleUtilizadores;
    private javax.swing.JCheckBox jcCurso;
    private javax.swing.JCheckBox jcEfectuarInscricao;
    private javax.swing.JCheckBox jcEfectuarPagamento;
    private javax.swing.JCheckBox jcFechoCaixa;
    private javax.swing.JCheckBox jcHonorarios;
    private javax.swing.JCheckBox jcInactivo;
    private javax.swing.JCheckBox jcInscricoes;
    private javax.swing.JCheckBox jcLocalizacao;
    private javax.swing.JCheckBox jcMostrarSenha;
    private javax.swing.JCheckBox jcMovimentoCaixa;
    private javax.swing.JCheckBox jcRegistarCandidato;
    private javax.swing.JCheckBox jcRegistarFormador;
    private javax.swing.JCheckBox jcRegistarPeriodo;
    private javax.swing.JCheckBox jcRegistarUtilizador;
    private javax.swing.JCheckBox jcRetirarValorCaixa;
    private javax.swing.JPasswordField jpConfirmarsenha;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtLogin;
    private javax.swing.JTextField jtnome;
    // End of variables declaration//GEN-END:variables
}
