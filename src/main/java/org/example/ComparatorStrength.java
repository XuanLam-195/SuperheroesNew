package org.example;

import java.util.Comparator;

public class ComparatorStrength implements Comparator<Superhero>{

    @Override
    public int compare(Superhero n, Superhero o) {
        return n.getStrength() - (o.getStrength());
    }
}
