/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controladora.PrincipalControladora;
import entidades.Utilizador;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author junito
 */
public class Principal extends javax.swing.JFrame {

    private PrincipalControladora listener;
    private entidades.Utilizador util;

    /**
     * Creates new form Principal
     */
    public Principal(entidades.Utilizador util) {
        initComponents();
        this.util = util;
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        listener = new PrincipalControladora(this);
        //modificar pelo icone da gajm
        URL url = getClass().getResource("/icones/gajm.jpg");
        URL url2 = getClass().getResource("/icones/gajmdesktop2.png");
        ImageIcon icon = new ImageIcon(url);
        ImageIcon icon2 = new ImageIcon(url2);
        setIconImage(icon.getImage());

        int alt = jDesktopPane1.getSize().height;
        int larg = jDesktopPane1.getSize().width;
        int altura = (int) alt;
        int largura = (int) larg;
        JLabel lab = new JLabel();
        lab.setBounds(250, 0, largura, altura);
//        lab.setBounds(0, 0, largura, altura);

//        icon2.setImage(icon.getImage().getScaledInstance(lab.getWidth(), lab.getHeight(),100 ));
        lab.setIcon(icon2);
        jDesktopPane1.add(lab);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

    }

    public Principal() {
    }

    public JMenuItem getJmRelatorioInscricoes() {
        return JmRelatorioInscricoes;
    }

    public JMenuItem getJmFecharCaixa() {
        return jmFecharCaixa;
    }

    public void setJmFecharCaixa(JMenuItem jmFecharCaixa) {
        this.jmFecharCaixa = jmFecharCaixa;
    }

    public void setJmRelatorioInscricoes(JMenuItem JmRelatorioInscricoes) {
        this.JmRelatorioInscricoes = JmRelatorioInscricoes;
    }

    public JMenuItem getJmHonorarios() {
        return jmHonorarios;
    }

    public void setJmHonorarios(JMenuItem jmHonorarios) {
        this.jmHonorarios = jmHonorarios;
    }

    public JMenu getJMCaixa() {
        return JMCaixa;
    }

    public void setJMCaixa(JMenu JMCaixa) {
        this.JMCaixa = JMCaixa;
    }

    public JMenuItem getJmCurso() {
        return jmCurso;
    }

    public void setJmCurso(JMenuItem jmCurso) {
        this.jmCurso = jmCurso;
    }

    public JMenu getJMConfiguracoes() {
        return JMConfiguracoes;
    }

    public void setJMConfiguracoes(JMenu JMConfiguracoes) {
        this.JMConfiguracoes = JMConfiguracoes;
    }

    public JMenu getJMControlo() {
        return JMControlo;
    }

    public void setJMControlo(JMenu JMControlo) {
        this.JMControlo = JMControlo;
    }

    public JMenu getJMRelatorios() {
        return JMRelatorios;
    }

    public void setJMRelatorios(JMenu JMRelatorios) {
        this.JMRelatorios = JMRelatorios;
    }

    public JMenu getjMArquivo() {
        return jMArquivo;
    }

    public void setjMArquivo(JMenu jMArquivo) {
        this.jMArquivo = jMArquivo;
    }

    public JLabel getjLencerrarSessao() {
        return jLencerrarSessao;
    }

    public void setjLencerrarSessao(JLabel jLencerrarSessao) {
        this.jLencerrarSessao = jLencerrarSessao;
    }

    public JLabel getJmutil() {
        return jmutil;
    }

    public void setJmutil(JLabel jmutil) {
        this.jmutil = jmutil;
    }

    public JMenuItem getJmInscricao() {
        return jmInscricao;
    }

    public JMenu getjMenu6() {
        return jMenu6;
    }

