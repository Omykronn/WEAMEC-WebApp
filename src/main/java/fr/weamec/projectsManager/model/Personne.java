/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

/**
 * Classe abstraire représentant une personnne
 * @author simon
 */
public abstract class Personne {
    private int id;    
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    
    /**
     * Constructeur de Personne
     * @param id        Identifiant
     * @param nom       Nom
     * @param prenom    Prenom
     * @param mail      Adresse mail
     * @param telephone Numero de telephone
     */
    public Personne(int id, String nom, String prenom, String mail, String telephone) {
        this.id = id;
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
