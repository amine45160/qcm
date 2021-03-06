package rmi;

import dao.*;
import modele.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amineboufatah on 05/12/14.
 */
public class QcmService implements QcmServiceInterface {

    IUsersDAO userDao = UserDAO.getInstance();
    

    public void init() throws RemoteException {

    }

    public User getUserByInformations(String identifiant, String password) throws RemoteException {
        System.out.println(userDao);
        return userDao.getUserByInfo(identifiant, password);

    }

    public List<Thematique> getThematiquesByLevel(int level) throws RemoteException{

        return ThematiqueDAO.getInstance().getThematiquesByLevel(level);

    }

    public int getMax() throws RemoteException {
        return UserDAO.getInstance().getMax();
    }

    public int getMax(int i) throws RemoteException {
        return QuestionDAO.getInstance().getMax(i);
    }

    public List<Question> getQuestionsByThematique(int thematique) throws RemoteException {
        return QuestionDAO.getInstance().getQuestionsByThematique(thematique);
    }

    public void addQcm(int idEnseignant, int thematique, List<Question> questions) throws RemoteException {
        QuestionDAO.getInstance().addQcm(idEnseignant , thematique , questions);
    }

    public List<Score> getScoreByQcm(int idQcm, int idUser) throws RemoteException {
        return ResultDAO.getInstance().getScoreByQcm(idQcm , idUser);
    }

    public void addScoreQuestion(int idEtudiant , int idQcm , int idQuestion , int answer){
        ResultDAO.getInstance().addScoreQuestion(idEtudiant , idQcm , idQuestion , answer);
    }

    public List<Thematique> getLaunchedThematiques(int level){
       return  ThematiqueDAO.getInstance().getLaunchedThematiques(level);
    }

    @Override
    public void launchQcm(int idQcm) throws RemoteException {
        QuestionDAO.getInstance().launchQcm(idQcm);
    }


    @Override
    public int getMaxByLevel(int thematique) throws RemoteException {
        return QuestionDAO.getInstance().getMaxQcmByLevel(thematique);
    }

    @Override
    public int getIdSessionByQcm(int idQcm) throws RemoteException {
        return ResultDAO.getInstance().getIdSessionByQcm(idQcm);
    }

    @Override
    public void addQcmResult(int idSession, int idUser, double resultat) throws RemoteException {
        ResultDAO.getInstance().addQcmResult(idSession , idUser , resultat);
    }

    @Override
    public int getIdThematiqueByContent(String content) throws RemoteException {
        return ThematiqueDAO.getInstance().getIdThematiqueByContent(content);
    }

    @Override
    public void addEtudiant( String identifiant) throws RemoteException {
        UserDAO.getInstance().addEtudiant(identifiant);
    }


    @Override
    public boolean hasResponded(int idUser, int idQcm) throws RemoteException {
        return QuestionDAO.getInstance().hasResponded(idUser , idQcm);
    }

    @Override
    public int getMaxQcmByLevel(int thematique) throws RemoteException {
        return QuestionDAO.getInstance().getMaxQcmByLevel(thematique);
    }

    @Override
    public List<Integer> getFinalResultQcm(int idQcm) throws RemoteException {
        return ResultDAO.getInstance().getFinalResultQcm(idQcm);
    }

    @Override
    public List<Thematique> getNotLaunchedThematiques(List<Thematique>l1 , List<Thematique>l2) {
        return ThematiqueDAO.getInstance().getNotLaunchedThematiques(l1, l2);
    }

    @Override
    public List<Thematique> getAllThematiques(int level) throws RemoteException {
        return ThematiqueDAO.getInstance().getAll(level);
    }

    @Override
    public List<Question> getQCMbyTheme(int theme) {
        return QuestionnaireDAO.getQCMbyTheme(theme);
    }

    @Override
    public boolean thematiqueExists(String content) throws RemoteException {
        return ThematiqueDAO.getInstance().thematiqueExists(content);
    }

    @Override
    public int getIdFormationByContent(String content) throws RemoteException {
        return FormationDAO.getInstance().getIdFormationByContent(content);
    }

    @Override
    public User logIn(String a, String b) throws RemoteException {
        return UserDAO.getInstance().logIn(a,b);
    }

    public List<Thematique> getMyThemes(int level){
        return ThematiqueDAO.getInstance().getMyThemes(level);
    }

}
