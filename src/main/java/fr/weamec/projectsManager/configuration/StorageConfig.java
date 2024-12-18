/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.weamec.projectsManager.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration pour le stockage des fichiers
 * @author simon
 */
@Configuration
@ConfigurationProperties(prefix = "app.storage")
public class StorageConfig {
    private String directory;
    private String tempDirectory;
    
    /**
     * directory Getter
     * @return Chemin d'accès vers le dossier de stockage
     */
    public String getDirectory() {
        return directory;
    }
    
    /**
     * storageDirectory Setter
     * @param directory Chemin d'accès vers le dossier de stockage
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * tempDirectory Getter
     * @return Chemin d'accès vers le dossier de stockage temporaire
     */
    public String getTempDirectory() {
        return tempDirectory;
    }

    /**
     * tempDirectory
     * @param tempDirectory Chemin d'accès vers le dossier de stockage temporaire
     */
    public void setTempDirectory(String tempDirectory) {
        this.tempDirectory = tempDirectory;
    }
    
    
}
