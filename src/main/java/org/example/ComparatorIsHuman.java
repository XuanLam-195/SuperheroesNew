package org.example;

import java.util.Comparator;

public class ComparatorIsHuman implements Comparator <Superhero> {
    @Override
    public int compare(Superhero l, Superhero m) {
        return l.getIsHuman().compareTo(m.getIsHuman());
    }
}
