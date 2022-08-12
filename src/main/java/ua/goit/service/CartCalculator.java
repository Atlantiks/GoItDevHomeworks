package ua.goit.service;

import ua.goit.grocery.InMemoryDatabase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartCalculator {
    static InMemoryDatabase db = new InMemoryDatabase();

    public static void main(String[] args) {
        String userInput = getUserInput();
        var userChoice = filterUserInput(userInput);
        var userCart = formUserCart(userChoice);
        userCart.entrySet().stream().forEach(entry -> {
            System.out.println("Товар с кодом " + entry.getKey() + " в количестве " + entry.getValue());
        });
        System.out.println("Общая стоймость всех товаров: " + calculateTotalCost(userCart));
    }

    public static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        while (true) {
            System.out.println("Введите коды товаров и нажмите ENTER");
            String lastUserInput = sc.nextLine();
            if(lastUserInput.equalsIgnoreCase("exit")) {
                break;
            } else {
                output.append(lastUserInput);
            }
        }
        return output.toString();
    }

    public static List<Character> filterUserInput(String userInput) {
        List<Character> userChoice = new ArrayList<>();
        char[] chars = userInput.toCharArray();

        for (char x : chars) {
            if (x > 64 && x < 69) userChoice.add(x);
        }
        return userChoice;
    }

    public static Map<Character, Long> formUserCart(List<Character> userChoice) {
        return userChoice.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }

    public static double calculateTotalCost(Map<Character, Long> userCart) {
        double totalCost = 0.0;

        for (var entry : userCart.entrySet()) {
            for (var product : db.getAllProducts()) {
                if (entry.getKey() == product.getCode()) {
                    if (Objects.nonNull(product.getDiscount())) {
                        totalCost += entry.getValue() / product.getDiscount().getUnits() * product.getDiscount().getCost() +
                                entry.getValue() % product.getDiscount().getUnits() * product.getPrice();
                    } else {
                        totalCost += entry.getValue() * product.getPrice();
                    }
                }
            }
        }


        return totalCost;
    }
}
