package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{

    private String itemMessage = "Munch, Munch, Yum!";

    public Candy(String itemSlot, String itemName, BigDecimal itemPrice) {
        super(itemSlot, itemName, itemPrice);
    }

    public String getItemMessage(){return itemMessage;}

}
