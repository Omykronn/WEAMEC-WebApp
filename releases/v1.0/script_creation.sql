
CREATE TABLE Users (
		id SERIAL NOT NULL,
		username VARCHAR(256),
		password VARCHAR(256),
		role VARCHAR(16),
		CONSTRAINT user_pk PRIMARY KEY (id)
);

INSERT INTO Users VALUES (1, 'admin', '$2y$10$8UwkixWDWx1Nvg3CpYLSTuXaepXKgs2vJ9TrFUOOucHnK/0Z1Zef2', 'ADMIN');


CREATE TABLE Priorite (
		id SERIAL NOT NULL,
                nom VARCHAR(512) NOT NULL,
                CONSTRAINT priorite_pk PRIMARY KEY (id)
);


CREATE TABLE Objectif (
		id SERIAL NOT NULL,
                nom VARCHAR(256) NOT NULL,
                CONSTRAINT objectif_pk PRIMARY KEY (id)
);


CREATE TABLE Defi (
		id SERIAL NOT NULL,
                nom VARCHAR(512) NOT NULL,
                CONSTRAINT defi_pk PRIMARY KEY (id)
);


CREATE TABLE StructureRattachement (
                id SERIAL NOT NULL,
                etablissement VARCHAR(64) NOT NULL,
                laboratoire VARCHAR(64) NOT NULL,
                equipe VARCHAR(64) NOT NULL,
                adresse VARCHAR(256) NOT NULL,
                ville VARCHAR(128) NOT NULL,
                code_postal INTEGER NOT NULL,
                nom_ref VARCHAR(64) NOT NULL,
                telephone_ref VARCHAR(32) NOT NULL,
                mail_ref VARCHAR(64) NOT NULL,
                CONSTRAINT structurerattachement_pk PRIMARY KEY (id)
);


CREATE TABLE CoordinateurScientifique (
                id SERIAL NOT NULL,
                nom VARCHAR(32) NOT NULL,
                prenom VARCHAR(32) NOT NULL,
                mail VARCHAR(64) NOT NULL,
                telephone_fixe VARCHAR(32) NOT NULL,
                telephone_port VARCHAR(32) NOT NULL,
                id_structure INTEGER NOT NULL,
                CONSTRAINT coordinateurscientifique_pk PRIMARY KEY (id)
);


CREATE TABLE Theme (
		id SERIAL NOT NULL,
                nom VARCHAR NOT NULL,
                CONSTRAINT theme_pk PRIMARY KEY (id)
);


CREATE TABLE Valeur (
		id SERIAL NOT NULL,
                nom VARCHAR NOT NULL,
                CONSTRAINT valeur_pk PRIMARY KEY (id)
);


CREATE TABLE Technologie (
		id SERIAL NOT NULL,
                nom VARCHAR NOT NULL,
                CONSTRAINT technologie_pk PRIMARY KEY (id)
);


CREATE TABLE Type (
		id SERIAL NOT NULL,
                nom VARCHAR(32) NOT NULL,
                CONSTRAINT type_pk PRIMARY KEY (id)
);


CREATE TABLE Categorie (
		id SERIAL NOT NULL,
                nom VARCHAR(64) NOT NULL,
                CONSTRAINT categorie_pk PRIMARY KEY (id)
);


CREATE TABLE Projet (
                id SERIAL NOT NULL,
                annee_selection INTEGER NOT NULL,
                debut_traitement DATE NOT NULL,
                traitement_fini BOOLEAN NOT NULL,
                fin_traitement DATE NOT NULL,
                id_coordinateur INTEGER NOT NULL,
                nom_acro VARCHAR(32) NOT NULL,
                nom_complet VARCHAR(64) NOT NULL,
                id_categorie INTEGER NOT NULL,
                id_type INTEGER NOT NULL,
                objectif_synth VARCHAR(128) NOT NULL,
                site_web VARCHAR(128),
                duree INTEGER NOT NULL,
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                description VARCHAR(10000) NOT NULL,
                objectif VARCHAR(256) NOT NULL,
                verrous_scientif VARCHAR(256) NOT NULL,
                programme_exp VARCHAR(256) NOT NULL,
                moyens_essai VARCHAR(256) NOT NULL,
                demonstrateur VARCHAR(256) NOT NULL,
                rupture_scient VARCHAR(256) NOT NULL,
                impact_tech VARCHAR(256) NOT NULL,
                impact_eco VARCHAR(256) NOT NULL,
                impact_env VARCHAR(256) NOT NULL,
                impact_soc VARCHAR(256) NOT NULL,
                trl_debut INTEGER NOT NULL,
                trl_fin INTEGER NOT NULL,
                brevet BOOLEAN NOT NULL,
                description_partenariat VARCHAR	(1024) NOT NULL,
                CONSTRAINT projet_pk PRIMARY KEY (id)
);


CREATE TABLE PrioriteDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE ObjectifDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE DefiDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE ThemeDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE ValeurDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE TechnoDuProjet (
                id_projet INTEGER NOT NULL,
                id_item INTEGER NOT NULL
);


CREATE TABLE Partenaire (
                id SERIAL NOT NULL,
                id_projet INTEGER NOT NULL,
                nom VARCHAR(32) NOT NULL,
                prenom VARCHAR(32) NOT NULL,
                telephone VARCHAR(32) NOT NULL,
                id_entite_rattachement INTEGER NOT NULL,
                mail VARCHAR(64) NOT NULL,
                CONSTRAINT partenaire_pk PRIMARY KEY (id)
);


