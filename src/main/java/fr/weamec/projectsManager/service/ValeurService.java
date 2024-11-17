/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Valeur;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Valeur
 * @author simon
 */
@Service
public class ValeurService {    
    @Autowired
    private ValeurRepository valeurRepo;
    
    /**
     * Renvoie le valeur dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du valeur
     * @return   Valeur correspondant à l'identifiant
     */
    public Optional<Valeur> getValeur(int id) {
        return valeurRepo.findById(id);
    }
    
    /**
     * Renvoie tous les valeur
     * @return Liste de tous les valeurs de la base de données
     */
    public Iterable<Valeur> getValeurs() {
        return valeurRepo.findAll();
    }
    
    /**
     * Supprime un valeur par son identifiant
     * @param id Identifiant du valeur à supprimer
     */
    public void deleteValeur(int id) {
        valeurRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un valeur dans la base de données
     * @param valeur Instance de Valeur à sauvegarder
     * @return Instance de Valeur sauvegardé
     */
    public Valeur save(Valeur valeur) {
        return valeurRepo.save(valeur);
    }
}
