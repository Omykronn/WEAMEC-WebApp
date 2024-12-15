/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.ImageType;
import com.aspose.cells.SheetRender;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe outils pour les fichiers Excel
 * @author simon
 */
public class ExcelFileTools {
    /**
     * Convertit les feuilles d'un document Excel en SheetRender sous forme de liste
     * @param workbook  Document à convertir
     * @return          Liste des SheetRender des feuilles du document
     * @throws Exception 
     */
    public static List<SheetRender> convertExcelToSheetRender(Workbook workbook) throws Exception {
        ArrayList<SheetRender> renders = new ArrayList<>();
        
        ImageOrPrintOptions imgOptions = new ImageOrPrintOptions();
        
        imgOptions.setImageType(ImageType.PNG);
        imgOptions.setAllColumnsInOnePagePerSheet(true);
        
        for (Object sheet: workbook.getWorksheets()) {
           renders.add(new SheetRender((Worksheet) sheet, imgOptions));
        }
        
        return renders;
    }
}
