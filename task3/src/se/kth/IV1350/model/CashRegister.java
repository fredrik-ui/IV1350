package se.kth.IV1350.model;

public class CashRegister {

    Amount cashInRegister;

    public CashRegister(){
        this.cashInRegister = new Amount(200);
    }


    public void addPayment(Payment payment) {
        cashInRegister.add(new Amount(payment.getTotalAmountPaid()-payment.getTotalChange()));
    }
    
}
