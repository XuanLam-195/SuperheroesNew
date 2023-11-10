package org.example;

import java.util.Comparator;

public class ComparatorRealName implements Comparator<Superhero>{
    @Override
    public int compare(Superhero n, Superhero o) {
        return n.getRealName().compareTo(o.getRealName());
    }
}
