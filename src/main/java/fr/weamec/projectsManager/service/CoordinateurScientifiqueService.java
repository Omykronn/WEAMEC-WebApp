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

/**
 * Service pour CoordinateurScientifique
 * @author simon
 */
@Service
public class CoordinateurScientifiqueService {    
    @Autowired
    private CoordinateurScientifiqueRepository coordinateurScientifiqueRepo;
    
    /**
     * Renvoie le coordinateur scientifique dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du coordinateur scientifique
     * @return   CoordinateurScientifique correspondant à l'identifiant
     */
    public Optional<CoordinateurScientifique> getCoordinateurScientifique(int id) {
        return coordinateurScientifiqueRepo.findById(id);
    }
    
    /**
     * Renvoie tous les coordinateur scientifique
     * @return Liste de tous les coordinateur scientifiques de la base de données
     */
    public Iterable<CoordinateurScientifique> getCoordinateurScientifiques() {
        return coordinateurScientifiqueRepo.findAll();
    }
    
    /**
     * Supprime un coordinateur scientifique par son identifiant
     * @param id Identifiant du coordinateur scientifique à supprimer
     */
    public void deleteCoordinateurScientifique(int id) {
        coordinateurScientifiqueRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un coordinateur scientifique dans la base de données
     * @param coordinateurScientifique Instance de CoordinateurScientifique à sauvegarder
     * @return Instance de CoordinateurScientifique sauvegardé
     */
    public CoordinateurScientifique save(CoordinateurScientifique coordinateurScientifique) {
        return coordinateurScientifiqueRepo.save(coordinateurScientifique);
    }
}
