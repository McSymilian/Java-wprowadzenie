package org.test.animals;

public class Sheep implements Animal {
    private final String vetID;
    private final String ID;

    public Sheep(String vetID, String ID) {
        this.vetID = vetID;
        this.ID = ID;
    }

    public String getVetID() {
        return vetID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String makeASound() {
        return "Beeee";
    }
}
