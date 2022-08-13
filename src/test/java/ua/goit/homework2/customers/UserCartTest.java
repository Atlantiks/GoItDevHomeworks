package ua.goit.homework2.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.goit.homework2.grocery.InMemoryDatabase;

import java.util.Map;
import java.util.stream.Stream;

public class UserCartTest {
    UserCart cart;
    static InMemoryDatabase db;

    @BeforeAll
    static void init() {
        db = InMemoryDatabase.getInstance();
    }
    @ParameterizedTest
    @MethodSource
    void testCalculateTotalCost(double expected, Map<Character,Long> providedMap) {
        cart = new UserCart(providedMap,db);
        Assertions.assertEquals(expected,cart.calculateTotalCost());
    }

    private static Stream<Arguments> testCalculateTotalCost() {
        return Stream.of(
                Arguments.of(13.25, Map.of('A',3L,'B',2L,'C',1L,'D',1L)),
                Arguments.of(3.0, Map.of('A',3L)),
                Arguments.of(5.5, Map.of('A',5L)),
                Arguments.of(1.5, Map.of('D',2L))
        );
    }
}
