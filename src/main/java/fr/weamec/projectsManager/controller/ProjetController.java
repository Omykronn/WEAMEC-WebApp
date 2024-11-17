/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.model.Projet;
import fr.weamec.projectsManager.service.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller pour Projet
 * @author simon
 */
@Controller
public class ProjetController {
    @Autowired
    ProjetService projetService;    
    
    @Autowired
    CategorieService categorieService;
    
    @Autowired
    TypeService typeService;
    
    @Autowired
    PrioriteService prioriteService;
    
    @Autowired
    ObjectifService objectifService;
    
    @Autowired 
    DefiService defiService;
    
    @Autowired
    ValeurService valeurService;
    
    @Autowired
    ThemeService themeService;
    
    @Autowired
    TechnologieService technologieService;
    
    @GetMapping("/viewProject/idProjet={id}")
    public String viewProject(@PathVariable("id") int id, Model model) {
        String pageName;
        Optional<Projet> projet = projetService.getProjet(id);
        
        if (projet.isPresent()) {
            pageName = "viewProjet";
            model.addAttribute("projet", projet.get());
        }
        else {
            pageName = "unknownProject";
        }
        
        return pageName;
    }
    
    @GetMapping("/editProject/idProjet={id}")
    public String editProject(@PathVariable("id") int id, Model model) {
        String pageName;
        Optional<Projet> projet = projetService.getProjet(id);
        
        if (projet.isPresent()) {
            pageName = "formProjet";
            model.addAttribute("projet", projet.get());
            
            model.addAttribute("allPriorites", prioriteService.getPriorites());
            model.addAttribute("allObjectifs", objectifService.getObjectifs());
            model.addAttribute("allDefis", defiService.getDefis());
            
            model.addAttribute("allValeurs", valeurService.getValeurs());
            model.addAttribute("allThemes", themeService.getThemes());
            model.addAttribute("allTechnologies", technologieService.getTechnologies());
            
            model.addAttribute("allCategories", categorieService.getCategories());
            model.addAttribute("allTypes", typeService.getTypes());
        }
        else {
            pageName = "unknownProject";
        }
        
        return pageName;
    }
}
