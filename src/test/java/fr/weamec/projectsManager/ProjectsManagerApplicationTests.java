package fr.weamec.projectsManager;

import fr.weamec.projectsManager.model.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectsManagerApplicationTests {
    @Test
    void contextLoads() {
    }
    
    /**
     * Test si la conversion de date fonctionne
     * @author simon
     * @throws Exception Test echoue
     */
    @Test
    void dateWellConverts() throws Exception {
        Date date = new Date(1, 6, 55);
        
        if (!"0055-06-01".equals(date.toString())) {
            throw new Exception();
        }
    }
}
