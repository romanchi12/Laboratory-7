package org.romanchi;

import org.romanchi.rozetka.Rozetka;
import org.romanchi.rozetka.context.BuyContext;

public class Main {

    public static void main(String[] args) throws Exception {
        try(Rozetka rozetka = new Rozetka()){
            BuyContext buyContext = (BuyContext) rozetka.getContext("buy");
            buyContext.setToBuy("macbook");
            buyContext.setMinPrice(40000);
            Thread.sleep(4000);
            buyContext.setMaxPrice(50000);
            buyContext.execute();
        }
    }
}