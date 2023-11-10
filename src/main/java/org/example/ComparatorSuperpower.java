package org.example;

import java.util.Comparator;

public class ComparatorSuperpower implements Comparator<Superhero>{

    @Override
    public int compare(Superhero n, Superhero o) {
        return n.getSuperPower().compareTo(o.getSuperPower());
    }
}
