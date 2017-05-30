/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Conexao.Conexao;
import Controladora.RelatorioInscricoesControladora;
import entidades.Utilizador;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import util.ReportUtils;
import vista.Honorarios;

/**
 *
 * @author junito
 */
public class Testar {

    public Testar() {
    }
    public static void main(String[] args) {
           Testar testar=new Testar();
        testar.abrirRelatorio("/ReciboInscricao.jasper", 60);
    }
    

    public void abrirRelatorio(String arquivoJasper, int util) {
        InputStream inputStream = getClass().getResourceAsStream(arquivoJasper);
        Connection con = new Conexao().conectar();

        Map parametros = new HashMap();
        parametros.put("idmatricula", util);
        JFrame form=new JFrame();
        form.setSize(500, 300);

        try {
            openReport("RELATORIO", inputStream, parametros, con, form);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioInscricoesControladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao, JFrame frame) throws JRException {

        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void viewReportFrame(String titulo, JasperPrint print, JFrame frame) {

        JRViewer viewer = new JRViewer(print);

        JDialog frameRelatorio = new JDialog(frame, titulo, true);

        frameRelatorio.add(viewer, BorderLayout.CENTER);

        frameRelatorio.setSize(frame.getSize());


        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frameRelatorio.setVisible(true);

    }

}
