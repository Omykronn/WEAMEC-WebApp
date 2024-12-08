/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.CustomUser;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour CustomUser
 * @author simon
 */
@Service
public class CustomUserService {    
    @Autowired
    private CustomUserRepository customUserRepo;
    
    /**
     * Renvoie le customUser dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du customUser
     * @return   CustomUser correspondant à l'identifiant
     */
    public Optional<CustomUser> getCustomUser(int id) {
        return customUserRepo.findById(id);
    }
    
    /**
     * Renvoie tous les customUser
     * @return Liste de tous les customUsers de la base de données
     */
    public Iterable<CustomUser> getCustomUsers() {
        return customUserRepo.findAll();
    }
    
    /**
     * Supprime un customUser par son identifiant
     * @param id Identifiant du customUser à supprimer
     */
    public void deleteCustomUser(int id) {
        customUserRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un customUser dans la base de données
     * @param customUser Instance de CustomUser à sauvegarder
     * @return Instance de CustomUser sauvegardé
     */
    public CustomUser save(CustomUser customUser) {
        return customUserRepo.save(customUser);
    }
}
