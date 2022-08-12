package ua.goit.customers;

import ua.goit.grocery.InMemoryDatabase;

import java.util.Map;
import java.util.Objects;

public class UserCart {
    private Map<Character, Long> selectedItems;
    private InMemoryDatabase db;

    public UserCart(Map<Character, Long> selectedItems, InMemoryDatabase db) {
        this.selectedItems = selectedItems;
        this.db = db;
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;

        for (var entry : selectedItems.entrySet()) {
            for (var product : db.getAllProducts()) {
                if (entry.getKey() == product.getCode()) {
                    if (Objects.nonNull(product.getDiscount())) {
                        totalCost += entry.getValue() / product.getDiscount().getUnits() * product.getDiscount().getCost()
                                +  entry.getValue() % product.getDiscount().getUnits() * product.getPrice();
                    } else {
                        totalCost += entry.getValue() * product.getPrice();
                    }
                }
            }
        }

        return totalCost;
    }
}
