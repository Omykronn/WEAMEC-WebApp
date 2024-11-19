/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Defi;
import fr.weamec.projectsManager.repository.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONArray;

/**
 * Service pour Defi
 * @author simon
 */
@Service
public class DefiService {    
    @Autowired
    private DefiRepository defiRepo;
    
    /**
     * Renvoie le defi dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du defi
     * @return   Defi correspondant à l'identifiant
     */
    public Optional<Defi> getDefi(int id) {
        return defiRepo.findById(id);
    }
    
    /**
     * Renvoie tous les defi
     * @return Liste de tous les defis de la base de données
     */
    public Iterable<Defi> getDefis() {
        return defiRepo.findAll();
    }
    
    /**
     * Supprime un defi par son identifiant
     * @param id Identifiant du defi à supprimer
     */
    public void deleteDefi(int id) {
        defiRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un defi dans la base de données
     * @param defi Instance de Defi à sauvegarder
     * @return Instance de Defi sauvegardé
     */
    public Defi save(Defi defi) {
        return defiRepo.save(defi);
    }
    
    /**
     * Génère la liste des Defis depuis leur index stocké dans un tableau JSON
     * @param jsonArray Tableau contenant les index
     * @return Liste des Defis
     */
    public List<Defi> listFromJSONArray(JSONArray jsonArray) {
        ArrayList<Defi> defis = new ArrayList<>();
        
        for (Object i: jsonArray) {
            Optional<Defi> defiOpt = this.getDefi(((Long) i).intValue());
            
            if (defiOpt.isPresent()) {
                defis.add(defiOpt.get());
            }
        }
        
        return defis;
    }
}
