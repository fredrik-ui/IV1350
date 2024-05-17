package se.kth.IV1350.integration;

public class ExternalSystemFailureException extends Exception {

    /**
     * Constructs an ExternalSystemFailureException when the system is not rechable
     */

    public ExternalSystemFailureException() {
        super("Error: connection to databse failed");
    }

}
