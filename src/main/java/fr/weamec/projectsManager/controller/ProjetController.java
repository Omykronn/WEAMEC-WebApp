/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller pour Projet
 * @author simon
 */
@Controller
public class ProjetController {
    @Autowired
    ProjetService projService;
    
    @Autowired
    CoordinateurScientifiqueService csService;
    
    @Autowired
    StructureRattachementService srService;
    
    /**
     * Fonction associée à l'affichage de la page dashboard
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/dashboard/")
    public String dashboard(Model model) {
        model.addAttribute("projets", projService.getProjets());
        
        return "dashboard";
    }
}
