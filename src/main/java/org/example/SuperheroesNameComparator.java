package org.example;

import java.util.Comparator;

public class SuperheroesNameComparator implements Comparator<Superhero> {

    public int compare(Superhero a, Superhero b){
        return a.getName().compareTo(b.getName());
    }
    public int compareRealName(Superhero c, Superhero d){
        return c.getRealName().compareTo(d.getRealName());
    }

    public int comparesuperPower(superpower)


}
