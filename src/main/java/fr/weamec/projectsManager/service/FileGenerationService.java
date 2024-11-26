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
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;

/**
 * Service pour la génération des fichiers
 * @author simon
 */
@Service
public class FileGenerationService {
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
}
