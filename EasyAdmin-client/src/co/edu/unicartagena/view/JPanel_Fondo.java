
package co.edu.unicartagena.view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alan M.E
 * @version 1.0
 */

public class JPanel_Fondo extends JPanel {
    
    private ImageIcon image;
    
    public JPanel_Fondo(ImageIcon image, Dimension dimension) {
        this.image = image;
        this.setSize(dimension.width, dimension.height);
    }
    
    @Override
    public void paint(Graphics g){
        Dimension size = getSize();      
        g.drawImage(image.getImage(),0,0, size.width, size.height, null);        
        setOpaque(false);
        super.paintComponent(g);
    }
    
}