    public void setjMenu6(JMenu jMenu6) {
        this.jMenu6 = jMenu6;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public void setJmInscricao(JMenuItem jmInscricao) {
        this.jmInscricao = jmInscricao;
    }

    public JMenuItem getJmControleUtilizadores() {
        return jmControleUtilizadores;
    }

    public void setJmControleUtilizadores(JMenuItem jmControleUtilizadores) {
        this.jmControleUtilizadores = jmControleUtilizadores;
    }

    public Utilizador getUtil() {
        return util;
    }

    public JMenuItem getJmFormador() {
        return jmFormador;
    }

    public void setJmFormador(JMenuItem jmFormador) {
        this.jmFormador = jmFormador;
    }

    public JMenuItem getJmAulas() {
        return jmAulas;
    }

    public void setJmAulas(JMenuItem jmAulas) {
        this.jmAulas = jmAulas;
    }

    public JMenuItem getJmControleFormadores() {
        return jmControleFormadores;
    }

    public void setJmControleFormadores(JMenuItem jmControleFormadores) {
        this.jmControleFormadores = jmControleFormadores;
    }

    public JMenuItem getjMovimentos() {
        return jMovimentos;
    }

    public void setjMovimentos(JMenuItem jMovimentos) {
        this.jMovimentos = jMovimentos;
    }

    public void setUtil(Utilizador util) {
        this.util = util;
    }

    public JMenuItem getNovoUtilizador() {
        return novoUtilizador;
    }

    public void setNovoUtilizador(JMenuItem novoUtilizador) {
        this.novoUtilizador = novoUtilizador;
    }

    public JMenuItem getAbrirCaixa() {
        return AbrirCaixa;
    }

    public void setAbrirCaixa(JMenuItem AbrirCaixa) {
        this.AbrirCaixa = AbrirCaixa;
    }

    public JMenuItem getNovoCandidato() {
        return novoCandidato;
    }

    public JMenuItem getJmEstudantes() {
        return jmEstudantes;
    }

    public void setJmEstudantes(JMenuItem jmEstudantes) {
        this.jmEstudantes = jmEstudantes;
    }

    public JMenuItem getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(JMenuItem localizacao) {
        this.localizacao = localizacao;
    }

    public void setNovoCandidato(JMenuItem novoCandidato) {
        this.novoCandidato = novoCandidato;
    }

    public JMenuItem getSair() {
        return sair;
    }

    public JMenuItem getControleCandidatos() {
        return controleCandidatos;
    }

    public void setControleCandidatos(JMenuItem controleCandidatos) {
        this.controleCandidatos = controleCandidatos;
    }

    public void setSair(JMenuItem sair) {
        this.sair = sair;
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public JMenuItem getJmPeriodo() {
        return jmPeriodo;
    }

    public void setJmPeriodo(JMenuItem jmPeriodo) {
        this.jmPeriodo = jmPeriodo;
    }

    public JMenuItem getJmCntrlPeriodo() {
        return jmCntrlPeriodo;
    }

    public void setJmCntrlPeriodo(JMenuItem jmCntrlPeriodo) {
        this.jmCntrlPeriodo = jmCntrlPeriodo;
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
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jmutil = new javax.swing.JLabel();
        jLencerrarSessao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMArquivo = new javax.swing.JMenu();
        novoCandidato = new javax.swing.JMenuItem();
        jmFormador = new javax.swing.JMenuItem();
        localizacao = new javax.swing.JMenuItem();
        jmInscricao = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        sair = new javax.swing.JMenuItem();
        JMControlo = new javax.swing.JMenu();
        controleCandidatos = new javax.swing.JMenuItem();
        jmEstudantes = new javax.swing.JMenuItem();
        jmControleFormadores = new javax.swing.JMenuItem();
        jmAulas = new javax.swing.JMenuItem();
        JMCaixa = new javax.swing.JMenu();
        AbrirCaixa = new javax.swing.JMenuItem();
        jMovimentos = new javax.swing.JMenuItem();
        jmFecharCaixa = new javax.swing.JMenuItem();
        JMRelatorios = new javax.swing.JMenu();
        jmHonorarios = new javax.swing.JMenuItem();
        JmRelatorioInscricoes = new javax.swing.JMenuItem();
        JMConfiguracoes = new javax.swing.JMenu();
        novoUtilizador = new javax.swing.JMenuItem();
        jmControleUtilizadores = new javax.swing.JMenuItem();
        jmPeriodo = new javax.swing.JMenuItem();
        jmCntrlPeriodo = new javax.swing.JMenuItem();
        jmCurso = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCIE - SISTEMA DE CONTROLE DE INSCRICAO DE ESTUDANTES");

        jDesktopPane1.setBackground(new java.awt.Color(0, 51, 204));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        jDesktopPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jmutil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jmutil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/userAute.png"))); // NOI18N
        jmutil.setToolTipText("Utilizador");
        jmutil.setEnabled(false);
        jmutil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLencerrarSessao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        jLencerrarSessao.setToolTipText("Encerrar Sessao");
        jLencerrarSessao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1346, Short.MAX_VALUE)
                .addComponent(jmutil, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLencerrarSessao))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLencerrarSessao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jmutil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jMenuBar1.setAlignmentY(0.5F);

        jMArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/home.png"))); // NOI18N
        jMArquivo.setText("Arquivo");
        jMArquivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMArquivo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMArquivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMArquivo.setMargin(new java.awt.Insets(0, 0, 0, 50));
        jMArquivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        novoCandidato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        novoCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novocandidato.png"))); // NOI18N
        novoCandidato.setText("Novo Candidato");
        jMArquivo.add(novoCandidato);

        jmFormador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmFormador.setText("Novo Formador");
        jMArquivo.add(jmFormador);

        localizacao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        localizacao.setText("Localizacao");
        jMArquivo.add(localizacao);

        jmInscricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmInscricao.setText("Nova Inscricao");
        jMArquivo.add(jmInscricao);
        jMArquivo.add(jSeparator1);

        sair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Shutdown.png"))); // NOI18N
        sair.setText("Sair");
        jMArquivo.add(sair);

        jMenuBar1.add(jMArquivo);

        JMControlo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/control.png"))); // NOI18N
        JMControlo.setText("Controlo");
        JMControlo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMControlo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JMControlo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JMControlo.setMargin(new java.awt.Insets(0, 0, 0, 50));
        JMControlo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        controleCandidatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        controleCandidatos.setText("Candidatos");
        JMControlo.add(controleCandidatos);

        jmEstudantes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmEstudantes.setText("Estudantes");
        JMControlo.add(jmEstudantes);

        jmControleFormadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmControleFormadores.setText("Formadores");
        JMControlo.add(jmControleFormadores);

        jmAulas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmAulas.setText("Aulas");
        JMControlo.add(jmAulas);

        jMenuBar1.add(JMControlo);

        JMCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/caixa.png"))); // NOI18N
        JMCaixa.setText("Caixa");
        JMCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMCaixa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JMCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JMCaixa.setMargin(new java.awt.Insets(0, 0, 0, 50));
        JMCaixa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        AbrirCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AbrirCaixa.setText("Abrir Caixa");
        JMCaixa.add(AbrirCaixa);

        jMovimentos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMovimentos.setText("Movimentos");
        JMCaixa.add(jMovimentos);

        jmFecharCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmFecharCaixa.setText("Fechar Caixa");
        JMCaixa.add(jmFecharCaixa);

        jMenuBar1.add(JMCaixa);

        JMRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/relatorio.png"))); // NOI18N
        JMRelatorios.setText("Relatorio");
        JMRelatorios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMRelatorios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JMRelatorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JMRelatorios.setMargin(new java.awt.Insets(0, 0, 0, 50));
        JMRelatorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jmHonorarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmHonorarios.setText("Honorarios");
        JMRelatorios.add(jmHonorarios);

        JmRelatorioInscricoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JmRelatorioInscricoes.setText("Inscricoes");
        JMRelatorios.add(JmRelatorioInscricoes);

        jMenuBar1.add(JMRelatorios);

        JMConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/avancados.png"))); // NOI18N
        JMConfiguracoes.setText("Avancados");
        JMConfiguracoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JMConfiguracoes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JMConfiguracoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JMConfiguracoes.setMargin(new java.awt.Insets(0, 0, 0, 50));
        JMConfiguracoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        novoUtilizador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        novoUtilizador.setText("Novo Utilizador");
        JMConfiguracoes.add(novoUtilizador);

        jmControleUtilizadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmControleUtilizadores.setText("Controlo de Utilizadores");
        JMConfiguracoes.add(jmControleUtilizadores);

        jmPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmPeriodo.setText("Novo Periodo");
        JMConfiguracoes.add(jmPeriodo);

        jmCntrlPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmCntrlPeriodo.setText("Controlo de Periodos");
        JMConfiguracoes.add(jmCntrlPeriodo);

        jmCurso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmCurso.setText("Curso");
        JMConfiguracoes.add(jmCurso);

        jMenuBar1.add(JMConfiguracoes);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ajuda.png"))); // NOI18N
        jMenu6.setText("Ajuda");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu6.setMargin(new java.awt.Insets(0, 0, 0, 50));
        jMenu6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal(new entidades.Utilizador());
                principal.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                principal.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirCaixa;
    private javax.swing.JMenu JMCaixa;
    private javax.swing.JMenu JMConfiguracoes;
    private javax.swing.JMenu JMControlo;
    private javax.swing.JMenu JMRelatorios;
    private javax.swing.JMenuItem JmRelatorioInscricoes;
    private javax.swing.JMenuItem controleCandidatos;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLencerrarSessao;
    private javax.swing.JMenu jMArquivo;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMovimentos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem jmAulas;
    private javax.swing.JMenuItem jmCntrlPeriodo;
    private javax.swing.JMenuItem jmControleFormadores;
    private javax.swing.JMenuItem jmControleUtilizadores;
    private javax.swing.JMenuItem jmCurso;
    private javax.swing.JMenuItem jmEstudantes;
    private javax.swing.JMenuItem jmFecharCaixa;
    private javax.swing.JMenuItem jmFormador;
    private javax.swing.JMenuItem jmHonorarios;
    private javax.swing.JMenuItem jmInscricao;
    private javax.swing.JMenuItem jmPeriodo;
    private javax.swing.JLabel jmutil;
    private javax.swing.JMenuItem localizacao;
    private javax.swing.JMenuItem novoCandidato;
    private javax.swing.JMenuItem novoUtilizador;
    private javax.swing.JMenuItem sair;
    // End of variables declaration//GEN-END:variables
}
