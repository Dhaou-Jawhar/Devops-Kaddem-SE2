package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartementServiceImplTestDynamic {
    @Autowired
    private DepartementServiceImpl departementService;
    @Autowired
    private DepartementRepository departementRepository;

    @Test
    void retrieveAllDepartements() {
    }

    @Test
    void addDepartement() {
        Departement dep = new Departement();
        dep.setNomDepart("amen1");
        Departement adddep = departementService.addDepartement(dep);

        assertNotNull(adddep);
        //assertEquals("ess", adddep.getNomDepart());
        assertEquals("amen1", adddep.getNomDepart());

        System.err.println("Step 1: Add a University : Test Passed");
    }

    @Test
    void updateDepartement() {
    }

    @Test
    void retrieveDepartement() {
    }

    @Test
    void deleteDepartement() {
    }
}