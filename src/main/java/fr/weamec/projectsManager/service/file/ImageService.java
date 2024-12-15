/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import com.aspose.cells.SheetRender;
import com.aspose.cells.Workbook;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service de gestion des images
 * @author simon
 */
@Service
public class ImageService {
    @Autowired
    FileSystemService fileSystemService;
    
    /**
     * Génère les images depuis un fichier PDF dans un dossier
     * @param dirPath       Chemin d'accès vers le dossier de sauvegarde
     * @param source        Fichier PDF source
     * @throws IOException 
     */
    private void generateImagesFromPdf(String dirPath, File source) throws IOException {
        PDDocument planning = Loader.loadPDF(source);
        int count = 1;
        
        for (BufferedImage image: PdfFileTools.convertPdfToImageBuffer(planning)) {
            ImageIO.write(image, "PNG", new File(dirPath + "/page_" + count + ".png"));
            count++;
        }
    }
    
    private void generateImagesFromExcel(String dirPath, File source) throws Exception {
        Workbook workbook = new Workbook(source.getAbsolutePath());
        int count = 1;
        
        for (SheetRender render: ExcelFileTools.convertExcelToSheetRender(workbook)) {
            render.toImage(0, dirPath + "/sheet_" + count + ".png");
        }
    }
    
    /**
     * Génère les images nécessaire à un dossier dans un dossier temporaire
     * @param idProjet          Identifiant du projet
     * @param destinationPath   Chemin d'accès vers le dossier de destination
     * @throws IOException 
     */
    public void generateProjectImages(int idProjet, String destinationPath) throws IOException, Exception {
        // Budget
        File budgetDir = new File(destinationPath + "/budget_img");
        budgetDir.mkdir();
        
        generateImagesFromExcel(budgetDir.getAbsolutePath(), fileSystemService.getBudget(idProjet));
        
        // Planning
        if (fileSystemService.getPlanning(idProjet).getName().equals("gantt.pdf")) {
            File planningDir = new File(destinationPath + "/planning_img");
            planningDir.mkdir();

            generateImagesFromPdf(planningDir.getAbsolutePath(), fileSystemService.getPlanning(idProjet));
        }
    }
    
    /**
     * Retourne une liste des chemins d'accès vers les images du planning d'un projet
     * @param idProjet  Identifiant du projet
     * @return          Liste des chemins d'accès
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public List<String> getPlanningImagePaths(int idProjet) throws FileNotFoundException, IOException {
        ArrayList<String> paths = new ArrayList<>();
        
        File projectDir = fileSystemService.getProjectDir(idProjet);
        File planningDir = new File(projectDir.getAbsolutePath() + "/planning_img");
        
        if (planningDir.exists()) {
            // S'il existe des images converties, on les utilise
            for (File page: planningDir.listFiles()) {
                paths.add(page.getAbsolutePath());
            }
        }
        else {
            // Sinon, on suppose que planning.xxx est une image
            paths.add(fileSystemService.getPlanning(idProjet).getAbsolutePath());
        }
        
        return paths;
    }
    
    /**
     * Retourne une liste des chemins d'accès vers les images du budget d'un projet
     * @param idProjet  Identifiant du projet
     * @return          Liste des chemins d'accès
     * @throws java.io.FileNotFoundException
     */
    public List<String> getBudgetImagePaths(int idProjet) throws FileNotFoundException {
        ArrayList<String> paths = new ArrayList<>();
        
        File projectDir = fileSystemService.getProjectDir(idProjet);
        File budgetDir = new File(projectDir.getAbsolutePath() + "/budget_img");
        
        if (budgetDir.exists()) {
            // S'il existe des images converties, on les utilise
            for (File page: budgetDir.listFiles()) {
                paths.add(page.getAbsolutePath());
            }
        }
        
        return paths;
    }
}
