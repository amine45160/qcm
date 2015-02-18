package dao;

import modele.Choice;
import modele.Question;
import modele.Questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 12/01/15.
 */
public class QuestionnaireDAO {
    private static List<Questionnaire> questionnaires = testing();

    public static ArrayList<Questionnaire> testing (){



            ArrayList<Question> questionsList = new ArrayList<Question>();
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
            question2.setIdQuestion(2);
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
            question3.setIdQuestion(3);
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


            // Un Autre Qcm
            ArrayList<Question> questionsList2 = new ArrayList<Question>();

            // 1 ere Question
            Question question4 = new Question();
            question4.setTime(40);
            question4.setIdQuestion(4);
            question4.setLevel(3);
            question4.setContenuQuestion("How do you printout a value?");
            List<Choice> choices14 = new ArrayList<Choice>();
            Choice c41 = new Choice();
            c41.setContenuChoice("System.out.println()");
            c41.setIsGoodAnswer(true);
            Choice c42 = new Choice();
            c42.setContenuChoice("print()");
            c42.setIsGoodAnswer(false);
            Choice c43 = new Choice();
            c43.setContenuChoice("Scan()");
            c43.setIsGoodAnswer(false);
            Choice c44 = new Choice();
            c44.setContenuChoice("PrintOut()");
            c44.setIsGoodAnswer(false);
            choices14.add(c41);
            choices14.add(c42);
            choices14.add(c43);
            choices14.add(c44);
            question4.setChoices(choices14);

            // Deuxieme Question
            Question question5 = new Question();
            question5.setTime(30);
            question5.setIdQuestion(5);
            question5.setLevel(3);
            question5.setContenuQuestion("How do you throw an Exception ?");
            List<Choice> choices15 = new ArrayList<Choice>();
            Choice c51 = new Choice();
            c51.setContenuChoice("Throw new Exception()");
            c51.setIsGoodAnswer(true);
            Choice c52 = new Choice();
            c52.setContenuChoice("Exception.throw()");
            c52.setIsGoodAnswer(false);
            Choice c53 = new Choice();
            c53.setContenuChoice("Throw() ");
            c53.setIsGoodAnswer(false);
            Choice c54 = new Choice();
            c54.setContenuChoice("Throws Exception()");
            c54.setIsGoodAnswer(false);
            choices15.add(c51);
            choices15.add(c52);
            choices15.add(c53);
            choices15.add(c54);
            question5.setChoices(choices15);
        questionsList2.add(question4);
        questionsList2.add(question5);


        // Un Autre Qcm
        List<Question> questionsList3 = new ArrayList<Question>();

        // 1 ere Question
        Question question6 = new Question();
        question6.setTime(40);
        question6.setIdQuestion(1);
        question6.setLevel(3);
        question6.setContenuQuestion("How do you select all datas in Sql ?");
        List<Choice> choices161 = new ArrayList<Choice>();
        Choice c16 = new Choice();
        c16.setContenuChoice("SELECT * FROM TABLE");
        c16.setIsGoodAnswer(true);
        Choice c26 = new Choice();
        c26.setContenuChoice("SELECT ALL FROM TABLE");
        c26.setIsGoodAnswer(false);
        Choice c36 = new Choice();
        c36.setContenuChoice("INSERT INTO TABLE");
        c36.setIsGoodAnswer(false);
        Choice c46 = new Choice();
        c46.setContenuChoice("SELECT FROM TABLE");
        c46.setIsGoodAnswer(false);
        choices161.add(c16);
        choices161.add(c26);
        choices161.add(c36);
        choices161.add(c46);
        question6.setChoices(choices161);

        // Deuxieme Question
        Question question7 = new Question();
        question5.setTime(30);
        question5.setIdQuestion(1);
        question5.setLevel(3);
        question5.setContenuQuestion("HOW DO YOU JOIN TABLES ?");
        List<Choice> choices17 = new ArrayList<Choice>();
        Choice c71 = new Choice();
        c71.setContenuChoice("TABLE JOIN TABLE ON ..");
        c71.setIsGoodAnswer(true);
        Choice c72 = new Choice();
        c72.setContenuChoice("TABLE.JOIN(TABLE)");
        c72.setIsGoodAnswer(false);
        Choice c73 = new Choice();
        c73.setContenuChoice("JOIN (T1 , T2 )");
        c73.setIsGoodAnswer(false);
        Choice c74 = new Choice();
        c74.setContenuChoice("JOIN OUT TABLE");
        c74.setIsGoodAnswer(false);
        choices15.add(c51);
        choices15.add(c52);
        choices15.add(c53);
        choices15.add(c54);
        question5.setChoices(choices15);



            Questionnaire questionnaire1 = new Questionnaire(1,1,questionsList);
            Questionnaire questionnaire2 = new Questionnaire(2,2,questionsList2);
        ArrayList<Questionnaire> questionnaireList = new ArrayList<Questionnaire>();
        questionnaireList.add(questionnaire1);
        questionnaireList.add(questionnaire2);

        return questionnaireList;

        }

    public static List<Question> getQCMbyTheme (int theme){
        for(int i = 0 ; i< questionnaires.size() ; i++){
            if(questionnaires.get(i).getIdThematique()==theme)
                return questionnaires.get(i).getMesQuestions();
        }
        return null;
    }
    public void testing2(){
        List<Question> questionsList = new ArrayList<Question>();
        // Première Question

        Question question1 = new Question();
        question1.setTime(40);
        question1.setIdQuestion(6);
        question1.setLevel(2);
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
        question2.setIdQuestion(7);
        question2.setLevel(2);
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
        question3.setIdQuestion(8);
        question3.setLevel(2);
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

    }




}
