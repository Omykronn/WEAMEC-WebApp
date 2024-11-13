/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant un Objectif
 * @author simon
 */
@Entity
@Table(name = "objectif")
public class Objectif extends Item{
    @Id
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Objectif() {
        super();
    }
    
    /**
     * Constructeur de Objectif
     * @param id        Identifiant
     * @param nom       Nom du objectif
     */
    public Objectif(int id, String nom) {
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
