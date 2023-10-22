package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.spring.kaddem.entities.Encadrant;
import tn.esprit.spring.kaddem.repositories.EncadrantRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

//@SpringBootTest
//@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)

class EncadrantServiceImpTest {
    @InjectMocks
    private EncadrantServiceImp encadrantService;

    @Mock
    private EncadrantRepository encadrantRepository;



    @Test
    public void testAddEncadrant() {
        // Arrange
        Encadrant encadrant = new Encadrant();
        encadrant.setNomEncadrant("Eya");

        // Configurer le comportement du mock
        when(encadrantRepository.save(encadrant)).thenReturn(encadrant);

        // Act
        Encadrant result = encadrantService.addEncadrant(encadrant);

        // Assert
        assertEquals(encadrant, result, "Adding Encadrant should return the same instance");
        assertEquals("Eya", result.getNomEncadrant());
        System.out.println(result.getNomEncadrant()+" ajouté");
    }
    @Test
    public void testUpdateEncadrant() {
        // Créer un objet Encadrant simulé
        Encadrant encadrantSimule = new Encadrant(1, "Nom1", "Prenom1", new Date(), new HashSet<>());

        // Configurer le comportement du mock
        when(encadrantRepository.save(encadrantSimule)).thenReturn(encadrantSimule);

        // Appeler la méthode à tester
        Encadrant resultat = encadrantService.updateEncadrant(encadrantSimule);

        // Vérifier que la méthode save() a été appelée avec les bonnes valeurs
        verify(encadrantRepository, times(1)).save(encadrantSimule);

        // Effectuer des assertions sur le résultat si nécessaire
        assertEquals(encadrantSimule, resultat);
    }
    @Test
    public void testDeleteEncadrant() {
        // ID simulé pour le test
        Integer idEncadrantSimule = 1;

        // Appeler la méthode à tester
        encadrantService.deleteEncadrant(idEncadrantSimule);

        // Vérifier que la méthode deleteById() a été appelée avec le bon argument
        verify(encadrantRepository, times(1)).deleteById(idEncadrantSimule);
    }
    @Test
    public void testGetEncadrantById() {
        // ID simulé pour le test
        Integer idEncadrantSimule = 1;

        // Créer un objet Encadrant simulé pour le retour de findById
        Encadrant encadrantSimule = new Encadrant(idEncadrantSimule, "Nom1", "Prenom1", new Date(), new HashSet<>());

        // Configurer le comportement du mock
        when(encadrantRepository.findById(idEncadrantSimule)).thenReturn(Optional.of(encadrantSimule));

        // Appeler la méthode à tester
        Encadrant resultat = encadrantService.getEncadrantById(idEncadrantSimule);

        // Vérifier que la méthode findById() a été appelée avec le bon argument
        verify(encadrantRepository, times(1)).findById(idEncadrantSimule);

        // Effectuer des assertions sur le résultat
        assertEquals(encadrantSimule, resultat);
    }
}






