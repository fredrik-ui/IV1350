package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.itemDTO;
import se.kth.IV1350.model.saleDTO;


public class View{
    private final Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }

    public void run() {
        contr.startSale();
        System.out.println();
        saleDTO item = contr.scanItemAndGetSaleDTO(1, 2);
        printer(item, 2, 1);

        // item = contr.scanItemAndGetSaleDTO(2, 1);
        // printer(item,1);

        // item = contr.scanItemAndGetSaleDTO(1, 1);
        // printer(item,1);

        contr.startDiscount(1);
        contr.enterPayemnt(100);
    }

    private void printer(saleDTO item, int quantity, int id){
        System.err.println("Add "+quantity+" item with id "+id);
        System.out.println("ItemID: "+id);
        System.out.println("Item name: "+item.getScannedItems());
        // System.out.println("Item cost: "+item.getPrice().getValue()+" SEK");
        // System.out.println("VAT: "+item.getVAT().getValue()+"%");
        // System.out.println("Item description: "+item.getDescription());
        // System.out.println("Total cost (incl VAT): ___");
        System.out.println("Total VAT: ___ SEK");
        System.out.println("\n");

    }



}