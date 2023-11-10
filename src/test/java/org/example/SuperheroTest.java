package org.example;

import org.example.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperheroTest {

    Superhero testHero;
    @BeforeEach
    void setup(){
        testHero = new Superhero("Testman", "Test Testeron", "Testing",
                2023, "No", 0);
    }
    @Test
    void constructSuperhero(){
        assertAll("Testing superhero construction:",
                () -> assertEquals("Testman", testHero.getName()),
                () -> assertEquals("Test Testeron", testHero.getRealName()),
                () -> assertEquals("Testing", testHero.getSuperPower()),
                () -> assertEquals(2023, testHero.getYearCreated()),
                () -> assertEquals("No", testHero.getIsHuman()),
                () -> assertEquals(0, testHero.getStrength())
        );
    }
    @Test
    void testToString() {
        String resultStringExpected =
                "Superhero Name: " + "Testman" +
                        "\nReal Name: " + "Test Testeron" +
                        "\nSuper Power: " + "Testing" +
                        "\nYear Created: " + 2023 +
                        "\nIs Human: " + "No" +
                        "\nStrengths: " + 0;
        assertEquals(resultStringExpected, testHero.toString());
    }
}