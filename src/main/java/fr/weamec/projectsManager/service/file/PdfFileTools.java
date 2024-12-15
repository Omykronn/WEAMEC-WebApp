/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

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
    
    /**
     * Convertit les pages d'un document PDF en images
     * @param document  Document à convertir
     * @return          Images des pages du document
     * @throws IOException 
     */
    public static List<BufferedImage> convertPdfToPng(PDDocument document) throws IOException {
        PDFRenderer renderer = new PDFRenderer(document);
        ArrayList<BufferedImage> images = new ArrayList<>();
        
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            images.add(renderer.renderImage(i));
        }
        
        return images;
    }
}
