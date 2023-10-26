package tn.esprit.spring.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.*;
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class EquipeServiceImpl implements IEquipeService {
	@Autowired
    EquipeRepository equipeRepository;

    @Autowired
    DetailEquipeRepository detailEquipeRepository;


    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    public Equipe addEquipe(Equipe e) {
        return (equipeRepository.save(e));
    }

    public void deleteEquipe(Integer idEquipe) {
        Equipe e = retrieveEquipe(idEquipe);
        equipeRepository.delete(e);
    }

    public Equipe retrieveEquipe(Integer equipeId) {
        return equipeRepository.findById(equipeId).get();
    }

    @Override
    public void assignEquipeToDetailEquipe(Integer idEquipe, Integer idDetailEquipe) {
        Equipe e = equipeRepository.findById(idEquipe).get();
        DetailEquipe detailEquipe = detailEquipeRepository.findById(idDetailEquipe).get();

        e.setDetailEquipe(detailEquipe);
        equipeRepository.save(e);

    }

    public Equipe updateEquipe(Equipe e, Integer idEquipe) {
        Equipe equipeExistant = equipeRepository.findById(idEquipe).get();
        if (equipeExistant != null){
            equipeExistant.setNomEquipe(e.getNomEquipe());
            equipeExistant.setNiveau(e.getNiveau());
            return equipeRepository.save(equipeExistant);
        }
        return null;
    }

    public void evoluerEquipes() {
        List<Equipe> equipes = (List<Equipe>) equipeRepository.findAll();
        for (Equipe equipe : equipes) {
            if ((equipe.getNiveau().equals(Niveau.JUNIOR)) || (equipe.getNiveau().equals(Niveau.SENIOR))) {
                List<Etudiant> etudiants = (List<Etudiant>) equipe.getEtudiants();
                Integer nbEtudiantsAvecContratsActifs = 0;
                for (Etudiant etudiant : etudiants) {
                    Set<Contrat> contrats = etudiant.getContrats();
                    //Set<Contrat> contratsActifs=null;
                    for (Contrat contrat : contrats) {
                        Date dateSysteme = new Date();
                        long difference_In_Time = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
                        long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
                        if ((contrat.getArchive() == false) && (difference_In_Years > 1)) {
                            //	contratsActifs.add(contrat);
                            nbEtudiantsAvecContratsActifs++;
                            break;
                        }
                        if (nbEtudiantsAvecContratsActifs >= 3) break;
                    }
                }
                if (nbEtudiantsAvecContratsActifs >= 3) {
                    if (equipe.getNiveau().equals(Niveau.JUNIOR)) {
                        equipe.setNiveau(Niveau.SENIOR);
                        equipeRepository.save(equipe);
                        break;
                    }
                    if (equipe.getNiveau().equals(Niveau.SENIOR)) {
                        equipe.setNiveau(Niveau.EXPERT);
                        equipeRepository.save(equipe);
                        break;
                    }
                }
            }

        }

    }
}