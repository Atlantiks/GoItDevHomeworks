package ua.goit;

import ua.goit.customers.User;
import ua.goit.service.UserService;

public class Main {
    public static void main(String[] args) {
        User firstCustomer = new User(1L,"Peter",null);

        new UserService().execute(firstCustomer);

        System.out.println("Общая стоймость выбранных товаров: "
                + firstCustomer.getUserCart().calculateTotalCost());
    }
}
