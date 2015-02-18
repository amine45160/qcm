package views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author IBM
 */
public class ImagePanel extends javax.swing.JPanel {

    private Image BackGroundimage;

    /**
     * Constructor of the ImagePanel
     */
    public ImagePanel(){

    }

    /**
     * Getter
     * @return Image
     */
    public Image getImage() {
        return BackGroundimage;
    }

    /**
     * Setter
     * @param image
     */
    public void setImage(Image image) {
        this.BackGroundimage = image;
        Dimension size=new Dimension(this.getWidth(),this.getHeight());
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        this.setOpaque(false);
    }

    /**
     * Method that paints the component on the Panel
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        if(this.BackGroundimage!=null){
            g.drawImage(BackGroundimage, 0, 0,this.getWidth(),this.getHeight(),null);
        }
    }
}