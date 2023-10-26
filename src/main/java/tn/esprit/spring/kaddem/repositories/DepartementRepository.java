package tn.esprit.spring.kaddem.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.kaddem.services.entities.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer> {



}
