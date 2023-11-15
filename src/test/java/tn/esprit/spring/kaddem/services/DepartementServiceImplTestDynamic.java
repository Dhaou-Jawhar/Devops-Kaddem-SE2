//package tn.esprit.spring.kaddem.services;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.spring.kaddem.entities.Departement;
//import tn.esprit.spring.kaddem.repositories.DepartementRepository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class DepartementServiceImplTestDynamic {
//    @Autowired
//    private DepartementServiceImpl departementService;
//
//    @Autowired
//    private DepartementRepository departementRepository;
//
//   /* @BeforeEach
//    public void setUp() {
//        // Assurez-vous que la base de données est vide au début de chaque test
//        departementRepository.deleteAll();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        // Effacez la base de données après chaque test
//        departementRepository.deleteAll();
//    }
//*/
//    @Test
//    void retrieveAllDepartements() {
//        List<Departement> departements = departementService.retrieveAllDepartements();
//        assertFalse(departements.isEmpty());
//        System.out.println("Liste des départements dans la table de département :");
//        for (Departement departement : departements) {
//            System.err.println("ID : " + departement.getIdDepart() + ", Nom : " + departement.getNomDepart());
//        }
//    }
//
//    @Test
//    void addDepartement() {
//        Departement dep = new Departement();
//        dep.setNomDepart("amen1");
//        Departement adddep = departementService.addDepartement(dep);
//        assertNotNull(adddep);
//        assertEquals("amen1", adddep.getNomDepart());
//        System.out.println("Step 1: Add a Departement : Test Passed");
//    }
//
//    @Test
//    void updateDepartement() {
//        Departement existingDepartement = new Departement();
//        existingDepartement.setIdDepart(34);
//        existingDepartement.setNomDepart("Updated Departement Name");
//        Departement savedDepartement = departementRepository.save(existingDepartement);
//        String updatedName = "wiem";
//        savedDepartement.setNomDepart(updatedName);
//        Departement updatedDepartement = departementService.updateDepartement(savedDepartement);
//        Departement retrievedDepartement = departementRepository.findById(updatedDepartement.getIdDepart()).orElse(null);
//        assertNotNull(retrievedDepartement);
//        assertEquals(updatedName, retrievedDepartement.getNomDepart());
//        System.err.println("Test updateDepartement réussi !");
//    }
//
//    @Test
//    void retrieveDepartement() {
//        Departement departmentToRetrieve = new Departement();
//        departmentToRetrieve.setNomDepart("Test Department");
//        Departement addedDepartment = departementService.addDepartement(departmentToRetrieve);
//
//        System.err.println("Récupération du département avec l'ID : " + addedDepartment.getIdDepart()+" "+ addedDepartment.getNomDepart());
//
//        Departement retrievedDepartment = departementService.retrieveDepartement(addedDepartment.getIdDepart());
//
//        assertEquals(addedDepartment.getIdDepart(), retrievedDepartment.getIdDepart());
//        assertEquals(addedDepartment.getNomDepart(), retrievedDepartment.getNomDepart());
//
//        System.out.println("Le département a été récupéré avec succès.");
//    }
    /************************************senario*******************************************/
   /* @Test
    public void testDepartement() {

        // Étape 1 : Ajouter un département
        Departement newDepartement = new Departement();
        newDepartement.setNomDepart("Computer Science2");
        Departement addedDepartement = departementService.addDepartement(newDepartement);
        assertNotNull(addedDepartement);
        System.err.println("Étape 1 : Ajouter un département : Test réussi "+newDepartement.getNomDepart());

        // Étape 2 : Récupérer le département par ID
        Integer idToRetrieve = addedDepartement.getIdDepart();
        Departement retrievedDepartement = departementService.retrieveDepartement(idToRetrieve);
        assertNotNull(retrievedDepartement);
        assertEquals(idToRetrieve, retrievedDepartement.getIdDepart());
        System.err.println("Étape 2 : Récupérer un département par ID : Test réussi (Nom du département = " + retrievedDepartement.getNomDepart() + ")");

        // Étape 3 : Mettre à jour le département
        addedDepartement.setNomDepart("Updated Computer Science1");
        Departement updatedDepartement = departementService.updateDepartement(addedDepartement);
        Integer idToVerify = updatedDepartement.getIdDepart();
        Departement verifiedDepartement = departementService.retrieveDepartement(idToVerify);
        assertNotNull(verifiedDepartement);
        assertEquals(idToVerify, verifiedDepartement.getIdDepart());
        assertEquals("Updated Computer Science1", verifiedDepartement.getNomDepart());
        System.err.println("Étapes  3 : Mettre à jour et vérifier le département : Test réussi (Nom du département mis à jour = " + verifiedDepartement.getNomDepart() + ")");

        // Étape 4 : Récupérer tous les départements
        List<Departement> allDepartements = departementService.retrieveAllDepartements();
        assertNotNull(allDepartements);
        assertFalse(allDepartements.isEmpty());
        System.err.println("Étape 4 : Récupérer Liste des départements : Test réussi");
        for (Departement retrievedDepart : allDepartements) {
            System.out.println("ID : " + retrievedDepart.getIdDepart() + ", Nom : " + retrievedDepartement.getNomDepart());
        }
        // Étape 5 : Supprimer le département
        Integer idToDelete = addedDepartement.getIdDepart();
        departementService.deleteDepartement(idToDelete);
        Departement deletedDepartement = null;
        try {
            deletedDepartement = departementService.retrieveDepartement(idToDelete);
        } catch (NoSuchElementException e) {
            System.err.println("Étape 5: Supprimer un département et vérifier : Test réussi");
        }

        if (deletedDepartement != null) {
            System.err.println("Étape 5 : Supprimer un département et vérifier : Test échoué");
        }
    }*/


//}
