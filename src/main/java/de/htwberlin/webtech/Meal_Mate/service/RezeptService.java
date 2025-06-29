package de.htwberlin.webtech.Meal_Mate.service;

import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import de.htwberlin.webtech.Meal_Mate.persistence.RezeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RezeptService {
    private final RezeptRepository rezeptRepository;

    @Autowired
    public RezeptService(RezeptRepository rezeptRepository) {
        this.rezeptRepository = rezeptRepository;
    }

    public List<Rezept> alleRezepte() {
        return rezeptRepository.findAll();
    }

    public Rezept speichereRezept(Rezept rezept) {
        return rezeptRepository.save(rezept);
    }

    public Rezept getRezeptById(Long id) {
        return rezeptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezept nicht gefunden"));
    }

    public void loescheRezept(Long id) {
        rezeptRepository.deleteById(id);
    }
}