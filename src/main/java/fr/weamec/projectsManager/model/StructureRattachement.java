/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe représentant une structure de rattachement : organisme de recherche ou entreprise
 * @author simon
 */
@Entity
@Table(name = "structurerattachement")
public class StructureRattachement { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String dir;
    private String etablissement;
    private String laboratoire;
    private String equipe;
    private String adresse;
    
    @Column(name = "telephone_ref")
    private String telephoneRef;
    
    @Column(name = "mail_ref")
    private String mailRef;
   
    /**
     * Constructeur par defaut
     */
    public StructureRattachement() {}
    
    /**
     * Constructeur de StructureRattachement
     * @param id            Identifiant
     * @param dir           Chemin d'accès aux fichiers
     * @param etablissement Nom de l'etablissement
     * @param laboratoire   Nom du laboratoire
     * @param equipe        Nom de l'equipe
     * @param adresse       Adresse postale
     * @param telephoneRef  Numero de Telephone
     * @param mailRef       Adresse mail
     */
    public StructureRattachement(int id, String dir, String etablissement, String laboratoire, String equipe, String adresse, String telephoneRef, String mailRef) {
        this.id = id;
        this.dir = dir;
        this.etablissement = etablissement;
        this.laboratoire = laboratoire;
        this.equipe = equipe;
        this.adresse = adresse;
        this.telephoneRef = telephoneRef;
        this.mailRef = mailRef;
    }
    
    /**
     * id Getter
     * @return Identifiant de la Structure de Rattachement
     */
    public int getId() {
        return id;
    }
    
    /**
     * id Setter
     * @param id Identifiant de la Structure de Rattachement
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * directory Getter
     * @return Chemin d'accès aux fichiers relatifs à la Structure de Rattachement
     */
    public String getDir() {
        return dir;
    }
    
    /**
     * directory Setter
     * @param dir Chemin d'accès aux fichiers relatifs à la Structure de Rattachement
     */
    public void setDir(String dir) {
        this.dir = dir;
    }
    
    /**
     * etablissement Getter
     * @return Nom de l'etablissement
     */
    public String getEtablissement() {
        return etablissement;
    }
    
    /**
     * etablissement Setter
     * @param etablissement Nom de l'etablissement 
     */
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
    
    /**
     * laboratoire Getter
     * @return Nom du Laboratoire
     */
    public String getLaboratoire() {
        return laboratoire;
    }
    
    /**
     * laboratoire Setter
     * @param laboratoire Nom du Laboratoire 
     */
    public void setLaboratoire(String laboratoire) {
        this.laboratoire = laboratoire;
    }
    
    /**
     * equipe Getter
     * @return Nom de l'equipe
     */
    public String getEquipe() {
        return equipe;
    }
    
    /**
     * equipe Setter
     * @param equipe Nom de l'equipe    
     */
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    
    /**
     * adresse Getter
     * @return Adresse de la Structure de Rattachement
     */
    public String getAdresse() {
        return adresse;
    }
    
    /**
     * adresse Setter
     * @param adresse Adresse de la Structure de Rattachement 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    /**
     * telephoneRef Getter
     * @return Numero de Telephone du referent
     */
    public String getTelephoneRef() {
        return telephoneRef;
    }

    /**
     * telephoneRef Setter
     * @param telephoneRef Numero de Telephone du referent 
     */
    public void setTelephoneRef(String telephoneRef) {
        this.telephoneRef = telephoneRef;
    }
    
    /**
     * mailRef Getter
     * @return Adresse mail du referent
     */
    public String getMailRef() {
        return mailRef;
    }
    
    /**
     * mailRef Setter
     * @param mailRef Adresse mail du referent
     */
    public void setMailRef(String mailRef) {
        this.mailRef = mailRef;
    }
}
