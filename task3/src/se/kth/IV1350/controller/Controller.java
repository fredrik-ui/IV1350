package se.kth.IV1350.controller;

import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;
import se.kth.IV1350.model.CashRegister;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.Sale;


public class Controller{
    
    private ExternalDB externalSystems;
    //private ReceiptPrinter printer;
    private Sale sale;
    //private int customerID;

    public Controller(ExternalDB exDB, ReceiptPrinter printer){
        CashRegister cashRegister = new CashRegister();
        this.externalSystems = exDB;
        //this.printer = printer;
    }

    public void startSale(){
        sale = new Sale();
    }

    public itemDTO scanItem(int itemID, int quantity){
        
        // First check if the item exist in the sale; 
        // 1.1
        itemDTO item = sale.checkForDuplicate(itemID);

        if(item == null){
            // 1.3
            item = externalSystems.getInventorySystem().getItemFromDB(itemID);
            if(item == null)
                // An error should be thrown
                return null;
            sale.additemToSale(item, quantity);
        }else{
            //1.2
            sale.additemToSale(item, quantity);
        }

        // return an item
        return item;
    }

    public double startDiscount(int customerID){
        double discount = externalSystems.getDiscountDBSystem().getDiscount(customerID, sale);
        double newPrice = sale.applyTotalDiscount(discount);
        return newPrice;
    }

    public Payment enterPayemnt(double amount){
        Payment change = sale.endSale(amount);
        return change;
        
    }

}