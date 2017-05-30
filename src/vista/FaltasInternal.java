/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controladora.FaltasInternalControladora;
import entidades.Estudante;
import entidades.Estudante_Pacotes;
import entidades.Pacotes;
import entidades.Periodo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junito
 */
public class FaltasInternal extends javax.swing.JInternalFrame {

    private FaltasInternalControladora listener;
    private Periodo periodo = new Periodo();
    private Pacotes pacotes = new Pacotes();
    private List<Estudante_Pacotes> listaDestudantes = new ArrayList<Estudante_Pacotes>();
    private DefaultTableModel candModel;

    /**
     * Creates new form PacotesInternal
     */
    public FaltasInternal() {
        initComponents();
        listener = new FaltasInternalControladora(this);
    }

    public JComboBox<String> getJcDataInicio() {
        return jcDataInicio;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public void setJcDataInicio(JComboBox<String> jcDataInicio) {
        this.jcDataInicio = jcDataInicio;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public DefaultTableModel getCandModel() {
        return candModel;
    }

    public void setCandModel(DefaultTableModel candModel) {
        this.candModel = candModel;
    }
    
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Pacotes getPacotes() {
        return pacotes;
    }

    public void setPacotes(Pacotes pacotes) {
        this.pacotes = pacotes;
    }

    public List<Estudante_Pacotes> getListaDestudantes() {
        return listaDestudantes;
    }

    public void setListaDestudantes(List<Estudante_Pacotes> listaDestudantes) {
        this.listaDestudantes = listaDestudantes;
    }

    public JComboBox<String> getJcPacotes() {
        return jcPacotes;
    }

    public void setJcPacotes(JComboBox<String> jcPacotes) {
        this.jcPacotes = jcPacotes;
    }

    public JComboBox<String> getJcPeriodo() {
        return jcPeriodo;
    }

    public void setJcPeriodo(JComboBox<String> jcPeriodo) {
        this.jcPeriodo = jcPeriodo;
    }

    public JTable getJtEstudantes() {
        return jtEstudantes;
    }

    public void setJtEstudantes(JTable jtEstudantes) {
        this.jtEstudantes = jtEstudantes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcPeriodo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcDataInicio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcPacotes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEstudantes = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/gajm.jpg"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Periodo");

        jcPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Data de Inicio");

        jcDataInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Pacotes");

        jcPacotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcPacotes, 0, 223, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jcDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcPacotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtEstudantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtEstudantes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcDataInicio;
    private javax.swing.JComboBox<String> jcPacotes;
    private javax.swing.JComboBox<String> jcPeriodo;
    private javax.swing.JTable jtEstudantes;
    // End of variables declaration//GEN-END:variables
}
