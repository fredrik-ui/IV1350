package se.kth.IV1350.controller;

import se.kth.IV1350.integration.DatabaseFailureException;
import se.kth.IV1350.integration.ExternalDB;
import se.kth.IV1350.integration.InvalidItemIdentifierException;
import se.kth.IV1350.integration.ReceiptPrinter;
import se.kth.IV1350.integration.itemDTO;
// import se.kth.IV1350.model.Amount;
// import se.kth.IV1350.model.CashRegister;
// import se.kth.IV1350.model.Payment;
// import se.kth.IV1350.model.Sale;
// import se.kth.IV1350.model.saleDTO;
import se.kth.IV1350.model.*;
import se.kth.IV1350.utils.*;


public class Controller {

    private ExternalDB externalSystems;
    private CashRegister cashRegister;
    private Sale sale;
    private FileLogger logger;
    /**
     * Constructs a new Controller object with its dependencies injected.
     * 
     * @param exDB    the external database containing information about external systems
     * @param printer the receipt printer used for printing receipts
     */
    public Controller(ExternalDB exDB, ReceiptPrinter printer) {
        this.cashRegister = new CashRegister();
        this.externalSystems = exDB;
        logger = new FileLogger();
    }

    /**
    * Starts a new sale by initializing a new Sale object.
    */
    public void startSale() {
        sale = new Sale();
    }
    /**
     * Retrieves the Sale object associated with this instance.
     *
     * @return  the Sale object associated with this instance
     */
    public Sale getSale(){
        return sale;
    }
    /**
     * Retrieves the CashRegister object associated with this instance.
     *
     * @return  the CashRegister object associated with this instance
     */
    public CashRegister getCashRegister(){
        return this.cashRegister;
    }
    /**
     * Retrieves the sale data transfer object (DTO) associated with the current sale.
     *
     * @return          the sale data transfer object (DTO) associated with the current sale
     */
    public saleDTO getSaleDTO(){     
        return sale.getDTO();
    }
    /**
     * Scans an item with the given item ID and quantity, and returns the sale DTO after adding the item to the sale.
     *
     * @param  itemID   the ID of the item to be scanned
     * @param  quantity the quantity of the item to be scanned
     * @return          the sale DTO after adding the item to the sale, or null if an error occurs
     */
    public saleDTO scanItem(int itemID, int quantity) throws InvalidItemIdentifierException, DatabaseFailureException{
        if(quantity <= 0){
            return null; // Error
        }

        try{
            itemDTO collectedItem = sale.checkForDuplicateItem(itemID);
        
            if (collectedItem == null) {
                collectedItem = externalSystems.getInventorySystem().getItemFromDB(itemID);
                sale.additemToSale(collectedItem, quantity, false);
            } else {
                sale.additemToSale(collectedItem, quantity, true);
            }

        }catch(InvalidItemIdentifierException exception){
            logger.log(exception.getMessage() + ". Stack trace: ", exception);
            throw exception;
        }catch(DatabaseFailureException exception){
            logger.log(exception.getMessage() + ". Stack trace: ", exception);
            throw exception;
        }
    
        return getSaleDTO();
    }
    /**
     * Calculates the discount for a customer and returns the new price after applying the discount.
     *
     * @param  customerID  the ID of the customer
     * @return             the new price after applying the discount
     */
    public double startDiscount(int customerID) {
        Amount discount = externalSystems.getDiscountDBSystem().getDiscount(customerID, sale);
        double newPrice = sale.applyTotalDiscount(discount).getValue();
        return newPrice;
    }
    /**
     * Ends the sale by processing the payment and updating the accounting and inventory systems.
     *
     * @param  amount  the amount tendered by the customer
     * @return         the payment object representing the transaction, or null if the amount paid is less than the total price
     */
    public Payment enterPayemnt(double amount) {
        Payment change = sale.endSale(amount);
        if(change == null){
            return null;
        }
        externalSystems.getAccountingSystem().updateAccounting();
        externalSystems.getInventorySystem().updateInventory();
        cashRegister.addPayment(change);
        return change;
    }

}