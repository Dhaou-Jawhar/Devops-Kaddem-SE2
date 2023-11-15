package tn.esprit.spring.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Universite implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUniv;
    private String nomUniv;
    private String model;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Departement> departements;
}
