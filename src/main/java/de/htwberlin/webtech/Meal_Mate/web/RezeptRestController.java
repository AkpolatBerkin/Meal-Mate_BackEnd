package de.htwberlin.webtech.Meal_Mate.web;

import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import de.htwberlin.webtech.Meal_Mate.persistence.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

@CrossOrigin
@RestController
public class RezeptRestController {

    @Autowired
    private RezeptRepository rezeptRepository;

    @Value("${frontend.url}")
    private String frontendUrl;

    @CrossOrigin(origins = "${frontend.url}")
    @GetMapping(path= "/api/rezept")
    public ResponseEntity<Rezept> getRezept() {
        final Rezept rezept = new Rezept("Pizza", "Teig, Tomatensoße, Käse, Thunfisch", "In Ofen bei 200 Grad backen", "Hauptgericht", 1, 10.0);
        return ResponseEntity.ok(rezept);
    }

    @CrossOrigin(origins = "${frontend.url}")
    @PostMapping(path = "/api/rezept")
    public ResponseEntity<Rezept> createRezept(@RequestBody Rezept rezept) {
        Rezept saved = rezeptRepository.save(rezept);
        return ResponseEntity.ok(saved);
    }
}
