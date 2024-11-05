/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.model.*;
import fr.weamec.projectsManager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller pour Projet
 * @author simon
 */
@Controller
public class ProjetController {
    @Autowired
    StructureRattachementService scService;
    
    @GetMapping("/createAccount")
    public String createAccount() {
        return "formNewStructureRattachement";
    }
    
    @PostMapping("/createAccount2")
    public String saveStructureRattachement(@ModelAttribute StructureRattachement structureRattachement, Model model) {
        
        // Sauvegarde de la nouvelle structure
        structureRattachement.setDir("zrbzoubev");
        StructureRattachement sc = scService.save(structureRattachement);
        
        // Transmission de l'indice pour le coordinateurScientifique
        model.addAttribute("idStruct", sc.getId());
        
        return "done";	
    }
}
