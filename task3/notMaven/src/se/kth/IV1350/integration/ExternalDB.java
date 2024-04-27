package se.kth.IV1350.integration;

public class ExternalDB{

    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private DiscountDB discountDBSystem;

    public ExternalDB(){
        this.accountingSystem = new ExternalAccountingSystem();
        this.inventorySystem = new ExternalInventorySystem();
        this.discountDBSystem = new DiscountDB();
    }

    public ExternalAccountingSystem getAccountingSystem(){
        return accountingSystem;
    }
    public ExternalInventorySystem getInventorySystem(){
        return inventorySystem;
    }
    public DiscountDB getDiscountDBSystem(){
        return discountDBSystem;
    }


}