package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import se.kth.IV1350.integration.itemDTO;

public class ReceiptTest {
    private Receipt receiptInstance;

    // @BeforeEach
    // void setUp() {
    //     itemDTO item = new itemDTO(1, "TestItem", new Amount(50.0), new Amount(2.0), "Test description");
    //     Payment payment = new Payment(150, new Amount(100));
    //     ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    //     scannedItems.add(new ItemAndQuantity(item, 2));
    //     saleDTO sale = new saleDTO("2024-04-28 14:47", new Amount(100), new Amount(10), new Amount(100), scannedItems);
    //     receiptInstance = new Receipt(payment, sale);
    // }

    @Test
    public void testToStringFormatsReceiptCorrectly() {
        itemDTO item = new itemDTO(1, "TestItem", new Amount(50.0), new Amount(2.0), "Test description");
        ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
        scannedItems.add(new ItemAndQuantity(item, 2));
        saleDTO sale = new saleDTO("2024-04-28 14:47", new Amount(100), new Amount(10), new Amount(100), scannedItems);
        Payment payment = new Payment(150, new Amount(100));
        receiptInstance = new Receipt(payment, sale);
       
       
        String expectedReceipt = 
                "-------------Receipt--------------\n\n" +
                "Time of sale: 2024-04-28 14:47\n\n" +
                "TestItem\t\t2 x 50.0 \t100.0 SEK\n\n" +
                "Total Before Discount: 100.0 SEK\n" +
                "Discount: 0.0 SEK\n" +
                "Total After Discount: 100.0 SEK\n" +
                "VAT: 10.0 SEK\n\n" +
                "Payment: 150.0 SEK\n" +
                "Change: 50.0 SEK\n\n" +
                "--------------END RECEIPT---------------\n";

        String actualReceipt = receiptInstance.toString();

        assertEquals(expectedReceipt, actualReceipt);
    }
}