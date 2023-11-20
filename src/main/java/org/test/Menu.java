package org.test;

import org.test.animals.Animal;
import org.test.animals.Cow;
import org.test.animals.Pig;
import org.test.animals.Sheep;

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
    public MenuAction getMenuAction() {
        return switch (nextAction) {
            case 1 -> () -> {
                for (Animal animal : animals) {
                    System.out.println(animal);

                }
            };
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
            default -> () -> {};
        };
    }



    public int getNextAction() {
        return nextAction;
    }
}
