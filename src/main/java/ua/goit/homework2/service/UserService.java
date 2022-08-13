package ua.goit.homework2.service;

import ua.goit.homework2.customers.User;
import ua.goit.homework2.customers.UserCart;
import ua.goit.homework2.grocery.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
        while (true) {
            System.out.println("Введите коды товаров без пробелов и знаков препинания, затем нажмите ENTER");
            System.out.println("Затем введите следующую последовательность (если необходимо)");
            System.out.println("Для завершения введите exit и нажмите ENTER");
            String lastUserInput = sc.nextLine();
            if (lastUserInput.equalsIgnoreCase("exit")) {
                break;
            } else {
                output.append(lastUserInput);
            }
        }
        return output.toString();
    }

    public List<Character> filterUserInput(String userInput) {
        List<Character> output = new ArrayList<>();
        char[] chars = userInput.toCharArray();

        for (char x : chars) {
            if (x > 64 && x < 69) output.add(x);
        }

        return output;
    }

    public Map<Character, Long> formUserCart(List<Character> userChoice) {
        return  userChoice.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }
}
