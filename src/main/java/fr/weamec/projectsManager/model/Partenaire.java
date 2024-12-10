/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.json.simple.JSONObject;

/**
 * Classe représentant un Partenaire d'un projet
 * @author simon
 */
@Entity
@Table(name = "partenaire")
public class Partenaire extends Personne{
    private String telephone;
    
    @OneToOne(cascade = CascadeType.ALL)
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
     * @param idProjet              Identifiant du projet
     * @param id                    Identifiant
     * @param nom                   Nom 
     * @param prenom                Prenom
     * @param mail                  Adresse mail
     * @param telephone             Numero de telephone
     */
    public Partenaire(StructureRattachement structureRattachement, int idProjet, int id, String nom, String prenom, String mail, String telephone) {
        super(id, nom, prenom, mail);
        this.telephone = telephone;
        this.structureRattachement = structureRattachement;
        this.idProjet = idProjet;
    }
    
    /**
     * Constructeur à partir d'un Objet JSON (id et idProjet ne sont pas à renseigner)
     * @param json Objet JSON
     */
    public Partenaire(JSONObject json) {
        super(json);
        this.telephone = (String) json.get("telephone");
        this.structureRattachement = new StructureRattachement((JSONObject) json.get("structureRattachement"));
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
    
    /**
     * telephone Getter
     * @return Numéro de téléphone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * telephone Setter
     * @param telephone Numéro de téléphone 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
