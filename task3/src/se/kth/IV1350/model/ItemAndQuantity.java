package se.kth.IV1350.model;

import se.kth.IV1350.integration.itemDTO;


public class ItemAndQuantity {
    
    private itemDTO item;
    private int quantity;

    public ItemAndQuantity(itemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public itemDTO getItemDTO(){
        return item;
    }

    public int getQuantity(){
        return quantity;
    }
}
