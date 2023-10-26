package tn.esprit.spring.kaddem.services.services;

import tn.esprit.spring.kaddem.services.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipes();
    public Equipe addEquipe(Equipe e);
    public  void deleteEquipe(Integer idEquipe);
    public Equipe updateEquipe(Equipe e, Integer idEquipe);
    public Equipe retrieveEquipe(Integer equipeId);
    public void assignEquipeToDetailEquipe(Integer idEquipe, Integer idDetailEquipe);
    public void evoluerEquipes();
}
