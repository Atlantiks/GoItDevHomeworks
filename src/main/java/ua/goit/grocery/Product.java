package ua.goit.grocery;

public class Product {
    String name;
    char code;
    double price;
    Discount disc;

    public Product(String name, char code, double price, Discount disc) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.disc = disc;
    }
}
