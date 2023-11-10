package org.example;


import java.util.Objects;

public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private int strength;

    public Superhero(String name, String realName, String superPower, int yearCreated, String isHuman, int strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return yearCreated == superhero.yearCreated && strength == superhero.strength && Objects.equals(name, superhero.name) && Objects.equals(realName, superhero.realName) && Objects.equals(superPower, superhero.superPower) && Objects.equals(isHuman, superhero.isHuman);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, realName, superPower, yearCreated, isHuman, strength);
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }


    @Override
    public String toString() {
        return

                "Superhero Name: " + name +
                        "\nReal Name: " + realName +
                        "\nSuper Power: " + superPower +
                        "\nYear Created: " + yearCreated +
                        "\nIs Human: " + isHuman +
                        "\nStrengths: " + strength;


    }
}




