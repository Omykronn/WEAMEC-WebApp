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
 * Classe représentant un Theme
 * @author simon
 */
@Entity
@Table(name = "themeduprojet")
public class Theme extends Item{
    @Id
    private int id;
    
    @Column(name = "id_projet")
    private int idProjet;
    
    @Column(name = "nom_theme")
    private String nom;
    
    /**
     * Constructeur par defaut
     */
    public Theme() {
        super();
    }
    
    /**
     * Constructeur de Theme
     * @param id        Identifiant
     * @param idProjet  Identifiant du Projet
     * @param nom       Nom du theme
     */
    public Theme(int id, int idProjet, String nom) {
        super(id, idProjet, nom);
    }
}
