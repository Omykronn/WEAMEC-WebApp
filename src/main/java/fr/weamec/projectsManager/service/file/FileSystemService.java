/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service pour l'accès aux fichiers sur le serveur
 * @author simon
 */
@Service
public class FileSystemService {
    /**
     * Chemin d'accès vers le stockage des fichiers des projets
     */
    public static final String STORAGE_DIRECTORY = "/home/simon/Documents/INFOSI/00_PAPPL/projectStorage";
    
    /**
     * Chemin d'accès vers le stockage temporaire
     */
    public static final String TEMP_DIRECTORY = "/tmp";
    
    @Autowired
    private ZipFileService zipFileService;
    
    /**
     * Test une liste d'extensions jusqu'à trouver un fichier correspondant
     * @param dir           Chemin d'accès au fichier AVEC POINT ET SANS EXTENSION
     * @param extensions    Liste d'extensions à chercher
     * @return              Fichier
     * @throws FileNotFoundException Aucun fichier avec les extensions proposées n'a été trouvé
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
     * @throws IOException Aucun fichier avec les extensions proposées n'a été trouvé
     */
    public File getVisuel(int idProjet) throws IOException {
        String dir = STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/visuel.";
        String[] extensions = {"png", "jpg", "jpeg"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au logo d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du logo
     * @throws IOException Aucun fichier avec les extensions proposées n'a été trouvé
     */
    public File getLogo(int idProjet) throws IOException {
        String dir = STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/logo.";
        String[] extensions = {"png", "jpg", "jpeg"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au budget d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du budget
     * @throws IOException Aucun fichier avec les extensions proposées n'a été trouvé
     */
    public File getBudget(int idProjet) throws IOException {
        String dir = STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/budget.";
        String[] extensions = {"xls", "xlsm", "xlsx"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne l'objet File associé au planning d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Objet file du planning
     * @throws IOException Aucun fichier avec les extensions proposées n'a été trouvé
     */
    public File getPlanning(int idProjet) throws IOException {
        String dir = STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/gantt.";
        String[] extensions = {"png", "jpg", "jpeg", "pdf"};
        
        return findFile(dir, extensions);
    }
    
    /**
     * Retourne un Array de File associé aux avis d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException Erreur de lecture du dossier
     */
    public File[] getAvis(int idProjet) throws IOException {        
        File directory = new File(STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/avisMotives");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les avis motives
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException Erreur lors de la compression
     */
    public byte[] getAvisZip(int idProjet) throws IOException {
        return zipFileService.createZip(getAvis(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux lettres d'interet d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException Erreur de lecture du dossier
     */
    public File[] getLettresInteret(int idProjet) throws IOException {                
        File directory = new File(STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/lettreInteret");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les lettres d'interet
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException Erreur lors de la compression
     */
    public byte[] getLettresInteretZip(int idProjet) throws IOException {
        return zipFileService.createZip(getLettresInteret(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux lettres de tutelle d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException Erreur de lecture du dossier
     */
    public File[] getLettresTutelle(int idProjet) throws IOException {                
        File directory = new File(STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/lettreTutelle");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les lettres de tutelle
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException Erreur lors de la compression
     */
    public byte[] getLettresTutelleZip(int idProjet) throws IOException {
        return zipFileService.createZip(getLettresTutelle(idProjet));
    }
    
    /**
     * Retourne un Array de File associé aux logos des partenaires d'un projet
     * @param idProjet  Identifiant d'un projet
     * @return          Array des fichiers du dossier
     * @throws IOException Erreur de lecture du dossier
     */
    private File[] getLogosPartenaire(int idProjet) throws IOException {        
        File directory = new File(STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet) + "/partenaire");
        
        return directory.listFiles();
    }
    
    /**
     * Genère le fichier ZIP contenant les logos des partenaires
     * @param idProjet  Identifiant du projet
     * @return          ByteArray du fichier ZIP
     * @throws IOException Erreur lors de la compression
     */
    public byte[] getLogosPartenaireZip(int idProjet) throws IOException {        
        return zipFileService.createZip(getLogosPartenaire(idProjet));
    }
    
    /**
     * Importe un fichier ZIP dans le dossier temporaire
     * @param dir   Dossier de destination
     * @param file  Fichier ZIP
     * @throws IOException Erreur lors de la decompression
     */
    public void importZipFile(String dir, MultipartFile file) throws IOException {
        zipFileService.saveZip(dir, file.getInputStream());
    }
    
    /**
     * Crée le dossier temporaire pour l'import d'un projet
     * @return Dossier temporaire
     * @throws java.io.IOException Erreur lors de la compression
     */
    public File createTempDir() throws IOException {
        File tempDir = new File(FileSystemService.TEMP_DIRECTORY + "/weamec" + System.currentTimeMillis());
        
        if (tempDir.exists()) {
            FileUtils.deleteDirectory(tempDir);
        }
        
        tempDir.mkdirs();
        return tempDir;
    }
    
    /**
     * Crée le dossier contenant les fichiers d'un projet
     * @param idProjet  Identifiant du projet
     * @return          Dossier du projet
     * @throws IOException Erreur lors de la decompression
     */
    public File createProjectDir(int idProjet) throws IOException {
        File projetDir = new File(FileSystemService.STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet));
        
        if (projetDir.exists()) {
            FileUtils.deleteDirectory(projetDir);
        }
        
        projetDir.mkdirs();
        return projetDir;
    }
    
    /**
     * Retourne un lien vers le dossier d'un projet
     * @param idProjet  Identifiant du projet
     * @return          Dossier d'un projet
     * @throws FileNotFoundException Le dossier du projet n'est pas trouvé
     */
    public File getProjectDir(int idProjet) throws FileNotFoundException {
        File projetDir = new File(FileSystemService.STORAGE_DIRECTORY + "/project" + String.format("%08d", idProjet));
        
        if (!projetDir.exists()) {
            throw new FileNotFoundException();
        }
        
        return projetDir;
    }
}
