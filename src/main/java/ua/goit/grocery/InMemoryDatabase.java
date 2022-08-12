package ua.goit.grocery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InMemoryDatabase {
    private static InMemoryDatabase db;
    private List<Product> allProducts = new ArrayList<>();

    private InMemoryDatabase() {
        allProducts.add(new Product("apple",'A',1.25, new Discount(3,3.0)));
        allProducts.add(new Product("lemon",'B',4.25, null));
        allProducts.add(new Product("cucumber",'C',1.0, new Discount(6,5.0)));
        allProducts.add(new Product("carrot",'D',0.75, null));
    }

    public static InMemoryDatabase getInstance() {
        if (Objects.nonNull(db)) return db;
        else return  new InMemoryDatabase();
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }
}
