/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant un Type
 * @author simon
 */
@Entity
@Table(name = "type")
public class Type extends Item{
    @Id
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Type() {
        super();
    }
    
    /**
     * Constructeur de Type
     * @param id        Identifiant
     * @param nom       Nom du theme
     */
    public Type(int id, String nom) {
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
