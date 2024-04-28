package se.kth.IV1350.model;
/**
* Handles and keeps track of the money in a cash register
 */
public class CashRegister {
    private Amount cashInRegister;

    /**
     * Constructs a CashRegister object with an initial amount of cash.
     */
    public CashRegister(){
        this.cashInRegister = new Amount(200); 
    }
    /**
     * Adds a payment to the cash register, updating the amount of cash in the register.
     * @param payment The payment to be added to the cash register.
     */
    public void addPayment(Payment payment) {
        cashInRegister = cashInRegister.add(new Amount(payment.getTotalAmountPaid().getValue() - payment.getTotalChange().getValue()));
    }

    public double getMoney(){
        return cashInRegister.getValue();
    }
    
}
