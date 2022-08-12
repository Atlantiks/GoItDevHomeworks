package ua.goit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.goit.customers.UserCart;

import java.util.List;
import java.util.Map;

public class UserServiceTest {
    String userInput;
    List<Character> userChoice;
    Map<Character, Long> selectedItems;
    UserCart cart;

    @Test
    void testFormUserCart() {
        userChoice = List.of('A','B');
        selectedItems = Map.of('A',1L,'B',1L);

        var x = new UserService().formUserCart(userChoice);
        Assertions.assertEquals(x,selectedItems);
    }

    @Test
    void testFilterUserInput() {
        String input = "AcdfgBdfdfdC";
        List<Character> expected = List.of('A','B','C');

        Assertions.assertEquals(expected,new UserService().filterUserInput(input));
    }
}
