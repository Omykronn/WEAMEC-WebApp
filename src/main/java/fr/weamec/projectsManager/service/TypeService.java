/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Type;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Type
 * @author simon
 */
@Service
public class TypeService {    
    @Autowired
    private TypeRepository typeRepo;
    
    /**
     * Renvoie le type dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du type
     * @return   Type correspondant à l'identifiant
     */
    public Optional<Type> getType(int id) {
        return typeRepo.findById(id);
    }
    
    /**
     * Renvoie tous les type
     * @return Liste de tous les types de la base de données
     */
    public Iterable<Type> getTypes() {
        return typeRepo.findAll();
    }
    
    /**
     * Supprime un type par son identifiant
     * @param id Identifiant du type à supprimer
     */
    public void deleteType(int id) {
        typeRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un type dans la base de données
     * @param type Instance de Type à sauvegarder
     * @return Instance de Type sauvegardé
     */
    public Type save(Type type) {
        return typeRepo.save(type);
    }
}
