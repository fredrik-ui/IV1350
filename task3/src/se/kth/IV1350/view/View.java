package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.model.saleDTO;


public class View{
    private final Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }

    public void run() {
        contr.startSale();
        System.out.println();
        int i = 0;
        saleDTO item = contr.scanItemAndGetSaleDTO(1, 2);
        printer(item,++i);

        item = contr.scanItemAndGetSaleDTO(2, 1);
        printer(item,++i);

        item = contr.scanItemAndGetSaleDTO(1, 1);
        printer(item,++i);

        contr.startDiscount(1);
        contr.enterPayemnt(100);
    }

    private void printer(saleDTO item, int index){
        System.out.println("ItemID: "+item.getScannedItems().get(index-1).getItemDTO().getItemID());
        System.out.println("Add "+item.getScannedItems().get(index-1).getQuantity()+" item");
        System.out.println("Item name: "+item.getScannedItems().get(index-1).getItemDTO().getName());
        System.out.println("Item cost: "+item.getScannedItems().get(index-1).getItemDTO().getPrice().getValue()+" SEK");
        System.out.println("VAT: "+item.getScannedItems().get(index-1).getItemDTO().getVAT().getValue()+"%");
        System.out.println("Item description: "+item.getScannedItems().get(index-1).getItemDTO().getDescription());
        System.out.println("Total cost (incl VAT): "+item.getTotalPrice().getValue());
        System.out.println("Total VAT: "+item.getTotalVAT().getValue()+" SEK");
        System.out.println("\n");

    }



}