package se.kth.IV1350.model;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import se.kth.IV1350.integration.itemDTO;


public class saleDTO {
    private Date time;
    private Amount totalPrice;
    private Amount totalVAT; 
    private Amount totalPriceAfterDiscount; 
    //private LinkedHashMap<itemDTO, Integer> scannedItems = new LinkedHashMap<>();
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private Sale sale;

    // public saleDTO(Date time, Amount totalPrice, Amount totalVAT, Amount totalPriceAfterDiscount, LinkedHashMap<itemDTO,Integer> scannedItems){
    //     this.time = time;
    //     this.totalPrice=totalPrice;
    //     this.totalVAT=totalVAT;
    //     this.totalPriceAfterDiscount=totalPriceAfterDiscount;
    //     this.scannedItems=scannedItems;
    // }

    public saleDTO(Sale sale){
        this.totalPrice = new Amount(0);
        this.totalVAT = new Amount(0);
        this.sale=sale;
    }

    public Amount getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(itemDTO item, int quantity) {
        this.totalPrice = this.totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
    }


    public Amount getTotalVAT() {
        return totalVAT;
    }
    public void setTotalVAT() {
        calculateTotalVAT();
        //sale.calculateTotalVAT();
    }

    private void calculateTotalVAT() {
        for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
            itemDTO currentItem = entry.getKey();
            int quantity = entry.getValue();
            double itemVATAmount = (currentItem.getPrice().getValue()*quantity)* (currentItem.getVAT().getValue() / 100);
            totalVAT = totalVAT.add(new Amount(itemVATAmount));
        }
    }


    public Amount getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }
    public void setTotalPriceAfterDiscount(Amount discount) {
        System.out.println("TOTAL PRICE: "+totalPrice.getValue());
        totalPriceAfterDiscount = this.totalPrice.subtract(discount);
    }

    public LinkedHashMap<itemDTO, Integer> getScannedItems() {
        return scannedItems;
    }
    // public LinkedHashMap<itemDTO, Integer> getScannedItems() {
    //     return scannedItems.get();
    // }
    // public LinkedHashMap<itemDTO, Integer> getScannedItemsQuantity() {
    //     return scannedItems;
    // }


    public void setScannedItems(itemDTO item, int currentQuantity, int quantity) {
        scannedItems.put(item, currentQuantity + quantity);
    }

    public Date getTime() {
        return time;
    }


}
