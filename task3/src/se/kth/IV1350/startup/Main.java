package se.kth.IV1350.startup;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.view.View;


public class Main {
    
    // To compile everything:
    // javac -classpath . se/kth/IV1350/controller/*.java se/kth/IV1350/integration/*.java se/kth/IV1350/model/*.java se/kth/IV1350/startup/*.java se/kth/IV1350/view/*.java
    // To run:
    // java -classpath src se.kth.IV1350.startup.Main

    public static void main(String[] args){
        ExternalDB externalSystems = new ExternalDB();
        ReceiptPrinter printer = new ReceiptPrinter();
        Controller contr = new Controller(externalSystems, printer);
        View view = new View(contr); // 
        view.run();
        
    }

}
