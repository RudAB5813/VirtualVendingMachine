package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    private String itemMessage = "Chew, Chew, Yum!";

    public Gum(String itemSlot, String itemName, BigDecimal itemPrice) {
        super(itemSlot, itemName, itemPrice);
    }


    public String getItemMessage(){return itemMessage;}

    }


