package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    private static final int INITIAL_STOCK = 5;

    private String itemSlot;
    private String itemName;
    private BigDecimal itemPrice;
    private int stock;


    public String getItemSlot() {
        return itemSlot;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }



    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public Item(String itemSlot, String itemName, BigDecimal itemPrice) {
        this.itemSlot = itemSlot;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.stock = INITIAL_STOCK;
    }

    public String getItemText(){
        if (stock == 0){
            return (itemName + " \t\n Price: $" + itemPrice + " \t SOLD OUT!" );
        } else
        return (itemName + " \t\n Price: $" + itemPrice + " \t Quantity " + stock + " remaining. " );
    }

    public abstract String getItemMessage();
}






