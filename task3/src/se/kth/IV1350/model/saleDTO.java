package se.kth.IV1350.model;

//import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Date;

import se.kth.IV1350.integration.itemDTO;


public class saleDTO {
    private Date time;
    private Amount totalPrice;
    private Amount totalVAT; 
    private Amount totalPriceAfterDiscount; 
    //private LinkedHashMap<itemDTO, Integer> scannedItems = new LinkedHashMap<>();
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();


    public saleDTO(Sale sale){
        this.totalPrice = new Amount(0);
        this.totalVAT = new Amount(0);
        this.time = new Date();
    }

    public Amount getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(itemDTO item, int quantity) {
        totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
    }


    public Amount getTotalVAT() {
        return totalVAT;
    }
    public void setTotalVAT() {
        calculateTotalVAT();
    }

    private void calculateTotalVAT() {
        // for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
        //     itemDTO currentItem = entry.getKey();
        //     int quantity = entry.getValue();
        //     double itemVATAmount = (currentItem.getPrice().getValue()*quantity)* (currentItem.getVAT().getValue() / 100);
        //     totalVAT = totalVAT.add(new Amount(itemVATAmount));
        // }

        for(ItemAndQuantity item: scannedItems){
            itemDTO currentItem = item.getItemDTO();
            double itemVATAmount = (currentItem.getPrice().getValue()*item.getQuantity())* (currentItem.getVAT().getValue() / 100);
            totalVAT = totalVAT.add(new Amount(itemVATAmount));
        }
    
    }


    public Amount getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }
    public void setTotalPriceAfterDiscount(Amount discount) {
        totalPriceAfterDiscount = this.totalPrice.subtract(discount);
    }

    public ArrayList<ItemAndQuantity> getScannedItems(){
        return scannedItems;
    }
    public void setScannedItems(itemDTO item, int currentQuantity, int quantity) {
        scannedItems.add(new ItemAndQuantity(item, currentQuantity + quantity));
    }
    // public LinkedHashMap<itemDTO, Integer> getScannedItems() {
    //     return scannedItems;
    // }

    // public void setScannedItems(itemDTO item, int currentQuantity, int quantity) {
    //     scannedItems.put(item, currentQuantity + quantity);
    // }
    

    public Date getTime() {
        return time;
    }

}
