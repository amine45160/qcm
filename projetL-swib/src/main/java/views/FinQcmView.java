
package views;

import controller.ControllerFinQcm;
import controller.FinQcmInterface;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinQcmView extends javax.swing.JFrame implements FinQcmViewInterface{

    private views.ImagePanel imageBackground;
    private javax.swing.JLabel labelFinQcm;
    private javax.swing.JLabel labelLoading;
    private views.TransparentPanel transparentPanel1;
    private FinQcmInterface finQcmInterface ;
    private javax.swing.JButton button;


    /**
     * Creates new Jframe
     */
    public FinQcmView(FinQcmInterface finQcmInterface) {
        this.finQcmInterface = finQcmInterface;
        initComponents();
        initComponentsEvents();
        try {
            this.imageBackground.setImage(new ImageIcon(getClass().getResource("../images/score.jpg")).getImage());
        }catch (Exception e){
            System.err.println("Le chargement de l'image a échoué veuilez vérifier le path "+e);
        }
        this.setVisible(true);
    }

    /**
     * Initialise the Components of this JFram
     */
    private void initComponents() {

        imageBackground = new views.ImagePanel();
        transparentPanel1 = new views.TransparentPanel();
        labelFinQcm = new javax.swing.JLabel();
        labelLoading = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        button.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelFinQcm.setFont(new java.awt.Font("Georgia", 1, 48));
        labelFinQcm.setText(" Fin du QCM");
        transparentPanel1.add(labelFinQcm);
        labelFinQcm.setBounds(80, 200, 370, 70);

        labelLoading.setFont(new java.awt.Font("Georgia", 1, 18));
        labelLoading.setText("  Loading score ...");
        transparentPanel1.add(labelLoading);
        labelLoading.setBounds(150, 250, 370, 70);


        button.setText("Voir Vos Résultats Pour Ce QCM");
        transparentPanel1.add(button);
        button.setBounds(60, 480, 360, 23);

        javax.swing.GroupLayout imageBackgroundLayout = new javax.swing.GroupLayout(imageBackground);
        imageBackground.setLayout(imageBackgroundLayout);
        imageBackgroundLayout.setHorizontalGroup(
                imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transparentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        imageBackgroundLayout.setVerticalGroup(
                imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transparentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    /**
     * Method that will initialise the ActionListener of the button log-in
     */
    private void initComponentsEvents() {
        button.setActionCommand("score");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finQcmInterface.redirect();
                }
            });

    }

    public void enableButton(){
        button.setEnabled(true);
    }

    /**
     * This method will shut down the JFrame
     */
    public void shutDown(){
        this.dispose();
    }


}
