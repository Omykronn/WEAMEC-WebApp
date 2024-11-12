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
 * Classe représentant une Technologie
 * @author simon
 */
@Entity
@Table(name = "technoduprojet")
public class Technologie extends Item{
    @Id
    private int id;
    
    @Column(name = "id_projet")
    private int idProjet;
    
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
     * @param idProjet  Identifiant du Projet
     * @param nom       Nom de la technologie
     */
    public Technologie(int id, int idProjet, String nom) {
        super(id, idProjet, nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
