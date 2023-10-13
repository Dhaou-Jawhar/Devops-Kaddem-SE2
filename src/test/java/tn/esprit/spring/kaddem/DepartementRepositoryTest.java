/* Devops Kaddem SE2 */
package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

import static org.assertj.core.api.Assertions.assertThat;
/* Test Code Here */


@SpringBootTest
@Slf4j
public class DepartementRepositoryTest {

    @Autowired
    private DepartementRepository departementRepository;
    private Departement departement; // Vous pouvez déclarer l'entité à nettoyer ici


    @Test
    public void testCRUDOperations() {
        // Création d'un nouvel Departement
        departement = new Departement();
        departement.setNomDepart("Esprit");
        departementRepository.save(departement);

        // Lecture du département depuis la base de données
        Departement departementEnregistre = departementRepository.findById(departement.getIdDepart()).orElse(null);
        assertThat(departementEnregistre).isNotNull();
        assertThat(departementEnregistre.getNomDepart()).isEqualTo("Esprit");

        // Mise à jour du département
        departementEnregistre.setNomDepart("5SE2");
        departementRepository.save(departementEnregistre);

        // Lecture du département mis à jour
        Departement departementMaj = departementRepository.findById(departement.getIdDepart()).orElse(null);
        assertThat(departementMaj).isNotNull();
        assertThat(departementMaj.getNomDepart()).isEqualTo("5SE2");

        // Cette méthode sera exécutée après chaque test
        // Vous pouvez y inclure des opérations de nettoyage

        if (departement != null) {
            departementRepository.delete(departement);
        }

        log.info("[*******************] Test est exécuté avec succé [*******************]");


    }
}

