package se.kth.IV1350.model;

import se.kth.IV1350.integration.itemDTO;

/**
 * Represents an item along with its quantity in a sale transaction.
 */
public class ItemAndQuantity {
    
    private itemDTO item;
    private int quantity;

    /**
     * Constructs an ItemAndQuantity object with the specified item and quantity.
     * 
     * @param item The item information.
     * @param quantity The quantity of the item.
     */

    public ItemAndQuantity(itemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    /**
     * Returns the itemDTO associated with this ItemAndQuantity.
     *
     * @return         the itemDTO associated with this ItemAndQuantity
     */
    public itemDTO getItemDTO(){
        return item;
    }
    /**
     * Returns the quantity associated with this ItemAndQuantity.
     *
     * @return         the quantity associated with this ItemAndQuantity
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * Sets the quantity of the item.
     *
     * @param  quantity  the new quantity of the item
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
