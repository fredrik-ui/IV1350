package se.kth.IV1350.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;

/**
 * Represents a sale transaction in the point of sale system.
 */
public class Sale {
    private String currentTime;
    private Amount totalPrice;
    private Amount totalVAT;
    private Amount totalPriceAfterDiscount;
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private List<SaleObserver> saleObserver = new ArrayList<>();
    private saleDTO DTO;

    /**
     * Constructs a new Sale object and initializes most of it's fields.
     */
    public Sale() {
        this.totalPrice = new Amount(0);
        this.totalVAT = new Amount(0);
        this.totalPriceAfterDiscount = new Amount(0);
        this.currentTime = setTime();
        this.DTO = new saleDTO(currentTime, totalPrice, totalVAT, totalPriceAfterDiscount, scannedItems);
    }

    /**
     * Sets the current time using LocalDateTime and returns it formatted as a
     * string.
     *
     * @return the current time formatted as a string
     */
    public String setTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return currentTime.format(formatter);
    }

    /**
     * Checks if an item with the specified itemID already exists in the sale.
     *
     * @param itemID the ID of the item to check for duplicates
     * @return the item if found, otherwise null
     */
    public itemDTO checkForDuplicateItem(int itemID) {
        for (ItemAndQuantity item : scannedItems) {
            itemDTO currentItem = item.getItemDTO();
            if (currentItem.getItemID() == itemID) {
                return currentItem;
            }
        }
        return null;
    }

    /**
     * Adds an item to the sale with the specified quantity.
     * If the item already exists in the sale, its quantity is updated.
     * If the item does not exist in the sale, it is added with the specified
     * quantity.
     *
     * @param item     the item to be added to the sale
     * @param quantity the quantity of the item to be added
     * @param exist    indicates whether the item already exists in the sale
     */
    public void additemToSale(itemDTO item, int quantity, boolean exist) {
        for (ItemAndQuantity scannedItem : scannedItems) {
            if (scannedItem.getItemDTO().equals(item)) {
                int currentQuantity = scannedItem.getQuantity();
                scannedItem.setQuantity(quantity + currentQuantity);
            }
        }
        if (!exist) {
            scannedItems.add(new ItemAndQuantity(item, quantity));
        }
        updateTotalCost(item, quantity);
        calculateTotalVAT();
    }

    /**
     * Updates the total cost by adding the cost of the given item multiplied by the
     * quantity to the current total price.
     *
     * @param item     the item for which the cost is to be updated
     * @param quantity the quantity of the item
     */
    private void updateTotalCost(itemDTO item, int quantity) {
        totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
    }

    /**
     * Calculates the total VAT amount for all scanned items in the sale.
     */
    private void calculateTotalVAT() {
        for (ItemAndQuantity item : scannedItems) {
            itemDTO currentItem = item.getItemDTO();
            double itemVATAmount = (currentItem.getPrice().getValue() * item.getQuantity())
                    * (currentItem.getVAT().getValue() / 100);
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
        } else {
            totalPriceAfterDiscount = this.totalPrice.subtract(discount);
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
        Payment payment = new Payment(amount, totalPriceAfterDiscount);
        if (payment.getTotalChange() == null) {
            System.out.println("Not enough for a payemnt");
            return null;
        }
        notifyObserver();
        Receipt receipt = new Receipt(payment, getDTO());
        ReceiptPrinter.printReceipt(receipt);
        return payment;
    }

    private void notifyObserver(){
        for(SaleObserver observer : saleObserver){
            System.out.println(observer);
            observer.newSale(totalPriceAfterDiscount);
        }
    }

    /**
     * @return a saleDTO object with the current time, total price, total VAT, total
     *         price after discount, and scanned items
     */
    public saleDTO getDTO() {
        return new saleDTO(currentTime, totalPrice, totalVAT, totalPriceAfterDiscount, scannedItems);
    }

    /**
     * @return the total price as an Amount object
     */
    public Amount getTotalPrice() {
        return totalPrice;
    }

    /**
     * @return the total price after discount
     */
    public Amount getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    /**
     * @return an ArrayList of ItemAndQuantity objects
     */
    public ArrayList<ItemAndQuantity> getScannedItems() {
        return scannedItems;
    }

    /**
     * @return the current time
     */
    public String getTime() {
        return currentTime;
    }

    public void addSaleObserver(SaleObserver obs){
        saleObserver.add(obs);
    }
}