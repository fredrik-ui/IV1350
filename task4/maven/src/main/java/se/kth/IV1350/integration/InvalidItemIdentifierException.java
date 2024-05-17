package se.kth.IV1350.integration;

public class InvalidItemIdentifierException extends Exception {

    /**
     * Constructs an InvalidItemIdentifierException when the given id is not found
     *
     * @param id The item identifier that could not be found in the inventory
     *           catalog.
     */

    public InvalidItemIdentifierException(int id) {
        super("Error: Could not find product with itemIdenifier: " + id + " in the inventory catalog.");
    }
}