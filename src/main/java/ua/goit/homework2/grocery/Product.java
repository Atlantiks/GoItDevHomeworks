package ua.goit.homework2.grocery;

public class Product {
    private String name;
    private char code;
    private double price;
    private Discount disc;

    public Product(String name, char code, double price, Discount disc) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.disc = disc;
    }

    public String getName() {
        return name;
    }

    public char getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public Discount getDiscount() {
        return disc;
    }
}
