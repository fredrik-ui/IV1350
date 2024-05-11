package se.kth.IV1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.IV1350.integration.ExternalSystemFailureException;
import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.InvalidItemIdentifierException;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.saleDTO;

public class ControllerTest {
    private Controller controllerInstance;
    private ExternalDB externalDB;
    private ReceiptPrinter printer;

    @BeforeEach
    public void setUp() {
        externalDB = new ExternalDB();
        printer = new ReceiptPrinter();
        controllerInstance = new Controller(externalDB, printer);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testStartSale() {
        controllerInstance.startSale();
        assertNotNull(controllerInstance.getSale(), "Sale could not be intialized");
    }

    @Test
    public void testGetSaleDTO() {
        controllerInstance.startSale();
        saleDTO saleDTO = controllerInstance.getSaleDTO();
        assertNotNull(saleDTO, "SaleDTO should not be null");
    }

    @Test
    public void testScanItemExist() {
        controllerInstance.startSale();
        int itemID = 1;
        int quantity = 2;

        try {
            saleDTO saleDTO = controllerInstance.scanItem(itemID, quantity);
            assertNotNull(saleDTO, "SaleDTO should not be null");
        } catch (InvalidItemIdentifierException | ExternalSystemFailureException e) {
            fail("Item or Database error:  " + e.getMessage());
        }
    }

    @Test
    public void testScanItemDontExist() {
        controllerInstance.startSale();
        int itemID = 8;
        int quantity = 2;
        try {
            controllerInstance.scanItem(itemID, quantity);
            fail("Item dose not exist");
        } catch (InvalidItemIdentifierException e) {
            // The expected exception was caught, the test passes
            assertTrue(e.getMessage().contains(
                    "Error: Could not find product with itemIdenifier: " + itemID + " in the inventory catalog."),
                    "Expected error message does not match");
        } catch (ExternalSystemFailureException e) {
            fail("Unexpected ExternalSystemFailureException was thrown: " + e.getMessage());
        }
    }

    @Test
    public void testStartDiscount() {
        controllerInstance.startSale();
        int customerID = 1;
        double newPrice = controllerInstance.startDiscount(customerID);
        assertTrue(newPrice >= 0, "New price should be greater than or equal to 0");
    }

    @Test
    public void testEnterPaymentSuccessful() {
        controllerInstance.startSale();
        double amount = 50;

        try {
            controllerInstance.scanItem(1, 2);
            controllerInstance.scanItem(2, 1);
            controllerInstance.startDiscount(0);
            double expectedOutput = controllerInstance.getCashRegister().getMoney() + 40; // 10 sek change not added

            Payment result = controllerInstance.enterPayemnt(amount);
            double output = controllerInstance.getCashRegister().getMoney() + 10;

            assertEquals(expectedOutput, output);
            assertNotNull(result, "The payment did not go through");
        } catch (InvalidItemIdentifierException | ExternalSystemFailureException e) {
            fail("Item or Database error: " + e.getMessage());
        }
    }

    @Test
    public void testEnterPaymentUnsuccessful() {
        controllerInstance.startSale();
        double amount = 10.0;
        try {
            controllerInstance.scanItem(1, 2);
            controllerInstance.scanItem(2, 1);
            controllerInstance.startDiscount(0);
            Payment result = controllerInstance.enterPayemnt(amount);

            assertNull(result, "Not enough payment");
        } catch (InvalidItemIdentifierException | ExternalSystemFailureException e) {
            fail("Item or Database error:  " + e.getMessage());
        }
    }

}
