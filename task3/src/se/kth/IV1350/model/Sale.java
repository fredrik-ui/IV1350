package se.kth.IV1350.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;


public class Sale {
   
    private Date time;
    private double totalPrice;
    private double totalVAT;
    private double totalPriceAfterDiscount;
    // The item and it's quantity
    private LinkedHashMap<itemDTO, Integer> scannedItems = new LinkedHashMap<>();


    // Start the sale and set the start time of it
    public Sale(){
        setTimeOfSale();
    }

    public void setTimeOfSale(){
        time = new Date();

    }

    public itemDTO checkForDuplicate(int itemID) {
        // Iterate over the entries of scannedItems map
        for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
            itemDTO currentItem = entry.getKey();
            // Check if the current item's ID matches the given itemID
            if (currentItem.getItemID() == itemID) {
                return currentItem; // Item with the given ID found, reutrn that item
            }
        }
        return null; // Item with the given ID not found
    }


    public void additemToSale(itemDTO item, int quantity) {
        scannedItems.put(item, quantity);
        totalPrice+=item.getPrice();
        //totalVAT+=item.getVAT();
    }

    public double applyTotalDiscount(double discount){
        if(totalPrice-discount<=0){
            totalPriceAfterDiscount = 0;
        }else{
            totalPriceAfterDiscount = totalPrice-discount;
        }
        return totalPriceAfterDiscount;
    }
    public Payment endSale(double amount){

        // 1.1.1
        Payment payment = new Payment(amount, totalPrice);
        //1.1.2
        Receipt receipt = new Receipt(payment);
        //1.1.3
        ReceiptPrinter.printReceipt(receipt);
        
        return null;
    }
}
