package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import se.kth.IV1350.integration.itemDTO;
public class ItemAndQuantityTest {
    private ItemAndQuantity itemAndQuantityInstance;

    @Test
    public void testConstructor() {
        itemDTO item = new itemDTO(1, "TestItem", new Amount(10.0), new Amount(2.0), "Test description");
        itemAndQuantityInstance = new ItemAndQuantity(item, 2);
        assertEquals(item, itemAndQuantityInstance.getItemDTO(), "The item should exist in the instance created");
        assertEquals(2, itemAndQuantityInstance.getQuantity(), "The quantity should exist in the instance created");
    }
}
