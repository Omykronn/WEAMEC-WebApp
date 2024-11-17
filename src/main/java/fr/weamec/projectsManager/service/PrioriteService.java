/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Priorite;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
