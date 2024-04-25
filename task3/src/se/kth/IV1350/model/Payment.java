package se.kth.IV1350.model;

public class Payment {

    double totalAmountPaid;
    double totalChange;

    public Payment(double amount, Amount totalPrice) {
        this.totalAmountPaid = amount;

        totalChange = calculateChange(amount, totalPrice);
    }

    private double calculateChange(double amount, Amount totalPrice){
        if(amount >= totalPrice.getValue()){
            return amount - totalPrice.getValue(); // Calculate change only if amount is greater than or equal to totalPrice
        } else {
            System.out.println("Insufficient amount paid. Please pay the remaining amount.");
            return -1; // Return a special value to indicate insufficient payment
        }        
    }

    public double getTotalAmountPaid(){
        return this.totalAmountPaid;
    }
    public double getTotalChange(){
        return this.totalChange;
    }
}

