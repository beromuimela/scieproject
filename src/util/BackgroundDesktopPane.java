/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;

/**
 *
 * @author junito
 */
public class BackgroundDesktopPane extends JDesktopPane{
    Image img;
    
    public BackgroundDesktopPane(){
        try{
            java.net.URL caminho=getClass().getResource("/icones/gajm.jpg");
            img=javax.imageio.ImageIO.read(caminho);
        }catch(Exception e){
            
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null)
            g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
        else
            g.drawString("Imagem nao encontrada", 0, 0);
    }
}
