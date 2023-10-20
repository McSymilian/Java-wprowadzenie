package org.test.model;

import java.time.LocalDate;

public class Osoba {
    private String name;
    private LocalDate birthDay;
    private String pesel;


    public Osoba(String name, LocalDate birthDay, String pesel) {
        this.name = name;
        this.birthDay = birthDay;
        this.pesel = pesel;
    }


    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getPesel() {
        return pesel;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
