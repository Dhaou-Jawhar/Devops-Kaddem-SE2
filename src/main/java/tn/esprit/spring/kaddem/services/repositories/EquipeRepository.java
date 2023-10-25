package tn.esprit.spring.kaddem.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.kaddem.services.entities.Equipe;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {



}
