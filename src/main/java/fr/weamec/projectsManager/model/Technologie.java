/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant une Technologie
 * @author simon
 */
@Entity
@Table(name = "technologie")
public class Technologie {
    @Id
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Technologie() {}
    
    /**
     * Constructeur de Technologie
     * @param nom Nom de la technologie
     */
    public Technologie(String nom) {
        this.nom = nom;
    }
    
    /**
     * nom Getter
     * @return Nom de la technologie
     */
    public String getNom() {
        return nom;
    }

    /**
     * nom Setter
     * @param nom Nom de la technologie 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
