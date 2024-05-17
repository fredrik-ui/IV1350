package se.kth.IV1350.integration;

public class ExternalSystemFailureException extends RuntimeException {

    /**
     * Constructs an ExternalSystemFailureException when the system is not reachable
     */
    public ExternalSystemFailureException() {
        super("Error: connection to database failed");
    }
}