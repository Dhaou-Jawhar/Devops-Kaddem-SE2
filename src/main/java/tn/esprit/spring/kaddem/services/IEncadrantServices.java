package tn.esprit.spring.kaddem.services;

import tn.esprit.spring.kaddem.entities.Encadrant;

import java.util.List;
import java.util.Map;

public interface IEncadrantServices {
    List <Encadrant> getAllEncadrants();

    Encadrant addEncadrant(Encadrant en);

    Encadrant updateEncadrant(Encadrant en);

    void deleteEncadrant(Integer idEncadrant);

    Encadrant getEncadrantById(Integer idEncadrant);

    void addAndAssignEncadrantToEquipe(Integer idEquipe, Encadrant en);


}
