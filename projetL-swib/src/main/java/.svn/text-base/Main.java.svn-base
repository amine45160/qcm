

import controller.ConnexionInterface;
import controller.ControllerConnexion;

import rmi.QcmServiceInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Main {

    public static final String HOST = "127.0.0.1";


      public static void main ( String [] args) {


        try {
            Registry registry = LocateRegistry.getRegistry(HOST, 9338);
            String[] names = registry.list();
            for (String name1 : names) {
                System.out.println("~~~~" + name1 + "~~~~");
            }

            QcmServiceInterface service = (QcmServiceInterface) registry.lookup(QcmServiceInterface.serviceName);
            ConnexionInterface connexionInterface = new ControllerConnexion(service);

        }
        catch (Exception e) {
            System.err.println("Remoteservice exception:");
            e.printStackTrace();
        }


    }

}
