package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    public void testPaymentConstructor() {

        Amount totalPrice = new Amount(80);
        Payment payment = new Payment(100, totalPrice);
        assertEquals(100, payment.getTotalAmountPaid().getValue(), "The total payemnt is different from expected value");
        assertEquals(20, payment.getTotalChange().getValue(), "The wrong change is calcualted");

    }

    @Test
    public void testPaymentConstructorWithInsufficientAmount() {

        Amount totalPrice = new Amount(80);
        Payment payment = new Payment(50, totalPrice);
        assertEquals(50, payment.getTotalAmountPaid().getValue(), "Payment amount should be initialized correctly");
        assertNull(payment.getTotalChange(),"Total change should be null when payment amount is insufficient");

    }
}
