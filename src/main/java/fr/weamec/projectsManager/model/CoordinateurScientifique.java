/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Classe représentant un Coordinateut Scientifique d'un projet
 * @author simon
 */
@Entity
@Table(name = "coordinateurscientifique")
public class CoordinateurScientifique extends Personne {
    @OneToOne
    @JoinColumn(name = "id_structure", referencedColumnName = "id")
    private StructureRattachement structureRattachement;
    
    /**
     * Constructeur par defaut
     */
    public CoordinateurScientifique() {}
    
    /**
     * Constructeur de CoordinateurScientifique
     * @param structureRattachement Structure de Rattachement
     * @param id                    Identifiant
     * @param nom                   Nom 
     * @param prenom                Prenom
     * @param mail                  Adresse mail
     * @param telephone             Numero de telephone
     */
    public CoordinateurScientifique(StructureRattachement structureRattachement, int id, String nom, String prenom, String mail, String telephone) {
        super(id, nom, prenom, mail, telephone);
        this.structureRattachement = structureRattachement;
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
}
