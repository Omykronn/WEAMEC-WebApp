/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Partenaire;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classe de test pour PartenaireService
 * @author simon
 */
@SpringBootTest
public class PartenaireServiceTest { 
    @Autowired
    private PartenaireService partenaireService;
    
    public PartenaireServiceTest() {
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
     * Test of listFromJSONArray method, of class PartenaireService.
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @Test
    public void testListFromJSONArray() throws IOException, ParseException {
        System.out.println("importFromJSON : Partenaire list");
        
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(new FileReader("src/test/resources/json/test_ListPartenaire.json"));
        List<Partenaire> listPartenaire = partenaireService.listFromJSONArray(json);
        
        assertEquals(listPartenaire.size(), 2);
        
        for (Partenaire partenaire: listPartenaire) {
            assertNotNull(partenaire);
            assertNotNull(partenaire.getStructureRattachement());
        }
    }
    
}
