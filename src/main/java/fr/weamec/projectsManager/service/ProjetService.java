/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.*;
import fr.weamec.projectsManager.repository.*;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

/**
 * Service pour Projet
 * @author simon
 */
@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepo;
    
    @Autowired 
    private TypeService typeService;
    
    @Autowired 
    private CategorieService categorieService;
    
    @Autowired 
    private TechnologieService technologieService;
    
    @Autowired 
    private ValeurService valeurService;
    
    @Autowired 
    private PrioriteService prioriteService;
    
    @Autowired 
    private ObjectifService objectifService;
    
    @Autowired 
    private DefiService defiService;
    
    @Autowired 
    private ThemeService themeService;
    
    @Autowired 
    private ExpertService expertService;
    
    @Autowired 
    private PartenaireService partenaireService;
    
    /**
     * Renvoie le projet dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du projet
     * @return   Projet correspondant à l'identifiant
     */
    public Optional<Projet> getProjet(int id) {
        return projetRepo.findById(id);
    }
    
    /**
     * Renvoie tous les projets
     * @return Liste de tous les projets de la base de données
     */
    public Iterable<Projet> getProjets() {
        return projetRepo.findAllByOrderByIdDesc();
    }
    
    /**
     * Renvoie tous les projets par acronyme dans l'ordre alphabétique
     * @return Liste de tous les projets de la base de données
     */
    public Iterable<Projet> getProjetsAlphabetic() {
        return projetRepo.findAllByOrderByNomAcroAscIdDesc();
    }
    
    /**
     * Supprime un projet par son identifiant
     * @param id Identifiant du projet à supprimer
     */
    public void deleteProjet(int id) {
        projetRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un projet dans la base de données
     * @param projet Instance de Projet à sauvegarder
     * @return Instance du Projet sauvegardé
     */
    public Projet save(Projet projet) {
        return projetRepo.save(projet);
    }
    
    /**
     * Importe un projet depuis un fichier JSON préalablement analysé vers la base de données
     * @param json Object d'un fichier JSON analysé
     * @return Instance du projet importé
     */
    public Projet importFromJSON(JSONObject json) {   
        Calendar calendar = Calendar.getInstance();
        
        // Pour categorie et type, si id faux, Optional retourne une erreur et donc affichage de la page error
        Projet projet = new Projet(calendar.get(Calendar.YEAR),
                                   new Date(calendar.getTime().getTime()),
                                   false,
                                   new Date(calendar.getTime().getTime()),
                                   new CoordinateurScientifique((JSONObject) json.get("coordinateurScientifique")),
                                   (String) json.get("nomAcro"),
                                   (String) json.get("nomComplet"),
                                   categorieService.getCategorie(((Long) json.get("categorie")).intValue()).get(),
                                   typeService.getType(((Long) json.get("type")).intValue()).get(),
                                   (String) json.get("objectifSynth"),
                                   (String) json.get("siteWeb"),
                                   ((Long) json.get("duree")).intValue(),
                                   Date.valueOf((String) json.get("dateDebut")),
                                   Date.valueOf((String) json.get("dateFin")),
                                   (String) json.get("description"),
                                   (String) json.get("objectif"),
                                   (String) json.get("verrousScientif"),
                                   (String) json.get("programmeExp"),
                                   (String) json.get("moyensEssai"),
                                   (String) json.get("demonstrateur"),
                                   (String) json.get("ruptureScient"),
                                   (String) json.get("impactTech"),
                                   (String) json.get("impactEco"),
                                   (String) json.get("impactEnv"),
                                   (String) json.get("impactSoc"),
                                   technologieService.listFromJSONArray((JSONArray) json.get("technologies")),
                                   ((Long) json.get("trlDebut")).intValue(),
                                   ((Long) json.get("trlFin")).intValue(),
                                   (boolean) json.get("brevet"),
                                   prioriteService.listFromJSONArray((JSONArray) json.get("prioriteWeamec")),
                                   objectifService.listFromJSONArray((JSONArray) json.get("objectifsWeamec")),
                                   defiService.listFromJSONArray((JSONArray) json.get("defisWeamec")),
                                   valeurService.listFromJSONArray((JSONArray) json.get("defisWeamec")),
                                   themeService.listFromJSONArray((JSONArray) json.get("themes")),
                                   new ArrayList<Partenaire>(),
                                   new ArrayList<Expert>());
        
        projet = this.save(projet);
        
        // Import des Partenaires après définition de l'identifiant du projet
        List<Partenaire> listePartenaires = partenaireService.listFromJSONArray((JSONArray) json.get("listePartenaires"));
        
        for (Partenaire partenaire: listePartenaires) {
            partenaire.setIdProjet(projet.getId());
        }
        
        projet.setListePartenaires(listePartenaires);
        
        // Import des Experts après définition de l'identifiant du projet
        List<Expert> listeExperts = expertService.listFromJSONArray((JSONArray) json.get("listeExperts"));
        
        for (Expert expert: listeExperts) {
            expert.setIdProjet(projet.getId());
        }
        
        projet.setListeExperts(listeExperts);
        
        projet = this.save(projet);
        
        return projet;
    }
}
