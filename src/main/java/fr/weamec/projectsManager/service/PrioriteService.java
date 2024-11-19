/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Priorite;
import fr.weamec.projectsManager.repository.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONArray;

/**
 * Service pour Priorite
 * @author simon
 */
@Service
public class PrioriteService {    
    @Autowired
    private PrioriteRepository prioriteRepo;
    
    /**
     * Renvoie le priorite dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du priorite
     * @return   Priorite correspondant à l'identifiant
     */
    public Optional<Priorite> getPriorite(int id) {
        return prioriteRepo.findById(id);
    }
    
    /**
     * Renvoie tous les priorite
     * @return Liste de tous les priorites de la base de données
     */
    public Iterable<Priorite> getPriorites() {
        return prioriteRepo.findAll();
    }
    
    /**
     * Supprime un priorite par son identifiant
     * @param id Identifiant du priorite à supprimer
     */
    public void deletePriorite(int id) {
        prioriteRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un priorite dans la base de données
     * @param priorite Instance de Priorite à sauvegarder
     * @return Instance de Priorite sauvegardé
     */
    public Priorite save(Priorite priorite) {
        return prioriteRepo.save(priorite);
    }
    
    /**
     * Génère la liste des Priorites depuis leur index stocké dans un tableau JSON
     * @param jsonArray Tableau contenant les index
     * @return Liste des Priorites
     */
    public List<Priorite> listFromJSONArray(JSONArray jsonArray) {
        ArrayList<Priorite> priorites = new ArrayList<>();
        
        for (Object i: jsonArray) {
            Optional<Priorite> prioriteOpt = this.getPriorite(((Long) i).intValue());
            
            if (prioriteOpt.isPresent()) {
                priorites.add(prioriteOpt.get());
            }
        }
        
        return priorites;
    }
}
