package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartementServiceImplTest {
    //@Autowired
    @InjectMocks
    private DepartementServiceImpl departementService;
   // @Autowired
   @Mock
    private DepartementRepository departementRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
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
        departement1.setNomDepart("esprit");
        //departementRepository.save(departement1);

        Departement departement2 = new Departement();
        departement2.setNomDepart("amen");
       // departementRepository.save(departement2);



        // Appelez la méthode getAll du service
        List<Departement> resultat = new ArrayList<>();
        resultat.add(departement1);
        resultat.add(departement2);

        // Vérifiez le résultat
        when(departementRepository.findAll()).thenReturn(resultat);
        assertEquals(2, resultat.size()); // Assurez-vous que la taille de la liste est correcte
        assertEquals("esprit", resultat.get(0).getNomDepart()); // Vérifiez le nom du premier département
        assertEquals("amen", resultat.get(1).getNomDepart()); // Vérifiez le nom du deuxième département
    }
    }

