Pour installer le logiciel de gestion des projets WEAMEC, copier les fichiers du dossier app vers le dossier du serveur choisi pour stocker les données de l'application, avec un serveur PostgreSQL initialisé avec le script script_creation.sql.
Puis, pour démarrer l'application : 
    
    1. Ouvrir un terminal
    2. Se déplacer vers le dossier qui contient les fichiers du logiciel
    3. Executer la commande "javac -jar projectsManager-1.0.jar"

La configuration actuelle à la suivante : 

    - Port utilisé : 3306
    - Utilisateur Postgresql : weamec
    - Mot de passe Postgresql : **********
    - Nom de la BDD : weamec
    - Dossier de stockage : /var/local/weamec

Si besoin, la configuration peut être modifiée en recompilant le code source après avoir modifié le fichier application.properties dans le dossier des ressources. L'ensemble du code source est disponible sur GitHub : 

    https://github.com/Omykronn/WEAMEC-WebApp

