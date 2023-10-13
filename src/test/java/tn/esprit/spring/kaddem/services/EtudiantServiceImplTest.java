package tn.esprit.spring.kaddem.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EtudiantServiceImplTest {

    @Autowired
    private EtudiantServiceImpl etudiantService;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    public void setup() {
        System.err.println("Effacement des données de la base de données!");
       etudiantRepository.deleteAll();
    }


//    @AfterEach
//    public void cleanup() {
//
//        etudiantRepository.deleteAll();
//
//    }
//    @Test
//    void addEtudiant() {
//
//        List<Etudiant> etudiants = new ArrayList<>();
//        Etudiant etudiant1 = new Etudiant();
//        etudiant1.setNomE("Jawher");
//        Etudiant etudiant2 = new Etudiant();
//        etudiant2.setNomE("Houssem");
//        etudiantService.addEtudiant(etudiant1);
//        etudiantService.addEtudiant(etudiant2);
//        etudiants.add(etudiant1);
//        etudiants.add(etudiant2);
//
//
//        System.err.println("Etape 2 de la méthode testRetrieveAllEtudiants \n Affichage de la liste d'étudiants!"+etudiantRepository.findAll());
//
//
//    }

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

        System.err.println("Etape 2 de la méthode testRetrieveAllEtudiants \n Affichage de la liste d'étudiants!"+etudiantService.getEtudiants(etudiants) );
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
}