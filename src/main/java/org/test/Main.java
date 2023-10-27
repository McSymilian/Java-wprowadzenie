package org.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] tablica = new int[76];
        int[] arr = {21, 7, 19, 3};

//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i] + " -> " + i);
//        }
//
//        for (int wartosc: arr) {
//            System.out.println(wartosc);
//        }

        List<String> lista = new LinkedList<>(List.of("Ala", "ma", "kota"));
        lista.add("Julka");
        lista.add("nie ma");
        lista.add("psa");

        System.out.println(lista);

    }
}
