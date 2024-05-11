package se.kth.IV1350.view;

import se.kth.IV1350.model.Amount;
import se.kth.IV1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver{
    private double totalPrice;
    /**
     * A method to handle a new sale by updating the total price and printing the total revenue in SEK.
     *
     * @param  price  the amount of the sale to add to the total revenue
     */
    @Override
    public void newSale(Amount price) {
        System.out.println("SAHkjSH");
        totalPrice += price.getValue();
        System.out.println("Total revenue: " + totalPrice + " SEK");
    }

    
}
