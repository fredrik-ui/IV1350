package se.kth.IV1350.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.IV1350.model.Amount;
import se.kth.IV1350.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {
    private double totalPrice;
    private PrintWriter logger;

    public TotalRevenueFileOutput() {
        try {
            logger = new PrintWriter(new FileWriter("TotalRevenueLog.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the total price with the given price and logs the new total revenue.
     *
     * @param price the amount to add to the total price
     */
    @Override
    public void newSale(Amount price) {
        totalPrice += price.getValue();
        logger.println("Total revenue: " + totalPrice + " SEK");
        logger.flush();
    }
}
