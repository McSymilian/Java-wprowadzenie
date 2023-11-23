package org.test;

import org.test.animals.*;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

import static org.test.Main.animals;

public class Menu {
    private int nextAction;
    public void showMenu() {
        System.out.println("1.Wyświetl wszysktkie zwierzęta");
        System.out.println("2.Wyświetl wszystkie owce");
        System.out.println("3.Wyświetl wszystkie krowy");
        System.out.println("4.Wyświetl wszystkie świnie");
        System.out.println("5.Dodaj zwierzę");
        System.out.println("6.Usuń zwierzę");

    }
    private static final Scanner sc = new Scanner(System.in);
    public void setNextAction() {
        nextAction = sc.nextInt();
    }
    private static final MenuAction showAllAction =()-> {
        for (Animal animal : animals) {
            System.out.println(animal);}
    };
    public MenuAction getMenuAction() {
        return switch (nextAction) {
            case 1 -> showAllAction;
            case 2-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Sheep sheep) {
                        System.out.println(sheep);
                    }
                }
            };
            case 3-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Cow cow) {
                        System.out.println(cow);
                    }
                }
            };
            case 4-> () -> {
                for (Animal animal: animals) {
                    if (animal instanceof Pig pig) {
                        System.out.println(pig);
                    }
                }
            };
            case 5-> () -> {
                System.out.println("select animal to add: Cow (C) or Sheep (S) or Pig (P)");
                char aniamlChose = sc.next().charAt(0);
                System.out.println("Set VetID");
                int vetID = sc.nextInt();
                System.out.println("Set ID");
                int animalID = sc.nextInt();
                switch (aniamlChose){
                    case 'C':
                        animals.add(new Cow(String.valueOf(vetID), String.valueOf(animalID)));
                        break;
                    case 'S':
                        animals.add(new Sheep(String.valueOf(vetID), String.valueOf(animalID)));
                        break;
                    case 'P':
                        System.out.println("set mass of Pig");
                        animals.add(new Pig(String.valueOf(vetID), String.valueOf(animalID), sc.nextDouble()));
                }
            };
            case 6->()-> {
                showAllAction.doAction();
                System.out.println("chose \"vetID\" -> 1, \"ID\" -> 2, \"index\" -> 3.");
                int userChose = sc.nextInt();
                switch (userChose){

                    case 1:
                        Livestock temporary;
                        do {
                            System.out.println("write vetID");
                            int userVetID = sc.nextInt();
                            temporary = animals.stream()
                                    .map((a) -> (Livestock) a)
                                    .filter(a -> "a".equals(a.getVetID()))
                                    .findFirst()
                                    .orElse(null);
                        } while  (temporary != null);
                        animals.remove(temporary);

                        //TODO case 2 usuniecie  ID, Usunięcie indexu

                    case 2:
                        do {
                            System.out.println("write ID");
                            int userID = sc.nextInt();
                            temporary = animals.stream()
                                    .map((a) -> (Livestock) a)
                                    .filter(a -> "a".equals(a.getID()))
                                    .findFirst()
                                    .orElse(null);
                        } while  (temporary != null);
                        animals.remove(temporary);
                    case 3:
                        System.out.println("write index number");
                        int userIndex = sc.nextInt();
                        animals.remove(userIndex);
                }
            };

            default -> () -> {};
        };
    }



    public int getNextAction() {
        return nextAction;
    }
}
