package rmi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class InitRemoteService implements ServletContextListener {
    public static boolean isRegistered = false;
    public static QcmServiceInterface service;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("le service est lancé");
        if(!isRegistered){
            try {
                service = new QcmService();
                QcmServiceInterface stub = (QcmServiceInterface) UnicastRemoteObject.exportObject(service, 0);
                Registry registry = LocateRegistry.createRegistry(9338);
                registry.rebind(QcmServiceInterface.serviceName, stub);
                System.out.println("++++++++++++++ Remote service bound");
                isRegistered = true;
                System.out.println(isRegistered);
            } catch (Exception e) {
                System.err.println("++++++++++++++ Remote service exception:");
                e.printStackTrace();
            }
        }
    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


    public InitRemoteService(){

    }

    public static QcmServiceInterface getService(){
        return service;
    }

}
