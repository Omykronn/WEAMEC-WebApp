/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service pour l'accès aux fichiers sur le serveur
 * @author simon
 */
@Service
public class FileSystemService {
    private final String storageDirectory = "/home/simon/Documents/INFOSI/00_PAPPL/projectStorage";
    
    @Autowired
    private ZipFileService zipGenerator;
    
    /**
     * Test une liste d'extensions jusqu'à trouver un fichier correspondant
     * @param dir           Chemin d'accès au fichier AVEC POINT ET SANS EXTENSION
     * @param extensions    Liste d'extensions à chercher
     * @return              Fichier
     * @throws FileNotFoundException 
     */
    private File findFile(String dir, String[] extensions) throws FileNotFoundException {
        File file = null;
        File tempFile;
        
        for (String ext: extensions) {
            tempFile = new File(dir + ext);
            
            if (tempFile.exists()) {
                file = tempFile;
            }
        }
        
        if (file == null) {
            throw new FileNotFoundException();
        }
        
        return file;
    }
    
    /**
     * Retourne l'objet File associé au visuel d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du visuel
     * @throws IOException 
     */
    public File getVisuel(int idProjet) throws IOException {
        String dir = storageDirectory + "/project" + String.format("%08d", idProjet) + "/visuel.";
        String[] extensions = {"png", "jpg", "jpeg"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au logo d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du logo
     * @throws IOException 
     */
    public File getLogo(int idProjet) throws IOException {
        String dir = storageDirectory + "/project" + String.format("%08d", idProjet) + "/logo.";
        String[] extensions = {"png", "jpg", "jpeg"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au budget d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du budget
     * @throws IOException 
     */
    public File getBudget(int idProjet) throws IOException {
        String dir = storageDirectory + "/project" + String.format("%08d", idProjet) + "/budget.";
        String[] extensions = {"xls", "xlsm", "xlsx"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au planning d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du planning
     * @throws IOException 
     */
    public File getPlanning(int idProjet) throws IOException {
        String dir = storageDirectory + "/project" + String.format("%08d", idProjet) + "/gantt.";
        String[] extensions = {"png", "jpg", "jpeg", "pdf"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne un Array de File associé aux avis d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException 
     */
    private File[] getAvis(int idProjet) throws IOException {        
        File directory = new File(storageDirectory + "/project" + String.format("%08d", idProjet) + "/avisMotives");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les avis motives
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException 
     */
    public byte[] getAvisZip(int idProjet) throws IOException {
        return zipGenerator.createZip(getAvis(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux lettres d'interet d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException 
     */
    private File[] getLettresInteret(int idProjet) throws IOException {                
        File directory = new File(storageDirectory + "/project" + String.format("%08d", idProjet) + "/lettreInteret");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les lettres d'interet
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException 
     */
    public byte[] getLettresInteretZip(int idProjet) throws IOException {
        return zipGenerator.createZip(getLettresInteret(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux lettres de tutelle d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException 
     */
    private File[] getLettresTutelle(int idProjet) throws IOException {                
        File directory = new File(storageDirectory + "/project" + String.format("%08d", idProjet) + "/lettreTutelle");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les lettres de tutelle
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException 
     */
    public byte[] getLettresTutelleZip(int idProjet) throws IOException {
        return zipGenerator.createZip(getLettresTutelle(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux logos des partenaires d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException 
     */
    private File[] getLogosPartenaire(int idProjet) throws IOException {        
        File directory = new File(storageDirectory + "/project" + String.format("%08d", idProjet) + "/partenaire");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les logos des partenaires
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException 
     */
    public byte[] getLogosPartenaireZip(int idProjet) throws IOException {        
        return zipGenerator.createZip(getLogosPartenaire(idProjet));
    }
}
