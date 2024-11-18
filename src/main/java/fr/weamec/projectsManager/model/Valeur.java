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
@Table(name = "valeur")
public class Valeur extends Item{
    @Id
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Valeur() {
        super();
    }
    
    /**
     * Constructeur de Valeur
     * @param id        Identifiant
     * @param nom       Nom de la valeur
     */
    public Valeur(int id, String nom) {
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
