package de.htwberlin.webtech.Meal_Mate.web.api;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Zutat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double menge;
    private String einheit;


    public Zutat(String name, double menge, String einheit) {
        this.name = name;
        this.menge = menge;
        this.einheit = einheit;
    }
}