/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

/**
 * Classe représentant une structure de rattachement : organisme de recherche ou entreprise
 * @author simon
 */
public class StructureRattachement {    
    private int id;
    private String dir;
    private String etablissement;
    private String laboratoire;
    private String equipe;
    private String adresse;
    private String telephoneRef;
    private String mailRef;
    
    /**
     * id Getter
     * @author simon
     * @return Identifiant de la Structure de Rattachement
     */
    public int getId() {
        return id;
    }
    
    /**
     * id Setter
     * @author simon
     * @param id Identifiant de la Structure de Rattachement
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * directory Getter
     * @author simon
     * @return Chemin d'accès aux fichiers relatifs à la Structure de Rattachement
     */
    public String getDir() {
        return dir;
    }
    
    /**
     * directory Setter
     * @author simon
     * @param dir Chemin d'accès aux fichiers relatifs à la Structure de Rattachement
     */
    public void setDir(String dir) {
        this.dir = dir;
    }
    
    /**
     * etablissement Getter
     * @author simon
     * @return Nom de l'etablissement
     */
    public String getEtablissement() {
        return etablissement;
    }
    
    /**
     * etablissement Setter
     * @author simon
     * @param etablissement Nom de l'etablissement 
     */
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
    
    /**
     * laboratoire Getter
     * @author simon
     * @return Nom du Laboratoire
     */
    public String getLaboratoire() {
        return laboratoire;
    }
    
    /**
     * laboratoire Setter
     * @author simon
     * @param laboratoire Nom du Laboratoire 
     */
    public void setLaboratoire(String laboratoire) {
        this.laboratoire = laboratoire;
    }
    
    /**
     * equipe Getter
     * @author simon
     * @return Nom de l'equipe
     */
    public String getEquipe() {
        return equipe;
    }
    
    /**
     * equipe Setter
     * @author simon
     * @param equipe Nom de l'equipe    
     */
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    
    /**
     * adresse Getter
     * @author simon
     * @return Adresse de la Structure de Rattachement
     */
    public String getAdresse() {
        return adresse;
    }
    
    /**
     * adresse Setter
     * @author simon
     * @param adresse Adresse de la Structure de Rattachement 
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    /**
     * telephoneRef Getter
     * @author simon
     * @return Numero de Telephone du referent
     */
    public String getTelephoneRef() {
        return telephoneRef;
    }

    /**
     * telephoneRef Setter
     * @author simon
     * @param telephoneRef Numero de Telephone du referent 
     */
    public void setTelephoneRef(String telephoneRef) {
        this.telephoneRef = telephoneRef;
    }
    
    /**
     * mailRef Getter
     * @author simon
     * @return Adresse mail du referent
     */
    public String getMailRef() {
        return mailRef;
    }
    
    /**
     * mailRef Setter
     * @author simon
     * @param mailRef Adresse mail du referent
     */
    public void setMailRef(String mailRef) {
        this.mailRef = mailRef;
    }
}
