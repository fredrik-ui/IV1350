package se.kth.IV1350.integration;

public class ExternalDB {

    private ExternalAccountingSystem accountingSystem;
    private ExternalInventorySystem inventorySystem;
    private DiscountDB discountDBSystem;

    /**
     * Constructs objects of all the differnet external systems used
     */
    public ExternalDB() {
        this.accountingSystem = new ExternalAccountingSystem();
        this.inventorySystem = new ExternalInventorySystem();
        this.discountDBSystem = new DiscountDB();
    }

    /**
     * Retrieves the external accounting system.
     *
     * @return the external accounting system
     */
    public ExternalAccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Retrieves the external inventory system.
     *
     * @return the external inventory system
     */
    public ExternalInventorySystem getInventorySystem() {
        return inventorySystem;
    }

    /**
     * Retrieves the DiscountDB system.
     *
     * @return the DiscountDB system
     */
    public DiscountDB getDiscountDBSystem() {
        return discountDBSystem;
    }
}