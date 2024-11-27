/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.model.Projet;
import fr.weamec.projectsManager.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller pour la génération et la gestion des fichiers
 * @author simon
 */
@Controller
public class FileController {
    @Autowired
    FileGenerationService generator;
    
    @Autowired
    ProjetService projetService;
    
    /**
     * Fonction relative au téléchargement d'un dossier d'un projet en format PDF
     * @param request   Requête HTML venant du servlet
     * @param response  Réponse HTML venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/casefile")
    public void downloadCaseFile(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        // TODO : Gerer l'objet Optional (si id absent)
        Projet projet = projetService.getProjet(id).get();
        byte[] content = generator.generateCaseFile(projet);
        
        response.setContentType("application/pdf");
        response.setContentLength((int) content.length);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"Dossier-" + projet.getNomAcro() + ".pdf\""));
        
        try {
            response.getOutputStream().write(content);
        }
        catch (IOException e) {}
    }  
    
    /**
     * Fonction relative au téléchargement de la présentation d'un projet en format PDF
     * @param request   Requête HTML venant du servlet
     * @param response  Réponse HTML venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/summary")
    public void downloadSummary(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        // TODO : Gerer l'objet Optional (si id absent)
        Projet projet = projetService.getProjet(id).get();
        byte[] content = generator.generateSummary(projet);
        
        response.setContentType("application/pdf");
        response.setContentLength((int) content.length);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"Résumé-" + projet.getNomAcro() + ".pdf\""));
        
        try {
            response.getOutputStream().write(content);
        }
        catch (IOException e) {}
    }  
    
    /**
     * Fonction relative au téléchargement de la page HTML d'un projet
     * @param request   Requête HTML venant du servlet
     * @param response  Réponse HTML venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/html")
    public void downloadHtmlPage(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        // TODO : Gerer l'objet Optional (si id absent)
        Projet projet = projetService.getProjet(id).get();
        byte[] content = generator.generateHtmlPage(projet);
        
        response.setContentType("text/html");
        response.setContentLength((int) content.length);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + projet.getNomAcro() + ".html\""));
        
        try {
            response.getOutputStream().write(content);
        }
        catch (IOException e) {}
    } 
}
