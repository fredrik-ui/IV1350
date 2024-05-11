package se.kth.IV1350.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExternalDBTest {

    @Test
    public void testConstructor() {
        // Create an instance of ExternalDB
        ExternalDB externalDB = new ExternalDB();

        // Verify that the ExternalDB object is not null
        assertNotNull(externalDB, "ExternalDB was not initialized corectly"); 

        // Verify that the accountingSystem is initialized
        assertNotNull(externalDB.getAccountingSystem(), "AccountingSystem was not initialized corectly");

        // Verify that the inventorySystem is initialized
        assertNotNull(externalDB.getInventorySystem(),"InventorySystem was not initialized corectly");

        // Verify that the discountDBSystem is initialized
        assertNotNull(externalDB.getDiscountDBSystem(),"DiscountDBSystem was not initialized corectly");
    }
}