package tn.esprit.spring.kaddem.services;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
class TestStatiqueEtudiantServiceImpl {
//    chbvddy
    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private DepartementServiceImpl departementService;

    @Mock
    private EquipeServiceImpl equipeService;

    @Mock
    private ContratServiceImpl contratService;

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
        MockitoAnnotations.initMocks(this);

    }

    @AfterEach
    public void cleanup() {
        departementRepository.deleteAll();
        etudiantRepository.deleteAll();
        equipeRepository.deleteAll();
        contratRepository.deleteAll();
    }


    @Test
    void Etape1() {
        System.err.println("<============================ Début du scénario de test ============================>");

        // Étape 1 : Ajouter trois étudiants
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNomE("Étudiant 1");
        etudiant1.setIdEtudiant(1);
        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNomE("Étudiant 2");
        etudiant2.setIdEtudiant(2);
        Etudiant etudiant3 = new Etudiant();
        etudiant3.setNomE("Étudiant 3");
        etudiant3.setIdEtudiant(3);

        when(etudiantRepository.save(etudiant1)).thenReturn(etudiant1);
        when(etudiantRepository.save(etudiant2)).thenReturn(etudiant2);
        when(etudiantRepository.save(etudiant3)).thenReturn(etudiant3);

        Etudiant ajoutEtudiant1 = etudiantService.addEtudiant(etudiant1);
        Etudiant ajoutEtudiant2 = etudiantService.addEtudiant(etudiant2);
        Etudiant ajoutEtudiant3 = etudiantService.addEtudiant(etudiant3);

        // Assertions
        assertNotNull(ajoutEtudiant1);
        assertNotNull(ajoutEtudiant2);
        assertNotNull(ajoutEtudiant3);

        System.err.println("Étape 1 : Ajout de trois étudiants");
        System.err.println(ajoutEtudiant1);
        System.err.println(ajoutEtudiant2);
        System.err.println(ajoutEtudiant3);
    }


    @Test
    void Etape2() {
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNomE("Étudiant 1");
        etudiant1.setIdEtudiant(1);
        when(etudiantRepository.save(etudiant1)).thenReturn(etudiant1);
        Etudiant ajoutEtudiant1 = etudiantService.addEtudiant(etudiant1);

        // Étape 2 : Modifier l'étudiant 1
        ajoutEtudiant1.setNomE("Nouveau Nom Étudiant 1");
        Etudiant modifEtudiant1 = etudiantService.updateEtudiant(ajoutEtudiant1);

        // Assertion pour vérifier que le nom de l'étudiant a été modifié
        assertEquals("Nouveau Nom Étudiant 1", modifEtudiant1.getNomE());

        System.err.println("Étape 2 : Modification de l'étudiant 1");
        System.err.println(modifEtudiant1);
    }

    @Test
    void Etape3() {
        Etudiant etudiant1 = new Etudiant();
        etudiant1.setNomE("Étudiant 1");
        etudiant1.setIdEtudiant(1);
        when(etudiantRepository.save(etudiant1)).thenReturn(etudiant1);
        Etudiant ajoutEtudiant1 = etudiantService.addEtudiant(etudiant1);

        // Étape 3 : Afficher l'étudiant 1 (en utilisant @Mock)
        when(etudiantRepository.findById(ajoutEtudiant1.getIdEtudiant())).thenReturn(Optional.of(ajoutEtudiant1));
        Etudiant etudiant1Retrouve = etudiantService.retrieveEtudiant(ajoutEtudiant1.getIdEtudiant());

        // Assertion pour vérifier que l'étudiant récupéré est le même que celui ajouté
        assertEquals(ajoutEtudiant1, etudiant1Retrouve);

        System.err.println("Étape 3 : Récupération de l'étudiant 1");
        System.err.println(etudiant1Retrouve);
    }

    @Test
    void Etape4() {
        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNomE("Étudiant 2");
        etudiant2.setIdEtudiant(2);
        when(etudiantRepository.save(etudiant2)).thenReturn(etudiant2);
        Etudiant ajoutEtudiant2 = etudiantService.addEtudiant(etudiant2);

        // Étape 4 : Suppression de l'étudiant 2 (en utilisant @Mock)
        when(etudiantRepository.findById(ajoutEtudiant2.getIdEtudiant())).thenReturn(Optional.of(ajoutEtudiant2));
        doNothing().when(etudiantRepository).delete(ajoutEtudiant2);
        etudiantService.removeEtudiant(ajoutEtudiant2.getIdEtudiant());

        // Assertion pour vérifier que l'étudiant 2 a bien été supprimé
        verify(etudiantRepository, times(1)).delete(ajoutEtudiant2);

        System.err.println("Étape 4 : Suppression de l'étudiant 2 ");

    }

    @Test
    void Etape5() {
        // Étape 5 : Création d'un département
        Departement departement = new Departement();
        departement.setNomDepart("Département Test");
        departement.setIdDepart(1);

        departementService.addDepartement(departement);

        // Assurez-vous que le département a été créé avec succès et n'est pas null
        assertNotNull(departement);
        System.err.println("Étape 5 : Création d'un nouveau département : " + departement);
    }

    @Test
    void Etape6() {
        Departement departement = new Departement();
        departement.setNomDepart("Département Test");
        departement.setIdDepart(1);
        Etudiant etudiant3 = new Etudiant();
        etudiant3.setNomE("Étudiant 3");
        etudiant3.setIdEtudiant(2);
        when(etudiantRepository.save(etudiant3)).thenReturn(etudiant3);
        Etudiant ajoutEtudiant3 = etudiantService.addEtudiant(etudiant3);

        departementService.addDepartement(departement);
        // Étape 6 : Affectation de l'étudiant 3 au département (en utilisant @Mock)
        // Simuler le comportement de etudiantRepository.findById() pour retourner l'étudiant ajoutEtudiant3
        when(etudiantRepository.findById(ajoutEtudiant3.getIdEtudiant())).thenReturn(Optional.of(ajoutEtudiant3));

        // Simuler le comportement de departementRepository.findById() pour retourner le département ajoutDepartement
        when(departementRepository.findById(departement.getIdDepart())).thenReturn(Optional.of(departement));

        // Appelez la méthode qui affecte l'étudiant au département
        etudiantService.assignEtudiantToDepartement(ajoutEtudiant3.getIdEtudiant(), departement.getIdDepart());

        // Assertion pour vérifier que l'étudiant a bien été affecté au département
        assertEquals(ajoutEtudiant3.getDepartement(),departement);

        System.err.println("Étape 6 : Affectation de l'étudiant " + ajoutEtudiant3.getNomE() + " au département " + departement.getNomDepart());
        System.err.println(departement);
        System.err.println(ajoutEtudiant3);

    }

    @Test
    void Etape7() {
        // Étape 7 : Création d'une équipe (en utilisant @Mock)
        Set<Etudiant> etudiants = new HashSet<>();
        Equipe equipe = new Equipe();
        equipe.setNomEquipe("Équipe Test");
        equipe.setIdEquipe(1);
        equipe.setEtudiants(etudiants);
        equipeService.addEquipe(equipe);

        // Assertion pour vérifier que l'équipe a été créée avec succès et n'est pas null
        assertNotNull(equipe);

        System.err.println("Étape 7 : Création d'une équipe");
        System.err.println(equipe);
    }

    @Test
    void Etape8() {
        // Étape 8 : Création d'un contrat (en utilisant @Mock)
        Contrat contrat = new Contrat();
        contrat.setMontantContrat(500);
        contrat.setIdContrat(1);
        contratService.addContrat(contrat);

        // Assertion pour vérifier que le contrat a été créé avec succès et n'est pas null
        assertNotNull(contrat);

        System.err.println("Étape 8 : Création d'un contrat");
        System.err.println(contrat);
    }

    @Test
    void Etape9() {
        Set<Etudiant> etudiants = new HashSet<>();
        Equipe equipe = new Equipe();
        equipe.setNomEquipe("Équipe Test");
        equipe.setIdEquipe(1);
        equipe.setEtudiants(etudiants);
        equipeService.addEquipe(equipe);

        Contrat contrat = new Contrat();
        contrat.setMontantContrat(500);
        contrat.setIdContrat(1);
        contratService.addContrat(contrat);

        // Étape 9 : Affectation d'un étudiant à une équipe et un contrat (en utilisant @Mock)
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE("HOUSSEM");
        etudiant.setIdEtudiant(7);

        when(etudiantRepository.findById(etudiant.getIdEtudiant())).thenReturn(Optional.of(etudiant));
        when(equipeRepository.findById(equipe.getIdEquipe())).thenReturn(Optional.of(equipe));
        when(contratRepository.findById(contrat.getIdContrat())).thenReturn(Optional.of(contrat));

        Etudiant etudiantAffecte = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, contrat.getIdContrat(), equipe.getIdEquipe());

        assertNotNull(etudiantAffecte); // Vérifie que l'étudiant a bien été ajouté
        assertEquals(etudiant.getIdEtudiant(), etudiantAffecte.getIdEtudiant()); // Vérifie l'ID de l'étudiant
        assertTrue(equipe.getEtudiants().contains(etudiantAffecte)); // Vérifie que l'étudiant est associé à l'équipe
        assertEquals(contrat.getEtudiant(), etudiantAffecte);

        System.err.println("Étape 9 : Ajout de l'étudiant " + etudiant.getNomE() + " avec affectation à une équipe et un contrat ");
        System.err.println("<============================ Fin du scénario de test ============================>");

    }
}