package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private ArrayList<Superhero> superheroes;
    private FileHandler fileHandler = new FileHandler();

    public Control() {
        superheroes = new ArrayList<>();
        populateDatabase();
    }

    public void populateDatabase() {
        Superhero superman = new Superhero("Superman", "Clark Kent",
                "Super strength, flight, xray vision",
                1938, "No", 8698);
        System.out.println("-----------------------------");
        Superhero spiderman = new Superhero("Spider-Man", "Peter Parker",
                "Wall-climbing, web-shooting, danger sense",
                1962, "Yes", 6299);
        System.out.println("-----------------------------");
        Superhero iroman = new Superhero("Tony", "ironman", "Flight, Strength, energy weapon, protection",
                2015, "Yes", 9587);
        System.out.println("______________________________");
        Superhero hulk = new Superhero("Robert", "hulk", "Invulnerability, regeneration, extraordinary leaping ability, Adaptability",
                2018, "no", 8928);
        System.out.println("______________________________");
        Superhero batman = new Superhero("Bruce Wayne", "Batman", "Exceptional Intelligence, Master Martial Artist, Physical Prowess",
                1939, "Yes", 6475);

        superheroes.add(superman);
        superheroes.add(spiderman);
        superheroes.add(iroman);
        superheroes.add(hulk);
        superheroes.add(batman);
    }

    public void addSuperhero(Superhero hero) {
        superheroes.add(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    public ArrayList<Superhero> searchSuperheroName(String name) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                if (!superheroList.contains(superhero.getName())) {
                    superheroList.add(superhero);
                }
            }
        }
        return superheroList;
    }

    public ArrayList<Superhero> deleteHeroName(String name) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroList.add(superhero);
            }
        }
        superheroes.removeAll(superheroList);
        return superheroList;
    }

    public void saveListOfHeroes() {
        fileHandler.saveSuperheroes(superheroes);
    }


    public String toString () {
        String heroes = "";
        int counter = 0;
        for (Superhero superhero : superheroes) {
            heroes += (++counter) + "---" + superhero + "\n";
        }
        return heroes;
    }
}



