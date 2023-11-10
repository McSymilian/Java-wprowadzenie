package org.test.animals;

public class Sheep extends Livestock implements Animal {
    public Sheep(String vetID, String ID) {
        super(vetID, ID);
    }


    @Override
    public String makeASound() {
        return "Beeee";
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "vetID='" + super.getVetID() + '\'' +
                ", ID='" + super.getID() + '\'' +
                '}';
    }
}
