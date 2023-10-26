package tn.esprit.spring.kaddem.services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.kaddem.services.entities.Contrat;
import tn.esprit.spring.kaddem.services.entities.Departement;
import tn.esprit.spring.kaddem.services.entities.Equipe;
import tn.esprit.spring.kaddem.services.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.entities.Etudiant;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class EtudiantServiceImpl implements IEtudiantService{
	@Autowired
    EtudiantRepository etudiantRepository ;
	@Autowired
    ContratRepository contratRepository;
	@Autowired
    EquipeRepository equipeRepository;
    @Autowired
    DepartementRepository departementRepository;
	public List<Etudiant> retrieveAllEtudiants(){
	return (List<Etudiant>) etudiantRepository.findAll();
	}

	public Etudiant addEtudiant (Etudiant e){
		return etudiantRepository.save(e);
	}

	public Etudiant updateEtudiant (Etudiant e){
		return etudiantRepository.save(e);
	}

	public Etudiant retrieveEtudiant(Integer  idEtudiant){
		return etudiantRepository.findById(idEtudiant).get();
	}

	public void removeEtudiant(Integer idEtudiant){
	Etudiant e=retrieveEtudiant(idEtudiant);
	etudiantRepository.delete(e);
	}

	public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
	}
	@Transactional
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe){
		Contrat c=contratRepository.findById(idContrat).orElse(null);
		Equipe eq=equipeRepository.findById(idEquipe).orElse(null);
		c.setEtudiant(e);
		eq.getEtudiants().add(e);
return e;
	}

	public 	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
return  etudiantRepository.findEtudiantsByDepartement_IdDepart((idDepartement));
	}
}
