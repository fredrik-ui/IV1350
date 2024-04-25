package se.kth.IV1350.model;

import se.kth.IV1350.integration.itemDTO;


public class ItemAndQuantity {
    
    private itemDTO item;
    private Integer quantity;

    public ItemAndQuantity(itemDTO item, Integer quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public itemDTO getItemDTO(){
        return item;
    }

    public Integer quantity(){
        return quantity;
    }
}
