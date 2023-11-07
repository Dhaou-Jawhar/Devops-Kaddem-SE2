package tn.esprit.spring.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.entities.Encadrant;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.services.IEncadrantServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/encadrants")
public class EncadrantsRestController {
    IEncadrantServices encadrantServices;
    @GetMapping("/get-all-encadrant")
    public List<Encadrant> getAllEncadrants() {
        List<Encadrant> listEncadrants = encadrantServices.getAllEncadrants();
        return listEncadrants;
    }
    @PostMapping("/add-Encadrant")
    public Encadrant addEncadrant(@RequestBody Encadrant en) {
        Encadrant encadrant = encadrantServices.addEncadrant(en);
        return encadrant;
    }
    @DeleteMapping("/remove-Encadrant/{idEncadrant}")
    public void deleteEncadrant(@PathVariable("idEncadrant") Integer idEncadrant) {
        encadrantServices.deleteEncadrant(idEncadrant);
    }
}
