package org.example;

import java.util.ArrayList;

public class Database {
    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Superhero> superheroes;


    public Database() {
        superheroes = new ArrayList<>();
        populateDatabase();
    }

    public void populateDatabase() {
        Superhero superman = new Superhero("Superman", "Clark Kent",
                "Super strength, flight, x-ray vision",
                1938, "No", 8698);
        Superhero spiderman = new Superhero("Spider-Man", "Peter Parker",
                "Wall-climbing, web-shooting, danger sense",
                1962, "Yes", 6299);
        Superhero iroman = new Superhero("Tony", "ironman", "Flight, Strength, energy weapon, protection",
                2015, "Yes", 9587);
        Superhero hulk = new Superhero("Robert", "hulk", "Invulnerability, regeneration, extraordinary leaping ability, Adaptability",
                2018, "no", 8928);
        Superhero batman = new Superhero("Bruce Wayne", "Batman", "Exceptional Intelligence, Master Martial Artist, Physical Prowess",
                1939, "Yes", 6475);

        superheroes.add(superman);
        superheroes.add(spiderman);
        superheroes.add(iroman);
        superheroes.add(hulk);
        superheroes.add(batman);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void addSuperhero(Superhero hero) {
        superheroes.add(hero);
    }

    public ArrayList<Superhero> searchSuperheroName(String name) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                if (!superheroList.contains(superhero)) {
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

    public void saveSuperheroes() {
        fileHandler.saveSuperheroes(superheroes);
    }

    public void loadSuperheroes() {
        fileHandler.loadSuperheroes(superheroes);
    }
}