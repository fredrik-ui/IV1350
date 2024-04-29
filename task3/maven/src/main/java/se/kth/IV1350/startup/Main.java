package se.kth.IV1350.startup;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.view.View;


public class Main {
    // Run using maven:
    // java -cp target/maven-maven-archetype-quickstart.jar se.kth.IV1350.startup.Main
    // Or:
    // java -jar target/maven-maven-archetype-quickstart.jar
    public static void main(String[] args){
        ExternalDB externalSystems = new ExternalDB();
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller contr = new Controller(externalSystems, printer);
        View view = new View(contr); // 
        view.run();   
    }
}
