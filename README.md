# sequence_diagram_java

Contexte :

Dans le cadre des opérations bancaires liées aux virements personnels, les employés de la banque utilisent un système informatique pour effectuer ces transactions. Lorsqu'un client souhaite effectuer un virement, l'employé de la banque commence par rechercher le client en utilisant son identifiant unique (ID). Une fois le client identifié, le système recherche ensuite tous les comptes associés à ce client. Le client peut posséder plusieurs comptes, mais chaque compte appartient à un seul client. Ensuite, l'employé de la banque spécifie le montant du virement.

Classes :

Classe Client :

Attributs : Identifiant (ID), Nom
Description : Représente un client de la banque, identifié par son ID unique et associé à un nom.

Classe Compte :
Attributs : Numéro de compte, Solde
Description : Représente un compte bancaire, identifié par son numéro de compte unique et associé à un solde. Chaque compte appartient à un seul client.
Classe Virement :

Attributs : Montant
Description : Représente une transaction de virement entre deux comptes. Le virement implique un retrait du compte source et un dépôt dans le deuxième compte.

# Diagramme de classes

![class](https://github.com/charef00/sequence_diagram_java/assets/46047976/68500522-74f1-41da-95ed-fda00c297893)

# Java

Classe Client :

Attributs : Identifiant (ID), Nom
Associations : Un client peut avoir 0 à plusieurs comptes (relation '0.*' avec la classe Compte). Cela entraîne l'ajout d'un attribut supplémentaire, comptes, de type tableau (array) de Compte.
Opération : chercherCompte - Cette opération permet de rechercher un compte dans la liste des comptes associés à un client.

```java
public class Client 
{
	private int id;
	private String nom;
	List<Compte> comptes=new ArrayList<Compte>();
	public Client(int id, String nom)
  {
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
}
```

Classe Compte :
Attributs : Numéro de compte, Solde
Opération : refirer et déposer
```java
public class Compte 
{
	private String ncom;
	private double solde;
	
	public Compte(String ncom, double solde) {
		this.ncom = ncom;
		this.solde = solde;
	}
	
	public boolean retirer(double mnt)
	{
		if(mnt<=solde)
		{
			this.solde-=mnt;
			return true;
		}
		
		return false;
	}
	
	
	public boolean deposer(double mnt)
	{
		if(mnt>0)
		{
			this.solde+=mnt;
			return true;
		}
		
		return false;
	}
}
```
Classe Virement :
Attributs : Montant
Associations : Un virement implique une association multiple entre la classe Virement et la classe Compte. La première association concerne la source du virement, tandis que la deuxième concerne la destination. En Java, cela se traduit par l'ajout de deux attributs supplémentaires dans la classe Virement : src de type Compte pour représenter la source du virement et dest de type Compte pour représenter la destination.
Opération : effectuer le virement
```java
public class Virement 
{
	private double mnt;
	private Compte src;
	private Compte dest;
	
	public Virement(double mnt, Compte src, Compte dest) 
	{
		this.mnt = mnt;
		this.src = src;
		this.dest = dest;
	}
	
	public boolean effectuer()
	{
		boolean rtn=this.src.retirer(this.mnt);
		if(!rtn)
		{
			return false;
		}
		rtn=this.dest.deposer(this.mnt);
		
		return rtn;
	}
}
```
# Diagramme de cas d'utlisation

![use cas](https://github.com/charef00/sequence_diagram_java/assets/46047976/79c8d017-bd3c-468d-9aa8-d0247f90b259)

# Diagramme de séquence

![sequence](https://github.com/charef00/sequence_diagram_java/assets/46047976/e8afc2de-fd2b-4dca-97d7-9fda2bfe7cfc)

