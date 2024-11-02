/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.repository;

import fr.weamec.projectsManager.model.Projet;
import fr.weamec.projectsManager.model.CoordinateurScientifique;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository pour Projet
 * @author simon
 */
@Repository
public interface ProjetRepository extends CrudRepository<Projet, Integer> {
    /**
     * Retourne les projets d'un coordinateur scientifique
     * @param coordinateurScientifique  Coordinateur Scientifique cible
     * @return                          Liste des Projets avec le Coordinateur Scientifique spécifié
     */
    public List<Projet> findByCoordinateurScientifique(CoordinateurScientifique coordinateurScientifique);
}
