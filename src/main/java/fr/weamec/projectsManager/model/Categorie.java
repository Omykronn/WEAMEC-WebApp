/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant un Categorie
 * @author simon
 */
@Entity
@Table(name = "categorie")
public class Categorie extends Item{
    @Id
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Categorie() {
        super();
    }
    
    /**
     * Constructeur de Categorie
     * @param id        Identifiant
     * @param nom       Nom du theme
     */
    public Categorie(int id, String nom) {
        super(id, nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
