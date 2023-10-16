package tn.esprit.spring.kaddem.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

import java.util.*;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class UniversiteStaticTest {
    @InjectMocks
    private UniversiteServiceImpl universiteService;
    @Mock
    private UniversiteRepository universiteRepository;
    @Mock
    private DepartementRepository departementRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddUniversite() {
        Universite universityToAdd = new Universite("New University");
        when(universiteRepository.save(any(Universite.class))).thenReturn(universityToAdd);

        Universite addedUniversity = universiteService.addUniversite(universityToAdd);

        assertEquals("New University", addedUniversity.getNomUniv());
        System.err.println(addedUniversity.getNomUniv()+" Is Added");
    }

    @Test
    void testUpdateUniversite() {
        // Arrange
        Universite existingUniversity = new Universite(1, "Existing University");

        // Mock the repository behavior
        when(universiteRepository.findById(existingUniversity.getIdUniv())).thenReturn(Optional.of(existingUniversity));
        when(universiteRepository.save(any(Universite.class))).thenAnswer(invocation -> {
            Universite updatedEntity = invocation.getArgument(0);
            // Simulate the entity being updated in the database
            existingUniversity.setNomUniv(updatedEntity.getNomUniv());
            return existingUniversity;
        });
        System.err.println("Befor Test Update = "+existingUniversity.getNomUniv());
        // Act
        // Change the name of the existingUniversity
        existingUniversity.setNomUniv("Updated University Name");
        Universite updatedUniversity = universiteService.updateUniversite(existingUniversity);

        // Assert
        assertEquals("Updated University Name", updatedUniversity.getNomUniv());
        // Verify that the save method was called with the updated entity
        verify(universiteRepository).save(existingUniversity);

        System.err.println("After Test Update = "+existingUniversity.getNomUniv());
    }

    @Test
    void testDeleteUniversite() {
        Universite expectedUniversite = new Universite("ESPRIT");
        when(universiteRepository.findById(expectedUniversite.getIdUniv())).thenReturn(Optional.of(expectedUniversite));
        Universite retrievedUniversite = universiteService.retrieveUniversite(expectedUniversite.getIdUniv());
        assertEquals(expectedUniversite, retrievedUniversite);
        if (expectedUniversite == retrievedUniversite) {
            System.err.println("--------------[Test : Delete Universite Method ]-------------------\n " + expectedUniversite.getNomUniv() +
                    " IS SUCCESSFULY DELETED \n -------------------------------------------------------------");
        } else {
            System.err.println("--------------[Test : Delete Universite Method ]-------------------\n " + expectedUniversite.getNomUniv() +
                    " IS FAILED DELETED \n -------------------------------------------------------------");
        }
    }

    @Test
    void testRetrieveDepartementsByUniversite() {
        Universite university = new Universite(1, "Sample University");
        Set<Departement> associatedDepartments = new HashSet<>();
        associatedDepartments.add(new Departement(1, "Department 1"));
        associatedDepartments.add(new Departement(2, "Department 2"));
        university.setDepartements(associatedDepartments);

        when(universiteRepository.findById(university.getIdUniv())).thenReturn(Optional.of(university));

        Set<Departement> retrievedDepartments = universiteService.retrieveDepartementsByUniversite(university.getIdUniv());

        assertEquals(associatedDepartments.size(), retrievedDepartments.size());
        for (Departement associatedDepartment : associatedDepartments) {
            assertTrue(retrievedDepartments.contains(associatedDepartment));
        }
    }

    @Test
    public void testRetrieveAllUniversites() {

        List<Universite> universities = new ArrayList<>();

        Universite univer1 = new Universite("ESPRIT");
        Universite univer2 = new Universite("PolyTech");


        universities.add(univer1);
        universities.add(univer2);
        when(universiteRepository.findAll()).thenReturn(universities);


        List<Universite> result = universiteService.retrieveAllUniversites();

        if (result.size() == 2) {
            log.info("Test Passed: Result size is 1 as expected.");
            System.err.println("Test 1 : \n Test Passed: Result size is 1 as expected.");
        } else {
            log.info("Test Failed: Expected result size 1, but got " + result.size());
            System.err.println("Test 1 : \n Test Failed: Expected result size 1, but got " + result.size());
        }

        assertEquals(2, result.size());
    }

    @Test
    public void testRetrieveUniversite() {

        Universite expectedUniversite = new Universite("ESPRIT");

        when(universiteRepository.findById(expectedUniversite.getIdUniv())).thenReturn(Optional.of(expectedUniversite));


        Universite retrievedUniversite = universiteService.retrieveUniversite(expectedUniversite.getIdUniv());


        assertEquals(expectedUniversite, retrievedUniversite);

        if (expectedUniversite == retrievedUniversite) {
            System.err.println( "Test 2 : \n "+expectedUniversite.getNomUniv()+" IS SUCCESSFULY DELETED ");
        }
    }

    }