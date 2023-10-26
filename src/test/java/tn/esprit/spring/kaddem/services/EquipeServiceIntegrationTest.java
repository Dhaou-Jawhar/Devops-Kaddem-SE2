package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class EquipeDynamicTest {

    @Autowired
    private EquipeServiceImpl equipeService;

    @Autowired
    private DetailEquipeRepository detailEquipeRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @BeforeEach
    public void setUp() {
        // Assurez-vous que la base de données est vide au début de chaque test
        equipeRepository.deleteAll();
    }

    /*@AfterEach
    public void tearDown() {
        // Effacez la base de données après chaque test
        equipeRepository.deleteAll();
    }

    @Test
    void retrieveAllEquipes() {
        // Testez la méthode retrieveAllEquipes pour vous assurer qu'elle retourne une liste d'équipes non vide.
        Equipe equipe = new Equipe(1, "Barcelona", Niveau.JUNIOR);
        equipeRepository.save(equipe);
        assertTrue(!equipeService.retrieveAllEquipes().isEmpty());
    }*/

    @Test
    void addEquipe() {
        // Testez la méthode addEquipe pour vous assurer qu'elle ajoute correctement une équipe à la base de données.
        Equipe equipe = new Equipe(1, "Real Madrid", Niveau.SENIOR);
        equipeService.addEquipe(equipe);
        assertNotNull(equipeRepository.findById(1));
    }

    /*@Test
    void deleteEquipe() {
        // Testez la méthode deleteEquipe pour vous assurer qu'elle supprime correctement une équipe de la base de données.
        Equipe equipe = new Equipe(1, "AC Milan", Niveau.JUNIOR);
        equipeRepository.save(equipe);
        equipeService.deleteEquipe(1);
        assertTrue(!equipeRepository.findById(1).isPresent());
    }

    @Test
    void retrieveEquipe() {
        // Testez la méthode retrieveEquipe pour vous assurer qu'elle renvoie correctement une équipe par son ID.
        Equipe equipe = new Equipe(2, "Juventus", Niveau.EXPERT);
        equipeRepository.save(equipe);
        Equipe retrievedEquipe = equipeService.retrieveEquipe(2);
        assertEquals("Juventus", retrievedEquipe.getNomEquipe());
    }

    @Test
    void assignEquipeToDetailEquipe() {
        // Testez la méthode assignEquipeToDetailEquipe pour vous assurer qu'elle attribue correctement une équipe à un détail d'équipe.
        Equipe equipe = new Equipe(1, "PSG", Niveau.JUNIOR);
        equipeRepository.save(equipe);
        DetailEquipe detailEquipe = new DetailEquipe(*//* initialisation de DetailEquipe *//*);
        detailEquipeRepository.save(detailEquipe);
        equipeService.assignEquipeToDetailEquipe(1, detailEquipe.getIdDetailEquipe());
        Equipe assignedEquipe = equipeRepository.findById(1).get();
        assertEquals(detailEquipe, assignedEquipe.getDetailEquipe());
    }

    @Test
    void updateEquipe() {
        // Testez la méthode updateEquipe pour vous assurer qu'elle met à jour correctement une équipe dans la base de données.
        Equipe equipe = new Equipe(1, "Bayern Munich", Niveau.SENIOR);
        equipeRepository.save(equipe);

        Equipe updatedEquipe = new Equipe(1, "Bayern Munich FC", Niveau.EXPERT);
        equipeService.updateEquipe(updatedEquipe, 1);

        Equipe retrievedEquipe = equipeService.retrieveEquipe(1);
        assertEquals("Bayern Munich FC", retrievedEquipe.getNomEquipe());
        assertEquals(Niveau.EXPERT, retrievedEquipe.getNiveau());
    }*/
}
