package ua.goit.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.goit.grocery.InMemoryDatabase;

import java.util.Map;

public class UserCartTest {
    UserCart cart;
    Map<Character, Long> selectedItems;
    InMemoryDatabase db;

    @Test
    void testCalculateTotalCost() {
        selectedItems = Map.of('A',3L,'B',2L,'C',1L,'D',1L);
        db = InMemoryDatabase.getInstance();
        cart = new UserCart(selectedItems,db);
        Assertions.assertEquals(13.25,cart.calculateTotalCost());
    }
}
