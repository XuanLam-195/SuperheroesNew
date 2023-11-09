package org.example;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    public void startProgram() {
        final int CREATE = 1;
        final int VIEW = 2;
        final int SEARCH = 3;
        final int EDIT = 4;
        final int DELETE = 5;
        final int SORTSUPERHERO = 6;
        final int SortRealName = 7;
        final int EXIT = 9;

        int userChoice;
        Scanner sc = new Scanner(System.in);
        Control control = new Control();

        do {
            System.out.println();
            System.out.println("Welcome to Superhero Universe: ");
            System.out.println();
            System.out.println("Press 1 to 'Create your Superhero'");
            System.out.println("---------------------------------");
            System.out.println("Press 2 to 'View Database'");
            System.out.println("-------------------------");
            System.out.println("Press 3 to 'Search Heroes' ");
            System.out.println("-------------------------");
            System.out.println("Press 4 to 'Edit Heroes' ");
            System.out.println("-----------------------");
            System.out.println("Press 5 to delete Heroes");
            System.out.println("------------------------");
            System.out.println("press 6 to sorted by superhero name");
            System.out.println("____________________________________");
            System.out.println("press 7 to sorted by real name");
            System.out.println("________________________________");
            System.out.println("Press 9 to 'Exit Program'");
            System.out.println("------------------------");

            userChoice = sc.nextInt();
            sc.nextLine();
            if (userChoice == CREATE) {
                System.out.println("CREATE SUPERHERO");
                System.out.println("Enter Hero name: ");
                String name = sc.next();
                System.out.println("___________________");
                if (name.isEmpty()) {
                    name = "Unknown";

                }

                System.out.println("Enter Hero real name: ");
                String realName = sc.next();
                System.out.println("_____________________");
                if (realName.isEmpty()) {
                    realName = "Unknown";

                }

                System.out.println("Hero's superpower: ");
                String superPower = sc.next();
                System.out.println("_____________________");
                if (superPower.isEmpty()) {
                    superPower = "Unknown";

                }

                System.out.println("Year of created: ");
                int yearCreated;
                sc.nextLine();

                while (true){
                    try {
                        yearCreated = sc.nextInt();
                        sc.nextLine();
                        System.out.println("_______________________");
                        break;
                    }catch (InputMismatchException e){
                        System.out.println("Must input a number!");
                        System.out.println("________________");
                        sc.nextLine();
                    }
                }


                System.out.println("Is hero a human: (YES/NO)");
                String isHuman = sc.next();
                System.out.println("_____________________");
                if (isHuman.isEmpty()) {
                    isHuman = "Yes";

                }

                System.out.println("What are the hero's strengths: (0 - 1000) ");
                String strengthValue = sc.next();
                System.out.println("______________________________");
                if (strengthValue.isEmpty()) {
                    strengthValue = "1";

                }
                double strength;
                try {
                    strength = Double.parseDouble(strengthValue);
                } catch (NumberFormatException e) {
                    System.out.println("Must input a number!");
                    System.out.println("Defaulted to strength value of 1.");
                    strength = 1;
                }

                Superhero newHero = new Superhero(name, realName, superPower,
                        yearCreated, isHuman, strength);
                control.addSuperhero(newHero);
                System.out.println(newHero + "\n" +
                        name + " " + "has been registered!");

            }

            if (userChoice == VIEW) {
                System.out.println(control);
            }
            if (userChoice == SEARCH) {
                System.out.println("Insearch Name");
                String searchName = sc.nextLine();
                ArrayList<Superhero> heroList = control.searchSuperheroName(searchName);
                String heroes = "";
                for (Superhero superhero : heroList) {
                    heroes += superhero;

                }
                // virker ikke helt
                    System.out.println(heroes);
                    System.out.println("_________________________");
                    System.out.println("The superhero was not found!");


            }


                if (userChoice == SORTSUPERHERO) {
                    System.out.println("Sort by superhero name:");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> superHeroesListe = control.getSuperheroes();
                    for (Superhero superhero : superHeroesListe) {
                        System.out.println(superhero.getName());
                    }
                }

                if (userChoice == SortRealName){
                    System.out.println("sort by real name: ");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> superheroesRealName = control.getSuperheroes();
                    for (Superhero superheroRealName: superheroesRealName){
                        System.out.println(superheroRealName.getRealName());
                    }
                }






            if (userChoice == EDIT) {
                System.out.println(control);
                int heroNumberPicked = sc.nextInt();
                System.out.println(control.getSuperheroes().get(heroNumberPicked - 1));

                System.out.println("---------------------");
                System.out.println("Insert new hero name: ");
                sc.nextLine();
                String newName = sc.nextLine();

                System.out.println("Insert new real name: ");
                String newRealName = sc.nextLine();

                System.out.println("Insert new superpower");
                String newSuperPower = sc.nextLine();

                System.out.println("Insert new year created: ");
                int newYearCreated;
                try {
                    newYearCreated = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Must input a number!");
                    System.out.println("Field left unchanged.");
                } finally {
                    newYearCreated = 0;
                }

                System.out.println("Is hero still human? ");
                String newIsHero = sc.nextLine();

                System.out.println("Insert new strength value: ");
                double newStrength;
                try {
                    newStrength = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Must input a number!");
                    System.out.println("Field left unchanged.");
                } finally {
                    newStrength = 0;

                }

                Superhero newHero = new Superhero(newName, newRealName, newSuperPower,
                        newYearCreated, newIsHero, newStrength);

                control.getSuperheroes().set(heroNumberPicked, newHero);

                System.out.println("Edit completed!");
                System.out.println(newHero);
            }

            if(userChoice == DELETE){
                System.out.println("Please enter the hero name to delete");
                System.out.println();
                String searchName = sc.nextLine();
                ArrayList<Superhero> deleteSuperheroes = control.deleteHeroName(searchName);
                System.out.println("Deleted Superheroes:");
                for(Superhero superhero : deleteSuperheroes){
                    System.out.println(superhero.getName());
                }
            }
        }
        while (userChoice != EXIT);
        control.saveListOfHeroes();
        System.out.println("'Searching er done.'");



    }
}
