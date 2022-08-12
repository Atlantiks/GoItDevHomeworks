package ua.goit.grocery;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {
    List<Product> allProducts = new ArrayList<>();

    public InMemoryDatabase() {
        allProducts.add(new Product("apple",'A',1.25, new Discount(3,3.0)));
        allProducts.add(new Product("apple",'B',4.25, null));
        allProducts.add(new Product("apple",'C',1.0, new Discount(6,5.0)));
        allProducts.add(new Product("apple",'D',0.75, null));
    }
}
