package se.kth.IV1350.model;

import java.util.ArrayList;

import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;



/**
 * Represents a sale transaction in the point of sale system.
 */
public class Sale {

    //private LinkedHashMap<itemDTO, Integer> scannedItems = new LinkedHashMap<>();
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private saleDTO DTO;

    /**
     * Constructs a new Sale object and sets the start time of the sale.
     */
    public Sale(){
        this.DTO = new saleDTO(this);
    }

    /**
     * Sets the time of sale to the current system time.
     */

    /**
     * Checks if an item with the specified ID already exists in the sale.
     * @param itemID The ID of the item to check for duplicates.
     * @return The item if found, otherwise null.
     */

     public itemDTO checkForDuplicate(int itemID) {
        for (ItemAndQuantity item : scannedItems) {
            itemDTO currentItem = item .getItemDTO();
            if (currentItem.getItemID() == itemID) {
                return currentItem; // Item with the given ID found, return that item
            }
        }
        return null; 
    }
     // public itemDTO checkForDuplicate(int itemID) {
    //     for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
    //         itemDTO currentItem = entry.getKey();
    //         if (currentItem.getItemID() == itemID) {
    //             return currentItem; // Item with the given ID found, return that item
    //         }
    //     }
    //     return null; 
    // }

    /**
     * Adds an item to the sale with the specified quantity.
     * If the item already exists in the sale, its quantity is updated.
     * @param item The item to add to the sale.
     * @param quantity The quantity of the item to add.
     */

     public void additemToSale(itemDTO item, int quantity) {
        if(scannedItems.isEmpty()) {
            DTO.setScannedItems(item, quantity, 0);
        } else {
            for (ItemAndQuantity scannedItem : scannedItems) {
                if (scannedItem.getItemDTO().equals(item)) {
                    int currentQuantity = scannedItem.getQuantity();
                    DTO.setScannedItems(item, currentQuantity, quantity);
                } else {
                    DTO.setScannedItems(item, quantity, 0);
                }

            }
        }
        DTO.setTotalPrice(item, quantity);
        DTO.setTotalVAT();
    }  

    // public void additemToSale(itemDTO item, int quantity) {
    //     boolean found = false;
    //     for (ItemAndQuantity scannedItem : scannedItems) {
    //         if (scannedItem.getItemDTO().equals(item)) {
    //             // If item already exists, update its quantity
    //             int currentQuantity = scannedItem.getQuantity();
    //             scannedItems.remove(scannedItem);
    //             DTO.setScannedItems(item, currentQuantity, quantity);
    //             found = true;
    //             break;
    //         }
    //     }
    //     if (!found) {
    //         DTO.setScannedItems(item, 0, quantity);
    //     }
    //             //DTO.lengthScannedItem();
    //             DTO.setTotalPrice(item, quantity);
    //             DTO.setTotalVAT();    
    // }

    // }    
    // public void additemToSale(itemDTO item, int quantity) {
    //     if(!scannedItems.containsKey(item)){
    //         scannedItems.put(item, quantity);
    //     }else{
    //         int currentQuantity = scannedItems.get(item);
    //         scannedItems.put(item, currentQuantity + quantity);   
    //     }
    //     totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));

    // }


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

    public saleDTO getDTO(){
        return DTO;
    }
}