/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package fr.weamec.projectsManager.service;

import fr.weamec.projectsManager.model.Expert;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.json.simple.JSONArray;
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
public class ExpertServiceTest {    
    public ExpertServiceTest() {
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
     * Test of listFromJSONArray method, of class ExpertService.
     * @throws java.io.IOException
     * @throws org.json.simple.parser.ParseException
     */
    @Test
    public void testListFromJSONArray() throws IOException, ParseException {
        System.out.println("importFromJSON : Expert list");
        
        ExpertService expertService = new ExpertService();
        
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(new FileReader("src/test/resources/json/test_ListExpert.json"));
        List<Expert> listExpert = expertService.listFromJSONArray(json);
        
        assertEquals(listExpert.size(), 2);
        
        for (Expert expert: listExpert) {
            assertNotNull(expert);
        }
    }
    
}
