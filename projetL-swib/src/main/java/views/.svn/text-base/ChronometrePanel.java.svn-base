package views;

import javax.swing.*;
import java.awt.*;


/**
 * Created by amineboufatah on 28/11/14.
 */
public class ChronometrePanel extends JPanel implements ChronometrePanelInterface {

    /** serialVersionUID : numero de serie */
    private static final long serialVersionUID = 1L;

    /** f : Font appliqué au texte */
    private static Font f = new Font("Book Antiqua", Font.BOLD, 25);


    /** couleur : couleur de fond du chronometre */
    private Color couleur=new Color(77,176,139);

    /** tempsRestant : temps restant */
    private int tempsRestant;

    /** temps : temps initial */
    private static int temps;

    /**
     * Construction du chronometre
     */
    public ChronometrePanel(int timeLeft){
        temps = timeLeft;
        tempsRestant = timeLeft;
        setOpaque(false);
        setPreferredSize(new Dimension(72, 72));
    }
    /**
     * Redéfinition de la méthode paintCompnent
     */

    public void paintComponent(Graphics g) {
        this.drawCircle(g, 35, 35, 30);
    }

    /**
     * Fonction qui permet de dessiner le chronometre
     * @param cg : element graphique
     * @param xCenter : abscice du centre du cercle
     * @param yCenter : ordonnee du centre du cercle
     * @param r : rayon du cercle
     */
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.setColor(new Color(222,222,222));
        cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
        if(tempsRestant > 9){
            cg.setColor(couleur);
        }else{
            cg.setColor(new Color(255,64,64));
        }
        cg.fillArc(xCenter-r, yCenter-r, 2*r, 2*r, 90, -(360-tempsRestant*360/temps));
        cg.setColor(Color.black);
        cg.setFont(f);
        if(tempsRestant>9){
            cg.drawString(""+this.tempsRestant, 24, 42);
        }
        else{
            cg.drawString("0"+this.tempsRestant, 24, 42);
        }
    }

    /**
     * Setter
     * @param tempsRestant
     */
    public void setTempsRestant(int tempsRestant) {
        this.tempsRestant = tempsRestant;
    }

    /**
     * Sets the visibility of the panel
     * @param visibility
     */
    public void setVisibility(boolean visibility){
        this.setVisible(visibility);
    }

    /**
     * Refreshes the view
     */
    public void refresh(){
        this.repaint();
    }

}
