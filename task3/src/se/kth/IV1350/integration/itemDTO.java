package se.kth.IV1350.integration;

public class itemDTO {
    
    // When the itemDTO is created these values cannot be changed
    private final int itemID;
    private final String name;
    private final int price;
    private final int VAT;
    private final String description;


    public itemDTO(int itemID,String name, int price, int VAT, String description){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
    }



    public int getItemID(){
        return itemID;
    }
    public String name(){
        return name;
    }
    public int price(){
        return price;
    }
    public int VAT(){
        return VAT;
    }
    public String description(){
        return description;
    }
    

}
