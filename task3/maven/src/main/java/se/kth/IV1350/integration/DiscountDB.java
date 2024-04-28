package se.kth.IV1350.integration;

import se.kth.IV1350.model.Amount;
import se.kth.IV1350.model.Sale;

public class DiscountDB {

    public DiscountDB() {
    }
    public Amount getDiscount(int customerID, Sale sale) {
        double fixedDiscountValue = 10.0;
        return new Amount(fixedDiscountValue);
    }
    
}
