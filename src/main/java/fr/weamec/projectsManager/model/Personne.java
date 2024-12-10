/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.json.simple.JSONObject;

/**
 * Classe abstraire représentant une personnne
 * @author simon
 */
@MappedSuperclass
public abstract class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    
    private String nom;
    private String prenom;
    private String mail;
    
    /**
     * Constructeur par defaut
     */
    public Personne() {}
    
    /**
     * Constructeur de Personne
     * @param id        Identifiant
     * @param nom       Nom
     * @param prenom    Prenom
     * @param mail      Adresse mail
     */
    public Personne(int id, String nom, String prenom, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }
    
    /**
     * Constructeur à partir d'un Objet JSON (id n'est pas à renseigner)
     * @param json Objet JSON
     */
    public Personne(JSONObject json) {
        this.nom = (String) json.get("nom");
        this.prenom = (String) json.get("prenom");
        this.mail = (String) json.get("mail");
    }
    
    /**
     * id Getter
     * @return Identifiant
     */
    public int getId() {
        return id;
    }
    
    /**
     * id Setter
     * @param id Identifiant 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * nom Getter
     * @return Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * nom Setter
     * @param nom Nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * prenom Getter
     * @return Prenom
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * prenom Setter
     * @param prenom Prenom 
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    /**
     * mail Getter
     * @return Adresse mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * mail Setter
     * @param mail Adresse mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
}
