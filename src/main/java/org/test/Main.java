package org.test;

import org.test.animals.Animal;
import org.test.animals.Cow;
import org.test.animals.Pig;
import org.test.animals.Sheep;
import org.test.archive.ArchiveParser;

import java.io.File;
import java.util.*;

/**
 * Zmienić sortowanie na sortowanie wzlędem vetID
 *
 * toString klasy Cow był scustomizowany dla niej
 */
public class Main {
    public static final List<Animal> animals = new ArrayList<>();
    public static void main(String[] args) {
        try {
            var aparser = new ArchiveParser();
            animals.addAll(aparser.parse(new File("src/main/resources/LivestockDB.txt")));
        } catch (NullPointerException e) {
            animals.add(new Cow("001", "01"));
            e.printStackTrace();
        }

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
