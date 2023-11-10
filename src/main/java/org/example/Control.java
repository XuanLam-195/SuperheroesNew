package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Control {

    private Database database = new Database(true);



    public void addSuperhero(Superhero hero) {
       database.addSuperhero(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }



    public ArrayList<Superhero> searchSuperheroName(String name) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : database.getSuperheroes()) {
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
        for (Superhero superhero : database.getSuperheroes()) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroList.add(superhero);
            }
        }
       database.removeSuperheroes(superheroList);
        database.saveSuperheroes();
        return superheroList;
    }
     public void editSuperheroes(int index, Superhero newSuperhero){
        Superhero oldSuperhero = database.getSuperheroes().get(index-1);
         getSuperheroes().set(index -1, newSuperhero);
         if(!oldSuperhero.equals(newSuperhero)){
             saveListOfHeroes();
         }
     }

    public void saveListOfHeroes() {
       database.saveSuperheroes();
    }




    public void sortSuperHeroName() {
    }
}



