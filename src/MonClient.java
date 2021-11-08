import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MonClient {

    static Scanner sc = new Scanner(System.in);// pour lire � partir du clavier
    static int port = 3001;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String reponse = "";

		
		while (reponse != "ok") {
	        reponse = choixMenu();
			System.out.println(reponse);
		}
		
	}
	

    public static String choixMenu() {
        int identifiant = 0;
        String nom = "";
        int age = 0;
        Object reponse = null;
        Map<String, String> personne = new HashMap<String, String>();
        Map<String, Object> dataSend = new HashMap<String, Object>();
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("MENU DU CLIENT : ");
        System.out.println("1- Ajouter une personne :");
        System.out.println("2- Demander l'identificateur d'une personne en envoyant les informations nom et age :");
        System.out.println("3- Récupérer les informations concernant une personne à partir de son identificateur :");
        System.out.println("0- Pour Quiiter le programme");
        System.out.println("Entrez le numero du menu : ");

        int choix = Integer.parseInt(sc.nextLine());
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        switch (choix) {

        case 1:
            System.out.println("1- Ajouter une personne :");
            System.out.println("Entrez le nom :");
            nom = sc.nextLine();
            System.out.println("Entrez l' age :");
            age = Integer.parseInt(sc.nextLine());

    		try {
    			IPersonne person = (IPersonne) Naming.lookup("rmi://localhost:"+port+"/personneImpl");
    			reponse = person.addPersonne(new Personne(age, nom));
    			System.out.println(reponse);
    			} 
    			catch (Exception e) {
    				System.out.print("Erreur: " + e);
    				e.printStackTrace();
    		}

            return "Reponse Serveur : "+reponse;
        case 2:
            System.out.println("2- Demander l'identificateur d'une personne en envoyant les informations nom et age :");
            System.out.println("Entrez le nom :");
            nom = sc.nextLine();
            System.out.println("Entrez l' age :");
            age = Integer.parseInt(sc.nextLine());
    		try {
    			IPersonne person = (IPersonne) Naming.lookup("rmi://localhost:"+port+"/personneImpl");
    			reponse = person.getId(new Personne(age, nom));
    			System.out.println(reponse);
    			} 
    			catch (Exception e) {
    				System.out.print("Erreur: " + e);
    				e.printStackTrace();
    		}
            
    		return "Reponse Serveur : "+reponse;

        case 3:
            System.out.println("Entrez l'identifiant :");
            identifiant = Integer.parseInt(sc.nextLine());
    		try {
    			IPersonne person = (IPersonne) Naming.lookup("rmi://localhost:"+port+"/personneImpl");
    			reponse = person.getPersonne(identifiant);
    			System.out.println(reponse);
    			} 
    			catch (Exception e) {
    				System.out.print("Erreur: " + e);
    				e.printStackTrace();
    		}
    		return "Reponse Serveur : "+reponse;

        case 0:
            return "ok";
        default:
            System.out.println("Choix incorrect");
            //String dataSendJsonDef = gson.toJson("");
            return "ok";
        }
    }


}
