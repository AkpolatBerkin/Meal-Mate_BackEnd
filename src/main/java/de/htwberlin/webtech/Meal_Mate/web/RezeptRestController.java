package de.htwberlin.webtech.Meal_Mate.web;

import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import de.htwberlin.webtech.Meal_Mate.persistence.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://meal-mate-frontend-ome0.onrender.com"})
public class RezeptRestController {

    @Autowired
    private RezeptRepository rezeptRepository;

    @Value("${frontend.url}")
    private String frontendUrl;

    @GetMapping(path = "/api/rezept")
    public ResponseEntity<List<Rezept>> getAlleRezepte() {
        List<Rezept> rezepte = rezeptRepository.findAll();
        return ResponseEntity.ok(rezepte);
    }

    @PostMapping(path = "/api/rezept")
    public ResponseEntity<Rezept> createRezept(@RequestBody Rezept rezept) {
        Rezept saved = rezeptRepository.save(rezept);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(path = "/api/rezept/{id}")
    public ResponseEntity<Void> deleteRezept(@PathVariable Long id) {
        Optional<Rezept> rezept = rezeptRepository.findById(id);
        if (rezept.isPresent()) {
            rezeptRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/api/rezept/{id}")
    public ResponseEntity<Rezept> getRezeptById(@PathVariable Long id) {
        Optional<Rezept> rezept = rezeptRepository.findById(id);
        if (rezept.isPresent()) {
            return ResponseEntity.ok(rezept.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/api/rezept/{id}")
    public ResponseEntity<Rezept> updateRezept(@PathVariable Long id, @RequestBody Rezept rezeptDetails) {
        Optional<Rezept> optionalRezept = rezeptRepository.findById(id);
        if (optionalRezept.isPresent()) {
            Rezept rezept = optionalRezept.get();
            rezept.setName(rezeptDetails.getName());
            rezept.setZubereitung(rezeptDetails.getZubereitung());
            rezept.setPortionen(rezeptDetails.getPortionen());
            rezept.setDauer(rezeptDetails.getDauer());
            rezept.setBewertung(rezeptDetails.getBewertung()); // Neue Zeile

            Rezept updatedRezept = rezeptRepository.save(rezept);
            return ResponseEntity.ok(updatedRezept);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}