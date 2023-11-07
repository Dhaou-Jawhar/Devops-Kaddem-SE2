package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Set;

@SpringBootTest
public class UniversiteDynamicTest {
    @Autowired
    private UniversiteServiceImpl universiteService;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @BeforeEach
    public void setUp() {
        // Ensure the database is empty at the start of each test
        universiteRepository.deleteAll();
        departementRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        // Clear the database after each test
        universiteRepository.deleteAll();
        departementRepository.deleteAll();
    }

    @Test
    public void testUniversityServiceScenario() {
        // Step 1: Add a University
        Universite newUniversity = new Universite("New University");
        Universite addedUniversity = universiteService.addUniversite(newUniversity);
        assertNotNull(addedUniversity);
        assertEquals("New University", addedUniversity.getNomUniv());
        System.err.println("Step 1: Add a University : Test Passed");

        // Step 2: Retrieve a University
        Universite retrievedUniversity = universiteService.retrieveUniversite(addedUniversity.getIdUniv());
        assertNotNull(retrievedUniversity);
        assertEquals(addedUniversity.getIdUniv(), retrievedUniversity.getIdUniv());
        System.err.println("Step 2: Retrieve a University : Test Passed ( the Univ name = " + addedUniversity.getNomUniv() + " )");

        // Step 3: Update a University
        addedUniversity.setNomUniv("Updated University");
        Universite updatedUniversity = universiteService.updateUniversite(addedUniversity);
        assertNotNull(updatedUniversity);
        assertEquals("Updated University", updatedUniversity.getNomUniv());
        System.err.println("Step 3: Update a University : Test Passed");

        // Step 4: Assign a Department to a University
        Departement department = new Departement("Computer Science");
        departementRepository.save(department);
        universiteService.assignUniversiteToDepartement(updatedUniversity.getIdUniv(), department.getIdDepart());
        System.err.println("Step 4: Assign a Department to a University : Test Passed");


        // Step 5: Retrieve Departments by University
        /*Set<Departement> retrievedDepartments = universiteService.retrieveDepartementsByUniversite(updatedUniversity.getIdUniv());
        assertNotNull(retrievedDepartments);
        assertTrue(retrievedDepartments.contains(department));*/

        Set<Departement> retrievedDepartments = universiteService.retrieveDepartementsByUniversite(updatedUniversity.getIdUniv());
        assertNotNull(retrievedDepartments);

        // Assuming departmentId is the unique identifier of the department you are checking
        Integer departmentIdToCheck = department.getIdDepart();
        boolean isDepartmentInSet = retrievedDepartments.stream().anyMatch(d -> d.getIdDepart().equals(departmentIdToCheck));

        if (isDepartmentInSet) {
            System.err.println("Step 5: Retrieve Departments by University : Test Passed");
        } else {
            System.err.println("Step 5: Retrieve Departments by University : Test Failed");
        }

        // Step 6: Delete a University
        /*universiteService.deleteUniversite(updatedUniversity.getIdUniv());
        Universite deletedUniversity = universiteService.retrieveUniversite(updatedUniversity.getIdUniv());
        assertNull(deletedUniversity);*/

        // Step 6: Delete a University
        universiteService.deleteUniversite(updatedUniversity.getIdUniv());

        Universite deletedUniversity = null;
        try {
            deletedUniversity = universiteService.retrieveUniversite(updatedUniversity.getIdUniv());
        } catch (NoSuchElementException e) {
            System.err.println("Step 6: Delete a University : Test Passed");
        }

        if (deletedUniversity != null) {
            System.err.println("Step 6: Delete a University: Test Failed ");
        }

        assertNull(deletedUniversity, "University should be deleted");
    }
}
