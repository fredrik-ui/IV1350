package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    void testAdd() {
        Amount amount1 = new Amount(10.0);
        Amount amount2 = new Amount(5.0);
        assertEquals(15, amount1.add(amount2).getValue());
    }

    @Test
    void testSubtract() {
        Amount amount1 = new Amount(10.0);
        Amount amount2 = new Amount(5.0);
        assertEquals(5, amount1.subtract(amount2).getValue());
    }

    @Test
    void testMultiply() {
        Amount amount1 = new Amount(10.0);
        Amount amount2 = new Amount(5.0);;
        assertEquals(50, amount1.multiply(amount2).getValue());
    }

    @Test
    void testConstructor() {
        Amount amount = new Amount();
        assertEquals(0.0, amount.getValue());
    }

    @Test
    void testConstructorWithValue() {
        Amount amount = new Amount(5.0);
        assertEquals(5.0, amount.getValue());
    }
}