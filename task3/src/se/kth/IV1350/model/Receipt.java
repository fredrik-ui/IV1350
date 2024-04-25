package se.kth.IV1350.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Date;


import se.kth.IV1350.integration.itemDTO;

public class Receipt {

    private Payment payment;
    private Amount totalPrice;
    private Amount totalVAT;
    private Amount totalPriceAfterDiscount;
    private LinkedHashMap<itemDTO, Integer> scannedItems;   
    private Date time; 

    // public Receipt(Payment payment, double totalPrice, double totalVAT, double totalPriceAfterDiscount, LinkedHashMap<itemDTO, Integer> scannedItems, LocalDateTime time) {
    //     this.payment = payment;
    //     this.totalPrice = totalPrice;
    //     this.totalVAT = totalVAT;
    //     this.totalPriceAfterDiscount = totalPriceAfterDiscount;
    //     this.scannedItems = scannedItems;
    //     this.time = time;
    // }


    public Receipt(Payment payment, saleDTO dTO) {
        this.payment = payment;
        this.totalPrice = dTO.getTotalPrice();
        this.totalVAT = dTO.getTotalVAT();
        this.totalPriceAfterDiscount = dTO.getTotalPriceAfterDiscount();
        this.scannedItems = dTO.getScannedItems();
        this.time = dTO.getTime();

    }

    @Override
    public String toString() {
        //System.out.println(totalVAT);
        StringBuilder sb = new StringBuilder();
        sb.append("-------------Receipt--------------\n\n");
        sb.append("Time of sale: ").append(time).append("\n\n");
        //sb.append("Scanned Items:\n");
        for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
            itemDTO item = entry.getKey();
            int quantity = entry.getValue();
            sb.append(item.getName()).append("\t\t"+quantity).append(" x ").append(item.getPrice().getValue());
            sb.append(" \t"+item.getPrice().getValue() * quantity+" SEK\n");
            // sb.append("Add ").append(quantity).append(" item with id ").append(item.getItemID()).append(":\n");
            // sb.append("Itemd ID: ").append(item.getItemID()).append("\n");
            // sb.append("Item name: ").append(item.getName()).append("\n");
            // sb.append("Item cost: ").append(item.getPrice()).append(" SEK\n");
            // sb.append("VAT: ").append(item.getVAT()).append("\n");
            // sb.append("Item description: ").append(item.getDescription()).append("\n");
            // sb.append("Total cost: (including VAT): ").append("INFO ABOUT TOTAL COST ").append("\n");
            // sb.append("---------------------------\n");
            //sb.append(" (Quantity: ").append(quantity).append(")\n");
        }
        //sb.append("Total: ").append(totalPrice.getValue());
        sb.append("\nTotal: ").append(totalPriceAfterDiscount.getValue());
        sb.append("\nDiscount: ").append(totalPrice.getValue()-totalPriceAfterDiscount.getValue()+" SEK");
        sb.append("\nVAT: ").append(totalVAT.getValue());
        sb.append("\n\nPayemnt: ").append(payment.getTotalAmountPaid()).append(" SEK");
        sb.append("\nChange: ").append(payment.getTotalChange()).append(" SEK");
        sb.append("\n\n--------------END RECEIPT---------------\n");
        sb.append("Change to give to customer: ").append(payment.getTotalChange()).append(" SEK");
        // sb.append("\nTotal Price: ").append(totalPrice).append("\n");
        // sb.append("Payment: ").append(payment.getTotalAmountPaid()).append("\n");
        // sb.append("Change: ").append(payment.getTotalChange()).append("\n");
        // sb.append("Total VAT: ").append(totalVAT).append("\n");
        // sb.append("Total Price After Discount: ").append(totalPriceAfterDiscount).append("\n");
        return sb.toString();
    }

    // StringBuilder sb = new StringBuilder();
    // sb.append("-------------Receipt--------------\n\n");
    // sb.append("Time of sale: ").append(time).append("\n");
    // //sb.append("Scanned Items:\n");
    // for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
    //     itemDTO item = entry.getKey();
    //     int quantity = entry.getValue();
    //     sb.append(item.getName()).append("\t\t"+quantity).append(" x ").append(item.getPrice());
    //     sb.append(" \t"+quantity*item.getPrice()+" SEK\n");
    //     // sb.append("Add ").append(quantity).append(" item with id ").append(item.getItemID()).append(":\n");
    //     // sb.append("Itemd ID: ").append(item.getItemID()).append("\n");
    //     // sb.append("Item name: ").append(item.getName()).append("\n");
    //     // sb.append("Item cost: ").append(item.getPrice()).append(" SEK\n");
    //     // sb.append("VAT: ").append(item.getVAT()).append("\n");
    //     // sb.append("Item description: ").append(item.getDescription()).append("\n");
    //     // sb.append("Total cost: (including VAT): ").append("INFO ABOUT TOTAL COST ").append("\n");
    //     // sb.append("---------------------------\n");
    //     //sb.append(" (Quantity: ").append(quantity).append(")\n");
    // }
    // sb.append("Total: ").append(totalPrice);
    // sb.append("\nVAT: ").append(totalPrice*totalVAT);
    // sb.append("\nPayemnt: ").append(payment.getTotalAmountPaid()).append(" SEK");
    // sb.append("\nChange: ").append(payment.getTotalChange()).append(" SEK");
    // sb.append("\n\n--------------END RECEIPT---------------\n");
    // sb.append("Change to give to customer: ").append(payment.getTotalChange()).append(" SEK");
    // // sb.append("\nTotal Price: ").append(totalPrice).append("\n");
    // // sb.append("Payment: ").append(payment.getTotalAmountPaid()).append("\n");
    // // sb.append("Change: ").append(payment.getTotalChange()).append("\n");
    // // sb.append("Total VAT: ").append(totalVAT).append("\n");
    // // sb.append("Total Price After Discount: ").append(totalPriceAfterDiscount).append("\n");
    // return sb.toString();
    
    
}
