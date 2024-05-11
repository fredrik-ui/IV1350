package se.kth.IV1350.integration;

public class InvalidItemIdentifierException extends Exception {

    public InvalidItemIdentifierException(int id) {
        super ("Error: Could not find product with itemIdenifier: " + id + " in the inventory catalog.");
    }
}