/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Projet;
import fr.weamec.projectsManager.model.CoordinateurScientifique;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;

/**
 * Service pour Projet
 * @author simon
 */
@Service
public class ProjetService {
    @Autowired
    private ProjetRepository projetRepo;
    
    @Autowired
    private CoordinateurScientifiqueRepository coordinateurScientifiqueRepo;
    
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
        return projetRepo.findAll();
    }
    
    /**
     * Renvoie tous les projets d'un coordinateur scientifique
     * @param id Identifiant du coordinateur scientifique
     * @return   Liste des projets du coordinateur scientifique
     */
    public Iterable<Projet> getProjetsByCoordinateurScientifiqueId(int id) {
        Iterable<Projet> listeProjets = new ArrayList<>();
        Optional<CoordinateurScientifique> coordinateurScientifiqueOpt = coordinateurScientifiqueRepo.findById(id);
        
        if (coordinateurScientifiqueOpt.isPresent()) {
            listeProjets = projetRepo.findByCoordinateurScientifique(coordinateurScientifiqueOpt.get());
        }
        
        return listeProjets;
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
}
