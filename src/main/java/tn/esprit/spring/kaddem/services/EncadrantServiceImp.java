package tn.esprit.spring.kaddem.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.Encadrant;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EncadrantRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.List;
@Service
public class EncadrantServiceImp implements IEncadrantServices {

    EquipeRepository equipeRepository;
    private final EncadrantRepository encadrantRepository;

    // Le constructeur avec injection de dépendances
    public EncadrantServiceImp(EncadrantRepository encadrantRepository) {
        this.encadrantRepository = encadrantRepository;
    }



    @Override
    public List<Encadrant> getAllEncadrants() {
        // Assurez-vous que encadrantRepository n'est pas null
        if (encadrantRepository == null) {
            throw new IllegalStateException("EncadrantRepository n'a pas été correctement initialisé.");
        }

        // Utilisez normalement encadrantRepository.findAll() ici
        return (List<Encadrant>) encadrantRepository.findAll();
    }

    @Override
    public Encadrant addEncadrant(Encadrant en) {
        return encadrantRepository.save(en);
    }

    @Override
    public Encadrant updateEncadrant(Encadrant en) {
        return encadrantRepository.save(en);
    }

    @Override
    public void deleteEncadrant(Integer idEncadrant) {
        encadrantRepository.deleteById(idEncadrant);
    }

    @Override
    public Encadrant getEncadrantById(Integer idEncadrant) {
        return encadrantRepository.findById(idEncadrant).orElse(null);

    }



    @Override
    public void addAndAssignEncadrantToEquipe(Integer idEquipe, Encadrant en) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        encadrantRepository.save(en);
        equipe.setEncadrant(en);
        equipeRepository.save(equipe);
    }



}

