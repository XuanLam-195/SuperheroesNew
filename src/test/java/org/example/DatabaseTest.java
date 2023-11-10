package org.example;

import org.example.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database database;

    Superhero testman;
    Superhero hackerman;


    @BeforeEach
    void setup() {
        database = new Database(false);
        testman = new Superhero("Testerson", "Test Testerson",
                "Testing", 2023, "No", 10);
        hackerman = new Superhero("Hackerman", "Hack Hackerson",
                "Hacking", 2023, "Yes", 9999);
        database.addSuperhero(testman);
        database.addSuperhero(hackerman);
    }

    @Test
    void searchSuperheroNameTest() {
        ArrayList<Superhero> testerListExpected = new ArrayList<>(Arrays.asList(testman));
        String queryName = "Testerson";
        ArrayList<Superhero> testerListReturned = database.searchSuperheroName(queryName);
        assertEquals(testerListExpected, testerListReturned);
    }

    @Test
    void getSuperheroes(){
        ArrayList<Superhero> superheroes = database.getSuperheroes();
        assertEquals(2, superheroes.size());
    }

    @Test
    void addSuperheroes(){
        assertEquals(2, database.getSuperheroes().size());
        Superhero superhero = new Superhero("blackman", "Won", "runfast", 2000,"no", 9999 );
        database.addSuperhero(superhero);
        assertEquals(3, database.getSuperheroes().size());

    }
    @Test
    void testRomoveSuperheroes(){
        assertEquals(2, database.getSuperheroes().size());
        Superhero testboy = new Superhero("Testerson", "Test Testerson",
                "Testing", 2023, "No", 10);
        Superhero hackerboy = new Superhero("Hackerman", "Hack Hackerson",
                "Hacking", 2023, "Yes", 9999);
        ArrayList<Superhero> removedSuperheroes = new ArrayList<>();
        removedSuperheroes.add(testboy);
        removedSuperheroes.add(hackerboy);
        database.removeSuperheroes(removedSuperheroes);
        assertEquals(0, database.getSuperheroes().size());


    }

}
