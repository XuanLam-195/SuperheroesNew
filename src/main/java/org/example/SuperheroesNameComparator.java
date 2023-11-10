package org.example;

import java.util.Comparator;

public class SuperheroesNameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero a, Superhero b){
        return a.getName().compareTo(b.getName());
    }

}
