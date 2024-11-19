/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Partenaire;
import fr.weamec.projectsManager.repository.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Service pour Partenaire
 * @author simon
 */
@Service
public class PartenaireService {    
    @Autowired
    private PartenaireRepository partenaireRepo;
    
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
     * Génère la liste des Partenaires depuis leur index stocké dans un tableau JSON
     * @param jsonArray Tableau contenant les index
     * @return Liste des Partenaires
     */
    public List<Partenaire> listFromJSONArray(JSONArray jsonArray) {
        ArrayList<Partenaire> partenaires = new ArrayList<>();
        
        for (Object obj: jsonArray) {
            partenaires.add(new Partenaire((JSONObject) obj));
        }
        
        return partenaires;
    }
}
