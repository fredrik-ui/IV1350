package se.kth.IV1350.integration;

import se.kth.IV1350.model.Amount;

public class itemDTO {

    // When the itemDTO is created these values cannot be changed
    private final int itemID;
    private final String name;
    private final Amount price;
    private final Amount VAT;
    private final String description;
    /**
     * Constructs a new itemDTO object with the specified attributes.
     *
     * @param itemID      the unique identifier of the item
     * @param name        the name of the item
     * @param price       the price of the item
     * @param VAT         the value-added tax (VAT) of the item
     * @param description the description of the item
     */
    public itemDTO(int itemID, String name, Amount price, Amount VAT, String description) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
    }

    /**
     * Retrieves the item ID.
     *
     * @return the item ID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Retrieves the name of the item.
     *
     * @return the name of the item as a String
     */
    /**
     * Retrieves the price of the item.
     *
     * @return the price of the item as an Amount object
     */
    public String getName() {
        return name;
    }
    /**
     * Retrieves the price of the item.
     *
     * @return the price of the item as an Amount object
     */
    public Amount getPrice() {
        return price;
    }
        /**
         * Retrieves the value-added tax (VAT) for the item.
         *
         * @return the VAT as an Amount object
         */
    public Amount getVAT() {
        return VAT;
    }
    /**
     * Retrieves the description of the item.
     *
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }

}
