package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.IV1350.integration.itemDTO;

public class SaleTest {
    
    private Sale saleInstance;


    @BeforeEach
    void setUp(){

        this.saleInstance = new Sale();
        saleInstance.additemToSale(new itemDTO(1, "TestItem: "+1, new Amount(10.0+1), new Amount(2.0), "Test description: "+1), 2, false);
        saleInstance.additemToSale(new itemDTO(2, "TestItem: "+2, new Amount(10.0+2), new Amount(2.0), "Test description: "+2), 2, false);
    }

    @AfterEach
    void tearDown(){
        this.saleInstance = null;
    }

    @Test
    void testAddNewItemToSale(){

        int expectedOutput = 6;
        int quantity = 2;
        boolean exist = false;

        for(int i = 1; i<5;i++){
            saleInstance.additemToSale(new itemDTO(i, "TestItem: "+i, new Amount(10.0+i), new Amount(2.0), "Test description: "+i), quantity, exist);
        }
        assertEquals(expectedOutput, saleInstance.getScannedItems().size(), "All items not added to the sale");
    }

    @Test
    void testAddExistingItemToSale(){

        int initialQuantity  = 2;
        int additionalQuantity  = 4;
        boolean exist = true;

        for(int i = 0; i<4;i++){
            saleInstance.additemToSale(new itemDTO(i, "TestItem: "+i, new Amount(10.0+i), new Amount(2.0), "Test description: "+i), initialQuantity, false);
        }
        itemDTO addedItem = saleInstance.getScannedItems().get(0).getItemDTO();
        saleInstance.additemToSale(addedItem, additionalQuantity, exist);

        ItemAndQuantity updatedItem = saleInstance.getScannedItems().get(0);

        assertTrue(updatedItem.getItemDTO().equals(addedItem),"Added item should match the provided item");
        assertEquals(initialQuantity+additionalQuantity, updatedItem.getQuantity(), "The two quantitys added togheter should exist in the list");

    }

    @Test 
    void applyTotalDiscountSuccess(){
        Amount amount = new Amount(10);
        Amount newPrice = saleInstance.applyTotalDiscount(amount);
        assertEquals(saleInstance.getTotalPrice().subtract(amount).getValue(), newPrice.getValue(), "The new price is not calucalted corectly");
    }
    @Test 
    void applyTotalDiscountFail(){
        Amount amount = new Amount(100);
        Amount newPrice = saleInstance.applyTotalDiscount(amount);
        assertTrue(saleInstance.getTotalPrice().subtract(amount).getValue() <=0);
        assertEquals(saleInstance.getTotalPriceAfterDiscount().getValue(), newPrice.getValue());
    }

    @Test
    void testEndSaleSuccess(){
        double amount = 200;
        saleInstance.applyTotalDiscount(new Amount(10));
        Payment payemnt = saleInstance.endSale(amount);
        assertEquals(payemnt.getTotalAmountPaid().getValue(), amount, "The wrong amount is stored in the class");
        assertEquals(payemnt.getTotalChange().getValue(), amount - saleInstance.getTotalPriceAfterDiscount().getValue(), "The total change is not calculated correctly");

    }

    @Test
    void testEndSaleFail(){
        double amount = 30;
        saleInstance.applyTotalDiscount(new Amount(10));
        Payment payemnt = saleInstance.endSale(amount);
        assertEquals(null, payemnt, "The amount provided is not enough to cover the total price");
    }
}
