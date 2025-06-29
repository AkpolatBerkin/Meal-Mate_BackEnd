package de.htwberlin.webtech.Meal_Mate;

import de.htwberlin.webtech.Meal_Mate.service.RezeptService;
import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import de.htwberlin.webtech.Meal_Mate.persistence.RezeptRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RezeptServiceTest {

    @Mock
    private RezeptRepository repository;

    @InjectMocks
    private RezeptService service;

    @Test
    void testAlleRezepte() {
        // given
        var rezept = new Rezept("Pasta", "Kochen", 30.0, 4, 0.0);
        when(repository.findAll()).thenReturn(List.of(rezept));

        // when
        var result = service.alleRezepte();

        // then
        verify(repository).findAll();
        assertEquals(1, result.size());
        assertEquals("Pasta", result.get(0).getName());
    }

    @Test
    void testSpeichereRezept() {
        // given
        var rezept = new Rezept("Pizza", "Backen", 45.0, 2, 0.0);

        when(repository.save(any(Rezept.class))).thenReturn(rezept);

        // when
        var result = service.speichereRezept(rezept);

        // then
        verify(repository).save(rezept);
        assertEquals("Pizza", result.getName());
    }

    @Test
    void testGetRezeptById() {
        // given
        var rezept = new Rezept("Suppe", "Kochen", 60.0, 6, 0.0);
        when(repository.findById(1L)).thenReturn(Optional.of(rezept));

        // when
        var result = service.getRezeptById(1L);

        // then
        verify(repository).findById(1L);
        assertEquals("Suppe", result.getName());
    }

    @Test
    void testLoescheRezept() {
        // when
        service.loescheRezept(1L);

        // then
        verify(repository).deleteById(1L);
    }
}