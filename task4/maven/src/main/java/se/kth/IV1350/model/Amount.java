package se.kth.IV1350.model;

public class Amount {
    private double value;
    /**
     * Constructs a new Amount object with a default value of 0.0.
     */
    public Amount() {
        this.value = 0.0;
    }
    /**
     * Constructs a new Amount object with the specified value.
     *
     * @param value the numerical value of the Amount object
     */
    public Amount(double value) {
        this.value = value;
    }
    /**
     * Retrieves the value of the variable.
     *
     * @return the value of the variable
     */
    public double getValue() {
        return value;
    }
    /**
     * Adds the value of the given Amount object to the current value of this Amount object.
     *
     * @param  amount  the Amount object to be added to this Amount object
     * @return         a new Amount object with the sum of the two values
     */
    public Amount add(Amount amount) {
        return new Amount(value+amount.getValue());
    }
    /**
     * Subtracts the value of the given Amount from the current Amount.
     *
     * @param  amount  the Amount to subtract from the current Amount
     * @return         a new Amount object with the result of subtracting the given Amount from the current Amount
     */
    public Amount subtract(Amount amount) {
        return new Amount(value-amount.getValue());
    }
    /**
     * Multiplies the value of local amount with incomning amount. 
     *
     * @param  amount  the Amount object to multiply this Amount object by
     * @return         a new Amount object with the result of the multiplication
     */
    public Amount multiply(Amount amount) {
        return new Amount(value*amount.getValue());
    }

}
