package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.itemDTO;


public class View{
    private final Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }

    public void run() {
        contr.startSale();
        System.out.println();
        itemDTO item = contr.scanItem(1, 2);
        printer(item, 2);

        item = contr.scanItem(2, 1);
        printer(item,1);

        item = contr.scanItem(1, 1);
        printer(item,1);

        contr.startDiscount(1);
        contr.enterPayemnt(100);
    }

    private void printer(itemDTO item, int quantity){
        System.err.println("Add "+quantity+" item with id "+item.getItemID());
        System.out.println("ItemID: "+item.getItemID());
        System.out.println("Item name: "+item.getName());
        System.out.println("Item cost: "+item.getPrice().getValue()+" SEK");
        System.out.println("VAT: "+item.getVAT().getValue()+"%");
        System.out.println("Item description: "+item.getDescription());
        System.out.println("Total cost (incl VAT): ___");
        System.out.println("Total VAT: ___ SEK");
        System.out.println("\n");

    }



}