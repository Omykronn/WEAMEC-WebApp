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
    
    @GetMapping("/home")
    public String home(Model model) {
        int id = 3;
        
        Optional<CoordinateurScientifique> csOpt = csService.getCoordinateurScientifique(id);
        String template;
        
        if (csOpt.isPresent()) {
            CoordinateurScientifique cs = csOpt.get();
            
            model.addAttribute("personne", cs);
            model.addAttribute("projets", projService.getProjetsByCoordinateurScientifiqueId(cs.getId()));
            
            template = "home";
        }
        else {
            template = "notFound";
        }
        
        return template;
    }
    
    @GetMapping("/newStructureRattachement")
    public String createAccount() {
        return "formNewStructureRattachement";
    }
    
    @PostMapping("/saveStructureRattachement")
    public String saveStructureRattachement(@ModelAttribute StructureRattachement structureRattachement, Model model) {
        // Sauvegarde de la nouvelle structure
        structureRattachement.setDir("zrbzoubev");
        StructureRattachement sc = srService.save(structureRattachement);
        
        return "done";	
    }
    
    @GetMapping("/newCoordinateurScientifique")
    public String newCoordinateurScientitifque() {
        return "formNewCoordinateurScientifique";
    }
    
    @PostMapping("/saveCoordinateurScientifique")
    public String saveCoordinateurScientifique(@ModelAttribute CoordinateurScientifique coordinateurScientifique,
                                               @ModelAttribute StructureRattachement structureRattachement) {
        // Sauvegarde de la structure de rattachement
        structureRattachement.setDir("helloworld");
        structureRattachement = srService.save(structureRattachement);
        
        // Sauvegarde du coordinateurScientifique
        coordinateurScientifique.setStructureRattachement(structureRattachement);
        coordinateurScientifique = csService.save(coordinateurScientifique);
        
        return "done";
    }
}
