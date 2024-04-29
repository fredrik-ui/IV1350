package se.kth.IV1350.integration;

import se.kth.IV1350.model.Amount;
import se.kth.IV1350.model.Sale;

public class DiscountDB {
    /**
     *  Initializes a new instance of DiscountDB
     */
    public DiscountDB() {
    }
    /**
     * Retrieves the discount amount for a customer based on their ID and sale.
     *
     * @param  customerID  the ID of the customer
     * @param  sale        the sale object for which the discount is being calculated
     * @return             the discount amount as an Amount object
     */
    public Amount getDiscount(int customerID, Sale sale) {
        double fixedDiscountValue = 10.0;
        return new Amount(fixedDiscountValue);
    }
    
}
