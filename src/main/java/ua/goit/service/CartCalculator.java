package ua.goit.service;

import ua.goit.grocery.InMemoryDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartCalculator {
    InMemoryDatabase db = new InMemoryDatabase();
    public static void main(String[] args) {
        String userInput = "ABBBBfdgdfgdf4CD";
        List<Character> userChoice = new ArrayList<>();

        char[] chars = userInput.toCharArray();

        for (char x : chars) {
            if (x > 64 && x < 69) userChoice.add(x);
        }

        userChoice.forEach(System.out::print);

    }

    public static double calculateTotalCost(List<Character> userChoice) {

        return 0.0;
    }
}
