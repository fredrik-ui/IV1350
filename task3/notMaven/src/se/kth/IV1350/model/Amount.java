package se.kth.IV1350.model;

public class Amount {
    private double value;

    public Amount() {
        this.value = 0.0;
    }

    public Amount(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Amount add(Amount amount) {
        return new Amount(value+amount.getValue());
    }

    public Amount subtract(Amount amount) {
        return new Amount(value-amount.getValue());
    }
    public Amount multiply(Amount amount) {
        return new Amount(value*amount.getValue());
    }

}
