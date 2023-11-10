package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // Créer un objet de la classe d'implémentation
            rmiService.IConversion conversionImpl = new rmiService.ConversionImpl();

            // Créer un registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Enregistrer l'objet d'implémentation dans le registre
            registry.rebind("ConversionService", conversionImpl);

            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Erreur du serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}
