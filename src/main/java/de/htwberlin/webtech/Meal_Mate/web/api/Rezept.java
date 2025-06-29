package de.htwberlin.webtech.Meal_Mate.web.api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Rezept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String zubereitung;
    private int portionen;
    private double dauer;
    private double bewertung;

    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL)
    private List<Zutat> zutaten;

    @ManyToOne
    @JoinColumn(name = "kategorie_id")
    private Kategorie kategorie;

    @OneToMany(mappedBy = "rezept", cascade = CascadeType.ALL)
    private List<Bewertung> bewertungen;

    // Neuer Konstruktor für Frontend-Daten
    public Rezept(String name, String kategorie, String zubereitung, double dauer, int portionen, double bewertung) {
        this.name = name;
        this.zubereitung = zubereitung;
        this.portionen = portionen;
        this.dauer = dauer;
        this.bewertung = bewertung;
    }
}
