package ua.goit.homework2.service;

import ua.goit.homework2.customers.User;
import ua.goit.homework2.customers.UserCart;
import ua.goit.homework2.grocery.InMemoryDatabase;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {
    String userInput;
    List<Character> userChoice;
    Map<Character, Long> selectedItems;
    UserCart cart;

    public void execute(User user) {
        userInput = processUserInput();
        userChoice = filterUserInput(userInput);
        selectedItems = formUserCart(userChoice);
        cart = new UserCart(selectedItems,InMemoryDatabase.getInstance());

        user.setUserCart(cart);
    }

    public String processUserInput() {
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        System.out.println("Введите коды товаров без пробелов и знаков препинания, затем нажмите ENTER");
        System.out.println("Для завершения введите " + "\033[0;93m" + "exit" + "\u001B[0m" + " и нажмите ENTER");
        String lastUserInput = sc.nextLine();
        while (!lastUserInput.equalsIgnoreCase("exit")) {
            output.append(lastUserInput);
            System.out.println("Введите следующую последовательность (если необходимо)");
            System.out.println("Для завершения введите " + "\033[0;93m" + "exit" + "\u001B[0m" + " и нажмите ENTER");
            lastUserInput = sc.nextLine();
        }
        return output.toString();
    }

    public List<Character> filterUserInput(String userInput) {
        List<Character> output = new ArrayList<>();
        if (Objects.isNull(userInput)) return output;
        char[] chars = userInput.toCharArray();

        for (char x : chars) {
            if (x > 64 && x < 69) output.add(x);
        }

        return output;
    }

    public Map<Character, Long> formUserCart(List<Character> userChoice) {
        if (Objects.isNull(userChoice)) return Map.of();
        return  userChoice.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }
}
