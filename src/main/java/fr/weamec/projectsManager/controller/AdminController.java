/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller pour l'administration des utilisateurs
 * @author simon
 */
@Controller
public class AdminController {
    @Autowired
    CustomUserService customUserService;
    
    /**
     * Fonction associée à l'affichage de tous les utilisateurs
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/admin/")
    public String allUsers(Model model) {
        model.addAttribute("users", customUserService.getCustomUsers());
        
        return "adminAllUsers"; 
    }
}
