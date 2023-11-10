package rmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ConversionImpl extends UnicastRemoteObject implements IConversion {

    public ConversionImpl() throws RemoteException {
        super();
    }

    @Override
    public double convertirMontant(double mt) throws RemoteException {
        // Implémentez la logique de conversion ici
        // Par exemple, simplement renvoyer le montant pour l'instant
        return mt;
    }
}
