package de.htwberlin.webtech.Meal_Mate.web;


import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RezeptRestController {

    @GetMapping(path= "/api/rezept")
    public ResponseEntity<Rezept> getRezept() {
        final Rezept rezept = new Rezept("Pizza", "Teig, Tomatensoße, Käse, Thunfisch", "In Ofen bei 200 Grad backen", "Hauptgericht", 1, 10.0);
        return ResponseEntity.ok(rezept);
    }
}
