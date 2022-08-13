package ua.goit.homework2.customers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private UserCart userCart;
}
