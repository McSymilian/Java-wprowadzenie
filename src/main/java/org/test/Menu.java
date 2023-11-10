package org.test;

import org.test.animals.Animal;
import org.test.animals.Cow;
import org.test.animals.Sheep;

import java.util.Scanner;

public class Menu {
    private int nextAction;
    public void showMenu() {
        System.out.println("1.Wyświetl wszysktkie zwierzęta");
        System.out.println("2.Wyświetl wszystkie owce");
        System.out.println("3.Wyświetl wszystkie krowy");
    }
    private static final Scanner sc = new Scanner(System.in);
    public void setNextAction() {
        nextAction = sc.nextInt();
    }
    public MenuAction getMenuAction() {
        return switch (nextAction) {
            case 1 -> () -> {
                for (Animal animal : Main.animals) {
                    System.out.println(animal);

                }
            };
            case 2-> () -> {
                for (Animal animal: Main.animals) {
                    if (animal instanceof Sheep sheep) {
                        System.out.println(sheep);
                    }
                }
            };
            case 3-> () -> {
                for (Animal animal: Main.animals) {
                    if (animal instanceof Cow cow) {
                        System.out.println(cow);
                    }
                }
            };
            default -> () -> {};
        };
    }



    public int getNextAction() {
        return nextAction;
    }
}
