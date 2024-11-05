/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.CoordinateurScientifique;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;

/**
 * Service pour CoordinateurScientifique
 * @author simon
 */
@Service
public class CoordinateurScientifiqueService {    
    @Autowired
    private CoordinateurScientifiqueRepository coordinateurScientifiqueRepo;
    
    /**
     * Renvoie le coordinateur scientifiqueRepo dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du coordinateur scientifiqueRepo
     * @return   CoordinateurScientifique correspondant à l'identifiant
     */
    public Optional<CoordinateurScientifique> getCoordinateurScientifique(int id) {
        return coordinateurScientifiqueRepo.findById(id);
    }
    
    /**
     * Renvoie tous les coordinateur scientifiqueRepos
     * @return Liste de tous les coordinateur scientifiqueRepos de la base de données
     */
    public Iterable<CoordinateurScientifique> getCoordinateurScientifiques() {
        return coordinateurScientifiqueRepo.findAll();
    }
    
    /**
     * Supprime un coordinateur scientifiqueRepo par son identifiant
     * @param id Identifiant du coordinateur scientifiqueRepo à supprimer
     */
    public void deleteCoordinateurScientifique(int id) {
        coordinateurScientifiqueRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un coordinateur scientifiqueRepo dans la base de données
     * @param coordinateur scientifiqueRepo Instance de CoordinateurScientifique à sauvegarder
     * @return Instance de CoordinateurScientifique sauvegardé
     */
    public CoordinateurScientifique save(CoordinateurScientifique coordinateurScientifique) {
        return coordinateurScientifiqueRepo.save(coordinateurScientifique);
    }
}
