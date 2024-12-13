/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.springframework.stereotype.Service;

/**
 * Service pour la création de fichier ZIP
 * @author simon
 */
@Service
public class ZipFileService {
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
    
    /**
     * Crée un fichier ZIP
     * @param files     Liste des fichiers à ajouter
     * @return 
     * @throws java.io.IOException 
     */
    public byte[] createZip(File[] files) throws IOException {
        ArrayList<byte[]> contents = new ArrayList<>();
        ArrayList<String> names = new ArrayList();
        
        for (File file: files) {
            contents.add(Files.readAllBytes(file.toPath()));
            names.add(file.getName());
        }
        
        return createZip(names, contents);
    }
    
    /**
     * Décompresse un fichier ZIP depuis son flux vers un chemin d'accès
     * @param dir   Chemin d'accès
     * @param input Flux entrant du fichier ZIP
     * @throws IOException 
     */
    public void saveZip(String dir, InputStream input) throws IOException {
        ZipInputStream zipInput = new ZipInputStream(input);
        ZipEntry entry = zipInput.getNextEntry();
        
        while (entry != null) {
            saveEntry(dir + '/' + entry.getName(), zipInput, entry.isDirectory());
            entry = zipInput.getNextEntry();
        }
    }
    
    /**
     * Enregistre une entrée d'un fichier ZIP depuis un flux vers un chemin d'accès
     * @param filePath      Chemin d'accès
     * @param zipInput      Flux entrant du fichier ZIP
     * @param isDirectory   Booléen si dossier
     * @throws IOException 
     */
    private void saveEntry(String filePath, ZipInputStream zipInput, boolean isDirectory) throws IOException {
        File file = new File(filePath);
        FileOutputStream output;
        byte[] buffer = new byte[1024];
        int len;
        
        if (isDirectory) {
            if (!file.mkdirs()) {
                throw new IOException();
            }
        }
        else {
            output = new FileOutputStream(file);
            
            while ((len = zipInput.read(buffer)) > 0) {
                output.write(buffer, 0, len);
            }
            
            output.close();
        }
    }
}
