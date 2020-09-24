Prérequis :
- Un serveur Apache Tomcat/ ou un conteneur de servlet
- Un serveur de BDD compatible MySQL 8+

Procédure de deploiement :
- Copier le fichier rando/target/rando-0.0.1-SNAPSHOT.war 
- Le coller dans le repertoire webapp/ de votre serveur 
- Recupérer le script sql présent dans l'archive rando-0.0.1-SNAPSHOT.war sous WEB-INF/classes/RandoUDEV3.sql
- Modifié le fichier jdbc.properties pour qu'il pointe sur votre serveur SQL avec vos identifiants
- Executer le script RandoUDEV3.sql sur votre serveur SQL
- Lancer les serveurs Tomcat et MySQL
- Connectez vous à l'application via http://localhost:[portDeVotreServeur]/rando/
 