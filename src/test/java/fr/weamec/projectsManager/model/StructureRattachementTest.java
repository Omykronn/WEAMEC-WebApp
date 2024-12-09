/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.weamec.projectsManager.model;

import java.io.IOException;
import java.io.FileReader;
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
public class StructureRattachementTest {
    
    public StructureRattachementTest() {
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
        JSONObject json = (JSONObject) parser.parse(new FileReader("src/test/resources/json/test_StructureRattachement.json"));
        StructureRattachement instance = new StructureRattachement(json);
        
        assertEquals(instance.getEtablissement(), "École Centrale de Nantes");
        assertEquals(instance.getLaboratoire(), "EI2+");
        assertEquals(instance.getEquipe(), "INFOSI");
        assertEquals(instance.getVille(), "Nantes");
        assertEquals(instance.getCodePostal(), 44000);
        assertEquals(instance.getNomRef(), "Jean-Baptiste AVRILLIER");
        assertEquals(instance.getMailRef(), "contact@ec-nantes.fr");
        assertEquals(instance.getTelephoneRef(), "+33 1 23 45 67 89");
    }    
}
