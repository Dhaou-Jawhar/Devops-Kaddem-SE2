package tn.esprit.spring.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Equipe implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    //@ManyToMany(mappedBy="equipes")
    @JsonIgnore
    @ManyToMany(cascade =CascadeType.ALL)
    private Set<Etudiant> etudiants;
    @JsonIgnore
    @OneToOne
    private DetailEquipe detailEquipe;

    public Equipe(String nomEquipe) {
        super();
        this.nomEquipe = nomEquipe;
    }

    public Equipe(Integer idEquipe, String nomEquipe) {
        super();
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
    }
    public Equipe(String nomEquipe, Niveau niveau) {
        super();
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
    }


}
