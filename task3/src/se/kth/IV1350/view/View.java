package se.kth.IV1350.view;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.itemDTO;


public class View{
    private final Controller contr;

    public View(Controller contr){
        this.contr = contr;
    }

    public void run() {
        contr.startSale();

        itemDTO item = contr.scanItem(1, 1);
        System.out.println(item.name());
    }



}