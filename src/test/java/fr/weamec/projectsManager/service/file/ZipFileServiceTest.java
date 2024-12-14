/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.weamec.projectsManager.service.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests pour ZipFileService
 * @author simon
 */
@SpringBootTest
public class ZipFileServiceTest {
    @Autowired
    private ZipFileService zipFileService;
    
    private static File testDir;
    
    /**
     * Crée le dossier où tous les fichiers de test seront créés
     */
    @BeforeAll
    public static void setUpClass() {
        // Crée le dossier où tous les fichiers de test seront créés
        testDir = new File("testZip");
        testDir.mkdir();
    }
    
    /**
     * Supprime le dossier où tous les fichiers de test ont été créés
     * @throws IOException 
     */
    @AfterAll
    public static void tearDownClass() throws IOException {
        FileUtils.deleteDirectory(testDir);
    }

    /**
     * Test of saveZip method, of class ZipFileService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveZip() throws Exception {
        System.out.println("saveZip");
        
        // Décompression d'un fichier test
        InputStream input = new FileInputStream(new File("src/test/resources/zip/AcronymeduProjet.zip"));
        zipFileService.saveZip(testDir.getAbsolutePath(), input);
        
        // Vérifie que les fichiers existent
        assertFileExists("budget.xlsx");
        assertFileExists("gantt.png");
        assertFileExists("logo.png");
        assertFileExists("projet.json");
        assertFileExists("visuel.png");
        assertFileExists("avisMotives/avis1.pdf");
        assertFileExists("lettreInteret/lettre1.pdf");
        assertFileExists("lettreInteret/lettre2.pdf");
        assertFileExists("lettreTutelle/lettre1.pdf");
        assertFileExists("partenaire/logo1.jpg");
        assertFileExists("partenaire/logo2.jpg");
    }
    
    /**
     * Assert if a file exists in the test directory
     * @param filename  File name
     */
    private void assertFileExists(String filename) {
        File file = new File(testDir.getAbsolutePath() + '/' + filename);
        
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}
