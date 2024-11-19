/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.json.simple.JSONObject;

/**
 * Classe représentant un Expert associé à un projet
 * @author simon
 */
@Entity
@Table(name = "expert")
public class Expert extends Personne {
    @Column(name = "entite_rattachement")
    private String entiteRattachement;
    
    @Column(name = "laboratoire_rattachement")
    private String laboratoireRattachement;
    
    private String specialite;
    
    @Column(name = "idProjet")
    private int idProjet;
    
    /**
     * Constructeur par defaut
     */
    public Expert() {}
    
    /**
     * Constructeur de Expert
     * @param entiteRattachement        Nom de l'entite de rattachement
     * @param laboratoireRattachement   Nom du laboratoire de rattachement
     * @param specialite                Specialite de l'expert
     * @param idProjet                  Identifiant du projet
     * @param id                        Identifiant
     * @param nom                       Nom
     * @param prenom                    Prenom
     * @param mail                      Mail
     * @param telephone                 Telephone
     */
    public Expert(String entiteRattachement, String laboratoireRattachement, String specialite, int idProjet, int id, String nom, String prenom, String mail, String telephone) {
        super(id, nom, prenom, mail, telephone);
        this.idProjet = idProjet;
        this.entiteRattachement = entiteRattachement;
        this.laboratoireRattachement = laboratoireRattachement;
        this.specialite = specialite;
    }
    
    /**
     * Constructeur à partir d'un Objet JSON (id et idProjet ne sont pas à renseigner)
     * @param json Objet JSON
     */
    public Expert(JSONObject json) {
        super(json);
        this.entiteRattachement = (String) json.get("entiteRattachement");
        this.laboratoireRattachement = (String) json.get("laboratoireRattachement");
        this.specialite = (String) json.get("specialite");
    }
    
    /**
     * entiteRattachement Getter
     * @return Nom de l'entite de rattachement
     */
    public String getEntiteRattachement() {
        return entiteRattachement;
    }
    
    /**
     * entiteRattachement Setter
     * @param entiteRattachement Nom de l'entite de rattachement
     */
    public void setEntiteRattachement(String entiteRattachement) {
        this.entiteRattachement = entiteRattachement;
    }
    
    /**
     * laboratoireRattachement Getter
     * @return Nom du laboratoire de rattachement
     */
    public String getLaboratoireRattachement() {
        return laboratoireRattachement;
    }
    
    /**
     * laboratoireRattachement Setter
     * @param laboratoireRattachement Nom du laboratoire de rattachement
     */
    public void setLaboratoireRattachement(String laboratoireRattachement) {
        this.laboratoireRattachement = laboratoireRattachement;
    }
    
    /**
     * specialite Getter
     * @return Specialite de l'expert
     */
    public String getSpecialite() {
        return specialite;
    }
    
    /**
     * specialite Setter
     * @param specialite Specialite de l'expert 
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
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
