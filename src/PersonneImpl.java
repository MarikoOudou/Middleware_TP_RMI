import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PersonneImpl extends UnicastRemoteObject implements IPersonne  {
	
    protected PersonneImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		// UnicastRemoteObject.exportObject(this);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataManager dm = new DataManager();

    /*public DataManagerImpl() throws RemoteException
    {
	// exportation de l'objet afin de créer la mécanique TCP pour
	// pouvoir appeler les opérations à distance sur cet objet
	UnicastRemoteObject.exportObject(this);
    }*/
    
    public int addPersonne(Personne p) throws RemoteException {
        int id = dm.addPersonne(p);
	    System.out.println("- Ajout de % "+p+" % avec identifiant = "+id);
        return id;
    };

    public Personne getPersonne(int id) throws RemoteException, InvalidIdException {
    	Personne p = dm.getPersonne(id);
 
		return p;

    }

    public int getId(Personne p) throws RemoteException {
        int id = dm.getId(p);
        return id;
    }

}
