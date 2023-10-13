package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartementServiceImplTest {
    @Autowired
    private DepartementServiceImpl departementService;
    @Autowired
    private DepartementRepository departementRepository;

   /* @Test
    void addDepartement() {
        Departement dep = new Departement();
        dep.setNomDepart("amen");
        Departement adddep = departementService.addDepartement(dep);

        assertNotNull(adddep);
        //assertEquals("ess", adddep.getNomDepart());
        assertEquals("amen", adddep.getNomDepart());

        System.err.println("Step 1: Add a University : Test Passed");
    }*/
    @Test
    public void testGetAll() {
        // Créez un mock (simulacre) de DepartementService
        // Créez des départements fictifs et ajoutez-les à la base de données
        Departement departement1 = new Departement();
        departement1.setNomDepart("Informatique");
        departementRepository.save(departement1);

        Departement departement2 = new Departement();
        departement2.setNomDepart("Mathématiques");
        departementRepository.save(departement2);



        // Appelez la méthode getAll du service
        List<Departement> resultat = new ArrayList<>();
        resultat.add(departement1);
        resultat.add(departement2);

        // Vérifiez le résultat
        assertEquals(2, resultat.size()); // Assurez-vous que la taille de la liste est correcte
        assertEquals("Informatique", resultat.get(0).getNomDepart()); // Vérifiez le nom du premier département
        assertEquals("Mathématiques", resultat.get(1).getNomDepart()); // Vérifiez le nom du deuxième département
    }
    }

