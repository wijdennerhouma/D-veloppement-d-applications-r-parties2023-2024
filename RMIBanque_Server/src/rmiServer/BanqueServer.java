
package rmiServer;

import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;

import rmiService.BanqueImpl;


public class BanqueServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1093);
            BanqueImpl banque = new BanqueImpl();
            registry.rebind("BanqueService", banque);
            System.out.println("Serveur prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
