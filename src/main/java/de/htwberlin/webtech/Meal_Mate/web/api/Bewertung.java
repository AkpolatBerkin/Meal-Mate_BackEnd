package de.htwberlin.webtech.Meal_Mate.web.api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Bewertung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int sterne;
    private String kommentar;
    private LocalDateTime erstelltAm;

    @ManyToOne
    @JoinColumn(name = "rezept_id")
    private Rezept rezept;

    public Bewertung(int sterne, String kommentar) {
        this.sterne = sterne;
        this.kommentar = kommentar;
        this.erstelltAm = LocalDateTime.now();
    }
}