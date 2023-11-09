package org.example;



public class Superhero {
    private String name;
    private String realName;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private double strength;

    public Superhero(String name, String realName, String superPower, int yearCreated, String isHuman, double strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
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

    public double getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return
                "List of superheroes: "+
                "\n" + "Superhero Name: " + name +
                        "\nReal Name: " + realName +
                        "\nSuper Power: " + superPower +
                        "\nYear Created: " + yearCreated +
                        "\nIs Human: " + isHuman +
                        "\nStrengths: " + strength + "\n";


    }
}




