package se.kth.IV1350.model;

import java.util.ArrayList;

public class saleDTO {
    private String time;
    private Amount totalPrice;
    private Amount totalVAT; 
    private Amount totalPriceAfterDiscount; 
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();

    public saleDTO(String currentTime, Amount totalPrice, Amount totalVAT, Amount totalPriceAfterDiscount, ArrayList<ItemAndQuantity> scannedItems) {
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

    public ArrayList<ItemAndQuantity> getScannedItems(){
        return scannedItems;
    }

    public String getTime() {
        return time;
    }

}
