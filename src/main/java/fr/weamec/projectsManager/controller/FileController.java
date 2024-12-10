/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.controller;

import fr.weamec.projectsManager.service.file.*;
import fr.weamec.projectsManager.model.Projet;
import fr.weamec.projectsManager.service.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Year;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller pour la génération et la gestion des fichiers
 * @author simon
 */
@Controller
public class FileController {    
    @Autowired
    HtmlBasedFileGenerationService htmlPdfGenerator;
    
    @Autowired
    ExcelFileGenerationService excelGenerator;
    
    @Autowired
    ProjetService projetService;
    
    @Autowired
    FileSystemService fileSystemService;
    
    /**
     * Construite une requête de réponse pour le téléchargement d'un fichier
     * @param fileName  Nom du fichier à afficher
     * @param mimeType  Type MIME du fichier 
     * @param content   Contenu binaire du fichier
     * @param response  Réponse HTTP venant du servelet
     */
    private void prepareResponse(String fileName, String mimeType, byte[] content, HttpServletResponse response) {
        response.setContentType(mimeType);
        response.setContentLength((int) content.length);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + fileName + "\""));
        
        try {
            response.getOutputStream().write(content);
        }
        catch (IOException e) {}
    }
    
    /**
     * Fonction relative au téléchargement d'un dossier d'un projet en format PDF
     * @param response  Réponse HTTP venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/casefile")
    public void downloadCaseFile(HttpServletResponse response, @PathVariable("id") int id) {
        // Si le projet n'existe pas, affiche une erreur dans le terminal, mais affiche bien la page error
        Projet projet = projetService.getProjet(id).get();
        byte[] content = htmlPdfGenerator.generateCaseFile(projet);
        
        prepareResponse("Dossier-" + projet.getNomAcro() + "-" + Year.now().getValue() + ".pdf", "application/pdf", content, response);
    }  
    
    /**
     * Fonction relative au téléchargement de la présentation d'un projet en format PDF
     * @param response  Réponse HTTP venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/summary")
    public void downloadSummary(HttpServletResponse response, @PathVariable("id") int id) {
        // Si le projet n'existe pas, affiche une erreur dans le terminal, mais affiche bien la page error
        Projet projet = projetService.getProjet(id).get();
        byte[] content = htmlPdfGenerator.generateSummary(projet);
        
        prepareResponse("Résumé-" + projet.getNomAcro() + "-" + Year.now().getValue() + ".pdf", "application/pdf", content, response);
    }  
    
    /**
     * Fonction relative au téléchargement de la page HTTP d'un projet
     * @param response  Réponse HTTP venant du servelet
     * @param id        Identifiant du projet
     */
    @GetMapping("/file/{id}/html")
    public void downloadHtmlPage(HttpServletResponse response, @PathVariable("id") int id) {
        // Si le projet n'existe pas, affiche une erreur dans le terminal, mais affiche bien la page error
        Projet projet = projetService.getProjet(id).get();
        byte[] content = htmlPdfGenerator.generateHtmlPage(projet);
        
        prepareResponse(projet.getNomAcro() + "-" + Year.now().getValue() + ".html", "text/html", content, response);
    } 
    
    /**
     * Fonction relative au téléchargement de tous les fichiers sur un projet dans un fichier ZIP
     * @param response  Réponse HTTP venant du servelet
     * @param id        Identifiant du projet 
     */
    @GetMapping("/file/{id}/all")
    public void downloadAll(HttpServletResponse response, @PathVariable("id") int id){
        // Si le projet n'existe pas, affiche une erreur dans le terminal, mais affiche bien la page error
        Projet projet = projetService.getProjet(id).get();
        byte[] content = htmlPdfGenerator.generateAll(projet);
        
        prepareResponse(projet.getNomAcro() + "-" + Year.now().getValue() + ".zip", "application/zip", content, response);
    }
    
    /**
     * Fonction associée à l'affichage du formulaire pour la génération des rendus
     * @param model Model fourni par Spring
     * @return      Nom de la page HTTP à afficher
     */
    @GetMapping("/file/generate")
    public String generateForm(Model model) {
        Iterable<Projet> projets = projetService.getProjetsAlphabetic();
        
        model.addAttribute("projets", projets);
        
        return "formFile";
    }
    
    /**
     * Fonction associée au téléchargement d'un fichier ZIP contenant tous les rendus d'un même type des projets renseignés dans un formulaire
     * @param response  
     * @param formData Données issues d'un formulaire
     */
    @PostMapping("/file/generate")
    public void downloadAll(HttpServletResponse response, @RequestParam MultiValueMap<String, String> formData) {
        ArrayList<Projet> projets = new ArrayList<>();
        String template = formData.get("template").getFirst();
        
        Optional<Projet> projet;
        
        for (String n: formData.get("listeProjets")) {
            projet = projetService.getProjet(Integer.parseInt(n));
            
            if (projet.isPresent()) {
                projets.add(projet.get());
            }
        }
        
        prepareResponse(template + ".zip", "application/zip", htmlPdfGenerator.generateAll(projets, template), response);
    }
    
    /**
     * Fonction relative au téléchargement du fichier Excel récapitulatif
     * @param response  Réponse HTTP venant du servelet
     * @throws java.io.IOException
     */
    @GetMapping("/file/excel")
    public void downloadHtmlPage(HttpServletResponse response) throws IOException {
        byte[] content = excelGenerator.generateExcel(projetService.getProjets());
        
        prepareResponse("Projets W2 " + Year.now().getValue() + "- Infos.xlsx", "application/xlsx", content, response);
    } 
    
    /**
     * Fonction relative au téléchargement du visuel d'un projet
     * @param response      Réponse HTTP venant du servelet
     * @param id            Identifiant du projet
     * @throws IOException 
     */
    @GetMapping("/file/{id}/visuel")
    public void downloadVisuel(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
        File file = fileSystemService.getVisuel(id);
        
        String name = file.getName();
        String mime = Files.probeContentType(file.toPath());
        byte[] content = Files.readAllBytes(file.toPath());
        
        prepareResponse(name, mime, content, response);
    }
}
