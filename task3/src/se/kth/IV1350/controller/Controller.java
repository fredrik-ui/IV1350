package se.kth.IV1350.controller;

import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;
import se.kth.IV1350.model.CashRegister;
import se.kth.IV1350.model.Sale;


public class Controller{
    
    private ExternalDB externalSystems;
    private ReceiptPrinter printer;
    private Sale sale;

    public Controller(ExternalDB exDB, ReceiptPrinter printer){
        CashRegister cashRegister = new CashRegister();
        this.externalSystems = exDB;
        this.printer = printer;
    }

    public void startSale(){
        sale = new Sale();
    }

    public itemDTO scanItem(int itemID, int quantity){
        
        // First check if the item exist in the sale; 
        itemDTO item = sale.checkForDuplicate(itemID);

        if(item == null){
            // Find this itemID in the inventory system
            item = externalSystems.getInventorySystem().getItemFromDB(itemID);
            if(item == null)
                // An error should be thrown
                return null;
            sale.additemToSale(item, quantity);
        }else{
            sale.additemToSale(item, quantity);
        }

        // return an item
        return item;
    }

}