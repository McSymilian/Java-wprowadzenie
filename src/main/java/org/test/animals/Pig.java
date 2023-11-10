package org.test.animals;

public class Pig extends Livestock implements Animal{
    public Pig(String vetID, String ID, double mass) {
        super(vetID, ID);
        this.mass = mass;
    }

    private double mass;
    @Override
    public String makeASound() {
        return "Chrum";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
