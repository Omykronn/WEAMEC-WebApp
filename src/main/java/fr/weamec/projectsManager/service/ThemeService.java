/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Theme;
import fr.weamec.projectsManager.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service pour Theme
 * @author simon
 */
@Service
public class ThemeService {    
    @Autowired
    private ThemeRepository themeRepo;
    
    /**
     * Renvoie le theme dont l'identifiant est spécifié (s'il existe)
     * @param id Identifiant du theme
     * @return   Theme correspondant à l'identifiant
     */
    public Optional<Theme> getTheme(int id) {
        return themeRepo.findById(id);
    }
    
    /**
     * Renvoie tous les theme
     * @return Liste de tous les themes de la base de données
     */
    public Iterable<Theme> getThemes() {
        return themeRepo.findAll();
    }
    
    /**
     * Supprime un theme par son identifiant
     * @param id Identifiant du theme à supprimer
     */
    public void deleteTheme(int id) {
        themeRepo.deleteById(id);
    }
    
    /**
     * Sauvegarde un theme dans la base de données
     * @param theme Instance de Theme à sauvegarder
     * @return Instance de Theme sauvegardé
     */
    public Theme save(Theme theme) {
        return themeRepo.save(theme);
    }
}
