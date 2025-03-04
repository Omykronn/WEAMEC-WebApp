/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;

/**
 * Classe représentant un projet 
 * @author simon
 */
@Entity
@Table(name = "projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "annee_selection")
    private int anneeSelection;
    
    @Column(name = "debut_traitement")
    private Date debutTraitement;
    
    @Column(name ="traitement_fini")
    private boolean traitementFini;
    
    @Column(name = "fin_traitement")
    private Date finTraitement;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coordinateur", referencedColumnName = "id")
    private CoordinateurScientifique coordinateurScientifique;
    
    @Column(name = "nom_acro")
    private String nomAcro;
    
    @Column(name = "nom_complet")
    private String nomComplet;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id")
    private Categorie categorie;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private Type type;
    
    @Column(name = "objectif_synth")
    private String objectifSynth;
    
    @Column(name = "site_web")
    private String siteWeb;
    
    private int duree;
    
    @Column(name = "date_debut")
    private Date dateDebut;
    
    @Column(name = "date_fin")
    private Date dateFin;
    
    private String description;
    private String objectif;
    
    @Column(name = "verrous_scientif")
    private String verrousScientif;
    
    @Column(name = "programme_exp")
    private String programmeExp;
    
    @Column(name = "moyens_essai")
    private String moyensEssai;
    
    private String demonstrateur;
    
    @Column(name = "rupture_scient")
    private String ruptureScient;
    
    @Column(name = "impact_tech")
    private String impactTech;
    
    @Column(name = "impact_eco")
    private String impactEco;
    
    @Column(name = "impact_env")
    private String impactEnv;
    
    @Column(name = "impact_soc")
    private String impactSoc;
    
    @Column(name = "trl_debut")
    private int trlDebut;
    
    @Column(name = "trl_fin")
    private int trlFin;
    
    private boolean brevet;
    
    private String descriptionPartenariat;
    
    @OneToMany(mappedBy = "idProjet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Partenaire> listePartenaires;
    
    @OneToMany(mappedBy = "idProjet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Expert> listeExperts;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "technoduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Technologie> technologies;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "valeurduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Valeur> valeurs;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "themeduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Theme> themes;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "objectifduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Objectif> objectifsWeamec;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "defiduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Defi> defisWeamec;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "prioriteduprojet",
            joinColumns = @JoinColumn(name = "id_projet"),
            inverseJoinColumns = @JoinColumn(name = "id_item")
            )
    private List<Priorite> prioriteWeamec;
    
    /**
     * Constructeur par defaut
     */
    public Projet() {}
    
    /**
     * Constructeur de Projet (sans id)
     * @param anneeSelection            Annee de Sélection
     * @param debutTraitement           Date de début du traitement du dossier
     * @param traitementFini            Booléen si traitement fini
     * @param finTraitement             Date de fin du traitement du dossier
     * @param coordinateurScientifique  Coordinateur Scientifique du projet
     * @param nomAcro                   Acronyme du nom du projet
     * @param nomComplet                Nom Complet du Projet
     * @param categorie                 Categorie WEAMEC
     * @param type                      Type de projet
     * @param objectifSynth             Objectif synthetise
     * @param siteWeb                   URL du site web
     * @param duree                     Duree en mois
     * @param dateDebut                 Date de debut
     * @param dateFin                   Date de fin
     * @param description               Description du projet
     * @param objectif                  Objectifs du projet
     * @param verrousScientif           Verrous Scientifiques
     * @param programmeExp              Programme Experimental
     * @param moyensEssai               Moyens d'essais
     * @param demonstrateur             Demonstrateur
     * @param ruptureScient             Ruptures Scientifiques
     * @param impactTech                Impacts Technologiques
     * @param impactEco                 Impacts Economiques
     * @param impactEnv                 Impacts Environnementaux
     * @param impactSoc                 Impacts Sociétaux
     * @param technologies              Liste des technologies du projet
     * @param trlDebut                  TRL au début
     * @param trlFin                    TRL à la fin
     * @param brevet                    Brevet vise
     * @param descriptionPartenariat    Description du partenariat entre les acteurs du projet
     * @param prioriteWeamec            Priorite WEAMEC
     * @param objectifsWeamec           Objectifs WEAMEC
     * @param defisWeamec               Defis WEAMEC
     * @param valeurs                   Valeurs du projet
     * @param themes                    Themes du projet
     * @param listePartenaires          Liste des partenaires du projet
     * @param listeExperts              Liste des experts du projet
     */
    public Projet(int anneeSelection, Date debutTraitement, boolean traitementFini, Date finTraitement, CoordinateurScientifique coordinateurScientifique, String nomAcro, String nomComplet, Categorie categorie, Type type, String objectifSynth, String siteWeb, int duree, Date dateDebut, Date dateFin, String description, String objectif, String verrousScientif, String programmeExp, String moyensEssai, String demonstrateur, String ruptureScient, String impactTech, String impactEco, String impactEnv, String impactSoc, List<Technologie> technologies, int trlDebut, int trlFin, boolean brevet, String descriptionPartenariat, List<Priorite> prioriteWeamec, List<Objectif> objectifsWeamec, List<Defi> defisWeamec, List<Valeur> valeurs, List<Theme> themes, List<Partenaire> listePartenaires, List<Expert> listeExperts) {
        this.anneeSelection = anneeSelection;
        this.debutTraitement = debutTraitement;
        this.traitementFini = traitementFini;
        this.finTraitement = finTraitement;
        this.coordinateurScientifique = coordinateurScientifique;
        this.nomAcro = nomAcro;
        this.nomComplet = nomComplet;
        this.categorie = categorie;
        this.type = type;
        this.objectifSynth = objectifSynth;
        this.siteWeb = siteWeb;
        this.duree = duree;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.objectif = objectif;
        this.verrousScientif = verrousScientif;
        this.programmeExp = programmeExp;
        this.moyensEssai = moyensEssai;
        this.demonstrateur = demonstrateur;
        this.ruptureScient = ruptureScient;
        this.impactTech = impactTech;
        this.impactEco = impactEco;
        this.impactEnv = impactEnv;
        this.impactSoc = impactSoc;
        this.technologies = technologies;
        this.trlDebut = trlDebut;
        this.trlFin = trlFin;
        this.brevet = brevet;
        this.descriptionPartenariat = descriptionPartenariat;
        this.prioriteWeamec = prioriteWeamec;
        this.objectifsWeamec = objectifsWeamec;
        this.defisWeamec = defisWeamec;
        this.valeurs = valeurs;
        this.themes = themes;
        this.listePartenaires = listePartenaires;
        this.listeExperts = listeExperts;
    }
    
    /**
     * id Getter
     * @return Identifiant
     */
    public int getId() {
        return id;
    }

    /**
     * id Setter
     * @param id Identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * coordinateurScientifique Getter
     * @return Coordinateur Scientifique du projet
     */
    public CoordinateurScientifique getCoordinateurScientifique() {
        return coordinateurScientifique;
    }

    /**
     * coordinateurScientifique Setter
     * @param coordinateurScientifique Coordinateur Scientifique du projet
     */
    public void setCoordinateurScientifique(CoordinateurScientifique coordinateurScientifique) {
        this.coordinateurScientifique = coordinateurScientifique;
    }

    /**
     * anneeSelection Getter
     * @return Année de sélection
     */
    public int getAnneeSelection() {
        return anneeSelection;
    }
    
    /**
     * anneeSelection Setter
     * @param anneeSelection Année de sélection 
     */
    public void setAnneeSelection(int anneeSelection) {
        this.anneeSelection = anneeSelection;
    }

    /**
     * debutTraitement Getter
     * @return Date de début du traitement du dossier
     */
    public Date getDebutTraitement() {
        return debutTraitement;
    }

    /**
     * debutTraitement Setter
     * @param debutTraitement Date de début du traitement du dossier 
     */
    public void setDebutTraitement(Date debutTraitement) {
        this.debutTraitement = debutTraitement;
    }
    
    /**
     * traitementFini Getter
     * @return Booléen si le traitement est fini
     */
    public boolean getTraitementFini() {
        return traitementFini;
    }
    
    /**
     * traitementFini Setter
     * @param traitementFini Booléen si le traitement est fini
     */
    public void setTraitementFini(boolean traitementFini) {
        this.traitementFini = traitementFini;
    }
    
    /**
     * finTraitement Getter
     * @return Date de fin du traitement du dossier
     */
    public Date getFinTraitement() {
        return finTraitement;
    }
    
    /**
     * finTraitement Setter
     * @param finTraitement Date de fin du traitement du dossier 
     */
    public void setFinTraitement(Date finTraitement) {
        this.finTraitement = finTraitement;
    }

    /**
     * nomAcro Getter
     * @return Acronyme du nom du projet
     */
    public String getNomAcro() {
        return nomAcro;
    }

    /**
     * nomAcro Setter
     * @param nomAcro Acronyme du nom du projet
     */
    public void setNomAcro(String nomAcro) {
        this.nomAcro = nomAcro;
    }

    /**
     * nomComplet Getter
     * @return Nom complet du projet
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * nomComplet Setter
     * @param nomComplet Nom complet du projet
     */
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    /**
     * categorie Getter
     * @return Categorie WEAMEC
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * categorie Setter
     * @param categorie Categorie WEAMEC
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * type Getter
     * @return Type de projet
     */
    public Type getType() {
        return type;
    }

    /**
     * type Setter
     * @param type Type de projet
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * objectifSynth Getter
     * @return Objectif synthetise
     */
    public String getObjectifSynth() {
        return objectifSynth;
    }

    /**
     * objectifSynth Setter
     * @param objectifSynth Objectif synthetise
     */
    public void setObjectifSynth(String objectifSynth) {
        this.objectifSynth = objectifSynth;
    }

    /**
     * siteWeb Getter
     * @return URL du site web
     */
    public String getSiteWeb() {
        return siteWeb;
    }

    /**
     * siteWeb Setter
     * @param siteWeb URL du site web
     */
    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    /**
     * duree Getter
     * @return Duree en mois
     */
    public int getDuree() {
        return duree;
    }

    /**
     * duree Setter
     * @param duree Duree en mois
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * dateDebut Getter
     * @return Date de debut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * dateDebut Setter
     * @param dateDebut Date de debut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * dateFin Getter
     * @return Date de fin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * dateFin Setter
     * @param dateFin Date de fin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * description Getter
     * @return Description du projet
     */
    public String getDescription() {
        return description;
    }

    /**
     * description Setter
     * @param description Description du projet
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * objectif Getter
     * @return Objectifs du projet
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * objectif Setter
     * @param objectif Objectifs du projet
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    /**
     * verrousScientif Getter
     * @return Verrous Scientifiques
     */
    public String getVerrousScientif() {
        return verrousScientif;
    }

    /**
     * verrousScientif Setter
     * @param verrousScientif Verrous Scientifiques
     */
    public void setVerrousScientif(String verrousScientif) {
        this.verrousScientif = verrousScientif;
    }

    /**
     * programmeExp Getter
     * @return Programme experimental
     */
    public String getProgrammeExp() {
        return programmeExp;
    }

    /**
     * programmeExp Setter
     * @param programmeExp Programme experimental
     */
    public void setProgrammeExp(String programmeExp) {
        this.programmeExp = programmeExp;
    }

    /**
     * moyensEssai Getter
     * @return Moyens d'essais
     */
    public String getMoyensEssai() {
        return moyensEssai;
    }

    /**
     * moyensEssai Setter
     * @param moyensEssai Moyens d'essais
     */
    public void setMoyensEssai(String moyensEssai) {
        this.moyensEssai = moyensEssai;
    }

    /**
     * demonstrateur Getter
     * @return Demonstrateur
     */
    public String getDemonstrateur() {
        return demonstrateur;
    }

    /**
     * demonstrateur Setter
     * @param demonstrateur Demonstrateur
     */
    public void setDemonstrateur(String demonstrateur) {
        this.demonstrateur = demonstrateur;
    }

    /**
     * ruptureScient Getter
     * @return Ruptures Scientifiques
     */
    public String getRuptureScient() {
        return ruptureScient;
    }

    /**
     * ruptureScient Setter
     * @param ruptureScient Ruptures Scientifiques
     */
    public void setRuptureScient(String ruptureScient) {
        this.ruptureScient = ruptureScient;
    }

    /**
     * impactTech Getter
     * @return Impacts Technologiques
     */
    public String getImpactTech() {
        return impactTech;
    }

    /**
     * impactTech Setter
     * @param impactTech Impacts Technologiques
     */
    public void setImpactTech(String impactTech) {
        this.impactTech = impactTech;
    }

    /**
     * impactEco Getter
     * @return Impacts Economiques
     */
    public String getImpactEco() {
        return impactEco;
    }

    /**
     * impactEco Setter
     * @param impactEco Impacts Economiques
     */
    public void setImpactEco(String impactEco) {
        this.impactEco = impactEco;
    }

    /**
     * impactEnv Getter
     * @return Impacts Environnementaux
     */
    public String getImpactEnv() {
        return impactEnv;
    }

    /**
     * impactEnv Setter
     * @param impactEnv Impacts Environnementaux
     */
    public void setImpactEnv(String impactEnv) {
        this.impactEnv = impactEnv;
    }

    /**
     * impactSoc Getter
     * @return Impacts Sociétaux
     */
    public String getImpactSoc() {
        return impactSoc;
    }

    /**
     * impactSoc Setter
     * @param impactSoc Impacts Sociétaux
     */
    public void setImpactSoc(String impactSoc) {
        this.impactSoc = impactSoc;
    }

    /**
     * technologies Getter
     * @return Liste des technologies du projet
     */
    public List<Technologie> getTechnologies() {
        return technologies;
    }

    /**
     * technologies Setter
     * @param technologies Liste des technologies du projet
     */
    public void setTechnologies(List<Technologie> technologies) {
        this.technologies = technologies;
    }

    /**
     * trlDebut Getter
     * @return TRL au début
     */
    public int getTrlDebut() {
        return trlDebut;
    }

    /**
     * trlDebut Setter
     * @param trlDebut TRL au début
     */
    public void setTrlDebut(int trlDebut) {
        this.trlDebut = trlDebut;
    }

    /**
     * trlFin Getter
     * @return TRL à la fin
     */
    public int getTrlFin() {
        return trlFin;
    }

    /**
     * trlFin Setter
     * @param trlFin TRL à la fin
     */
    public void setTrlFin(int trlFin) {
        this.trlFin = trlFin;
    }

    /**
     * brevet Getter
     * @return Brevet vise
     */
    public boolean getBrevet() {
        return brevet;
    }

    /**
     * brevet Setter
     * @param brevet Brevet vise
     */
    public void setBrevet(boolean brevet) {
        this.brevet = brevet;
    }
    
    /**
     * descriptionPartenariat Getter
     * @return Description du partenariat avec les acteurs du projet
     */
    public String getDescriptionPartenariat() {
        return descriptionPartenariat;
    }

    /**
     * descriptionPartenariat Setter
     * @param descriptionPartenariat Description du partenariat avec les acteurs du projet 
     */
    public void setDescriptionPartenariat(String descriptionPartenariat) {
        this.descriptionPartenariat = descriptionPartenariat;
    }
    
    /**
     * prioriteWeamec Getter
     * @return Priorite WEAMEC
     */
    public List<Priorite> getPrioriteWeamec() {
        return prioriteWeamec;
    }

    /**
     * prioriteWeamec Setter
     * @param prioriteWeamec Priorite WEAMEC
     */
    public void setPrioriteWeamec(List<Priorite> prioriteWeamec) {
        this.prioriteWeamec = prioriteWeamec;
    }

    /**
     * objectifsWeamec Getter
     * @return Objectifs WEAMEC
     */
    public List<Objectif> getObjectifsWeamec() {
        return objectifsWeamec;
    }

    /**
     * objectifsWeamec Setter
     * @param objectifsWeamec Objectifs WEAMEC
     */
    public void setObjectifsWeamec(List<Objectif> objectifsWeamec) {
        this.objectifsWeamec = objectifsWeamec;
    }

    /**
     * defisWeamec Getter
     * @return Defis WEAMEC
     */
    public List<Defi> getDefisWeamec() {
        return defisWeamec;
    }

    /**
     * defisWeamec Setter
     * @param defisWeamec Defis WEAMEC
     */
    public void setDefisWeamec(List<Defi> defisWeamec) {
        this.defisWeamec = defisWeamec;
    }

    /**
     * valeurs Getter
     * @return Valeurs du projet
     */
    public List<Valeur> getValeurs() {
        return valeurs;
    }

    /**
     * valeurs Setter
     * @param valeurs Valeurs du projet
     */
    public void setValeurs(List<Valeur> valeurs) {
        this.valeurs = valeurs;
    }

    /**
     * themes Getter
     * @return Themes du projet
     */
    public List<Theme> getThemes() {
        return themes;
    }

    /**
     * themes Setter
     * @param themes Themes du projet
     */
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    /**
     * listePartenaires Getter
     * @return Liste des partenaires du projet
     */
    public List<Partenaire> getListePartenaires() {
        return listePartenaires;
    }

    /**
     * listePartenaires Setter
     * @param listePartenaires Liste des partenaires du projet
     */
    public void setListePartenaires(List<Partenaire> listePartenaires) {
        this.listePartenaires = listePartenaires;
    }

    /**
     * listeExperts Getter
     * @return Liste des experts du projet
     */
    public List<Expert> getListeExperts() {
        return listeExperts;
    }

    /**
     * listeExperts Setter
     * @param listeExperts Liste des experts du projet
     */
    public void setListeExperts(List<Expert> listeExperts) {
        this.listeExperts = listeExperts;
    }
}
