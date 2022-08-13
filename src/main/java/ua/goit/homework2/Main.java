package ua.goit.homework2;

import ua.goit.homework2.customers.User;
import ua.goit.homework2.service.UserService;

public class Main {
    public static void main(String[] args) {
        User firstCustomer = new User(1L,"Peter",null);

        new UserService().execute(firstCustomer);

        firstCustomer.getUserCart().getSelectedItems().forEach((key,value) -> {
            System.out.println("Товаров с индексом " + key + ": " + value);
        });

        System.out.println("Общая стоймость выбранных товаров: " + "\033[0;92m" +
                firstCustomer.getUserCart().calculateTotalCost()  + "\u001B[0m");
    }
}
