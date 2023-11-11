package rmiClient;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import rmiService.IBanque;
import metier.Compte;
public class BanqueClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1097);
            IBanque banque = (IBanque) registry.lookup("BanqueService");

            // Initialiser les propriétés du compte pour le test
            Compte nouveauCompte = new Compte();
            nouveauCompte.setCode(1);  // Spécifiez le code du compte
            nouveauCompte.setSolde(1000.0);  // Spécifiez le solde initial
            nouveauCompte.setDateCreation(new Date());  // Spécifiez la date de création

            // Utilisez la méthode creerCompte pour créer le compte
            String resultatCreation = banque.creerCompte(nouveauCompte);
            System.out.println(resultatCreation);

            // Spécifiez le code du compte existant pour le test
            int codeCompte = 1;

            // Utilisez la méthode getInfoCompte pour obtenir les informations du compte existant
            String infoCompte = banque.getInfoCompte(codeCompte);
            System.out.println(infoCompte);
        } catch (Exception e) {
            e.printStackTrace(); }}}
