package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.model.saleDTO;


public class View{
    private final Controller contr;
    /**
     * Initializes a new instance of the View class.
     *
     * @param contr The controller object to be associated with the view.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Runs the function.
     *
     * @param  None    No parameters are required.
     * @return         No return value.
     */
    public void run() {
        contr.startSale();
        System.out.println();
        saleDTO item = contr.scanItemAndGetSaleDTO(1, 2);
        printer(item, 1);

        item = contr.scanItemAndGetSaleDTO(2, 1);
        printer(item,2);

        item = contr.scanItemAndGetSaleDTO(1, 1);
        printer(item,1);

        item = contr.scanItemAndGetSaleDTO(2, 4);
        printer(item,2);

        contr.startDiscount(1);
        contr.enterPayemnt(100);
    }
    /**
     * Prints the details of a sale item to the console.
     *
     * @param  item  the sale item to print details for
     * @param  index the index of the item in the sale
     */
    private void printer(saleDTO item, int index){
        System.out.println("ItemID: "+item.getScannedItems().get(index-1).getItemDTO().getItemID());
        System.out.println("Item name: "+item.getScannedItems().get(index-1).getItemDTO().getName());
        System.out.println(item.getScannedItems().get(index-1).getQuantity()+" of "+item.getScannedItems().get(index-1).getItemDTO().getName());
        System.out.println("Item cost: "+item.getScannedItems().get(index-1).getItemDTO().getPrice().getValue()+" SEK");
        System.out.println("VAT: "+item.getScannedItems().get(index-1).getItemDTO().getVAT().getValue()+"%");
        System.out.println("Item description: "+item.getScannedItems().get(index-1).getItemDTO().getDescription());
        System.out.println("Total cost (incl VAT): "+item.getTotalPrice().getValue());
        System.out.println("Total VAT: "+item.getTotalVAT().getValue()+" SEK");
        System.out.println("\n");

    }



}