package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
public class UniversiteServiceImplTest {

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
            System.err.println("--------------[Test 1]-------------------\n Test Passed: Result size is 1 as expected. \n -------------------------------------------------------------");
        } else {
            System.err.println("--------------[Test 1]-------------------\n Test Failed: Expected result size 1, but got " + result.size() + "\n -------------------------------------------------------------");
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
            System.err.println( "--------------[Test 1]-------------------\n "+expectedUniversite.getNomUniv()+" IS SUCCESSFULY DELETED \n -------------------------------------------------------------");
        }
    }

}
