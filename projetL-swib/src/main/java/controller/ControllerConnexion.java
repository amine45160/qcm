package controller;

import exceptions.ServiceException;
import modele.User;
import rmi.QcmServiceInterface;
import views.Connexion;
import views.ConnexionViewInterface;

import java.rmi.RemoteException;


/**
 * Created by amineboufatah on 15/11/14.
 */
public class ControllerConnexion implements ConnexionInterface {
    private QcmServiceInterface service;
    private ConnexionViewInterface connexionViewInterface ;

    /**
     * Constructor Connexion
     */
    public ControllerConnexion (QcmServiceInterface service){
        this.connexionViewInterface = new Connexion(this) ;
        this.service = service;
    }

    /**
     * Method that allows the user to log in the QCM
     */
    public void logInQcm(String email , String password) throws ServiceException {
        User user = null  ;
        try {

            //user = service.logIn(email , password);

            user = service.getUserByInformations(email,password);
            System.out.println("Mon User "+user.getNom()+user.getLevel());
            System.out.println("");

        } catch (RemoteException e) {
            System.err.println("Une erreur est survenue lors de l'appel au Service RMI ");
            e.printStackTrace();
        }

        if(service==null){
           throw new ServiceException("Le Service n'a pas été lancé Correctement ! ");
        }

        if (user == null){
            System.out.println("LOG IN NOT ALLOWED");

        }else{

            closeConnexionView();
            ThematiqueInterface thematiqueInterface = new ControllerThematique(service , user);

        }
    }

    /**
     * Method that closes the actual view
     */
    public void closeConnexionView() {
        this.connexionViewInterface.shutDown();
    }
}
