package org.test;

import java.util.Scanner;

public class Menu {
    private int nextAction;
    public void showMenu() {
        System.out.println("1.Wyświetl wszysktkie zwierzęta");
        System.out.println("2.Wyświetl wszystkie owce");
        System.out.println("3.Wyświetl wszystkie krowy");
    }
    public void setNextAction() {
        try(Scanner sc = new Scanner(System.in)) {
            nextAction = sc.nextInt();
        }
    }
    public MenuAction getMenuAction() {
        return switch (nextAction) {
            case 1 -> () -> {};

            default -> () -> {};
        }
    }



    public int getNextAction() {
        return nextAction;
    }
}
