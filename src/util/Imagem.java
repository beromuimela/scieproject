/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author junito
 */
public class Imagem {

    private String path;
    private URL directorio;
    private String nomedaimagem = "candidato";
    private URL url;
    private BufferedImage imagem;

    public Imagem() {
        this.url = getClass().getResource("/icones/candidato.png");
        this.path = url.getPath();
    }

    public void guardarImagem() throws IOException {
        this.imagem = ImageIO.read(url);
        File novaImagem = new File(System.getProperty("user.dir") + "/src/database" + System.getProperty("file.separator") + nomedaimagem + "candidato.png");
        ImageIO.write(imagem, "png", novaImagem);

        path = novaImagem.getPath();
        nomedaimagem = novaImagem.getName();
    }

    public void abreImagem(JPanel panel, JLabel foto) throws MalformedURLException {
        JFileChooser filechoser = new JFileChooser();
        filechoser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de Imagem", "jpg", "gif", "png");
        filechoser.addChoosableFileFilter(filter);
        filechoser.setDialogTitle("Seleccione a foto");

        int result = filechoser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechoser.getSelectedFile();
            URI uri = selectedFile.toURI();
            this.url = uri.toURL();
            this.path = selectedFile.getAbsolutePath();
            this.nomedaimagem = selectedFile.getName();
            ImageIcon icon = new ImageIcon(path);

            //redimensionando a imagem
            icon.setImage(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), 100));
            panel.setBackground(null);
            foto.setIcon(icon);
        }
    }

    public void mostrarImagem(JPanel panel, JLabel foto) throws FileNotFoundException {
        ImageIcon icon = new ImageIcon(url);
        icon.setImage(icon.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), 100));

//        ImageIcon icon = new ImageIcon(path);
        panel.setBackground(null);
        foto.setIcon(icon);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNomedaimagem() {
        return nomedaimagem;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void setNomedaimagem(String nomedaimagem) {
        this.nomedaimagem = nomedaimagem;
    }

}
