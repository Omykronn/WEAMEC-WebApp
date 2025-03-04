/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.json.simple.JSONObject;

/**
 * Classe représentant un Coordinateut Scientifique d'un projet
 * @author simon
 */
@Entity
@Table(name = "coordinateurscientifique")
public class CoordinateurScientifique extends Personne {
    private String telephoneFixe;
    private String telephonePort;
    
    @OneToOne(cascade = CascadeType.ALL)
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
     * @param telephoneFixe          Numero de telephone fixe
     * @param telephonePort         Numéro de téléphone portable
     */
    public CoordinateurScientifique(StructureRattachement structureRattachement, int id, String nom, String prenom, String mail, String telephoneFixe, String telephonePort) {
        super(id, nom, prenom, mail);
        this.telephoneFixe = telephoneFixe;
        this.telephonePort = telephonePort;
        this.structureRattachement = structureRattachement;
    }
    
    /**
     * Constructeur à partir d'un Objet JSON (id n'est pas à renseigner)
     * @param json Objet JSON
     */
    public CoordinateurScientifique(JSONObject json) {
        super(json);
        this.telephoneFixe = (String) json.get("telFixe");
        this.telephonePort = (String) json.get("telPort");
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
     * telephoneFixe Getter
     * @return Numéro de téléphone fixe
     */
    public String getTelephoneFixe() {
        return telephoneFixe;
    }
    
    /**
     * telephoneFixe Setter
     * @param telephoneFixe Numéro de téléphone fixe 
     */
    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }
    
    /**
     * telephonePort Getter
     * @return Numéro de téléphone portable
     */
    public String getTelephonePort() {
        return telephonePort;
    }
    
    /**
     * telephonePort Setter
     * @param telephonePort Numéro de téléphone portable 
     */
    public void setTelephonePort(String telephonePort) {
        this.telephonePort = telephonePort;
    }
    
}
