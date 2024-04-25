package se.kth.IV1350.model;

import java.util.ArrayList;
import java.util.Date;

public class Receipt {

    private Payment payment;
    private Amount totalPrice;
    private Amount totalVAT;
    private Amount totalPriceAfterDiscount;
    //private LinkedHashMap<itemDTO, Integer> scannedItems;   
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private Date time; 


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
        for(ItemAndQuantity item : scannedItems){
            sb.append(item.getItemDTO().getName()).append("\t\t"+item.getQuantity()).append(" x ").append(item.getItemDTO().getPrice().getValue());
            sb.append(" \t"+item.getItemDTO().getPrice().getValue()*item.getQuantity()+" SEK\n");
        }
        sb.append("\nTotal: ").append(totalPriceAfterDiscount.getValue());
        sb.append("\nDiscount: ").append(totalPrice.getValue()-totalPriceAfterDiscount.getValue()+" SEK");
        sb.append("\nVAT: ").append(totalVAT.getValue());
        sb.append("\n\nPayemnt: ").append(payment.getTotalAmountPaid()).append(" SEK");
        sb.append("\nChange: ").append(payment.getTotalChange()).append(" SEK");
        sb.append("\n\n--------------END RECEIPT---------------\n");
        sb.append("Change to give to customer: ").append(payment.getTotalChange()).append(" SEK");
        return sb.toString();
    }
}
