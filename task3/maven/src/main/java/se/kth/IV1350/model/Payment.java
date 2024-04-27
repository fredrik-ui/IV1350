package se.kth.IV1350.model;

/**
 * Represents a payment in the point of sale system.
 */

public class Payment {

    double totalAmountPaid;
    double totalChange;

    /**
     * Constructs a new instance of Payment.
     *
     * @param amount The amount paid for the payment.
     * @param totalPrice The total price of the items in the sale.
     */

    public Payment(double amount, Amount totalPrice) {
        this.totalAmountPaid = amount;

        totalChange = calculateChange(amount, totalPrice);
    }

    /**
     * Calculates the change to be returned to the customer based on the amount paid and the total price of the items.
     *
     * @param  amount         the amount paid by the customer
     * @param  totalPrice     the total price of the items
     * @return                the change to be returned to the customer, or -1 if the amount paid is less than the total price
     */
    private double calculateChange(double amount, Amount totalPrice){
        if(amount >= totalPrice.getValue()){
            return amount - totalPrice.getValue(); // Calculate change only if amount is greater than or equal to totalPrice
        } else {
            return -1; // THROW AN ERROR HERE FOR NEXT SEMINARE
        }        
    }

    public double getTotalAmountPaid(){
        return this.totalAmountPaid;
    }
    public double getTotalChange(){
        return this.totalChange;
    }
}

