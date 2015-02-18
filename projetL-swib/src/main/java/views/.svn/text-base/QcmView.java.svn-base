
package views;

import controller.QCMInterface;


import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QcmView extends javax.swing.JFrame implements QcmViewInterface {
    private QCMInterface qcmInterface ;
    private ChronometrePanel chrono ;
    private views.ImagePanel imageBackground;
    private javax.swing.JTextArea textQuestion;
    private javax.swing.JLabel labelInfo;
    private javax.swing.ButtonGroup radioGroupe;
    private javax.swing.JRadioButton radioReponse1;
    private javax.swing.JRadioButton radioReponse2;
    private javax.swing.JRadioButton radioReponse3;
    private javax.swing.JRadioButton radioReponse4;
    private String choiceMade ;
    private javax.swing.JButton suivantButton;
    private views.TransparentPanel transparentPanel1;

    /**
     * Constructor QcmView
     * @param qcmInterface
     */
    public QcmView (QCMInterface qcmInterface){
        this.qcmInterface = qcmInterface ;
        initComponents();
        initComponentsEvents();
        try {
            this.imageBackground.setImage(new ImageIcon(getClass().getResource("../images/qcm.jpg")).getImage());
        }catch (Exception e){
            System.err.println("Le chargement de l'image a échoué veuilez vérifier le path "+e);
        }
            this.setVisible(true);
    }

    /**
     * This method will initialise the components of the view
     */
    private void initComponents() {

        radioGroupe = new javax.swing.ButtonGroup();
        imageBackground = new views.ImagePanel();
        transparentPanel1 = new views.TransparentPanel();
        textQuestion = new javax.swing.JTextArea();
        radioReponse1 = new javax.swing.JRadioButton();
        radioReponse2 = new javax.swing.JRadioButton();
        radioReponse3 = new javax.swing.JRadioButton();
        radioReponse4 = new javax.swing.JRadioButton();
        suivantButton = new javax.swing.JButton();
        labelInfo = new javax.swing.JLabel();


        suivantButton.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 500));
        setResizable(false);

        transparentPanel1.setBackground(new java.awt.Color(255, 255, 255));



        textQuestion.setFont(new java.awt.Font("Georgia", 1, 18));
        transparentPanel1.add(textQuestion);
        textQuestion.setBounds(30, 120, 390, 40);
        textQuestion.setOpaque(false);
        textQuestion.setLineWrap(true);
        textQuestion.setWrapStyleWord(true);


        radioReponse1.setOpaque(false);
        radioGroupe.add(radioReponse1);
        radioReponse1.setFont(new java.awt.Font("Georgia", 1, 14));
        transparentPanel1.add(radioReponse1);
        radioReponse1.setBounds(80, 180, 370, 25);


        radioReponse2.setOpaque(false);
        radioGroupe.add(radioReponse2);
        radioReponse2.setFont(new java.awt.Font("Georgia", 1, 14));
        transparentPanel1.add(radioReponse2);
        radioReponse2.setBounds(80, 220, 370, 25);


        radioReponse3.setOpaque(false);
        radioGroupe.add(radioReponse3);
        radioReponse3.setFont(new java.awt.Font("Georgia", 1, 14));
        transparentPanel1.add(radioReponse3);
        radioReponse3.setBounds(80, 260, 370, 25);


        radioReponse4.setOpaque(false);
        radioGroupe.add(radioReponse4);
        radioReponse4.setFont(new java.awt.Font("Georgia", 1, 14));
        radioReponse4.setBounds(80, 300, 370, 25);
        transparentPanel1.add(radioReponse4);
        textQuestion.setLineWrap(true);
        textQuestion.setWrapStyleWord(true);

        suivantButton.setBackground(new java.awt.Color(49, 49, 49));

        suivantButton.setFont(new java.awt.Font("Cambria", 1, 14));
        suivantButton.setForeground(new java.awt.Color(255, 255, 255));
        suivantButton.setText("Repondre");
        transparentPanel1.add(suivantButton);
        suivantButton.setBounds(150, 360, 130, 40);

        labelInfo.setFont(new java.awt.Font("Cambria", 0, 10));
        labelInfo.setText("");
        transparentPanel1.add(labelInfo);
        labelInfo.setBounds(80, 450, 320, 20);

        javax.swing.GroupLayout imageBackgroundLayout = new javax.swing.GroupLayout(imageBackground);
        imageBackground.setLayout(imageBackgroundLayout);
        imageBackgroundLayout.setHorizontalGroup(
                imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transparentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        imageBackgroundLayout.setVerticalGroup(
                imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transparentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
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
     *Method will construct the chrono
     */
    private void constructChrono(ChronometrePanel chronometrePanel){
        chrono = chronometrePanel ;
        javax.swing.GroupLayout chronoLayout = new javax.swing.GroupLayout(chrono);
        chrono.setLayout(chronoLayout);
        chronoLayout.setHorizontalGroup(
                chronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 80, Short.MAX_VALUE)
        );
        chronoLayout.setVerticalGroup(
                chronoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 72, Short.MAX_VALUE)
        );

        transparentPanel1.add(chrono);
        chrono.setBounds(0, 0, 80, 72);
        chrono.setVisible(true);
        chrono.validate();
    }

    /**
     * Method that will initialise the ActionListener of the button validate
     */

    private void initComponentsEvents() {
        suivantButton.setActionCommand("validate");
        suivantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qcmInterface.stopChronometre();
                qcmInterface.updateChronometre();
                qcmInterface.validerQuestion(choiceMade);
                radioGroupe.clearSelection();
                suivantButton.setEnabled(false);
            }
        });
        radioReponse1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suivantButton.setEnabled(true);
                choiceMade = radioReponse1.getText();
            }
        });
        radioReponse2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suivantButton.setEnabled(true);
                choiceMade = radioReponse2.getText();
            }
        });
        radioReponse3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suivantButton.setEnabled(true);
                choiceMade = radioReponse3.getText();
            }
        });
        radioReponse4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suivantButton.setEnabled(true);
                choiceMade = radioReponse4.getText();
            }
        });
    }

    /**
     * This method will refresh the view after passing new values
     */
    private void refresh(){
        this.validate();
    }

    /**
     * This method will catch up the new values of the Jframe passed out through the controller
     */
    public void newValues(String question , String [] choices , ChronometrePanel chrono  ){
        textQuestion.setText(question);
        radioReponse1.setText(choices[0]);
        radioReponse2.setText(choices[1]);
        radioReponse3.setText(choices[2]);
        radioReponse4.setText(choices[3]);
        constructChrono(chrono);
    }

    /**
     * This method will shut down the JFrame
     */
    public void shutDown(){
        this.dispose();
    }

    /**
     * Method that will update the chrono
     */
    public void update(){
        this.chrono.setVisible(false);
        this.getContentPane().remove(chrono);
        this.getContentPane().validate();
        refresh();
    }

    /**
     * Method that displays the user name on the view
     * @param name
     */
    public void setUserInfo(String name){
        labelInfo.setText(name);
    }

}
