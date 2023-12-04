package grp2;

import java.util.ArrayList;
import java.util.List;

public class Client 
{
	private int id;
	private String nom;
	List<Compte> comptes=new ArrayList<Compte>();
	
	public Client(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public void ajouterCompte(Compte c)
	{
		this.comptes.add(c);
	}
	
	public Compte chercherCompte(String nco)
	{
		for (Compte compte : comptes) {
			if(compte.getNcom()==nco)
			{
				return compte;
			}
		}
		return null;
	}
	
	public void afficherComptes()
	{
		for (Compte compte : comptes) {
			System.out.println("N: "+compte.getNcom()+" solde= "+compte.getSolde());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
}
