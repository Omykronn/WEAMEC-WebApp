/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Objectif;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Objectif
 * @author simon
 */
@Service
public class ObjectifService {    
    @Autowired
    private ObjectifRepository objectifRepo;
    
    /**
     * Renvoie le objectif dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du objectif
     * @return   Objectif correspondant à l'identifiant
     */
    public Optional<Objectif> getObjectif(int id) {
        return objectifRepo.findById(id);
    }
    
    /**
     * Renvoie tous les objectif
     * @return Liste de tous les objectifs de la base de données
     */
    public Iterable<Objectif> getObjectifs() {
        return objectifRepo.findAll();
    }
    
    /**
     * Supprime un objectif par son identifiant
     * @param id Identifiant du objectif à supprimer
     */
    public void deleteObjectif(int id) {
        objectifRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un objectif dans la base de données
     * @param objectif Instance de Objectif à sauvegarder
     * @return Instance de Objectif sauvegardé
     */
    public Objectif save(Objectif objectif) {
        return objectifRepo.save(objectif);
    }
}
