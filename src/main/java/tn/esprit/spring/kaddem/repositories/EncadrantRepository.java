package tn.esprit.spring.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.kaddem.entities.Encadrant;
@Repository
public interface EncadrantRepository extends CrudRepository<Encadrant,Integer> {
}

