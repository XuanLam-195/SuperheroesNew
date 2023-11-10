package org.example;

import java.util.Comparator;

public class ComparatorYearCreated implements Comparator<Superhero>{
        @Override
        public int compare(Superhero e, Superhero f) {
            return e.getYearCreated() - f.getYearCreated();
        }
}
