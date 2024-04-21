package se.kth.IV1350.integration;

import java.util.ArrayList;

public class ExternalInventorySystem {


    private ArrayList<itemDTO> items = new ArrayList<>();

    public ExternalInventorySystem(){
        // Here manually the items are added to the list "items"
        items.add(new itemDTO(1, "korv", 10, 5, "60% kötthalt"));
        items.add(new itemDTO(2, "Mjölk", 20, 5, "Mejeir produkt"));
        items.add(new itemDTO(3, "Pasta", 15, 5, "Gjort på durum vete"));

    }

    public itemDTO getItemFromDB(int itemID) {
        // Check if the item is apart of the inventory
        
        itemDTO item = checkInventory(itemID);
        return item;
    }


    public itemDTO checkInventory(int itemID) {


        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getItemID() == itemID)
                return items.get(i);
        }


        // Iterate over the entries of scannedItems map
        // for (Map.Entry<itemDTO, Integer> entry : scannedItems.entrySet()) {
        //     itemDTO currentItem = entry.getKey();
        //     // Check if the current item's ID matches the given itemID
        //     if (currentItem.getItemID() == itemID) {
        //         return currentItem; // Item with the given ID found, reutrn that item
        //     }
        // }
        return null; // Item with the given ID not found
    }
    
}
