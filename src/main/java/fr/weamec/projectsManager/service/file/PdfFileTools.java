/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import java.io.OutputStream;

/**
 * Service pour la génération de fichiers PDF
 * @author simon
 */
public class PdfFileTools {
    /**
     * Fusionne une collection de documents PDF
     * @param documents Collection de documents PDF
     * @param output    Flux sortant
     */
    public static void mergePdfDocuments(Iterable<PdfDocument> documents, OutputStream output) {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(output));
        PdfMerger merger = new PdfMerger(pdfDoc);
        
        for (PdfDocument currentDoc: documents) {
            merger.merge(currentDoc, 1, currentDoc.getNumberOfPages());
        }
        
        pdfDoc.close();
    }
}
