package org.test.animals;

public abstract class Livestock {
    private final String vetID;
    private final String ID;

    public Livestock(String vetID, String ID) {
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
    public String toString() {
        return "Livestock{" +
                "vetID='" + vetID + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}
