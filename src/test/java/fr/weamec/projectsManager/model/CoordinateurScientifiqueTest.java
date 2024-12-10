/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.weamec.projectsManager.model;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour CoordinateurScientifique
 * @author simon
 */
public class CoordinateurScientifiqueTest {
    
    public CoordinateurScientifiqueTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of import from JSON.
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @Test
    public void testImportFromJson() throws IOException, ParseException {
        System.out.println("importFromJSON : CoordinateurScientifique");
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new FileReader("src/test/resources/json/test_CoordinateurScientifique.json"));
        CoordinateurScientifique instance = new CoordinateurScientifique(json);
        
        assertEquals(instance.getNom(), "MARTIN");
        assertEquals(instance.getPrenom(), "Jean-Yves");
        assertEquals(instance.getMail(), "jean-yves.martin@ec-nantes.fr");
        assertEquals(instance.getTelephoneFixe(), "+33 1 23 45 67 89");
        assertEquals(instance.getTelephonePort(), "+33 7 89 01 23 45");
        
        // Simple vérification qu'un object a été créé
        // Vérification du contenu avec le test d'import de StrucutureRattachement 
        assertNotNull(instance.getStructureRattachement());
    }     
}
