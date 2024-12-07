/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.stereotype.Service;

/**
 * Service pour la création de fichier ZIP
 * @author simon
 */
@Service
public class ZipFileGenerationService {
    /**
     * Crée un fichier ZIP
     * @param fileNames Liste des noms des fichiers à ajouter
     * @param files     Liste des fichiers à ajouter
     * @return 
     */
    public byte[] createZip(List<String> fileNames, List<byte[]> files) {
        ByteArrayOutputStream binOutput = new ByteArrayOutputStream();
        ZipOutputStream zipOutput = new ZipOutputStream(binOutput);
        
        // Récupération des Itérateurs pour parcours en parrallèle
        ListIterator<String> nameIter = fileNames.listIterator();
        ListIterator<byte[]> fileIter = files.listIterator();
        
        try {
            while (nameIter.hasNext() && fileIter.hasNext()) {
                zipOutput.putNextEntry(new ZipEntry(nameIter.next()));
                zipOutput.write(fileIter.next());
                zipOutput.closeEntry();
            }
            
            zipOutput.close();
        }
        catch (IOException e) {}
        
        return binOutput.toByteArray();
    }
}
