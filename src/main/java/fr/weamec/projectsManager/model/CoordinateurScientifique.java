/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

/**
 * Classe représentant un Coordinateut Scientifique d'un projet
 * @author simon
 */
public class CoordinateurScientifique extends Personne {
    private StructureRattachement structureRattachement;
    
    /**
     * Constructeur de CoordinateurScientifique
     * @author simon
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
     * @author simon
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
