package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item{
    private String itemMessage = "Crunch Crunch, Yum!";

    public Chip(String itemSlot, String itemName, BigDecimal itemPrice) {
        super(itemSlot, itemName, itemPrice);
    }
    public String getItemMessage(){return itemMessage;}
}
