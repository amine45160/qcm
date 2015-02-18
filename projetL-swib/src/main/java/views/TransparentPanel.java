package views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class TransparentPanel extends JPanel{

    private int red;
    private int green;
    private int blue;
    private int alpha;

    /**
     * Constructor
     */
    public TransparentPanel(){
        this(233,238,238,100);
    }

    /**
     * Constructor
     * @param red
     * @param green
     * @param blue
     * @param alpha
     */
    public TransparentPanel(int red,int green,int blue,int alpha){
        super();
        this.setOpaque(false);
        this.setLayout(null);
    }

    /**
     * PaintComponent method
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Color c=new Color(red,green,blue,alpha);
        g.setColor(c);
        g.fillRect(0,0, this.getWidth(),this.getHeight());

    }
}

