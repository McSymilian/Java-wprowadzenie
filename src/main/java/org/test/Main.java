package org.test;

import org.test.animals.Animal;
import org.test.animals.Cow;
import org.test.animals.Sheep;

import java.util.*;

/**
 * Zmienić sortowanie na sortowanie wzlędem vetID
 *
 * toString klasy Cow był scustomizowany dla niej
 */
public class Main {
    public static final List<Animal> animals = new ArrayList<>();
    public static void main(String[] args) {
        animals.add(new Cow("0008", "0008"));
        animals.add(new Sheep("0000", "0000"));
        animals.add(new Cow("0010", "0009"));
        animals.add(new Sheep("0001", "0001"));

        animals.sort((a , b) -> {
            if (a instanceof Sheep && b instanceof Cow)
                return 1;
            else if (a instanceof Cow && b instanceof Sheep)
                return -1;

            return 0;
        });

        Menu menu = new Menu();
        menu.showMenu();
        menu.setNextAction();
        menu.getMenuAction().doAction();


    }
}
