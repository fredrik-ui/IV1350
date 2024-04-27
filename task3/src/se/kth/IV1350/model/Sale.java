package se.kth.IV1350.model;

import java.util.ArrayList;
import java.util.Date;

import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;

/**
 * Represents a sale transaction in the point of sale system.
 */
public class Sale {
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
    public Sale() {
        this.totalPrice = new Amount(0);
        this.totalVAT = new Amount(0);
        this.time = new Date();        
        this.DTO = new saleDTO(time, totalPrice, totalVAT, totalPriceAfterDiscount, scannedItems);
    }

    public Date setTime(){
        return new Date();
    }

    /**
     * Checks if an item with the specified itemID already exists in the sale.
     *
     * @param  itemID the ID of the item to check for duplicates
     * @return the item if found, otherwise null
     */
    public itemDTO checkForDuplicateItem(int itemID) {
        for (ItemAndQuantity item : scannedItems) {
            itemDTO currentItem = item.getItemDTO();
            if (currentItem.getItemID() == itemID) {
                return currentItem; // Item with the given ID found, return that item
            }
        }
        return null;
    }

    /**
     * Adds an item to the sale with the specified quantity.
     * If the item already exists in the sale, its quantity is updated.
     * If the item does not exist in the sale, it is added with the specified quantity.
     *
     * @param  item    the item to be added to the sale
     * @param  quantity the quantity of the item to be added
     * @param  exist   indicates whether the item already exists in the sale
     */
    public void additemToSale(itemDTO item, int quantity, boolean exist) {
        for (ItemAndQuantity scannedItem : scannedItems) {
            if (scannedItem.getItemDTO().equals(item)) {
                int currentQuantity = scannedItem.getQuantity();
                scannedItem.setQuantity(quantity+currentQuantity);
            }
        }
        if (!exist) {
            System.out.println(item.getName());;
            scannedItems.add(new ItemAndQuantity(item, quantity));
        }
        totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
        calculateTotalVAT();
    }
    private void calculateTotalVAT() {
        for(ItemAndQuantity item: scannedItems){
            itemDTO currentItem = item.getItemDTO();
            double itemVATAmount = (currentItem.getPrice().getValue()*item.getQuantity())* (currentItem.getVAT().getValue() / 100);
            totalVAT = totalVAT.add(new Amount(itemVATAmount));
        }
    
    }

    /**
     * Applies a total discount to the total price of the sale.
     * 
     * @param discount The discount amount to apply.
     * @return The total price after applying the discount.
     */
    public Amount applyTotalDiscount(Amount discount) {
        if (totalPrice.subtract(discount).getValue() <= 0) {
            totalPriceAfterDiscount = new Amount(0);
            //DTO.setTotalPriceAfterDiscount(new Amount(0));
        } else {
            totalPriceAfterDiscount = this.totalPrice.subtract(discount);
            //DTO.setTotalPriceAfterDiscount(discount);
        }
        return totalPriceAfterDiscount;
    }
    /**
     * Ends the sale by processing the payment and printing the receipt.
     * 
     * @param amount The amount tendered by the customer.
     * @return The payment object representing the transaction.
     */
    public Payment endSale(double amount) {
        Payment payment = new Payment(amount, totalPrice);
        if(payment.getTotalChange() == -1){
            System.out.println("Not enough for a payemnt");
            return null;
        }
        Receipt receipt = new Receipt(payment, getDTO());
        ReceiptPrinter.printReceipt(receipt);
        return payment;
    }

    public saleDTO getDTO() {
        return new saleDTO(time, totalPrice, totalVAT, totalPriceAfterDiscount, scannedItems);
    }
    
}