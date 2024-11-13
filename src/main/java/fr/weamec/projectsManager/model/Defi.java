/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant un Defi
 * @author simon
 */
@Entity
@Table(name = "defi")
public class Defi extends Item{
    @Id
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Defi() {
        super();
    }
    
    /**
     * Constructeur de Defi
     * @param id        Identifiant
     * @param nom       Nom du theme
     */
    public Defi(int id, String nom) {
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
