package se.kth.IV1350.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem externalInventorySystemInstance;
    @BeforeEach
    void setUp(){
        externalInventorySystemInstance = new ExternalInventorySystem();
    }
    @AfterEach
    void tearDown(){
        externalInventorySystemInstance = null;
    }

    @Test
    public void testGetItemFromDBSuccess() {
        int itemID = 1;
        try {
            itemDTO item = externalInventorySystemInstance.getItemFromDB(itemID);
            assertNotNull(item);
            assertEquals(item.getDescription(), "60% kötthalt");
        } catch (InvalidItemIdentifierException | ExternalSystemFailureException e) {
            fail("Somethign went wrong, an exception is thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetItemFromDBNotFound() {
        int itemID = 10;
        try {
            externalInventorySystemInstance.getItemFromDB(itemID);
            fail("An expected InvalidItemIdentifierException should be thrown, but was not");
        } catch (InvalidItemIdentifierException exception) {
            assertEquals(exception.getMessage(), "Error: Could not find product with itemIdenifier: " + itemID + " in the inventory catalog.");
        } catch (ExternalSystemFailureException e) {
            fail("Unexpected ExternalSystemFailureException was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testGetItemFromDB_ExternalSystemFailureException() {
        int itemID = 51; // This item ID triggers ExternalSystemFailureException in the test setup
        try {
            externalInventorySystemInstance.getItemFromDB(itemID);
            fail("Expected ExternalSystemFailureException was not thrown");
        } catch (InvalidItemIdentifierException e) {
            fail("Unexpected InvalidItemIdentifierException was thrown: " + e.getMessage());
        } catch (ExternalSystemFailureException exception) {
            assertEquals(exception.getMessage(), "Error: connection to databse failed");
        }
    }


    
}
