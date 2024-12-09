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
 *
 * @author simon
 */
public class PartenaireTest {
    
    public PartenaireTest() {
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
     */
    @Test
    public void testImportFromJson() throws IOException, ParseException {
        System.out.println("importFromJSON : StructureRattachement");
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new FileReader("src/test/resources/json/test_Partenaire.json"));
        Partenaire instance = new Partenaire(json);
        
        assertEquals(instance.getNom(), "LE GOFF");
        assertEquals(instance.getPrenom(), "Gwenaelle");
        assertEquals(instance.getMail(), "gwenaelle.legoff@ec-nantes.fr");
        assertEquals(instance.getTelephone(), "+33 4 89 67 23 45");
        
        // Simple vérification qu'un object a été créé
        // Vérification du contenu avec le test d'import de StrucutureRattachement 
        assertNotNull(instance.getStructureRattachement());
    }   
}
