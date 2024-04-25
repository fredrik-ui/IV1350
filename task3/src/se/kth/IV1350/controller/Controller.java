package se.kth.IV1350.controller;

import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;
import se.kth.IV1350.model.Amount;
import se.kth.IV1350.model.CashRegister;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.Sale;
import se.kth.IV1350.model.saleDTO;


public class Controller{
    
    private ExternalDB externalSystems;
    private CashRegister cashRegister;
    private Sale sale;

    public Controller(ExternalDB exDB, ReceiptPrinter printer){
        //this.cashRegister = new CashRegister();
        this.cashRegister = new CashRegister();
        this.externalSystems = exDB;
    }

    public void startSale(){
        sale = new Sale();
    }

    public itemDTO scanItem(int itemID, int quantity){
        
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

    public saleDTO getSaleDTO() {
        return new saleDTO(sale);
    }


    public saleDTO scanItemAndGetSaleDTO(int itemID, int quantity) {
        itemDTO item = sale.checkForDuplicate(itemID);
    
        if (item == null) {
            item = externalSystems.getInventorySystem().getItemFromDB(itemID);
            if (item == null)
                return null; // An error should be thrown
            sale.additemToSale(item, quantity);
        } else {
            sale.additemToSale(item, quantity);
        }
    
        return getSaleDTO();
    }


    public double startDiscount(int customerID){
        Amount discount = externalSystems.getDiscountDBSystem().getDiscount(customerID, sale);
        double newPrice = sale.applyTotalDiscount(discount).getValue();
        return newPrice;
    }

    public Payment enterPayemnt(double amount){
        Payment change = sale.endSale(amount);
        //externalSystems.updateDB();
        cashRegister.addPayment(change);
        return change;
    }

}