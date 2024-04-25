package se.kth.IV1350.integration;

import java.util.ArrayList;

import se.kth.IV1350.model.Amount;

public class ExternalInventorySystem {


    private ArrayList<itemDTO> items = new ArrayList<>();

    public ExternalInventorySystem(){
        items.add(new itemDTO(1, "Korv", new Amount(10), new Amount(5), "60% kötthalt"));
        items.add(new itemDTO(2, "Mjölk", new Amount(20), new Amount(5), "Mejeir produkt"));
        items.add(new itemDTO(3, "Pasta", new Amount(15), new Amount(5), "Gjort på durum vete"));

    }

    public itemDTO getItemFromDB(int itemID) {
        itemDTO item = checkInventory(itemID);
        return item;
    }


    public itemDTO checkInventory(int itemID) {


        for(int i = 0; i<items.size(); i++){
            if(items.get(i).getItemID() == itemID)
                return items.get(i);
        }
        return null;
    }
    
    public void updateInventory(){
        // Ska detta göras?
    }

}
