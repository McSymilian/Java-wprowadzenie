package org.test;

import org.test.animals.Animal;
import org.test.animals.Cow;
import org.test.animals.Sheep;

import java.util.*;

public class Main {

    static void nois(Animal animal){
        System.out.println(animal.makeASound());
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Sheep("0000", "0000"));
        animals.add(new Cow());


    }
}
