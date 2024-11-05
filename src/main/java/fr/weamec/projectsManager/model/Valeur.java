/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant une Valeur
 * @author simon
 */
@Entity
@Table(name = "valeurduprojet")
public class Valeur {
    @Id
    private int id;
    
    @Column(name = "id_projet")
    private int idProjet;
    
    @Column(name = "nom_valeur")
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Valeur() {}
    
    /**
     * Constructeur de Valeur
     * @param id        Identifiant
     * @param idProjet  Identifiant du Projet
     * @param nom       Nom de la valeur
     */
    public Valeur(int id, int idProjet, String nom) {
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
     * @return Nom de la valeur
     */
    public String getNom() {
        return nom;
    }

    /**
     * nom Setter
     * @param nom Nom de la valeur 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
