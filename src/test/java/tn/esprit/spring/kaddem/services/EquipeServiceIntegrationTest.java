package tn.esprit.spring.kaddem.services;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EquipeServiceIntegrationTest {

    @Autowired
    private EquipeServiceImpl equipeService;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private DetailEquipeRepository detailEquipeRepository;
/*
    @BeforeEach
    public void setUp() {
        // Assurez-vous que la base de données est vide au début de chaque test
        equipeRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        // Effacez la base de données après chaque test
        equipeRepository.deleteAll();
    }

    @Test
    public void testAddEquipeAndDetailEquipeWithAssign() {
        // Créez une équipe et ajoutez-la à la base de données
        Equipe equipe = new Equipe("ESPRIT", Niveau.JUNIOR);
        Equipe addedEquipe = equipeService.addEquipe(equipe);

        // Vérifiez que l'équipe a été ajoutée avec succès
        assertNotNull(addedEquipe);
        assertEquals(equipe.getNomEquipe(), addedEquipe.getNomEquipe());
        assertEquals(equipe.getNiveau(), addedEquipe.getNiveau());

        // Créez une DetailEquipe et ajoutez-la à la base de données
        DetailEquipe detailEquipe = new DetailEquipe(1, "Football");
        DetailEquipe addDetailEquipe = detailEquipeRepository.save(detailEquipe);

        // Vérifiez que le DetailEquipe a été ajoutée avec succès
        assertNotNull(addDetailEquipe);
        assertEquals(detailEquipe.getSalle(), addDetailEquipe.getSalle());
        assertEquals(detailEquipe.getThematique(), addDetailEquipe.getThematique());

        equipeService.assignEquipeToDetailEquipe(equipe.getIdEquipe(),detailEquipe.getIdDetailEquipe());

        System.out.println("Equipe ajouté avec succée:"+"\n* Nom Equipe: "
                +equipe.getNomEquipe()+"\n* Niveau d'équipe: "+
                equipe.getNiveau()+"\n* Numéro de salle: "+equipe.getDetailEquipe().getSalle()+"\n* Thématique: "+
                equipe.getDetailEquipe().getThematique());
    }

    @Test
    public void testRetrieveAllEquipes() {
        // Créez des équipes dans la base de données
        Equipe equipe1 = new Equipe("Barcelona", Niveau.JUNIOR);
        equipeService.addEquipe(equipe1);

        Equipe equipe2 = new Equipe("Real Madrid", Niveau.SENIOR);
        equipeService.addEquipe(equipe2);

        // Appelez la méthode de service pour récupérer les équipes
        List<Equipe> equipes = equipeService.retrieveAllEquipes();

        // Assurez-vous que la méthode renvoie des équipes et qu'elles correspondent à ce qui est dans la base de données
        assertNotNull(equipes);
        assertTrue(equipes.size() >= 2);
        assertTrue(equipes.contains(equipe1));
        assertTrue(equipes.contains(equipe2));

        System.out.println("la liste des equipes sont:\n"+"Equipe1: "+equipe1.getNomEquipe()+"\n"+"Equipe2: "+ equipe2.getNomEquipe());
    }






    // Ajoutez d'autres tests pour les autres méthodes de service

    @Test
    public void testDeleteEquipe() {
        // Créez une équipe et ajoutez-la à la base de données
        Equipe equipe = new Equipe(1,"EquipeTest", Niveau.JUNIOR);
        equipeService.addEquipe(equipe);

        // Vérifiez que l'équipe a été ajoutée avec succès
        assertNotNull(equipeService.retrieveEquipe(equipe.getIdEquipe()));

        // Appelez la méthode de service pour supprimer l'équipe
        equipeService.deleteEquipe(equipe.getIdEquipe());

        // Vérifiez que l'équipe a été supprimée de la base de données
        assertNull(equipeService.retrieveEquipe(equipe.getIdEquipe()));
    }

   @Test
    public void testUpdateEquipe() {
        // Créez une équipe et ajoutez-la à la base de données
        Equipe equipe = new Equipe("EquipeTest", Niveau.JUNIOR);
        equipeService.addEquipe(equipe);

        // Modifiez les données de l'équipe
        equipe.setNomEquipe("NouveauNom");
        equipe.setNiveau(Niveau.SENIOR);

        // Appelez la méthode de service pour mettre à jour l'équipe
        Equipe updatedEquipe = equipeService.updateEquipe(equipe, equipe.getIdEquipe());

        // Vérifiez que l'équipe a été mise à jour avec succès
        assertNotNull(updatedEquipe);
        assertEquals(equipe.getIdEquipe(), updatedEquipe.getIdEquipe());
        assertEquals("NouveauNom", updatedEquipe.getNomEquipe());
        assertEquals(Niveau.SENIOR, updatedEquipe.getNiveau());
    }*/
}
