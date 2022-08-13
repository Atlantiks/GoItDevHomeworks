package ua.goit.homework2;

import ua.goit.homework2.customers.User;
import ua.goit.homework2.service.UserService;

public class Main {
    public static void main(String[] args) {
        User firstCustomer = new User(1L,"Peter",null);

        new UserService().execute(firstCustomer);

        System.out.println("Общая стоймость выбранных товаров: "
                + firstCustomer.getUserCart().calculateTotalCost());
    }
}
