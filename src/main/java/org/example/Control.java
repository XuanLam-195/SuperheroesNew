package org.example;

import java.util.ArrayList;

public class Control {
    private Database database = new Database();
    

    public String listSuperheroes() {
        String heroes = "";
        int counter = 0;
        for (Superhero superhero : database.getSuperheroes()) {
            heroes += (++counter) + "---" + superhero + "\n";
        }
        return heroes;
    }

    public void saveListOfHeroes() {
        database.saveSuperheroes();
    }

    public void loadListOfHeroes() {
        database.loadSuperheroes();
    }

    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }

    public void addSuperhero(Superhero newHero) {
    }

    public ArrayList<Superhero> searchSuperheroName(String searchName) {
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> deleteHeroName(String searchName) {
        return database.getSuperheroes();
    }
}

