/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Expert;
import fr.weamec.projectsManager.repository.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Service pour Expert
 * @author simon
 */
@Service
public class ExpertService {    
    @Autowired
    private ExpertRepository expertRepo;
    
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
     * Génère la liste des Experts depuis leur index stocké dans un tableau JSON
     * @param jsonArray Tableau contenant les index
     * @return Liste des Experts
     */
    public List<Expert> listFromJSONArray(JSONArray jsonArray) {
        ArrayList<Expert> experts = new ArrayList<>();
        
        for (Object obj: jsonArray) {
            experts.add(new Expert((JSONObject) obj));
        }
        
        return experts;
    }
}
