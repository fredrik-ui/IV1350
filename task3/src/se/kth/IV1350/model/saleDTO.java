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

    public saleDTO(Date time, Amount totalPrice, Amount totalVAT, Amount totalPriceAfterDiscount, ArrayList<ItemAndQuantity> scannedItems) {
        this.time = time;  
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.totalPriceAfterDiscount = totalPriceAfterDiscount;
        this.scannedItems = scannedItems;
    }
    // public saleDTO(Sale sale){
    //     this.time = sale.getTime();
    //     this.totalPrice = sale.getTotalPrice();
    //     this.totalVAT = sale.getTotalVAT();
    //     this.totalPriceAfterDiscount = sale.getTotalPriceAfterDiscount();
    //     this.scannedItems = sale.getScannedItems();
    // }


    // public saleDTO(Sale sale){
    //     this.totalPrice = new Amount(0);
    //     this.totalVAT = new Amount(0);
    //     this.time = new Date();
    // }

    public Amount getTotalPrice() {
        return totalPrice;
    }
    // public void setTotalPrice(itemDTO item, int quantity) {
    //     System.out.println("Price of item: "+item.getPrice().getValue());
    //     totalPrice = totalPrice.add(new Amount(item.getPrice().getValue() * quantity));
    // }


    public Amount getTotalVAT() {
        return totalVAT;
    }
    // public void setTotalVAT() {
    //     calculateTotalVAT();
    // }

    // private void calculateTotalVAT() {
    //     for(ItemAndQuantity item: scannedItems){
    //         itemDTO currentItem = item.getItemDTO();
    //         double itemVATAmount = (currentItem.getPrice().getValue()*item.getQuantity())* (currentItem.getVAT().getValue() / 100);
    //         totalVAT = totalVAT.add(new Amount(itemVATAmount));
    //     }
    
    // }


    public Amount getTotalPriceAfterDiscount() {
        return totalPriceAfterDiscount;
    }
    // public void setTotalPriceAfterDiscount(Amount discount) {
    //     totalPriceAfterDiscount = this.totalPrice.subtract(discount);
    // }

    public ArrayList<ItemAndQuantity> getScannedItems(){
        return scannedItems;
    }
    // public void setScannedItems(itemDTO item, int quantity) {
    //     scannedItems.add(new ItemAndQuantity(item, quantity));
    // }    

    public Date getTime() {
        return time;
    }

}
