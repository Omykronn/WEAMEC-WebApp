/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Classe représentant un Partenaire d'un projet
 * @author simon
 */
@Entity
@Table(name = "partenaire")
public class Partenaire extends Personne{
    @OneToOne
    @JoinColumn(name = "id_entite_rattachement", referencedColumnName = "id")
    private StructureRattachement structureRattachement;
    
    @Column(name = "id_projet")
    private int idProjet;
    
    /**
     * Constructeur par defaut
     */
    public Partenaire() {}
    
    /**
     * Constructeur de Partenaire
     * @param structureRattachement Structure de Rattachement
     * @param id                    Identifiant
     * @param idProjet              Identifiant du projet
     * @param nom                   Nom 
     * @param prenom                Prenom
     * @param mail                  Adresse mail
     * @param telephone             Numero de telephone
     */
    public Partenaire(StructureRattachement structureRattachement, int idProjet, int id, String nom, String prenom, String mail, String telephone) {
        super(id, nom, prenom, mail, telephone);
        this.structureRattachement = structureRattachement;
        this.idProjet = idProjet;
    }
    
    /**
     * structureRattachement Getter
     * @return Structure de Rattachement
     */
    public StructureRattachement getStructureRattachement() {
        return structureRattachement;
    }
    
    /**
     * structureRattachement Setter
     * @param structureRattachement Structure de Rattachement 
     */
    public void setStructureRattachement(StructureRattachement structureRattachement) {
        this.structureRattachement = structureRattachement;
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
}
