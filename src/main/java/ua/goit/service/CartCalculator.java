package ua.goit.service;

import ua.goit.grocery.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CartCalculator {
    static InMemoryDatabase db = new InMemoryDatabase();

    public static void main(String[] args) {
        String userInput = "ABCDABA";
        List<Character> userChoice = new ArrayList<>();

        char[] chars = userInput.toCharArray();

        for (char x : chars) {
            if (x > 64 && x < 69) userChoice.add(x);
        }

        userChoice.forEach(System.out::print);

        Map<Character, Long> userCart = userChoice.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        System.out.println(calculateTotalCost(userCart));
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
