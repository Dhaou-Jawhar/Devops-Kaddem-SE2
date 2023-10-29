package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import java.util.*;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

class ContratStaticTest {


    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;
    @Mock
    private EtudiantRepository etudiantRepository;
    // You need to create ContratRepository for data access

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllContrats() {
        // Create a list of sample Contrats
        List<Contrat> sampleContrats = new ArrayList<>();

        Contrat contrat1 = new Contrat();
        contrat1.setIdContrat(1);
        contrat1.setMontantContrat(1000);
        // Set other properties as needed
        sampleContrats.add(contrat1);

        Contrat contrat2 = new Contrat();
        contrat2.setIdContrat(2);
        contrat2.setMontantContrat(2000);
        // Set other properties as needed
        sampleContrats.add(contrat2);

        // Mock the behavior of the contratRepository to return the sampleContrats when retrieveAllContrats is called
        when(contratRepository.findAll()).thenReturn(sampleContrats);

        // Call the service method
        List<Contrat> result = contratService.retrieveAllContrats();

        // Verify that the service method returned the expected data
        assertEquals(sampleContrats, result);

        System.err.println("testRetrieveAllContrats : SUCCESS");
    }

    @Test
    public void testAddContrat() {
        // Create a sample Contrat to add
        Contrat newContrat = new Contrat();
        newContrat.setIdContrat(3);
        newContrat.setDateDebutContrat(new Date()); // You can use java.util.Date for date fields
        newContrat.setDateFinContrat(new Date());
        newContrat.setSpecialite(Specialite.IA); // Replace with a valid enum value
        newContrat.setArchive(false);
        newContrat.setMontantContrat(5000);

        // Create a sample Etudiant
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("John");
        newContrat.setEtudiant(etudiant);

        // Mock the behavior of the contratRepository to save the newContrat and return it
        when(contratRepository.save(newContrat)).thenReturn(newContrat);

        // Call the service method
        Contrat addedContrat = contratService.addContrat(newContrat);

        // Verify that the service method returned the added contract
        assertEquals(newContrat, addedContrat);

        // Verify that the save method was called on the contratRepository
        verify(contratRepository, times(1)).save(newContrat);

        System.err.println("testAddContrat : SUCCESS");

}
    @Test
    public void testUpdateContrat() {
        // Create a sample Contrat to update
        Contrat existingContrat = new Contrat();
        existingContrat.setIdContrat(1);
        // Set other properties as needed

        // Mock the behavior of the contratRepository to save the updated Contrat and return it
        when(contratRepository.save(existingContrat)).thenReturn(existingContrat);

        // Call the service method
        Contrat updatedContrat = contratService.updateContrat(existingContrat);

        // Verify that the service method returned the updated contract
        assertEquals(existingContrat, updatedContrat);

        // Verify that the save method was called on the contratRepository
        verify(contratRepository, times(1)).save(existingContrat);

        System.err.println("testUpdateContrat : SUCCESS");
    }
    @Test
    public void testRetrieveContrat() {
        // Create a sample Contrat with a known ID
        int id = 1;
        Contrat sampleContrat = new Contrat();
        sampleContrat.setIdContrat(id);
        // Set other properties as needed

        // Mock the behavior of the contratRepository to return the sampleContrat when findById is called
        when(contratRepository.findById(id)).thenReturn(Optional.of(sampleContrat));

        // Call the service method
        Contrat result = contratService.retrieveContrat(id);

        // Verify that the service method returned the expected Contrat
        assertEquals(sampleContrat, result);

        // Verify that the findById method was called on the contratRepository
        verify(contratRepository, times(1)).findById(id);

        System.err.println("testRetrieveContrat : SUCCESS");
    }
    @Test
    void testDeleteContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);

        when(contratRepository.save(contrat)).thenReturn(contrat);
        contratService.removeContrat(contrat.getIdContrat());
        List<Contrat> result = contratService.retrieveAllContrats();
        assertEquals(0, result.size());

        System.err.println("DeleteContratTest : Ok");
    }

}