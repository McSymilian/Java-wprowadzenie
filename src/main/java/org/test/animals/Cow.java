package org.test.animals;

public class Cow extends Livestock{
    public Cow(String vetID, String ID) {
        super(vetID, ID);
    }

    @Override
    public String makeASound() {
        return "Mooo";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
