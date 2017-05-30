
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BGDesktopPane extends JFrame {

    private static Image img;
    private JDesktopPane dp1;

    public BGDesktopPane() {
        try {
            img = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("/icones/gajm.jpg"), "gajm.jpg"));

        } catch (Exception e) {
        }

        dp1 = new JDesktopPane() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img != null) {
                    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                    g.drawString("Background Carregado com Sucesso!!!", (this.getWidth() / 2), (this.getHeight() / 2));
                } else {
                    g.drawString("Image not found", 50, 50);
                }
                /* O repaint e o VAlidade aparentimente n fazem diferença. Caso
              encontrem algum bom motivo para usa-los, postem, please! xD
                 */
                //super.repaint();
                //super.validate();
            }

        };
        addWindowListener(new WindowAdapter() {

            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        }
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().add(dp1);
        setSize(img.getWidth(null), img.getHeight(null));
        setVisible(true);
        pack();
    }

    private void formWindowOpened(WindowEvent evt) {
        setLocationRelativeTo(null);
        setExtendedState(6);
    }

    public static void main(String[] args) {
        new BGDesktopPane();
    }
}
