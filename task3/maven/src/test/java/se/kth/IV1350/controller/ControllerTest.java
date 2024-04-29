package se.kth.IV1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.saleDTO;

public class ControllerTest {
    private Controller controllerInstance;
    private ExternalDB externalDB;
    private ReceiptPrinter printer;

    @BeforeEach
    void setUp(){
        externalDB = new ExternalDB();
        printer = new ReceiptPrinter();
        this.controllerInstance = new Controller(externalDB, printer);
    }

    @AfterEach
    void tearDown(){
        this.controllerInstance = null;
    }

    @Test
    void testStartSale(){
        this.controllerInstance.startSale();
        assertNotNull(controllerInstance.getSale(), "Start sale is sucesfull");    
    }

    @Test
    void testGetSaleDTO(){
        this.controllerInstance.startSale();
        saleDTO saleDTO = controllerInstance.getSaleDTO();
        assertNotNull(saleDTO, "SaleDTO should not be null");
    }

    @Test
    void testScanItemExist(){
        this.controllerInstance.startSale();
        int itemID = 1;
        int quantity = 2;


        saleDTO saleDTO = controllerInstance.scanItem(itemID, quantity);
        assertNotNull(saleDTO, "SaleDTO should not be null");
    }
    @Test
    void testScanItemDontExist(){
        this.controllerInstance.startSale();
        int itemID = 8;
        int quantity = 2;
        saleDTO saleDTO = controllerInstance.scanItem(itemID, quantity);
        assertNull(saleDTO, "SaleDTO should not be null");
    }

    @Test 
    void testStartDiscount(){
        this.controllerInstance.startSale();
        int customerID = 1;
        double newPrice = controllerInstance.startDiscount(customerID);
        assertTrue(newPrice >= 0, "New price should be greater than or equal to 0");
    }

    @Test
    void testEnterPayment_Successful() {
        this.controllerInstance.startSale();
        double amount = 50;

        controllerInstance.scanItem(1, 2); 
        controllerInstance.scanItem(2, 1); 
        controllerInstance.startDiscount(0);
        double expectedOutput = controllerInstance.getCashRegister().getMoney()+amount;

        Payment result = controllerInstance.enterPayemnt(amount);
        double output = controllerInstance.getCashRegister().getMoney()+10; 

        assertEquals(expectedOutput, output);
        assertNotNull(result, "The payemnt went through");
    }

    @Test
    void testEnterPayment_Unsuccessful() {
        this.controllerInstance.startSale();
        double amount = 10.0;
        controllerInstance.scanItem(1, 2); 
        controllerInstance.scanItem(2, 1); 
        
        Payment result = controllerInstance.enterPayemnt(amount);

        assertNull(result, "Not enough payment");
    }
}
