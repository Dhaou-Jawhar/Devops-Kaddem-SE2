//package tn.esprit.spring.kaddem.services;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.spring.kaddem.entities.Contrat;
//import tn.esprit.spring.kaddem.repositories.ContratRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class ContratDynamiqueTest {
//
//    @Autowired
//    private ContratServiceImpl contratService;
//
//    @Autowired
//    private ContratRepository contratRepository;
//
//    @Test
//    void addContrat() {
//        Contrat cont = new Contrat();
//        cont.setIdContrat(1);
//        Contrat contrat = contratService.addContrat(cont);
//        assertNotNull(contrat);
//        assertEquals(1, contrat.getIdContrat());
//        System.out.println(" Add Contrat: OK");
//    }
//
//    @Test
//    void retrieveAllContrat() {
//        List<Contrat> contrats = contratService.retrieveAllContrats();
//        assertFalse(contrats.isEmpty());
//        System.out.println("Liste des contrat :");
//        for (Contrat c : contrats) {
//            System.err.println("ID : " + c.getIdContrat() + ", Montant : " + c.getMontantContrat());
//        }
//    }
//
//    @Test
//    void retrieveContrat() {
//        Contrat ContratRetrieve = new Contrat();
//        ContratRetrieve.setMontantContrat(50);
//        Contrat addeContrat = contratService.addContrat(ContratRetrieve);
//
//        System.err.println("ID : " + addeContrat.getIdContrat()+" "+ addeContrat.getMontantContrat());
//
//        Contrat retrieveContrat = contratService.retrieveContrat(addeContrat.getIdContrat());
//
//        assertEquals(addeContrat.getIdContrat(), retrieveContrat.getIdContrat());
//        assertEquals(addeContrat.getMontantContrat(), retrieveContrat.getMontantContrat());
//
//        System.out.println("Retrieve Contrat: OK");
//    }
//
//    @Test
//    void updateContrat() {
//        Contrat contrattrue = new Contrat();
//        contrattrue.setIdContrat(34);
//        contrattrue.setMontantContrat(40);
//        Contrat savedContrat = contratRepository.save(contrattrue);
//        Integer updatedMontant = 77;
//        savedContrat.setMontantContrat(updatedMontant);
//        Contrat updatedContrat = contratService.updateContrat(savedContrat);
//        Contrat retrievedContrat = contratRepository.findById(updatedContrat.getIdContrat()).orElse(null);
//        assertNotNull(retrievedContrat);
//        assertEquals(updatedMontant, retrievedContrat.getMontantContrat());
//        System.err.println("Update Contrat : OK !");
//    }
//
//
//}