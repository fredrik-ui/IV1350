package se.kth.IV1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashRegisterTest {
    private CashRegister cashRegisterInstance;
    
    @BeforeEach
    void setUp(){
        cashRegisterInstance = new CashRegister();
    }
    
    @AfterEach
    void tearDown(){
        cashRegisterInstance = null;
    }

    @Test
    void testCashRegisterConstructor(){
        assertEquals(200, cashRegisterInstance.getMoney(), "Wrong amount of money in the cash register");
    }

    @Test 
    void testAddPayment(){

        Amount cashGiven = new Amount(100);
        Amount totalPriceOfSale = new Amount(20);
        Payment payment = new Payment(cashGiven.getValue(), totalPriceOfSale);

        cashRegisterInstance.addPayment(payment);


        assertEquals(220, cashRegisterInstance.getMoney());
    }
    

}
