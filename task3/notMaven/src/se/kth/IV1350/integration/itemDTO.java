package se.kth.IV1350.integration;

import se.kth.IV1350.model.Amount;

public class itemDTO {
    
    // When the itemDTO is created these values cannot be changed
    private final int itemID;
    private final String name;
    private final Amount price;
    private final Amount VAT;
    private final String description;


    public itemDTO(int itemID,String name, Amount price, Amount VAT, String description){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
    }



    public int getItemID(){
        return itemID;
    }
    public String getName(){
        return name;
    }
    public Amount getPrice(){
        return price;
    }
    public Amount getVAT(){
        return VAT;
    }
    public String getDescription(){
        return description;
    }
    

}
