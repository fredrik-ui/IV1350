package se.kth.IV1350.model;

import java.util.ArrayList;

public class saleDTO {
    private String time;
    private Amount totalPrice;
    private Amount totalVAT;
    private Amount totalPriceAfterDiscount;
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();

    /**
     * Constructs a new saleDTO object with the provided sale details.
     *
     * @param currentTime             the current time of the sale
     * @param totalPrice              the total price of the sale
     * @param totalVAT                the total value-added tax (VAT) of the sale
     * @param totalPriceAfterDiscount the total price of the sale after applying
     *                                discounts
     * @param scannedItems            the list of scanned items and their quantities
     *                                in the sale
     */
    public saleDTO(String currentTime, Amount totalPrice, Amount totalVAT, Amount totalPriceAfterDiscount,
            ArrayList<ItemAndQuantity> scannedItems) {
        this.time = currentTime;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
        this.scannedItems = scannedItems;
    }

    public Amount getTotalPrice() {
        return totalPrice;
    }

    public Amount getTotalVAT() {
        return totalVAT;
    }

    public Amount getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }

    public ArrayList<ItemAndQuantity> getScannedItems() {
        return scannedItems;
    }

    public String getTime() {
        return time;
    }

}
