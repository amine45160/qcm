
package views;

import controller.ScoreInterface;

import javax.swing.*;

public class ScoreView extends javax.swing.JFrame implements ScoreViewInterface {

    private views.ImagePanel imageBackground;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelClassement;
    private javax.swing.JLabel labelClassementValue;
    private javax.swing.JLabel labelFinQcm;
    private javax.swing.JLabel labelScoreValue;
    private javax.swing.JLabel labelSlash;
    private javax.swing.JLabel labelTotalClassement;
    private javax.swing.JLabel labelTotalScore;
    private views.ImagePanel smiley;
    private views.TransparentPanel transparentPanel1;
    private ScoreInterface scoreInterface;


    /**
     * Constructor ScoreView
     * @param scoreInterface
     */
    public ScoreView(ScoreInterface scoreInterface) {
        this.scoreInterface=scoreInterface;
        initComponents();
        try {
            this.imageBackground.setImage(new ImageIcon(getClass().getResource("../images/score.JPG")).getImage());
            this.smiley.setImage(new ImageIcon(getClass().getResource("images/smileyHappy.png")).getImage());
        }catch (Exception e){
            System.err.println("Le chargement de l'image a échoué veuilez vérifier le path "+e);
        }
        this.setVisible(true);
    }

    /**
     * Method that initialises the Components of this JFrame
     */
    private void initComponents() {

        imageBackground = new views.ImagePanel();
        transparentPanel1 = new views.TransparentPanel();
        labelFinQcm = new javax.swing.JLabel();
        labelClassementValue = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelTotalClassement = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelClassement = new javax.swing.JLabel();
        labelScoreValue = new javax.swing.JLabel();
        labelTotalScore = new javax.swing.JLabel();
        labelSlash = new javax.swing.JLabel();
        smiley = new views.ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelFinQcm.setFont(new java.awt.Font("Georgia", 1, 48));
        labelFinQcm.setText("Résultats");
        transparentPanel1.add(labelFinQcm);
        labelFinQcm.setBounds(110, 60, 370, 70);

        labelClassementValue.setFont(new java.awt.Font("Georgia", 1, 36));
        labelClassementValue.setText("");
        transparentPanel1.add(labelClassementValue);
        labelClassementValue.setBounds(310, 270, 50, 90);

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 48));
        jLabel2.setText("/");
        transparentPanel1.add(jLabel2);
        jLabel2.setBounds(350, 250, 30, 140);

        labelTotalClassement.setFont(new java.awt.Font("Georgia", 1, 36));
        labelTotalClassement.setText("82");
        transparentPanel1.add(labelTotalClassement);
        labelTotalClassement.setBounds(380, 290, 70, 70);



        jLabel1.setFont(new java.awt.Font("Georgia", 1, 36));
        jLabel1.setText("Score ");
        transparentPanel1.add(jLabel1);
        jLabel1.setBounds(50, 190, 114, 70);

        labelClassement.setFont(new java.awt.Font("Georgia", 1, 36));
        labelClassement.setText("Classement");
        transparentPanel1.add(labelClassement);
        labelClassement.setBounds(50, 280, 290, 70);

        labelScoreValue.setFont(new java.awt.Font("Georgia", 1, 36));
        labelScoreValue.setText("");
        transparentPanel1.add(labelScoreValue);
        labelScoreValue.setBounds(240, 200, 80, 50);

        labelTotalScore.setFont(new java.awt.Font("Georgia", 1, 36));
        labelTotalScore.setText("20");
        transparentPanel1.add(labelTotalScore);
        labelTotalScore.setBounds(360, 190, 70, 70);

        labelSlash.setFont(new java.awt.Font("Georgia", 1, 48));
        labelSlash.setText("/");
        transparentPanel1.add(labelSlash);
        labelSlash.setBounds(330, 150, 30, 140);

        javax.swing.GroupLayout smileyLayout = new javax.swing.GroupLayout(smiley);
        smiley.setLayout(smileyLayout);
        smileyLayout.setHorizontalGroup(
                smileyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        smileyLayout.setVerticalGroup(
                smileyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );

        transparentPanel1.add(smiley);
        smiley.setBounds(200, 410, 100, 110);

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

    public void setScore(String result){
        this.labelScoreValue.setText(result);
    }

    public void setClassement(String classement){
        this.labelClassementValue.setText(classement);
    }

    public void setClassementTotal(String classementTotal){
        this.labelTotalClassement.setText(classementTotal);
    }


}
