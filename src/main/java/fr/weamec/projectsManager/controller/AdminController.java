/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.model.CustomUser;
import fr.weamec.projectsManager.service.CustomUserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    /**
     * Fonction associée à l'affichage du formulaire de modidification d'un utilisateur
     * @param id    Identifiant de l'utilisateur à afficher
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        String pageName;
        Optional<CustomUser> user = customUserService.getCustomUser(id);
        
        if (user.isPresent()) {
            user.get().setPassword("");
            model.addAttribute("user", user.get());
            pageName = "adminEditUser";
        }
        else {
            pageName = "error";
        }
        
        return pageName;
    }
    
    /**
     * Fonction associée à l'affichage du formulaire de création d'un utilisateur
     * @param model Model fourni par Spring
     * @return      Nom de la page HTML à afficher
     */
    @GetMapping("/admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new CustomUser());
        
        return "adminEditUser";
    }
    
    /**
     * Fonction associée à la sauvegarde d'un utlisateur (après création ou modification)
     * @param user  Utilisateur à sauvegardé
     * @return      Redirection vers la liste des utilisateurs
     */
    @PostMapping("/admin/save")
    public String saveUser(@ModelAttribute CustomUser user) {
        customUserService.save(user);
        
        return "redirect:/admin/";
    }
}
