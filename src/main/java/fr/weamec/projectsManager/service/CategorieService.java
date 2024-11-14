/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Categorie;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Categorie
 * @author simon
 */
@Service
public class CategorieService {    
    @Autowired
    private CategorieRepository categorieRepo;
    
    /**
     * Renvoie le categorie dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du categorie
     * @return   Categorie correspondant à l'identifiant
     */
    public Optional<Categorie> getCategorie(int id) {
        return categorieRepo.findById(id);
    }
    
    /**
     * Renvoie tous les categorie
     * @return Liste de tous les categories de la base de données
     */
    public Iterable<Categorie> getCategories() {
        return categorieRepo.findAll();
    }
    
    /**
     * Supprime un categorie par son identifiant
     * @param id Identifiant du categorie à supprimer
     */
    public void deleteCategorie(int id) {
        categorieRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un categorie dans la base de données
     * @param categorie Instance de Categorie à sauvegarder
     * @return Instance de Categorie sauvegardé
     */
    public Categorie save(Categorie categorie) {
        return categorieRepo.save(categorie);
    }
}
