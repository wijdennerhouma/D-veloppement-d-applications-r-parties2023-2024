package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.IConversion;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Localiser le registre RMI sur le serveur
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Obtenir l'objet distant du service de conversion
            IConversion conversionService = (IConversion) registry.lookup("ConversionService");

            // Utiliser le service de conversion
            double montantConverti = conversionService.convertirMontant(100.0);
            System.out.println("Montant converti : " + montantConverti);
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.toString());
            e.printStackTrace();
        }
    }
}
