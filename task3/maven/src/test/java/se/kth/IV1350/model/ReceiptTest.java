package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.IV1350.integration.itemDTO;

public class ReceiptTest {
    private Receipt receiptInstance;

    @BeforeEach
    void setUp() {
        itemDTO item = new itemDTO(1, "TestItem", new Amount(50.0), new Amount(2.0), "Test description");
        Payment payment = new Payment(150, new Amount(50));
        ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
        scannedItems.add(new ItemAndQuantity(item, 2)); // Add the item to the list of scanned items
        saleDTO dTO = new saleDTO("2024-04-28 14:47", new Amount(150), new Amount(10), new Amount(0), scannedItems);
        receiptInstance = new Receipt(payment, dTO);
    }

    // @Test
    // public void testToString() {
    //     // Expected substrings in the receipt string
    //     String expectedSubstrings = "-------------Receipt--------------\n"+
    //             "Time of sale: 2024-04-28 14:47\n" +
    //             "TestItem\t\t2 x 50.0 \t100.0 SEK\n" +
    //             "Total: 150.0\n" +
    //             "Discount: 0.0 SEK\n" +
    //             "VAT: 10.0\n" +
    //             "Payment: 150.0 SEK\n" +
    //             "Change: 50.0 SEK"+
    //             "--------------END RECEIPT---------------";

    //     // Check if the receipt string contains the expected substrings
    //     String receiptString = receiptInstance.toString();
    //     System.out.println(receiptString);
    //     for (String substring : expectedSubstrings.split("\n")) {
    //         assertEquals(true, receiptString.contains(substring),
    //                 "Receipt string does not contain expected substring: " + substring);
    //     }
    // }
}
