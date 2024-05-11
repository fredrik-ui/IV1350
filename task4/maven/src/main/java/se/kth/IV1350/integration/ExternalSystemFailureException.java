package se.kth.IV1350.integration;

public class ExternalSystemFailureException extends Exception  {
    
    public ExternalSystemFailureException() {
        super("Error: connection to databse failed");
    }

}
