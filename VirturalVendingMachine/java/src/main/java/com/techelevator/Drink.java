package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{

    private String itemMessage = "Glug, Glug, Yum!";

    public Drink(String itemSlot, String itemName, BigDecimal itemPrice) {
        super(itemSlot, itemName, itemPrice);
    }
    public String getItemMessage(){return itemMessage;}
}
