package de.htwberlin.webtech.Meal_Mate;

import de.htwberlin.webtech.Meal_Mate.service.RezeptService;
import de.htwberlin.webtech.Meal_Mate.web.api.Rezept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MealMateApplicationTests {

	@Autowired
	private RezeptService rezeptService;

	@Test
	void contextLoads() {
	}

	@Test
	void testRezeptSpeichernUndLaden() {
		var rezept = new Rezept("Test-Pasta", "Kochen", 4, 30.0);
		var gespeichert = rezeptService.speichereRezept(rezept);

		assertNotNull(gespeichert);
		assertEquals("Test-Pasta", gespeichert.getName());

		var geladen = rezeptService.getRezeptById(gespeichert.getId());
		assertEquals("Test-Pasta", geladen.getName());
	}
}