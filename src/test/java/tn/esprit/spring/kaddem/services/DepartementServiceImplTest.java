package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartementServiceImplTest {
    @Autowired
    private DepartementServiceImpl departementService;

    @Test
    void addDepartement() {
        Departement dep = new Departement();
        dep.setNomDepart("amen");
        Departement adddep = departementService.addDepartement(dep);

        assertNotNull(adddep);
        //assertEquals("ess", adddep.getNomDepart());
        assertEquals("amen", adddep.getNomDepart());

        System.err.println("Step 1: Add a University : Test Passed");
    }
}