package grp2;

import java.util.ArrayList;
import java.util.List;

public class Controller 
{
	List<Client>clients=new ArrayList<Client>();
	
	public Controller()
	{
		Client client=new Client(23, "ahmed");
		Compte c1=new Compte("cl1-ab", 2000);
		Compte c2=new Compte("cl1-bc", 1000);
		client.ajouterCompte(c1);
		client.ajouterCompte(c2);
		this.clients.add(client);
	}
	
	
	public boolean effectuerVirementP(int id,String nc1,String nc2, double mnt)
	{
		Client client=chercherClient(id);
		Compte c1=client.chercherCompte(nc1);
		Compte c2=client.chercherCompte(nc2);
		client.afficherComptes();
		Virement v1=new Virement(mnt, c1, c2);
		boolean rtn=v1.effectuer();
		System.out.println("-------------------------");
		client.afficherComptes();
		return rtn;
	}
	
	public Client chercherClient(int id)
	{
		for (Client client : clients) {
			if(client.getId()==id)
			{
				return client;
			}
		}
		
		return null;
	}
}
