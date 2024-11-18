/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

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
    private String telephone;
    
    /**
     * Constructeur par defaut
     */
    public Personne() {}
    
    /**
     * Constructeur de Personne (sans id)
     * @param nom       Nom
     * @param prenom    Prenom
     * @param mail      Adresse mail
     * @param telephone Numero de telephone
     */
    public Personne(String nom, String prenom, String mail, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
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
    
    /**
     * telephone Getter
     * @return Numero de telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * telephone Setter
     * @param telephone Numero de telephone 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
