package se.kth.IV1350.model;

import java.util.ArrayList;

public class Receipt {

    private Payment payment;
    private Amount totalPrice;
    private Amount totalVAT;
    private Amount totalPriceAfterDiscount;
    private ArrayList<ItemAndQuantity> scannedItems = new ArrayList<>();
    private String time; 

    /**
     * Constructs a new Receipt object with the provided payment information and sale details.
     *
     * @param payment              the payment object representing the payment made for the sale
     * @param dTO                  the saleDTO object containing details of the sale
     */
    public Receipt(Payment payment, saleDTO dTO) {
        this.payment = payment;
        this.totalPrice = dTO.getTotalPrice();
        this.totalVAT = dTO.getTotalVAT();
        this.totalPriceAfterDiscount = dTO.getTotalPriceAfterDiscount();
        this.scannedItems = dTO.getScannedItems();
        this.time = dTO.getTime();
    }

    /**
     * Returns a string representation of the receipt, including the time of sale,
     * scanned items, total price, discount, VAT, payment amount, change, and
     * change to give to the customer.
     *
     * @return         	a string representation of the receipt
     */
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
        sb.append("\nTotal Before Discount: ").append(totalPrice.getValue()).append(" SEK");
        sb.append("\nDiscount: ").append(totalPrice.getValue() - totalPriceAfterDiscount.getValue()).append(" SEK");
        sb.append("\nTotal After Discount: ").append(totalPriceAfterDiscount.getValue()).append(" SEK");
        sb.append("\nVAT: ").append(totalVAT.getValue()).append(" SEK");
        sb.append("\n\nPayment: ").append(payment.getTotalAmountPaid().getValue()).append(" SEK");
        sb.append("\nChange: ").append(payment.getTotalChange().getValue()).append(" SEK");
        sb.append("\n\n--------------END RECEIPT---------------\n");
        // sb.append("Change to give to customer: ").append(payment.getTotalChange()).append(" SEK");
        return sb.toString();
    }
}
