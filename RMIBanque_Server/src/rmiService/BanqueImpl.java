// BanqueImpl.java
package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException {
        super();
        comptes = new HashMap<>();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {
        if (comptes.containsKey(c.getCode())) {
            return "Échec de la création du compte. Le compte existe déjà.";
        } else {
            comptes.put(c.getCode(), c);
            return "Compte créé avec succès.";
        }
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        if (comptes.containsKey(code)) {
            Compte compte = comptes.get(code);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String dateCreation = sdf.format(compte.getDateCreation());

            return "Code: " + compte.getCode() +
                    "\nSolde: " + compte.getSolde() +
                    "\nDate de création: " + dateCreation;
        } else {
            return "Aucun compte trouvé avec le code " + code;
        }
    }
}
