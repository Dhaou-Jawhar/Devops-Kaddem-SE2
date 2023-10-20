package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class EquipeStaticTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;
    @Mock
    private EquipeRepository equipeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEquipe() {
        Equipe equipeToAdd = new Equipe("BSB", Niveau.SENIOR);
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipeToAdd);

        Equipe addEquipe = equipeService.addEquipe(equipeToAdd);

        assertEquals("BSB", addEquipe.getNomEquipe());
        System.err.println("Test 1: ADD Method\n One Line with NameEquipe = " + addEquipe.getNomEquipe() + " && Niveau Equipe = " + addEquipe.getNiveau() + " is added successfully");
    }

    @Test
    void testUpdateEquipe() {
        // Arrange
        Equipe existingEquipe = new Equipe(1, "Existing Equipe Name");

        // Mock the repository behavior
        when(equipeRepository.findById(existingEquipe.getIdEquipe())).thenReturn(Optional.of(existingEquipe));
        when(equipeRepository.save(any(Equipe.class))).thenAnswer(invocation -> {
            Equipe updatedEntity = invocation.getArgument(0);
            // Simulate the entity being updated in the database
            existingEquipe.setNomEquipe(updatedEntity.getNomEquipe());
            existingEquipe.setNiveau(updatedEntity.getNiveau());
            return existingEquipe;
        });
        System.err.println("Test 2: Update Method \n Befor Test Update = " + existingEquipe.getNomEquipe());
        // Act
        // Change the name of the existingUniversity
        existingEquipe.setNomEquipe("Updated Equipe Name");
        Equipe updatedEquipe = equipeService.updateEquipe(existingEquipe, 1);

        // Assert
        assertEquals("Updated Equipe Name", updatedEquipe.getNomEquipe());
        // Verify that the save method was called with the updated entity
        verify(equipeRepository).save(existingEquipe);

        System.err.println(" After Test Update = " + existingEquipe.getNomEquipe());
    }

    @Test
    void testRetrieveAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();

        Equipe equipe1 = new Equipe("Barcelona", Niveau.SENIOR);
        Equipe equipe2 = new Equipe("RealMadrid", Niveau.JUNIOR);

        equipes.add(equipe1);
        equipes.add(equipe2);

        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> result = equipeService.retrieveAllEquipes();

        if (result.size() == 2) {
            log.info("Test Passed: Le nombre de résultats est de 2 comme prévu.");
            System.err.println("Test 3: FetchAll Method() \n Test réussi : Le nombre de résultats est de 2 comme prévu.");

            // Afficher la liste des équipes dans la console
            for (Equipe equipe : result) {
                System.out.println("Nom de l'équipe : " + equipe.getNomEquipe() + " | " + "Niveau de l'équipe : " + equipe.getNiveau());
            }
        } else {
            log.info("Test échoué : Le nombre de résultats attendu était 2, mais on a obtenu " + result.size());
            System.err.println("Test 3: FetchAll Method() \n Test échoué : Le nombre de résultats attendu était 2, mais on a obtenu " + result.size());
        }

        assertEquals(2, result.size());
    }


}
