/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.StructureRattachement;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour StructureRattachement
 * @author simon
 */
@Service
public class StructureRattachementService {    
    @Autowired
    private StructureRattachementRepository structureRattachementRepo;
    
    /**
     * Renvoie le structure rattachement dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du structure rattachement
     * @return   StructureRattachement correspondant à l'identifiant
     */
    public Optional<StructureRattachement> getStructureRattachement(int id) {
        return structureRattachementRepo.findById(id);
    }
    
    /**
     * Renvoie tous les structure rattachements
     * @return Liste de tous les structure rattachements de la base de données
     */
    public Iterable<StructureRattachement> getStructureRattachements() {
        return structureRattachementRepo.findAll();
    }
    
    /**
     * Supprime un structure rattachement par son identifiant
     * @param id Identifiant du structure rattachement à supprimer
     */
    public void deleteStructureRattachement(int id) {
        structureRattachementRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un structure rattachement dans la base de données
     * @param structure rattachement Instance de StructureRattachement à sauvegarder
     * @return Instance de StructureRattachement sauvegardé
     */
    public StructureRattachement save(StructureRattachement structureRattachement) {
        return structureRattachementRepo.save(structureRattachement);
    }
}
