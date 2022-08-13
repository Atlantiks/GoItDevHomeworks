package ua.goit.homework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UserServiceTest {
    static UserService userService;

    @BeforeAll
    static void init() {
        userService = new UserService();
    }

    @ParameterizedTest
    @MethodSource
    void testFormUserCart(List<Character> input,Map<Character, Long> expected) {
        Assertions.assertEquals(expected,userService.formUserCart(input));
    }

    @ParameterizedTest
    @MethodSource
    void testFilterUserInput(String input, List<Character> expectedOutput) {
        Assertions.assertEquals(expectedOutput,userService.filterUserInput(input));
    }

    private static Stream<Arguments> testFilterUserInput() {
        return Stream.of(
                Arguments.of("AcdfgBdfdfdC", List.of('A','B','C')),
                Arguments.of("ABABBAB", List.of('A','B','A','B','B','A','B')),
                Arguments.of("  ", List.of()),
                Arguments.of(null, List.of()),
                Arguments.of("\n", List.of()),
                Arguments.of("русскийТекстАААианглийскаяB", List.of('B'))
        );
    }

    private static Stream<Arguments> testFormUserCart() {
        return Stream.of(
                Arguments.of(List.of('A','B'),Map.of('A',1L,'B',1L)),
                Arguments.of(null,Map.of(),
                Arguments.of(List.of(),Map.of())
                ));
    }
}
