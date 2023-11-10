package org.example;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public void saveSuperheroes(ArrayList<Superhero> superheroes) {
        try (PrintStream output = new PrintStream(new File("Superheros.csv"))) {
            for (Superhero superhero : superheroes) {
                output.println(superhero.getName() + "," + superhero.getRealName() +
                        "," + superhero.getSuperPower() + "," + superhero.getYearCreated() +
                        "," + superhero.getIsHuman() + "," + superhero.getStrength());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void loadSuperheroes(ArrayList<Superhero> superheroes){
        try(Scanner scanner = new Scanner(new File("Superheroes.csv"))){
            while( scanner.hasNextLine()){
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 6) {
                    String name = parts[0];
                    String realName = parts[1];
                    String superPower = parts[2];
                    int yearCreated = Integer.parseInt(parts[3]);
                    String isHuman = parts[4];
                    int strength = Integer.parseInt(parts[5]);
                    superheroes.add(new Superhero(name, realName, superPower, yearCreated, isHuman, strength));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

