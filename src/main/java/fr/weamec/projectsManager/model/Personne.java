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
    
    
}
