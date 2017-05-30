/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidades.Utilizador;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import vista.Honorarios;
import vista.Pagamento;
import vista.RelatorioInscricoes;

/**
 *
 * @author junito
 */
public class ReportUtils {

    public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao, Honorarios frame) throws JRException {

        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao, JDialog frame) throws JRException {

        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, JRDataSource dataSource, Honorarios frame) throws JRException {
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, JRDataSource dataSource, JDialog frame) throws JRException {
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(null, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void viewReportFrame(String titulo, JasperPrint print, Honorarios frame) {

        JRViewer viewer = new JRViewer(print);

        JDialog frameRelatorio = new JDialog(frame, titulo, true);

        frameRelatorio.add(viewer, BorderLayout.CENTER);

        frameRelatorio.setSize(frame.getJpanelRelatorios().getSize());

        frameRelatorio.setLocationRelativeTo(frame.getJpanelRelatorios());

        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frameRelatorio.setVisible(true);

    }

    private static void viewReportFrame(String titulo, JasperPrint print, JDialog frame) {

        JRViewer viewer = new JRViewer(print);

        // cria o JDialog
        JDialog frameRelatorio = new JDialog(frame, titulo, true);

        // adiciona o JRViewer no JFrame
        frameRelatorio.add(viewer, BorderLayout.CENTER);

        // configura o tamanho padrão do JFrame
        frameRelatorio.setSize(frame.getSize());

        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setLocationRelativeTo(frame);

        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // exibe o JFrame
        frameRelatorio.setVisible(true);

    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao, RelatorioInscricoes frame) throws JRException {

        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void openReport(String titulo, InputStream inputStream, Map parametros, JRDataSource dataSource, RelatorioInscricoes frame) throws JRException {
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(titulo, print, frame);
        } else {
            JOptionPane.showMessageDialog(frame, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void viewReportFrame(String titulo, JasperPrint print, RelatorioInscricoes frame) {

        JRViewer viewer = new JRViewer(print);

        JDialog frameRelatorio = new JDialog(frame, titulo, true);

        frameRelatorio.add(viewer, BorderLayout.CENTER);

        frameRelatorio.setSize(frame.getJpanelRelatorios().getSize());

        frameRelatorio.setLocationRelativeTo(frame.getJpanelRelatorios());

        frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frameRelatorio.setVisible(true);

    }

    public static void openReport(String ficha_de_Inscricao, InputStream inputStream, Map parametros, Connection con, Pagamento form) throws JRException {
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, con);
        if (!print.getPages().isEmpty()) {
            viewReportFrame(ficha_de_Inscricao, print, form);
        } else {
            JOptionPane.showMessageDialog(form, "O Relatorio nao contem nenhuma pagina!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
