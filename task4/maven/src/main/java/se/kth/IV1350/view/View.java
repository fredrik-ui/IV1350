package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.model.Payment;
import se.kth.IV1350.model.saleDTO;
import se.kth.IV1350.integration.InvalidItemIdentifierException;
import se.kth.IV1350.integration.ExternalSystemFailureException;


public class View{
    private final Controller contr;
    /**
     * Initializes a new instance of the View class.
     *
     * @param contr The controller object to be associated with the view.
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addObserver(new TotalRevenueView());
    }
    /**
     * Runs the function.
     *
     * @param  None    No parameters are required.
     * @return         No return value.
     */
    public void run() {
        contr.startSale();
        System.out.println();
        saleDTO item = null;

        try{
            item = contr.scanItem(1, 2);
            printer(item, 1);
        }catch(InvalidItemIdentifierException exception){
            System.out.println("Error: Invalid item identifier!\n");
        }catch(ExternalSystemFailureException exception){
            System.out.println("Error: Database is offline\n");
        }

        try{
            item = contr.scanItem(100, 1);
            printer(item, 2);
        }catch(InvalidItemIdentifierException exception){
            System.out.println("Error: Invalid item identifier!\n");
        }catch(ExternalSystemFailureException exception){
            System.out.println("Error: Database is offline\\n");
        }

        try{
            item = contr.scanItem(51, 1);
            printer(item, 1);
        }catch(InvalidItemIdentifierException exception){
            System.out.println("Error: Invalid item identifier!\n");
        }catch(ExternalSystemFailureException exception){
            System.out.println("Error: Database is offline\n");
        }

        double newPrice = contr.startDiscount(1);
        System.out.println("Discount started, price before: "+item.getTotalPrice().getValue()+"SEK");
        System.out.println("Price after discount: "+newPrice+"SEK");
        Payment change = contr.enterPayemnt(200);
        System.out.println("User has paid: "+change.getTotalAmountPaid().getValue()+"SEK, and the change is: "+change.getTotalChange().getValue()+"SEK");
    }
    /**
     * Prints the details of a sale item to the console.
     *
     * @param  item  the sale item to print details for
     * @param  index the index of the item in the sale
     */
    private void printer(saleDTO item, int index){
        System.out.println("ItemID: "+item.getScannedItems().get(index-1).getItemDTO().getItemID());
        System.out.println("Item name: "+item.getScannedItems().get(index-1).getItemDTO().getName());
        System.out.println(item.getScannedItems().get(index-1).getQuantity()+" of "+item.getScannedItems().get(index-1).getItemDTO().getName());
        System.out.println("Item cost: "+item.getScannedItems().get(index-1).getItemDTO().getPrice().getValue()+" SEK");
        System.out.println("VAT: "+item.getScannedItems().get(index-1).getItemDTO().getVAT().getValue()+"%");
        System.out.println("Item description: "+item.getScannedItems().get(index-1).getItemDTO().getDescription());
        System.out.println("Total cost (incl VAT): "+item.getTotalPrice().getValue());
        System.out.println("Total VAT: "+item.getTotalVAT().getValue()+" SEK");
        System.out.println("\n");

    }



}