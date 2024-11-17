/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant une Technologie
 * @author simon
 */
@Entity
@Table(name = "technologie")
public class Technologie extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Technologie() {
        super();
    }
    
    /**
     * Constructeur de Technologie
     * @param id        Identifiant
     * @param nom       Nom de la technologie
     */
    public Technologie(int id, String nom) {
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
