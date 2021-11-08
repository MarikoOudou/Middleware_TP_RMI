import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MonServeur {
	
	static GsonBuilder builder = new GsonBuilder();
	static Gson gson = builder.create();
	static Personne personnes;
	static DataManager dm = new DataManager();
	static int id;
	static Invocation invoc = new Invocation(dm);
	static int port = 3001;

	public static void main(String[] args)  throws RemoteException, AlreadyBoundException {
		// TODO Auto-generated method stub
		
		try {
			Registry registry = LocateRegistry.createRegistry(port);
			PersonneImpl personneImpl = new PersonneImpl();
			registry.bind("personneImpl", personneImpl);
			System.out.print("Le serveur fonctionne...");
		} catch (Exception e) {
			System.out.print("Erreur: " + e);
		}

	}

}
