package org.test.controller;

import org.test.model.Osoba;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OsobaKontroller {
    List<Osoba> listaOsob = new ArrayList<>();

    public Osoba makeOsoba(String name, LocalDate birthDate, String pesel) throws Exception {
        if (name.replace(" ", "").length() <= 3 )
            throw new Exception("Wrong name");
        if (birthDate.isBefore(LocalDate.parse("1900-01-01")))
            throw new Exception("Wrong birtday");
        if (!pesel.matches("\\d{9}"))
            throw new Exception("Wrong date");

        return new Osoba(name, birthDate, pesel);



    }

    public Osoba addNewPerson() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                return makeOsoba(sc.next(), LocalDate.parse(sc.next()), sc.next());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void makeProgram() {
        for (int i = 0; i < 3; i++) {
            listaOsob.add(addNewPerson());
        }

        System.out.println(listaOsob);

    }
}
