package org.example;



import java.util.*;

public class UserInterface {
    public void startProgram() {
        final int CREATE = 1;
        final int VIEW = 2;
        final int SEARCH = 3;
        final int EDIT = 4;
        final int DELETE = 5;
        final int SORTByAll = 6;
        final int EXIT = 9;

        int userChoice;
        Scanner sc = new Scanner(System.in);
        Control control = new Control();

        do {
            System.out.println();
            System.out.println("________________________________");
            System.out.println("Welcome to Superhero Universe: ");
            System.out.println();
            System.out.println("Press 1 to 'Create your Superhero'");
            System.out.println("________________________________");
            System.out.println("Press 2 to 'View Database'");
            System.out.println("________________________________");
            System.out.println("Press 3 to 'Search Heroes' ");
            System.out.println("________________________________");
            System.out.println("Press 4 to 'Edit Heroes' ");
            System.out.println("________________________________");
            System.out.println("Press 5 to delete Heroes");
            System.out.println("________________________________");
            System.out.println("Press 6 to sorted by superheroes ");
            System.out.println("________________________________");
            System.out.println("Press 9 to 'Exit Program'");
            System.out.println("________________________________");

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

                while (true) {
                    try {
                        yearCreated = sc.nextInt();
                        sc.nextLine();
                        System.out.println("_______________________");
                        break;
                    } catch (InputMismatchException e) {
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
                        yearCreated, isHuman, (int) strength);
                control.addSuperhero(newHero);
                System.out.println(newHero + "\n" +
                        name + " " + "has been registered!");

            }

            if (userChoice == VIEW) {
                System.out.println(control);
            }
            if (userChoice == SEARCH) {
                System.out.println("Insert Name");
                String searchName = sc.nextLine().trim().toLowerCase();
                ArrayList<Superhero> heroList = control.searchSuperheroName(searchName);
                boolean foundAny = false;

                for (Superhero superhero : heroList) {
                    if (superhero.getName().toLowerCase().equals(searchName)) {

                        System.out.println(superhero.getRealName() + " is found");
                        foundAny = true;
                    }
                }
                if (!foundAny) {
                    System.out.println("The superhero was not found!");
                }
            }


            if (userChoice == SORTByAll) {
                System.out.println(""" 
                        \n
                        SORT AS NEEDED:
                        ______________________________
                        
                        1) Press 1 to Sort by 'Name'
                        ______________________________
                        2) Press 2 to Sort by 'RealName'
                        ______________________________
                        3) Press 3 to Sort by 'SuperPower'
                        ______________________________
                        4) Press 4 to Sort by ' Created year'
                        ______________________________
                        5) Press 5 to Sort by 'IsHuman'
                        ______________________________
                        6) Press 6 to Sort by 'Strength' 
                        ______________________________
                        7) Press 7 to see all the superhero you """);

                int sortChoice = sc.nextInt();
                sc.nextLine();

                if (sortChoice == 1) {
                    System.out.println("Sort by superhero name:");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> superHeroesName = control.getSuperheroes();

                    // Sorter listen af superhelte efter navne
                    superHeroesName.sort(Comparator.comparing(Superhero::getName));

                    for (Superhero superhero : superHeroesName) {
                        System.out.println(superhero.getRealName() + " - is also -> " + " " + superhero.getName());
                    }
                } else if (sortChoice == 2) {
                    System.out.println("sort by real name: ");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> superheroesRealName = control.getSuperheroes();
                    superheroesRealName.sort(Comparator.comparing(Superhero::getRealName));
                    for (Superhero superheroRealName : superheroesRealName) {
                        System.out.println(superheroRealName.getName() + " - is named by -> " + " " + superheroRealName.getRealName());
                    }
                } else if (sortChoice == 3) {
                    System.out.println("sort by superpower");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> SUPERPOWER = control.getSuperheroes();
                    SUPERPOWER.sort(Comparator.comparing(Superhero::getSuperPower));
                    for (Superhero superpower : SUPERPOWER) {
                        System.out.println(superpower.getName() + " - superpower: " + superpower.getSuperPower());
                    }
                } else if (sortChoice == 4) {
                    System.out.println("sort by Created year");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> yearCreated = control.getSuperheroes();
                    yearCreated.sort(Comparator.comparing(Superhero::getYearCreated));
                    for (Superhero superhero : yearCreated) {
                        System.out.println(superhero.getName() + " - year: " + superhero.getYearCreated());
                    }
                } else if (sortChoice == 5) {
                    System.out.println("sort by human or not human");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> ishuman = control.getSuperheroes();

                    ishuman.sort(Comparator.comparing(Superhero::getIsHuman));
                    for (Superhero superhero : ishuman) {
                        System.out.println(superhero.getName() + " - human: " + superhero.getIsHuman());
                    }
                } else if (sortChoice == 6) {
                    System.out.println("sort by strength");
                    control.sortSuperHeroName();
                    ArrayList<Superhero> strength = control.getSuperheroes();

                    strength.sort(Comparator.comparing(Superhero::getStrength));
                    for (Superhero superhero : strength) {
                        System.out.println(superhero.getName() + " - strength: " + superhero.getStrength());
                    }
                } else if (sortChoice == 7) {
                    System.out.println("Her is all the superhero you have in you database");
                    helpName();
                }
            } else {
                System.out.println("ivalid choice");
            }


                if (userChoice == EDIT) {
                    System.out.println(control);
                    System.out.println("Enter a number depending of which hero you want to edit:");
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
                            newYearCreated, newIsHero, (int) newStrength);

                    control.getSuperheroes().set(heroNumberPicked, newHero);

                    System.out.println("Edit completed!");
                    System.out.println(newHero);
                }

                if (userChoice == DELETE) {
                    System.out.println("Please enter the hero name to delete");
                    System.out.println();
                    String searchName = sc.nextLine();
                    ArrayList<Superhero> deleteSuperheroes = control.deleteHeroName(searchName);
                    System.out.println("Deleted Superheroes:");
                    for (Superhero superhero : deleteSuperheroes) {
                        System.out.println(superhero.getName());
                    }
                }
            }

        while (userChoice != EXIT) ;
        control.saveListOfHeroes();
        System.out.println("'You left the game'");

        }

    public void helpName(){

        System.out.println();
        System.out.println("ironman");
        System.out.println("batman");
        System.out.println("hulk");
        System.out.println("Superman");
        System.out.println("Spider-Man");
    }
    }



