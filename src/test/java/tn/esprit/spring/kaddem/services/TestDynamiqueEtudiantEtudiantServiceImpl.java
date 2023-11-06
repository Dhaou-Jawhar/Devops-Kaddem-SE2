package tn.esprit.spring.kaddem.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ActiveProfiles("test")
class TestDynamiqueEtudiantEtudiantServiceImpl {

    @Autowired
    private EtudiantServiceImpl etudiantService;

    @Autowired
    private DepartementServiceImpl departementService;

    @Autowired
    private EquipeServiceImpl equipeService;

    @Autowired
    private ContratServiceImpl contratService;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @BeforeEach
    public void setup() {

    }

    @AfterEach
    public void cleanup() {

        // Définir les paramètres de connexion
        String url = "jdbc:mysql://localhost:3306/kaddemdb";
        String user = "root";
        // String password = "your_password";

        try {
            // Établir une connexion à la base de données
            Connection connection = DriverManager.getConnection(url, user, "");

            // Créer un objet Statement
            Statement statement = connection.createStatement();

            // Exécuter une requête SQL pour supprimer toutes les tables
            statement.executeUpdate("DROP DATABASE kaddemdb");

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        dynamicTests.add(DynamicTest.dynamicTest("Étape 1 : Ajouter trois étudiants", () -> {
            Etudiant etudiant1 = createEtudiant("Étudiant 1", 1);
            Etudiant etudiant2 = createEtudiant("Étudiant 2", 2);
            Etudiant etudiant3 = createEtudiant("Étudiant 3", 3);

            assertNotNull(etudiant1);
            assertNotNull(etudiant2);
            assertNotNull(etudiant3);
            System.err.println("Trois étudiants crées correctement\n"+etudiant1+"\n"+etudiant2+"\n"+etudiant3);
        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 2 : Modifier l'étudiant 1", () -> {
            Optional<Etudiant> optionalEtudiant1 = retrieveEtudiant(1);

            assertTrue(optionalEtudiant1.isPresent());
            Etudiant etudiant1 = optionalEtudiant1.get();

            Etudiant modifEtudiant1 = updateEtudiant(etudiant1, "Nouveau Nom Étudiant 1");

            assertNotNull(modifEtudiant1);
            System.err.println("Etudiant "+etudiant1.getNomE()+" modifié correctement!");
        }));


        dynamicTests.add(DynamicTest.dynamicTest("Étape 3 : Afficher l'étudiant 1", () -> {
            Optional<Etudiant> optionalEtudiant1 = retrieveEtudiant(1);

            assertTrue(optionalEtudiant1.isPresent());
            Etudiant etudiant1 = optionalEtudiant1.get();

            assertNotNull(etudiant1);
            assertEquals("Nouveau Nom Étudiant 1", etudiant1.getNomE());

            System.err.println("Etudiant récupéré correctement:\n"+etudiant1);
        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 4 : Suppression de l'étudiant 2", () -> {
            removeEtudiant(2);

            System.err.println("Etudiant avec id=2 supprrimé correctement");
        }));


        dynamicTests.add(DynamicTest.dynamicTest("Étape 5 : Création d'un département", () -> {
            Departement departement = createDepartement("Département Test", 1);

            assertNotNull(departement);
            assertEquals("Département Test", departement.getNomDepart());
            System.err.println("Département crée avec succès\n"+departement);
        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 6 : Affectation de l'étudiant 3 au département", () -> {
            assignEtudiantToDepartement(3, 1);
            System.err.println("Affectation effectuée avec succés de l'étudiant avec id=3 au departement avec id=1");

        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 7 : Création d'une équipe", () -> {
            // Étape 7 : Création d'une équipe
            Set<Etudiant> etudiants1 = new HashSet<>();
            Equipe equipe = new Equipe();
            equipe.setNomEquipe("Équipe Test");
            equipe.setIdEquipe(1);
            equipe.setEtudiants(etudiants1);
            equipeService.addEquipe(equipe);

            // Assurez-vous que l'équipe a été créée avec succès et n'est pas null
            Optional<Equipe> equipeCreee = equipeRepository.findById(equipe.getIdEquipe());
            assertNotNull(equipeCreee);
            assertEquals("Équipe Test", equipeCreee.get().getNomEquipe());
            System.err.println("Equipe crée avec succès \n"+equipe);
        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 8 : Création d'un contrat", () -> {
            // Étape 8 : Création d'un contrat
            Contrat contrat = new Contrat();
            contrat.setMontantContrat(500);
            contrat.setIdContrat(1);
            contratService.addContrat(contrat);

            // Assurez-vous que le contrat a été créé avec succès et n'est pas null
            Optional<Contrat> contratCree = contratRepository.findById(contrat.getIdContrat());
            assertNotNull(contratCree);
            System.err.println("Contrat crée avec succès\n"+contrat);
        }));

        dynamicTests.add(DynamicTest.dynamicTest("Étape 9 : Affectation d'un nouvel étudiant à une équipe et un contrat", () -> {
            // Étape 9 : Affectation d'un nouvel étudiant à une équipe et un contrat
            Etudiant nouvelEtudiant = new Etudiant();
            nouvelEtudiant.setNomE("Nouvel Étudiant");
            nouvelEtudiant.setIdEtudiant(4); // Assurez-vous d'utiliser un ID unique

            // Ajoutez d'abord l'étudiant à la base de données
            etudiantService.addEtudiant(nouvelEtudiant);

            // Ensuite, affectez l'étudiant à une équipe et un contrat
            etudiantService.addAndAssignEtudiantToEquipeAndContract(nouvelEtudiant, 1, 1);

            // Assurez-vous que le nouvel étudiant a été affecté à l'équipe et au contrat
            Optional<Equipe> equipeAffectee = equipeRepository.findById(1); // Remplacez par l'ID correct de l'équipe
            Optional<Contrat> contratAffecte = contratRepository.findById(1); // Remplacez par l'ID correct du contrat
            Optional<Etudiant> nouvelEtudiantAffecte = etudiantRepository.findById(nouvelEtudiant.getIdEtudiant());
            assertNotNull(equipeAffectee);
            assertNotNull(contratAffecte);
            assertNotNull(nouvelEtudiantAffecte);

            System.err.println("Affectation de l'étudiant:\n"+nouvelEtudiant+"\n au contrat avec id=1 et a équipe avec id=1 a été effectuée avec succès!");
        }));



        return dynamicTests.stream();
    }

    private Etudiant createEtudiant(String nom, int id) {
        Etudiant etudiant = new Etudiant();
        etudiant.setNomE(nom);
        etudiant.setIdEtudiant(id);
        etudiantService.addEtudiant(etudiant);
        return etudiant;
    }

    private Etudiant updateEtudiant(Etudiant etudiant, String nouveauNom) {
        etudiant.setNomE(nouveauNom);
        etudiantService.updateEtudiant(etudiant);
        return etudiant;
    }

    private Optional<Etudiant> retrieveEtudiant(int id) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(id);
        return Optional.ofNullable(etudiant);
    }


    private void removeEtudiant(int id) {
        etudiantService.removeEtudiant(id);
    }

    private Departement createDepartement(String nom, int id) {
        Departement departement = new Departement();
        departement.setNomDepart(nom);
        departement.setIdDepart(id);
        departementService.addDepartement(departement);
        return departement;
    }

    private void assignEtudiantToDepartement(int etudiantId, int departementId) {
        etudiantService.assignEtudiantToDepartement(etudiantId, departementId);
    }


}