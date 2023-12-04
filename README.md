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
# Diagramme de cas d'utlisation

![use cas](https://github.com/charef00/sequence_diagram_java/assets/46047976/79c8d017-bd3c-468d-9aa8-d0247f90b259)

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

# Diagramme de séquence
Le diagramme de séquence que nous élaborerons se concentrera sur un exemple concret illustrant l'utilisation d'un cas d'utilisation spécifique : l'exécution d'un virement personnel. Pour ce faire, nous aborderons également la boîte blanche, qui nous permet de représenter les interactions entre les objets internes de l'application.

La création de ce diagramme de séquence nécessitera préalablement la disponibilité du diagramme de cas d'utilisation ainsi que du diagramme de classes. Dans un souci de bonnes pratiques de développement Java, nous adopterons l'architecture 3 tiers.

Dans cette structure, la classe Main "Console" représentera la vue (view). Nous introduirons une nouvelle classe, le contrôleur (Controller), qui sera responsable de la logique de traitement. Enfin, le modèle sera représenté par les trois classes : Client, Compte, et Virement, conformément à notre diagramme de classes.

En suivant cette approche en trois tiers, nous organiserons le flux de données de manière claire et modulaire, favorisant une conception robuste et évolutive de l'application.

![sequence](https://github.com/charef00/sequence_diagram_java/assets/46047976/e8afc2de-fd2b-4dca-97d7-9fda2bfe7cfc)

Au commencement du diagramme de séquence, un acteur, représenté par un employé, initie l'interaction. Un message nommé "effectuerVirementPersonnel" est échangé entre l'employé et l'objet de classe Controller. Ce message incarne une méthode de la classe Controller, indiquant ainsi l'action d'effectuer un virement personnel.

Le second message, "chercherClient", est un message réflexif qui débute à partir de la période d'activité de la méthode "effectuerVirementPersonnel". En termes d'exécution, cela signifie que le message "chercherClient" est une méthode de la classe Controller, et son exécution se déroule au sein de la classe elle-même. Un message réflexif se traduit simplement par l'appel d'une méthode à l'intérieur de la même classe.

Après avoir identifié le client grâce à la méthode "chercherClient", la recherche des deux comptes du même client s'impose. Comme rappelé précédemment, la méthode "chercherCompte" est une méthode de la classe Client. Par conséquent, un message est échangé entre la période active de la méthode "effectuerVirementPersonnel" et l'objet client que nous avons déjà trouvé avec la méthode "chercherClient".
Alors, la classe Controller va être comme suit :
```java
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
		Virement v1=new Virement(mnt, c1, c2);
		boolean rtn=v1.effectuer();
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
```
