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
 * Interface d'un item
 * @author simon
 */
@MappedSuperclass
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   
    
    private int idProjet;
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Item() {}
    
    /**
     * Constructeur de Item
     * @param id        Identifiant
     * @param idProjet  Identifiant du Projet
     * @param nom       Nom du theme
     */
    public Item(int id, int idProjet, String nom) {
        this.id = id;
        this.idProjet = idProjet;
        this.nom = nom;
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
     * idProjet Getter
     * @return Identifiant du projet
     */
    public int getIdProjet() {
        return idProjet;
    }
    
    /**
     * idProjet Setter
     * @param idProjet Identifiant du projet 
     */
    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
    
    /**
     * nom Getter
     * @return Nom de l'item
     */
    public String getNom() {
        return nom;
    }

    /**
     * nom Setter
     * @param nom Nom de l'item 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
