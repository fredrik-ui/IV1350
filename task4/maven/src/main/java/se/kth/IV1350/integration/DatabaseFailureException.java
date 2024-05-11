package se.kth.IV1350.integration;

public class DatabaseFailureException extends Exception  {
    
    public DatabaseFailureException() {
        super("Error: connection to databse failed");
    }

}
