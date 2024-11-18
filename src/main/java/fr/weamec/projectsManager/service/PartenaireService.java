/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Partenaire;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONObject;

/**
 * Service pour Partenaire
 * @author simon
 */
@Service
public class PartenaireService {    
    @Autowired
    private PartenaireRepository partenaireRepo;
    
    @Autowired
    private StructureRattachementService structureRattachementService;
    
    /**
     * Renvoie le partenaire dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du partenaire
     * @return   Partenaire correspondant à l'identifiant
     */
    public Optional<Partenaire> getPartenaire(int id) {
        return partenaireRepo.findById(id);
    }
    
    /**
     * Renvoie tous les partenaire
     * @return Liste de tous les partenaires de la base de données
     */
    public Iterable<Partenaire> getPartenaires() {
        return partenaireRepo.findAll();
    }
    
    /**
     * Supprime un partenaire par son identifiant
     * @param id Identifiant du partenaire à supprimer
     */
    public void deletePartenaire(int id) {
        partenaireRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un partenaire dans la base de données
     * @param partenaire Instance de Partenaire à sauvegarder
     * @return Instance de Partenaire sauvegardé
     */
    public Partenaire save(Partenaire partenaire) {
        return partenaireRepo.save(partenaire);
    }
    
    /**
     * Importe un partenaire depuis un fichier JSON préalablement analysé
     * @param json Object d'un fichier JSON analysé
     * @return Instance d'un partenaire importé
     */    
    public Partenaire importFromJSON(JSONObject json) {
        Partenaire partenaire = new Partenaire(structureRattachementService.importFromJSON((JSONObject) json.get("structureRattachement")),
                                                                                         (String) json.get("nom"),
                                                                                         (String) json.get("prenom"),
                                                                                         (String) json.get("mail"),
                                                                                         (String) json.get("telephone"));                                                                                
        
        return partenaire;
    }
}
