package se.kth.IV1350.model;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;



/**
 * Represents a sale transaction in the point of sale system.
 */
public class Sale {

    //private LocalDateTime time;
    private Date time;
    private Amount totalPrice;
    private Amount totalVAT; 
    private Amount totalPriceAfterDiscount; 
    //private LinkedHashMap<itemDTO, Integer> scannedItems = new LinkedHashMap<>();
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private saleDTO DTO;

    /**
     * Constructs a new Sale object and sets the start time of the sale.
     */
    public Sale(){
        setTimeOfSale();
        this.DTO = new saleDTO(this);

    }

    /**
     * Sets the time of sale to the current system time.
     */
    public void setTimeOfSale(){
        time = new Date();
    }

    /**
     * Checks if an item with the specified ID already exists in the sale.
     * @param itemID The ID of the item to check for duplicates.
     * @return The item if found, otherwise null.
     */
    public itemDTO checkForDuplicate(int itemID) {
        for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
            itemDTO currentItem = entry.getKey();
            if (currentItem.getItemID() == itemID) {
                return currentItem; // Item with the given ID found, return that item
            }
        }
        return null; 
    }

    /**
     * Adds an item to the sale with the specified quantity.
     * If the item already exists in the sale, its quantity is updated.
     * @param item The item to add to the sale.
     * @param quantity The quantity of the item to add.
     */
    public void additemToSale(itemDTO item, int quantity) {
        if(!scannedItems.containsKey(item)){
            //scannedItems.put(item, quantity);
            DTO.setScannedItems(item, quantity, 0);
        }else{
            int currentQuantity = scannedItems.get(item);
            DTO.setScannedItems(item,currentQuantity,quantity);
            //scannedItems.put(item, currentQuantity + quantity);   
        }
        DTO.setTotalPrice(item, quantity);
        DTO.setTotalVAT();
        //totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));

    }    
    // public void additemToSale(itemDTO item, int quantity) {
    //     if(!scannedItems.containsKey(item)){
    //         scannedItems.put(item, quantity);
    //     }else{
    //         int currentQuantity = scannedItems.get(item);
    //         scannedItems.put(item, currentQuantity + quantity);   
    //     }
    //     totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));

    // }
    // I DTO känns mest rimligt???


    /**
     * Applies a total discount to the total price of the sale.
     * @param discount The discount amount to apply.
     * @return The total price after applying the discount.
     */
    public Amount applyTotalDiscount(Amount discount){
        if(DTO.getTotalPrice().subtract(discount).getValue()<= 0){
            
            DTO.setTotalPriceAfterDiscount(new Amount(0));
            //totalPriceAfterDiscount = new Amount(0);
        }else{
            //totalPriceAfterDiscount = totalPrice - discount;
            DTO.setTotalPriceAfterDiscount(discount);
            //totalPriceAfterDiscount = totalPrice.subtract(discount);
        }
        return DTO.getTotalPriceAfterDiscount();
    }

    /**
     * Ends the sale by processing the payment and printing the receipt.
     * @param amount The amount tendered by the customer.
     * @return The payment object representing the transaction.
     */
    public Payment endSale(double amount){
        Payment payment = new Payment(amount, DTO.getTotalPrice());
        Receipt receipt = new Receipt(payment, DTO);
        //Receipt receipt = new Receipt(payment, totalPrice, totalVAT, totalPriceAfterDiscount, scannedItems, time);
        ReceiptPrinter.printReceipt(receipt);
        return payment;
    }


    // public Amount getTotalPrice() {
    //     return totalPrice;
    // }

    // public Amount getTotalVAT() {
    //     calculateTotalVAT();
    //     return totalVAT;
    // }

    // public Amount getTotalPriceAfterDiscount() {
    //     return totalPriceAfterDiscount;
    // }

    // public LinkedHashMap<itemDTO, Integer> getScannedItems() {
    //     return scannedItems;
    // }

    // public Date getTime() {
    //     return time;
    // }
}