CREATE TABLE Expert (
                id SERIAL NOT NULL,
                id_projet INTEGER NOT NULL,
                nom VARCHAR(32) NOT NULL,
                prenom VARCHAR(32) NOT NULL,
                entite_rattachement VARCHAR(64) NOT NULL,
                laboratoire_rattachement VARCHAR(64) NOT NULL,
                specialite VARCHAR(32) NOT NULL,
                mail VARCHAR(64) NOT NULL,
                CONSTRAINT expert_pk PRIMARY KEY (id)
);

ALTER TABLE PrioriteDuProjet ADD CONSTRAINT propr_prioriteduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Priorite (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ObjectifDuProjet ADD CONSTRAINT objectif_objectifduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Objectif (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE DefiDuProjet ADD CONSTRAINT defi_defiduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Defi (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Partenaire ADD CONSTRAINT entiterattachement_partenaire_fk
FOREIGN KEY (id_entite_rattachement)
REFERENCES StructureRattachement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE CoordinateurScientifique ADD CONSTRAINT structurerattachement_coordinateurscientifique_fk
FOREIGN KEY (id_structure)
REFERENCES StructureRattachement (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Projet ADD CONSTRAINT coordinateurscientifique_projet_fk
FOREIGN KEY (id_coordinateur)
REFERENCES CoordinateurScientifique (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ThemeDuProjet ADD CONSTRAINT theme_themeduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Theme (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ValeurDuProjet ADD CONSTRAINT valeur_valeurduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Valeur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE TechnoDuProjet ADD CONSTRAINT technologie_technoduprojet_fk
FOREIGN KEY (id_item)
REFERENCES Technologie (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Projet ADD CONSTRAINT type_projet_fk
FOREIGN KEY (id_type)
REFERENCES Type (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Projet ADD CONSTRAINT categorie_projet_fk
FOREIGN KEY (id_categorie)
REFERENCES Categorie (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Expert ADD CONSTRAINT projet_expert_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE Partenaire ADD CONSTRAINT projet_partenaire_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE TechnoDuProjet ADD CONSTRAINT projet_technoduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ValeurDuProjet ADD CONSTRAINT projet_valeurduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ThemeDuProjet ADD CONSTRAINT projet_themeduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PrioriteDuProjet ADD CONSTRAINT projet_prioriteduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE DefiDuProjet ADD CONSTRAINT projet_defiduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE ObjectifDuProjet ADD CONSTRAINT projet_objectifduprojet_fk
FOREIGN KEY (id_projet)
REFERENCES Projet (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Filling

INSERT INTO Categorie(nom)
VALUES ('WEAMEC Recherche Région'),
	('WEAMEC Recherche Internationale'),
	('Matériel');
	
INSERT INTO Type(nom)
VALUES ('Emergence'), ('Challenge'), ('Défi'), ('Matériel');

INSERT INTO Priorite(nom)
VALUES ('1 : Accompagner le développement du territoire et de ses acteurs dans le domaine des EMR'),
	('2 : Soutenir les partenaires académiques ou les centres de recherche industriels du territoire');
	
INSERT INTO Objectif(nom)
VALUES ('1 : Réduire le LCOE'),
	('2 : Favoriser l''hybridation'),
	('3 : Faire progresser les systèmes émergents'),
	('4 : Accompagner la filière dans un développement durable et accepté');
	
INSERT INTO Defi(nom)
VALUES ('1 : Favoriser l''acceptabilité des EMR et de développer des modèles économiques novateurs de déploiement'),
	('2 : Imaginer, construire et tester des méthodes outillées d''étude et de surveillance de l''environnement marin'),
	('3 : Renforcer le socle scientifique, les méthodes d''analyses et travailler sur les briques technologiques et les méthodes industrielles qui permettront le développement opérationnel et compétitif de l''éolien flottant'),
	('4 : Développer des outils, des méthodes et des savoirs faire pour optimiser la maintenance et les opérations offshore au service des installations EMR'),
	('5 : Proposer et évaluer des méthodes, composants et technologies durables au profit de la filière des EMR'), 
	('6 : Soutenir les développements, les tests et le déploiement de systèmes EMR émergents'),
	('7 : Accompagner les travaux, dispositifs et systèmes permettant le couplage de différentes sources d''énergies, le stockage, la production de carburants "verts" et l''optimisation de l''injection sur le réseau');
	
INSERT INTO Theme(nom)
VALUES ('Génie océanique'),
	('Génie civil & matériaux'),
	('Génie électrique'),
	('Ressource & environnement naturel'),
	('Droit / Economie / Sécurité / Société');
	
INSERT INTO Technologie(nom)
VALUES ('Eolien posé'),
	('Eolien flottant'),
	('Hydrolien'),
	('Houlomoteur'),
	('Energie Thermique des Mers'),
	('Osmotique'),
	('Solaire'),
	('Toutes EMR');

INSERT INTO Valeur(nom)
VALUES ('Caractérisation des sites et études environnementales'),
	('Ingénierie des parcs'),
	('Ingénierie des machines / du réseau énergétique'),
	('Ingénierie de fabrication / transport / installation'),
	('Fabrication'),
	('Installation en mer / Certification / Mise en service'),
	('Exploitation / Maintenance / SHM'),
	('Sécurité / Sûreté'),
	('Démantèlement et Recyclage'),
	('Services support');

-- Privileges

GRANT ALL ON ALL TABLES IN SCHEMA public TO weamec;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO weamec;
