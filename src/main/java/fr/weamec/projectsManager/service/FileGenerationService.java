/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Projet;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service pour la génération des fichiers
 * @author simon
 */
@Service
public class FileGenerationService {
    @Autowired
    ZipService zipper;
    
    private ClassLoaderTemplateResolver templateResolver;
    private TemplateEngine templateEngine;
    
    /**
     * Constructeur par défaut, initie les objects propres à Thymeleaf pour la génération de page Web
     */
    public FileGenerationService() {
        // Initie un templateResolver de Thymeleaf
        templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        
        // template en src/main/resources/weamec/*.html
        templateResolver.setPrefix("weamec/");
        templateResolver.setSuffix(".html");
        
        
        // Initie un templateEngine de Thymeleaf
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }
    
    /**
     * Génère un code HTML à partir d'un template et d'un context
     * @param template  Nom du template à utiliser
     * @param context   Context Thymeleaf stockant les valeurs à utiliser
     * @return Code HTML
     */
    private String generateHtml(String template, Context context) {
        return templateEngine.process(template, context);
    }
    
    /**
     * Génère le ByteArray d'un dossier PDF d'un projet
     * @param projet Projet dont le dossier doit être généré
     * @return ByteArray du fichier PDF
     */
    public byte[] generateCaseFile(Projet projet) {
        Context context = new Context();
        context.setVariable("projet", projet);
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(generateHtml("caseFile_template", context), output);
        
        return output.toByteArray();
    }
    
    /**
     * Génère le ByteArray d'une diapositive de présentation PDF d'un projet
     * @param projet Projet dont la diapositive doit être générée
     * @return ByteArray du fichier PDF
     */
    public byte[] generateSummary(Projet projet) {
        Context context = new Context();
        context.setVariable("projet", projet);
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(generateHtml("summary_template", context), output);
        
        return output.toByteArray();
    }
    
    /**
     * Génère le ByteArray de la page HTML d'un projet
     * @param projet Projet dont la page HTML doit être générée
     * @return ByteArray du fichier HTML
     */
    public byte[] generateHtmlPage(Projet projet) {
        Context context = new Context();
        context.setVariable("projet", projet);
        
        return generateHtml("htmlPage_template", context).getBytes();
    }
    
    /**
     * Génère un fichier ZIP avec le dossier, la présentation et la page HTML d'un projet
     * @param projet Projet cible
     * @return ByteArray du fichier ZIP
     */
    public byte[] generateAll(Projet projet) {
        ArrayList<String> names = new ArrayList();
        ArrayList<byte[]> files = new ArrayList();
        
        Context context = new Context();
        context.setVariable("projet", projet);
        
        names.add("Dossier-" + projet.getNomAcro() + ".pdf");
        files.add(generateCaseFile(projet));
        
        names.add("Résumé-" + projet.getNomAcro() + ".pdf");
        files.add(generateSummary(projet));
        
        names.add(projet.getNomAcro() + ".html");
        files.add(generateHtmlPage(projet));
        
        return zipper.createZip(names, files);
    }
    
    /**
     * Génère un fichier ZIP un rendu pour plusieurs projets
     * @param projets   Liste des projets
     * @param template  Nom du rendu
     * @return          ByteArray du fichier ZIP
     */
    public byte[] generateAll(Iterable<Projet> projets, String template) {
        ArrayList<String> names = new ArrayList();
        ArrayList<byte[]> files = new ArrayList();
        
        String ext = "";
        
        for (Projet projet: projets) {
            switch (template) {
                case "casefile":
                    ext = ".pdf";
                    files.add(generateCaseFile(projet));
                    break;

                case "html":
                    ext = ".html";
                    files.add(generateHtmlPage(projet));
                    break;

                case "summary":
                    ext = ".pdf";
                    files.add(generateSummary(projet));
                    break;
            }
            
            if (!ext.equals("")) {
                names.add(projet.getNomAcro() + ext);
            }
        }
        
        return zipper.createZip(names, files);
    }
}