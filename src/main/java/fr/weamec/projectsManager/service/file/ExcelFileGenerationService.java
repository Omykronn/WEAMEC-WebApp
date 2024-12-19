/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import fr.weamec.projectsManager.model.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 * Service pour la génération de fichiers Excel
 * @author simon
 */
@Service
public class ExcelFileGenerationService {
    private ClassLoader classLoader;
    
    /**
     * Constructeur par défaut
     */
    public ExcelFileGenerationService() {
        // Workbook vide pour obtenir des instances de CellStyle & CreationHelper
        XSSFWorkbook mockWorkbook = new XSSFWorkbook();
        CreationHelper creationHelper = mockWorkbook.getCreationHelper();
        
        classLoader = Thread.currentThread().getContextClassLoader();
    }
    
    /**
     * Génère le ByteArray d'un fichier excel d'une liste de projets
     * @param projets Liste de projets
     * @return ByteArray du fichier Excel
     * @throws java.io.IOException Erreur lors du chargement du fichier en tant que XSSFWorkbook
     */
    public byte[] generateExcel(Iterable<Projet> projets) throws IOException {
        InputStream template = classLoader.getResourceAsStream("weamec/excel_template.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(template);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        fillExcel(workbook, projets);
        workbook.write(output);
        
        return output.toByteArray();
    }
    
    /**
     * Remplie un fichier excel à partir des informations de la liste de projets
     * @param workbook Fichier excel
     * @param projets Liste de projets
     * @return Fichier excel
     */
    private XSSFWorkbook fillExcel(XSSFWorkbook workbook, Iterable<Projet> projets) {
        fillSheetInfosProjet(workbook, projets);
        fillSheetExperts(workbook, projets);
        
        return workbook;
    }
    
    /**
     * Ajoute les données à la feuille InfosProjet
     * @param workbook  Fichier Excel
     * @param projets   Liste de projets
     */
    private void fillSheetInfosProjet(XSSFWorkbook workbook, Iterable<Projet> projets) {
        XSSFSheet sheet = workbook.getSheet("Infos projets");
        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        
        // Creation du format de date personnalisé
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/mm/yyyy"));
        
        int i = 3;
        
        for (Projet projet: projets) {
            fillRowProjet(sheet.createRow(i), projet, dateCellStyle);
            i++;
        }
        
    }
    
    /**
     * Ajoute les données d'un projet à une ligne
     * @param row           Ligne
     * @param projet        Projet
     * @param dateCellStyle Format de cellules pour celles contenant une date
     */
    private void fillRowProjet(XSSFRow row, Projet projet, CellStyle dateCellStyle) {
        row.createCell(0).setCellValue(projet.getNomAcro());
        row.createCell(1).setCellValue(projet.getCategorie().getNom());
        row.createCell(2).setCellValue(projet.getAnneeSelection());
        row.createCell(2).setCellValue(projet.getType().getNom());
        row.createCell(9).setCellValue(projet.getCoordinateurScientifique().getStructureRattachement().getEtablissement());
        row.createCell(10).setCellValue(projet.getCoordinateurScientifique().getStructureRattachement().getLaboratoire());
        row.createCell(11).setCellValue(projet.getCoordinateurScientifique().getStructureRattachement().getEquipe());
        row.createCell(12).setCellValue(projet.getCoordinateurScientifique().getNom());
        row.createCell(13).setCellValue(projet.getCoordinateurScientifique().getPrenom());
        row.createCell(14).setCellValue(projet.getCoordinateurScientifique().getMail());
        row.createCell(92).setCellValue(projet.getTrlDebut());
        row.createCell(93).setCellValue(projet.getTrlFin());
        row.createCell(94).setCellValue(projet.getBrevet());
        
        if (projet.getTraitementFini()) {
            row.createCell(122).setCellValue("X");
        }
        
        XSSFCell dateDebut = row.createCell(6);
        dateDebut.setCellValue(projet.getDateDebut());
        dateDebut.setCellStyle(dateCellStyle);
        
        XSSFCell dateFin = row.createCell(7);
        dateFin.setCellValue(projet.getDateFin());
        dateFin.setCellStyle(dateCellStyle);
        
        XSSFCell dateDebutTraitement = row.createCell(4);
        dateDebutTraitement.setCellValue(projet.getDebutTraitement());
        dateDebutTraitement.setCellStyle(dateCellStyle);
        
        if (projet.getFinTraitement() != null) {
            XSSFCell dateFinTraitement = row.createCell(3);
            dateFinTraitement.setCellValue(projet.getFinTraitement());
            dateFinTraitement.setCellStyle(dateCellStyle);
        }
        
        // Partenaires
        for (int i = 0; i < 6 && i < projet.getListePartenaires().size(); i++) {
            row.createCell(15 + 7*i).setCellValue(projet.getListePartenaires().get(i).getStructureRattachement().getEtablissement());
            row.createCell(16 + 7*i).setCellValue(projet.getListePartenaires().get(i).getStructureRattachement().getCodePostal());
            row.createCell(17 + 7*i).setCellValue(projet.getListePartenaires().get(i).getStructureRattachement().getVille());
            row.createCell(18 + 7*i).setCellValue(projet.getListePartenaires().get(i).getStructureRattachement().getLaboratoire());
            row.createCell(19 + 7*i).setCellValue(projet.getListePartenaires().get(i).getNom());
            row.createCell(20 + 7*i).setCellValue(projet.getListePartenaires().get(i).getPrenom());
            row.createCell(21 + 7*i).setCellValue(projet.getListePartenaires().get(i).getMail());
        }
        
        // Technologie
        for (Technologie technologie: projet.getTechnologies()) {
            // Test si "Toute EMR"
            if (technologie.getId() == 8) {
                for (int i = 70; i < 57; i++) {
                    row.createCell(i).setCellValue("X");
                }
            }
            else {
                row.createCell(70 + (technologie.getId() - 1)).setCellValue("X");
            }
        }
        
        // Themes
        for (Theme theme: projet.getThemes()) {
            row.createCell(78 + (theme.getId() - 1)).setCellValue("X");
        }
        
        // Valeurs
        for (Valeur valeur: projet.getValeurs()) {
            row.createCell(83 + (valeur.getId() - 1)).setCellValue("X");
        }
        
        // Priorité
        for (Priorite priorite: projet.getPrioriteWeamec()) {
            row.createCell(95 + (priorite.getId() - 1)).setCellValue("X");
        }
        
        // Objectifs
        for (Objectif objectif: projet.getObjectifsWeamec()) {
            row.createCell(97 + (objectif.getId() - 1)).setCellValue("X");
        }
        
        // Defis
        for (Defi defi: projet.getDefisWeamec()) {
            row.createCell(101 + (defi.getId() - 1)).setCellValue("X");
        }
    }
    
    /**
     * Ajoute les données la feuille Experts
     * @param workbook  Fichier Excel
     * @param projets   Liste de projets
     */
    private void fillSheetExperts(XSSFWorkbook workbook, Iterable<Projet> projets) {
        XSSFSheet sheet = workbook.getSheet("Experts");
        int i = 2;
        
        for (Projet projet: projets) {
            for (Expert expert: projet.getListeExperts()) {
                fillRowExpert(sheet.createRow(i), expert, projet.getNomAcro(), projet.getCoordinateurScientifique().getNom());
                i++;
            }
        }
    }
    
    /**
     * Ajoute les données d'un Expert à une ligne
     * @param row               Ligne
     * @param expert            Expert
     * @param nomProjet         Nom du projet
     * @param nomCoordinateur   Nom du coordinateur scientifique
     */
    private void fillRowExpert(XSSFRow row, Expert expert, String nomProjet, String nomCoordinateur) {
        row.createCell(0).setCellValue(expert.getSpecialite());
        row.createCell(1).setCellValue(expert.getNom());
        row.createCell(2).setCellValue(expert.getPrenom());
        row.createCell(3).setCellValue(expert.getEntiteRattachement());
        row.createCell(4).setCellValue(expert.getLaboratoireRattachement());
        row.createCell(5).setCellValue(expert.getMail());
        row.createCell(6).setCellValue(nomProjet);
        row.createCell(7).setCellValue(nomCoordinateur);
    }
}
