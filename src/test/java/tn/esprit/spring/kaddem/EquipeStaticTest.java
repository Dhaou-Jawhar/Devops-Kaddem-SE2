package tn.esprit.spring.kaddem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class EquipeStaticTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;
    @Mock
    private EquipeRepository equipeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddEquipe() {
        Equipe equipeToAdd = new Equipe("BSB", Niveau.SENIOR);
        when(equipeRepository.save(any(Equipe.class))).thenReturn(equipeToAdd);

        Equipe addEquipe = equipeService.addEquipe(equipeToAdd);

        assertEquals("BSB", addEquipe.getNomEquipe());
        System.err.println(addEquipe.getNomEquipe()+" Is Added");
    }
}
