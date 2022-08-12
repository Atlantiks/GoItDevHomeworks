package ua.goit.grocery;

public class Discount {
    private int units;
    private double cost;

    public Discount(int units, double cost) {
        this.units = units;
        this.cost = cost;
    }

    public int getUnits() {
        return units;
    }

    public double getCost() {
        return cost;
    }
}
