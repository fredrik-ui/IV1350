package se.kth.IV1350.integration;

import java.util.ArrayList;

import se.kth.IV1350.model.Amount;

public class ExternalInventorySystem {


    private ArrayList<itemDTO> items = new ArrayList<>();
    /** 
     *  Creates items for the inventory to be used in the sale
     */
    public ExternalInventorySystem(){
        items.add(new itemDTO(1, "Korv", new Amount(10), new Amount(5), "60% kötthalt"));
        items.add(new itemDTO(2, "Mjölk", new Amount(20), new Amount(5), "Mejeri produkt"));
        items.add(new itemDTO(3, "Pasta", new Amount(15), new Amount(5), "Gjort på durum vete"));

    }
    /**
     * Retrieves an item from the database based on the given item ID.
     *
     * @param  itemID  the ID of the item to retrieve
     * @return         the item with the given ID, or null if not found
     */
    public itemDTO getItemFromDB(int itemID) {
        itemDTO item = checkInventory(itemID);
        return item;
    }

    /**
     * Checks the inventory for an item with the given ID.
     *
     * @param  itemID  the ID of the item to check
     * @return         the item with the given ID, or null if not found
     */
    public itemDTO checkInventory(int itemID) {


        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getItemID() == itemID)
                return items.get(i);
        }
        return null;
    }
    /**
     *  Supposed to update the external invenotry after a purchase 
     *  but not demanded to do
     */
    public void updateInventory(){
    }

}
