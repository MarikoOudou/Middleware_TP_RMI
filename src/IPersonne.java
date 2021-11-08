import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPersonne extends Remote {
    public int addPersonne(Personne p)  throws RemoteException;

    public Personne getPersonne(int id) throws RemoteException, InvalidIdException;

    public int getId(Personne p) throws RemoteException;
    
}
