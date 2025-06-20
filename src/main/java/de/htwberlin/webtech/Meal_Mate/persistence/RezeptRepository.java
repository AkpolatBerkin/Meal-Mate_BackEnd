package de.htwberlin.webtech.Meal_Mate.persistence;

import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezeptRepository extends JpaRepository<Rezept, Long> {

}
