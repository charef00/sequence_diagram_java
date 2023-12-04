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

# Diagramme de cas d'utlisation

![use cas](https://github.com/charef00/sequence_diagram_java/assets/46047976/79c8d017-bd3c-468d-9aa8-d0247f90b259)

# Diagramme de séquence

![sequence](https://github.com/charef00/sequence_diagram_java/assets/46047976/e8afc2de-fd2b-4dca-97d7-9fda2bfe7cfc)
