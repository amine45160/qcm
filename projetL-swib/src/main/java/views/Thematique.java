
package views;
import controller.ThematiqueInterface;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Thematique extends javax.swing.JFrame implements views.ThematiqueInterface{

    private ThematiqueInterface thematiqueInterface;
    private views.ImagePanel imageBackground;
    private javax.swing.JButton [] themeButton;
    private views.TransparentPanel transparentPanel1;


    /**
     * Constructor
     */
    public Thematique(ThematiqueInterface thematiqueInterface ) {
        this.thematiqueInterface = thematiqueInterface;
        initComponents();
        try {
            this.imageBackground.setImage(new ImageIcon(getClass().getResource("../images/plan.jpg")).getImage());
        }catch (Exception e){
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
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
     * This method will construct the Buttons from the thematic table
     */
   public void constructorButtons(List<String> thematicList) {

       themeButton = new JButton[thematicList.size()];
       int addValue1=0 ;
       int addValue2=0;
       for (int i = 0; i <thematicList.size(); i++) {

           themeButton[i] = new JButton();
           themeButton[i].setFont(new Font("Cambria", 1, 14));
           themeButton[i].setText(thematicList.get(i));
           themeButton[i].setName(thematicList.get(i));
           themeButton[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
           themeButton[i].setBorderPainted(false);
           themeButton[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
           themeButton[i].setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
           themeButton[i].setFocusable(false);
           transparentPanel1.add(themeButton[i]);

           if(i<=thematicList.size()/2){
               if (thematicList.size() <= 4) {
                   themeButton[i].setBounds(10, 180 + addValue1, 160, 40);
                   addValue1 += 100;
               } else {
                   themeButton[i].setBounds(10, 130 + addValue1, 160, 40);
                   addValue1 += 70;
               }
           }else{
               if(thematicList.size() <=4 ) {
                   themeButton[i].setBounds(200,180+addValue2, 160, 40);
                   addValue2+= 100;
               }else{
                   themeButton[i].setBounds(200,130+addValue2, 160, 40);
                   addValue2+= 70;
               }

            }
         }

       initComponentsEvents();
   }


    /**
     * Method that will initialise the ActionListener of the button log-in
     */
    private void initComponentsEvents() {
        for (int i = 0; i < themeButton.length; i++) {
            themeButton[i].setActionCommand(String.valueOf(themeButton[i].getName()));
            themeButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    thematiqueInterface.changeView(e.getActionCommand());
                }
            });
        }
    }

    /**
     * This method will shut down the JFrame
     */
    public void shutDown(){
        this.dispose();
    }

}





