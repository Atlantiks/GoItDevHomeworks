package ua.goit.customers;

import java.util.List;

public class User {
    private long id;
    private String name;
    private UserCart userCart;

    public User(long id, String name, UserCart userCart) {
        this.id = id;
        this.name = name;
        this.userCart = userCart;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserCart getUserCart() {
        return userCart;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserCart(UserCart userCart) {
        this.userCart = userCart;
    }
}
