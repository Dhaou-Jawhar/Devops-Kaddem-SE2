package tn.esprit.spring.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.services.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
	@Autowired
	IEquipeService equipeService;
	// http://localhost:8089/kaddem/equipe/retrieve-all-equipes
	@GetMapping("/retrieve-all-equipes")
	public List<Equipe> getEquipes() {
		List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
		return listEquipes;
	}
	// http://localhost:8089/kaddem/equipe/retrieve-equipe/8
	@GetMapping("/retrieve-equipe/{equipe-id}")
	public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
		return equipeService.retrieveEquipe(equipeId);
	}

	// http://localhost:8089/kaddem/equipe/add-equipe

	@PostMapping("/add-equipe")
	public Equipe addEquipe(@RequestBody Equipe e) {
		return equipeService.addEquipe(e);
	}

	// http://localhost:8089/kaddem/equipe/remove-equipe/1
	@DeleteMapping("/remove-equipe/{equipe-id}")
	public void removeEquipe(@PathVariable("equipe-id") Integer equipeId) {
		equipeService.deleteEquipe(equipeId);
	}

	// http://localhost:8089/kaddem/equipe/update-equipe
	@PutMapping("/update-equipe")
	public Equipe updateEtudiant(@RequestBody Equipe e) {
		Equipe equipe= equipeService.updateEquipe(e);
		return equipe;
	}

	@Scheduled(cron="0 0 13 * * *")
	@PutMapping("/faireEvoluerEquipes")
	public void faireEvoluerEquipes() {
		 equipeService.evoluerEquipes() ;
	}
}


