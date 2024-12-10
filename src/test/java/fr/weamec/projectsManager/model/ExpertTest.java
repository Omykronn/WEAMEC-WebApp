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
 * Classe de test pour Expert
 * @author simon
 */
public class ExpertTest {
    
    public ExpertTest() {
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
        System.out.println("importFromJSON : Expert");
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(new FileReader("src/test/resources/json/test_Expert.json"));
        Expert instance = new Expert(json);
        
        assertEquals(instance.getNom(), "DOE");
        assertEquals(instance.getPrenom(), "John");
        assertEquals(instance.getEntiteRattachement(), "École Centrale de Nantes");
        assertEquals(instance.getLaboratoireRattachement(), "INFOSI");
        assertEquals(instance.getSpecialite(), "JAVA Spring Boot");
        assertEquals(instance.getMail(), "john.doe@eleves.ec-nantes.fr");
    }   
}
