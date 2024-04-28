// package se.kth.IV1350.model;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// public class AmountTest {
//     private Amount amountInstance;

//     @BeforeEach
//     void setUp(){
//         amountInstance = new Amount(10);
//     }

//     @AfterEach
//     void tearDown(){
//         amountInstance = new Amount(0); // Reset the amountInstance to 0
//     }

//     @Test
//     public void testAmountConstructor() {
//         double amount = 100.0;
//         amountInstance = new Amount(amount);
//         assertEquals(100, amountInstance.getValue(), "The amount is different from expected value");
//     }

//     @Test
//     public void testAdd() {
//         Amount amount = new Amount(100);
//         Amount newAmount = amount.add(amountInstance);
//         assertEquals(110, newAmount.getValue(), "The new amount is not calculated correctly");
//     }
    
//     @Test
//     public void testSubtract() {
//         Amount amount = new Amount(5);
//         Amount newAmount = amountInstance.subtract(amount);
//         assertEquals(5, newAmount.getValue(), "The new amount is not calculated correctly");
//     }
    
//     @Test
//     public void testMultiply() {
//         Amount amount = new Amount(2);
//         Amount newAmount = amountInstance.multiply(amount);
//         assertEquals(20, newAmount.getValue(), "The new amount is not calculated correctly");
//     }
// }