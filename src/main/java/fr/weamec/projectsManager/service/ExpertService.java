/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Expert;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONObject;

/**
 * Service pour Expert
 * @author simon
 */
@Service
public class ExpertService {    
    @Autowired
    private ExpertRepository expertRepo;
    
    @Autowired
    private StructureRattachementService structureRattachementService;
    
    /**
     * Renvoie le expert dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du expert
     * @return   Expert correspondant à l'identifiant
     */
    public Optional<Expert> getExpert(int id) {
        return expertRepo.findById(id);
    }
    
    /**
     * Renvoie tous les expert
     * @return Liste de tous les experts de la base de données
     */
    public Iterable<Expert> getExperts() {
        return expertRepo.findAll();
    }
    
    /**
     * Supprime un expert par son identifiant
     * @param id Identifiant du expert à supprimer
     */
    public void deleteExpert(int id) {
        expertRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un expert dans la base de données
     * @param expert Instance de Expert à sauvegarder
     * @return Instance de Expert sauvegardé
     */
    public Expert save(Expert expert) {
        return expertRepo.save(expert);
    }
    
    /**
     * Importe un expert depuis un fichier JSON préalablement analysé
     * @param json Object d'un fichier JSON analysé
     * @return Instance d'un expert importé
     */    
    public Expert importFromJSON(JSONObject json) {
        Expert expert = new Expert(structureRattachementService.importFromJSON((JSONObject) json.get("structureRattachement")),
                                                                                         (String) json.get("nom"),
                                                                                         (String) json.get("prenom"),
                                                                                         (String) json.get("mail"),
                                                                                         (String) json.get("telephone"));                                                                                
        
        return expert;
    }
}
