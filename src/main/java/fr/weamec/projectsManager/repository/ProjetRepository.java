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
     * Retourne les projets dans l'ordre décroissant
     * @return Liste des Projets
     */
    public List<Projet> findAllByOrderByIdDesc();
    
    /**
     * Retourne les projets par acronyme dans l'ordre alphabétique
     * @return Liste des projets
     */
    public List<Projet> findAllByOrderByNomAcroAscIdDesc();
}
