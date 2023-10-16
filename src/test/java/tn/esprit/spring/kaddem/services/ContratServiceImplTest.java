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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

class ContratServiceImplTest {


    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository; // You need to create ContratRepository for data access

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
}