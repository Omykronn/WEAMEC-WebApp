/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Technologie;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Technologie
 * @author simon
 */
@Service
public class TechnologieService {    
    @Autowired
    private TechnologieRepository technologieRepo;
    
    /**
     * Renvoie le technologie dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du technologie
     * @return   Technologie correspondant à l'identifiant
     */
    public Optional<Technologie> getTechnologie(int id) {
        return technologieRepo.findById(id);
    }
    
    /**
     * Renvoie tous les technologie
     * @return Liste de tous les technologies de la base de données
     */
    public Iterable<Technologie> getTechnologies() {
        return technologieRepo.findAll();
    }
    
    /**
     * Supprime un technologie par son identifiant
     * @param id Identifiant du technologie à supprimer
     */
    public void deleteTechnologie(int id) {
        technologieRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un technologie dans la base de données
     * @param technologie Instance de Technologie à sauvegarder
     * @return Instance de Technologie sauvegardé
     */
    public Technologie save(Technologie technologie) {
        return technologieRepo.save(technologie);
    }
}
