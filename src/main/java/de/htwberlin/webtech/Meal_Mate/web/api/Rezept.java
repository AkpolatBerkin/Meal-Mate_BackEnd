package de.htwberlin.webtech.Meal_Mate.web.api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String zutaten;
    private String zubereitung;
    private String kategorie;
    private int portionen;
    private double dauer;

    public Rezept(String name, String zutaten, String zubereitung, String kategorie, int portionen, double dauer) {
        this.name = name;
        this.zutaten = zutaten;
        this.zubereitung = zubereitung;
        this.kategorie = kategorie;
        this.portionen = portionen;
        this.dauer = dauer;
    }
}