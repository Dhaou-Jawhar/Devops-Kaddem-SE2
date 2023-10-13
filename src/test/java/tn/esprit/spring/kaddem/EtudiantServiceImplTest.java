package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
public class EtudiantServiceImplTest {
    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;

    @Mock
    private DepartementRepository departementRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void cleanup() {

        etudiantRepository.deleteAll();

    }


    @Test
    @Transactional
    public void testRetrieveAllEtudiants() {
        System.err.println("Etape 1 de la méthode testRetrieveAllEtudiants \n Création de la liste d'étudiants!");
        // Create a list of Etudiant objects for testing
        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNomE("Jawher");
        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNomE("Houssem");
        etudiantService.addEtudiant(etudiant1);
        etudiantService.addEtudiant(etudiant2);
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);


        System.err.println("Etape 2 de la méthode testRetrieveAllEtudiants \n Affichage de la liste d'étudiants!"+etudiantRepository.findAll());


       // when(etudiantRepository.findAll()).thenReturn(etudiants);

        List<Etudiant> result = etudiantService.retrieveAllEtudiants();
        System.err.println("Etape 3 de la méthode testRetrieveAllEtudiants \n Vérification du résultat!");



        if (etudiants.size() == result.size()) {
            log.info("Le test a réussi : La taille de la liste correspond.");
        } else {
            log.error("Le test a échoué : La taille de la liste ne correspond pas.");
        }
       // System.err.println("Etape 4 de la méthode testRetrieveAllEtudiants \n Vérification des conditions attendues!");

        // Utilisez des assertions pour vérifier les conditions attendues
        assertEquals(2, result.size());
    }

    @Test
    @Transactional
    public void testAddEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("Houssem");

        // Définir un indicateur pour contrôler le succès ou l'échec
        boolean success = true;

        // Utiliser une réponse conditionnelle en fonction de l'indicateur
        if (success) {
            // Simuler un retour réussi lors de l'ajout de l'étudiant
            when(etudiantRepository.save(etudiant)).thenReturn(etudiant);
        } else {
            // Simuler un échec lors de l'ajout de l'étudiant (retour null)
            when(etudiantRepository.save(etudiant)).thenReturn(null);
        }

        try {
            // Appeler la méthode que vous testez
            Etudiant result = etudiantService.addEtudiant(etudiant);

            // Vérifier si le résultat renvoyé est non null (cas de succès)
            assertNotNull(result);

            // Cas de succès du test
            log.info("Test Add Etudiant a réussi !");
        } catch (Exception e) {
            // Cas d'échec du test en raison de l'exception
            log.error("Test Add Etudiant a échoué comme prévu en raison de l'exception : " + e.getMessage());
        }
    }
    @Test
    public void testAssignEtudiantToDepartement() {
        Integer etudiantId = 1;
        Integer departementId = 2;
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("Houssem");
        Departement departement = new Departement();
        departement.setNomDepart("5SE2");

        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(etudiant));
        when(departementRepository.findById(departementId)).thenReturn(Optional.of(departement));

        etudiantService.assignEtudiantToDepartement(etudiantId, departementId);

        if (departement.equals(etudiant.getDepartement())) {
            log.info("Test Assign Etudiant To Departement a réussi !");
        } else {
            log.error("Test Assign Etudiant To Departement a échoué !");
        }

        verify(etudiantRepository, times(1)).save(etudiant);
    }

}
