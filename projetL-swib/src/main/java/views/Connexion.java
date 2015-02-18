
package views;
import controller.ConnexionInterface;
import exceptions.ServiceException;
import modele_local.ValidationForm;
import modele_local.ValidationFormInterface;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connexion extends javax.swing.JFrame implements ConnexionViewInterface{

    private ConnexionInterface connexionInterface ;
    private ValidationFormInterface validationFormInterface ;
    private views.ImagePanel imageBackground;
    private javax.swing.JLabel labeQcm;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUniv;
    private javax.swing.JButton loginButton;
    private views.TransparentPanel transparentPanel1;
    private javax.swing.JTextField userEmailField;
    private javax.swing.JPasswordField userPasswordField;
    private javax.swing.JComboBox userStatut;
    private javax.swing.JLabel invalideEmailLabel;
    private javax.swing.JLabel invalidePasswordLabel;

    private static final String INVALIDATE_EMAIL_MESSAGE = "Email Invalide";
    private static final String INVALIDATE_PASSWORD_MESSAGE = "Mot de passe Invalide";

    private static final String LABEL_PASSWORD = "Mot de Passe";
    private static final String LABEL_LOG_IN = "Se Connecter";
    private static final String LABEL_EMAIL = "Email";
    private static final String LABEL_UNIV = "Université d'Orléans";
    private static final String LABEL_QCM = "QCM - Département Informatique";

    private static final String ACT_LOGIN = "logIn";

    private static final String FONT_LABEL ="Cambria";
    private static final String FONT_BUTTONS ="Georgia";


    /**
     * Constructor
     * @param connexionInterface
     */
    public Connexion (ConnexionInterface connexionInterface){
        this.connexionInterface = connexionInterface ;
        this.validationFormInterface = new ValidationForm();
        initComponents();
        initComponentsEvents();
        try {
            this.imageBackground.setImage(new ImageIcon(getClass().getResource("../images/plan.jpg")).getImage());
        }catch(Exception e){
            System.err.println("Le chargement de l'image a échoué veuilez vérifier le path "+e);
        }
            this.setVisible(true);
    }


    /**
     * This method will initialise the Jframes components
     */
    private void initComponents() {

        imageBackground = new views.ImagePanel();
        transparentPanel1 = new views.TransparentPanel();
        labelPassword = new javax.swing.JLabel();
        userEmailField = new javax.swing.JTextField();
        userPasswordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        labelEmail = new javax.swing.JLabel();
        labelUniv = new javax.swing.JLabel();
        labeQcm = new javax.swing.JLabel();
        userStatut = new javax.swing.JComboBox();
        invalidePasswordLabel = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        invalideEmailLabel = new javax.swing.JLabel();
        invalideEmailLabel.setFont(new java.awt.Font(FONT_LABEL, 1, 10));
        invalideEmailLabel.setForeground(new java.awt.Color(255, 0, 0));
        invalideEmailLabel.setText(INVALIDATE_EMAIL_MESSAGE);
        transparentPanel1.add(invalideEmailLabel);
        invalideEmailLabel.setBounds(360, 160, 90, 18);
        invalideEmailLabel.setVisible(false);

        invalidePasswordLabel = new javax.swing.JLabel();
        invalidePasswordLabel.setFont(new java.awt.Font(FONT_LABEL, 1, 10));
        invalidePasswordLabel.setForeground(new java.awt.Color(255, 0, 0));
        invalidePasswordLabel.setText(INVALIDATE_PASSWORD_MESSAGE);
        transparentPanel1.add(invalidePasswordLabel);
        invalidePasswordLabel.setBounds(350, 220, 98, 18);
        invalidePasswordLabel.setVisible(false);


        labelPassword.setFont(new java.awt.Font(FONT_LABEL, 1, 14));
        labelPassword.setText(LABEL_PASSWORD);
        transparentPanel1.add(labelPassword);
        labelPassword.setBounds(40, 200, 90, 40);

        transparentPanel1.add(userEmailField);
        userEmailField.setBounds(150, 150, 200, 30);
        userEmailField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        transparentPanel1.add(userPasswordField);
        userPasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        userPasswordField.setBounds(150, 210, 200, 30);

        loginButton.setFont(new java.awt.Font(FONT_BUTTONS, 1, 14));
        loginButton.setText(LABEL_LOG_IN);
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        loginButton.setFocusable(false);
        transparentPanel1.add(loginButton);
        loginButton.setBounds(190, 330, 130, 40);

        labelEmail.setFont(new java.awt.Font(FONT_LABEL, 1, 14));
        labelEmail.setText(LABEL_EMAIL);
        transparentPanel1.add(labelEmail);
        labelEmail.setBounds(80, 140, 40, 40);

        labelUniv.setFont(new java.awt.Font(FONT_LABEL, 1, 12));
        labelUniv.setText(LABEL_UNIV);
        transparentPanel1.add(labelUniv);
        labelUniv.setBounds(240, 20, 120, 20);

        labeQcm.setFont(new java.awt.Font(FONT_LABEL, 1, 12));
        labeQcm.setText(LABEL_QCM);
        transparentPanel1.add(labeQcm);
        labeQcm.setBounds(240, 0, 190, 20);

        userStatut.setFont(new java.awt.Font(FONT_LABEL, 1, 14));
        userStatut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Etudiant", "Administrateur" }));
        transparentPanel1.add(userStatut);
        userStatut.setBounds(150, 270, 200, 30);

        javax.swing.GroupLayout imageBackgroundLayout = new javax.swing.GroupLayout(imageBackground);
        imageBackground.setLayout(imageBackgroundLayout);
        imageBackgroundLayout.setHorizontalGroup(
                imageBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transparentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
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
     * Method that will initialise the ActionListener of the button log-in
     */
    private void initComponentsEvents(){

        loginButton.setActionCommand(ACT_LOGIN);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean emailCorrect = validationFormInterface.validateEmail(userEmailField.getText());
                boolean passwordCorrect = validationFormInterface.validatePassword(userPasswordField.getText());

                if (emailCorrect && passwordCorrect)
                {
                    try {
                        connexionInterface.logInQcm(userEmailField.getText(), userPasswordField.getText());
                    } catch (ServiceException e1) {
                        e1.printStackTrace();
                    }
                }
                else
                {
                     if (!emailCorrect)
                       {
                       displayErrorEmail();
                      }
                     else
                     {
                       invalideEmailLabel.setVisible(false);
                       userEmailField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                       refresh();
                      }

                      if (!passwordCorrect)
                      {
                           displayErrorPassword();
                       }
                      else
                      {
                           invalidePasswordLabel.setVisible(false);
                           userPasswordField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                           refresh();
                       }


                }
            }
        });
    }

    /**
     * This method will shut down the JFrame
     */
    public void shutDown (){
        this.dispose();
    }

    /**
     * This method will refresh the view after passing new values
     */
    private void refresh(){
        this.validate();
    }

    /**
     * This method will display the errors on the Connexion View
     */
    public void displayError(String error){
        System.out.println(error);
    }

    /**
     * When there's an incorrect Email
     */
    public void displayErrorEmail(){
        userEmailField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        invalideEmailLabel.setVisible(true);
        refresh();
    }

    /**
     * When there's an incorrect Password
     */
    public void displayErrorPassword(){
        userPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        invalidePasswordLabel.setVisible(true);
        refresh();
    }

}
