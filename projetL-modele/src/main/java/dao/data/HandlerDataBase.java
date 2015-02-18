package dao.data;

import dao.FormationDAO;
import dao.QuestionDAO;
import dao.ThematiqueDAO;
import dao.UserDAO;
import modele.Choice;
import modele.Question;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by amineboufatah on 11/01/15.
 */
public class HandlerDataBase {
    /**
     * Handler Constructor by Default
     */
    public HandlerDataBase(){

    }
    public static void start(){
        ThematiqueDAO.getInstance().addThematique(
                FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"),
                "JAVA L11");
        addQcm();

    }

    /**
     * Starting Inserting DB
     */
    public static void startApp(){
        start();
    }

    /**
     * This Method adds Formations to the DataBase
     */
    public static void addFormations(){
        if(FormationDAO.getInstance().existFormations()!=1) {
            FormationDAO.getInstance().insertFormation("LICENCE 1");
            FormationDAO.getInstance().insertFormation("LICENCE 2");
            FormationDAO.getInstance().insertFormation("LICENCE 3");
            FormationDAO.getInstance().insertFormation("MASTER 1");
            FormationDAO.getInstance().insertFormation("MASTER 2");
        }
        addThematiques();
    }

    /**
     * This method add the Thematique to the DataBase
     */
    public static void addThematiques(){
        ThematiqueDAO.getInstance().addThematique(
                FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"),
                "JAVA L11");
        if(!ThematiqueDAO.getInstance().thematiqueExists("ANGLAIS L1")) {
            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"),
                    "ANGLAIS L1");

            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"),
                    "ALGORITHMIQUE L1");

            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"),
                    "OBJECTIVE CAML");
            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"),
                    "ANGLAIS L2");

            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"),
                    "BASE DE DONNEES");

            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"),
                    "JAVA 2");

            ThematiqueDAO.getInstance().addThematique(
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"),
                    "MATHEMATIQUES 2");
        }
        addStudentsDb();
    }


    /**
     * This method adds The Users to the DataBase
     */
    public static void addStudentsDb(){
        UserDAO.getInstance().addUser("user", "user", "user",
                FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
        UserDAO.getInstance().addEtudiant("user.user@etu.univ-orleans.fr");
        if(UserDAO.getInstance().getLastUserAdded()== -1 ) {
            UserDAO.getInstance().addUser("Ghedeba", "Enzo", "enzoghedeba",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
            UserDAO.getInstance().addEtudiant("ghedeba.enzo@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("Dupont", "Jean", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEtudiant("dupont.jean@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("Padonou", "Jimmy", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEtudiant("padonou.jimmy@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("Donald", "Amelie", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
            UserDAO.getInstance().addEtudiant("donald.amelie@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("etudiant", "Jacque", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
            UserDAO.getInstance().addEtudiant("etudiant.jacque@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("etudiant", "george", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
            UserDAO.getInstance().addEtudiant("etudiant.george@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("etudiant", "Jean", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEtudiant("etudiant.jean@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("etudiant", "Jimmy", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEtudiant("etudiant.jimmy@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("etudiant", "Amine", "etudiant",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEtudiant("etudiant.amine@etu.univ-orleans.fr");
        }
        addEnseignantDb();
    }

    /**
     * This method adds an enseignant to the DataBase
     */
    public static void addEnseignantDb(){
        if(UserDAO.getInstance().getMax() != -1 ) {
            UserDAO.getInstance().addUser("Boichut", "Yohan", "administrateur",
            FormationDAO.getInstance().getIdFormationByContent("LICENCE 1"));
            UserDAO.getInstance().addEnseignant("yohan.boichut@etu.univ-orleans.fr");
            UserDAO.getInstance().addUser("Moal", "Frederic", "administrateur",
                    FormationDAO.getInstance().getIdFormationByContent("LICENCE 2"));
            UserDAO.getInstance().addEnseignant("frederic.moal@etu.univ-orleans.fr");
        }
        addQcm();
    }

    public static void addQcm2(){

            List<Question> questionsList = new ArrayList<Question>();
            // Première Question

            Question question1 = new Question();
            question1.setTime(40);
            question1.setIdQuestion(1);
            question1.setLevel(3);
            question1.setContenuQuestion("How old are you ?");
            List<Choice> choices1 = new ArrayList<Choice>();
            Choice c11 = new Choice();
            c11.setContenuChoice("My name's Bill");
            c11.setIsGoodAnswer(false);
            Choice c12 = new Choice();
            c12.setContenuChoice("I am 22");
            c12.setIsGoodAnswer(true);
            Choice c13 = new Choice();
            c13.setContenuChoice("This is Laura");
            c13.setIsGoodAnswer(false);
            Choice c14 = new Choice();
            c14.setContenuChoice("I love Paris");
            c14.setIsGoodAnswer(false);
            choices1.add(c11);
            choices1.add(c12);
            choices1.add(c13);
            choices1.add(c14);
            question1.setChoices(choices1);

            // Deuxieme Question
            Question question2 = new Question();
            question2.setTime(30);
            question2.setIdQuestion(1);
            question2.setLevel(3);
            question2.setContenuQuestion("How Are you ?");
            List<Choice> choices2 = new ArrayList<Choice>();
            Choice c21 = new Choice();
            c21.setContenuChoice("Hello");
            c21.setIsGoodAnswer(false);
            Choice c22 = new Choice();
            c22.setContenuChoice("My girlfriend is here");
            c22.setIsGoodAnswer(false);
            Choice c23 = new Choice();
            c23.setContenuChoice("I'm okay ");
            c23.setIsGoodAnswer(true);
            Choice c24 = new Choice();
            c24.setContenuChoice("Thank you !");
            c24.setIsGoodAnswer(false);
            choices2.add(c21);
            choices2.add(c22);
            choices2.add(c23);
            choices2.add(c24);
            question2.setChoices(choices2);
            // 3eme Question
            Question question3 = new Question();
            question3.setTime(30);
            question3.setIdQuestion(1);
            question3.setLevel(3);
            question3.setContenuQuestion("What's your name?");
            List<Choice> choices3 = new ArrayList<Choice>();
            Choice c31 = new Choice();
            c31.setContenuChoice("I am French");
            c31.setIsGoodAnswer(false);
            Choice c32 = new Choice();
            c32.setContenuChoice("My girlfriend is here");
            c32.setIsGoodAnswer(false);
            Choice c33 = new Choice();
            c33.setContenuChoice("Yes indeed");
            c33.setIsGoodAnswer(false);
            Choice c34 = new Choice();
            c34.setContenuChoice("My name's Charlie");
            c34.setIsGoodAnswer(true);
            choices3.add(c31);
            choices3.add(c32);
            choices3.add(c33);
            choices3.add(c34);
            question3.setChoices(choices3);
            questionsList.add(question1);
            questionsList.add(question2);
            questionsList.add(question3);
            QuestionDAO.getInstance().addQcm(UserDAO.getInstance().getMax(),
                    ThematiqueDAO.getInstance().getIdThematiqueByContent("ANGLAIS L2"), questionsList
            );

            // Un Autre Qcm
            List<Question> questionsList2 = new ArrayList<Question>();

            // 1 ere Question
            Question question4 = new Question();
            question4.setTime(40);
            question4.setIdQuestion(1);
            question4.setLevel(3);
            question4.setContenuQuestion("How do you select all datas in Sql ?");
            List<Choice> choices14 = new ArrayList<Choice>();
            Choice c41 = new Choice();
            c41.setContenuChoice("SELECT * FROM TABLE");
            c41.setIsGoodAnswer(true);
            Choice c42 = new Choice();
            c42.setContenuChoice("SELECT ALL FROM TABLE");
            c42.setIsGoodAnswer(false);
            Choice c43 = new Choice();
            c43.setContenuChoice("INSERT INTO TABLE");
            c43.setIsGoodAnswer(false);
            Choice c44 = new Choice();
            c44.setContenuChoice("SELECT FROM TABLE");
            c44.setIsGoodAnswer(false);
            choices14.add(c41);
            choices14.add(c42);
            choices14.add(c43);
            choices14.add(c44);
            question4.setChoices(choices14);

            // Deuxieme Question
            Question question5 = new Question();
            question5.setTime(30);
            question5.setIdQuestion(1);
            question5.setLevel(3);
            question5.setContenuQuestion("HOW DO YOU JOIN TABLES ?");
            List<Choice> choices15 = new ArrayList<Choice>();
            Choice c51 = new Choice();
            c51.setContenuChoice("TABLE JOIN TABLE ON ..");
            c51.setIsGoodAnswer(true);
            Choice c52 = new Choice();
            c52.setContenuChoice("TABLE.JOIN(TABLE)");
            c52.setIsGoodAnswer(false);
            Choice c53 = new Choice();
            c53.setContenuChoice("JOIN (T1 , T2 )");
            c53.setIsGoodAnswer(false);
            Choice c54 = new Choice();
            c54.setContenuChoice("JOIN OUT TABLE");
            c54.setIsGoodAnswer(false);
            choices15.add(c51);
            choices15.add(c52);
            choices15.add(c53);
            choices15.add(c54);
            question5.setChoices(choices15);

            QuestionDAO.getInstance().addQcm(UserDAO.getInstance().getMax(),
                    ThematiqueDAO.getInstance().getIdThematiqueByContent("BASE DE DONNEES"), questionsList
            );
            launchQcm();
            launchQcm2();
        }


    /**
     * This method add Qcm
     */
    public static void addQcm() {

        List<Question> list = QuestionDAO.getInstance().getQuestionsByThematique(
                ThematiqueDAO.getInstance().getIdThematiqueByContent("JAVA L11"));



            List<Question> questionsList = new ArrayList<Question>();
            // Première Question

            Question question1 = new Question();
            question1.setTime(40);
            question1.setIdQuestion(1);
            question1.setLevel(3);
            question1.setContenuQuestion("How old are you ?");
            List<Choice> choices1 = new ArrayList<Choice>();
            Choice c11 = new Choice();
            c11.setContenuChoice("My name's Bill");
            c11.setIsGoodAnswer(false);
            Choice c12 = new Choice();
            c12.setContenuChoice("I am 22");
            c12.setIsGoodAnswer(true);
            Choice c13 = new Choice();
            c13.setContenuChoice("This is Laura");
            c13.setIsGoodAnswer(false);
            Choice c14 = new Choice();
            c14.setContenuChoice("I love Paris");
            c14.setIsGoodAnswer(false);
            choices1.add(c11);
            choices1.add(c12);
            choices1.add(c13);
            choices1.add(c14);
            question1.setChoices(choices1);

            // Deuxieme Question
            Question question2 = new Question();
            question2.setTime(30);
            question2.setIdQuestion(1);
            question2.setLevel(3);
            question2.setContenuQuestion("How Are you ?");
            List<Choice> choices2 = new ArrayList<Choice>();
            Choice c21 = new Choice();
            c21.setContenuChoice("Hello");
            c21.setIsGoodAnswer(false);
            Choice c22 = new Choice();
            c22.setContenuChoice("My girlfriend is here");
            c22.setIsGoodAnswer(false);
            Choice c23 = new Choice();
            c23.setContenuChoice("I'm okay ");
            c23.setIsGoodAnswer(true);
            Choice c24 = new Choice();
            c24.setContenuChoice("Thank you !");
            c24.setIsGoodAnswer(false);
            choices2.add(c21);
            choices2.add(c22);
            choices2.add(c23);
            choices2.add(c24);
            question2.setChoices(choices2);
            // 3eme Question
            Question question3 = new Question();
            question3.setTime(30);
            question3.setIdQuestion(1);
            question3.setLevel(3);
            question3.setContenuQuestion("What's your name?");
            List<Choice> choices3 = new ArrayList<Choice>();
            Choice c31 = new Choice();
            c31.setContenuChoice("I am French");
            c31.setIsGoodAnswer(false);
            Choice c32 = new Choice();
            c32.setContenuChoice("My girlfriend is here");
            c32.setIsGoodAnswer(false);
            Choice c33 = new Choice();
            c33.setContenuChoice("Yes indeed");
            c33.setIsGoodAnswer(false);
            Choice c34 = new Choice();
            c34.setContenuChoice("My name's Charlie");
            c34.setIsGoodAnswer(true);
            choices3.add(c31);
            choices3.add(c32);
            choices3.add(c33);
            choices3.add(c34);
            question3.setChoices(choices3);
            questionsList.add(question1);
            questionsList.add(question2);
            questionsList.add(question3);
            QuestionDAO.getInstance().addQcm(UserDAO.getInstance().getIdUserByName("Moal"),
                    ThematiqueDAO.getInstance().getIdThematiqueByContent("JAVA L11"), questionsList
            );
        launchQcm();


        }


    /**
     * Method that launches the Qcm on the DataBase
     */
    public static void launchQcm(){
        QuestionDAO.getInstance().launchQcm(QuestionDAO.getInstance().getMaxQcmByLevel(
                ThematiqueDAO.getInstance().getIdThematiqueByContent("JAVA L11")
        ));

    }

    public static void launchQcm2(){
        QuestionDAO.getInstance().launchQcm(QuestionDAO.getInstance().getMaxQcmByLevel(
                ThematiqueDAO.getInstance().getIdThematiqueByContent("BASE DE DONNEES")
        ));

        QuestionDAO.getInstance().launchQcm(QuestionDAO.getInstance().getMaxQcmByLevel(
                ThematiqueDAO.getInstance().getIdThematiqueByContent("ANGLAIS L2")));
    }

}
