/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.model.*;
import fr.weamec.projectsManager.service.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
   
    /**
     * Fonction associée à l'affichage de la page dashboard
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/projects")
    public String dashboard(Model model) {
        model.addAttribute("projets", projetService.getProjets());
        
        return "dashboard"; 
    }
    
    /**
     * Fonction associée à l'affichage de la page d'un projet
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/projects/{id}")
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
    
    /**
     * Fonction associée à l'affichage du formulaire de modidification d'un projet
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/projects/{id}/edit")
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
    
    /**
     * Fonction associée à l'enregistrement des modifications d'un projet
     * @param projet Instance du projet modifié
     * @param model  Model fourni par Spring
     * @return       Nom de la page HTML à afficher
     */
    @PostMapping("/projects/{id}")
    public String saveProject(@ModelAttribute Projet projet, Model model) {        
        projet = projetService.save(projet);
        
        return "viewProjet";
    }
    
    /**
     * Fonction associée à la suppression d'un projet
     * @param id Identifiant du projet à supprimer
     * @return   Redirection vers la page principale
     */
    @GetMapping("/projects/{id}/drop")
    public ModelAndView dropProject(@PathVariable("id") int id) {
        projetService.deleteProjet(id);
        
        return new ModelAndView("redirect:/projects");
    }
}
