package ua.goit.homework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.goit.homework2.customers.UserCart;
import ua.goit.homework2.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource
    void testFilterUserInput(String input, List<Character> expectedOutput) {
        Assertions.assertEquals(expectedOutput,new UserService().filterUserInput(input));
    }

    private static Stream<Arguments> testFilterUserInput() {
        return Stream.of(
                Arguments.of("AcdfgBdfdfdC", List.of('A','B','C')),
                Arguments.of("AAA", List.of('A','A','A')),
                Arguments.of("  ", List.of()),
                Arguments.of(null, List.of())
        );
    }
}
