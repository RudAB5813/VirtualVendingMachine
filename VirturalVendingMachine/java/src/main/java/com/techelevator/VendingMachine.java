package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
//    private static BigDecimal balance = new BigDecimal("0.00");
    private static BigDecimal balance = new BigDecimal("0");
    private static final String path = "vendingmachine.csv";
    public Map<String, Item> inventoryMap = new TreeMap<>();


    public Map<String, Item> getInventoryMap() {
        return inventoryMap;
    }

    public static void setBalance(BigDecimal balance) {
        VendingMachine.balance = balance;
    }

    public static BigDecimal getBalance() {
        return balance;
    }

//    public String getBalanceString(){return Integer.toString(balance);}

    public static void feedMachineMoney(BigDecimal money) {
        balance = balance.add(money);
    }

    public VendingMachine() {
        this.balance = new BigDecimal (0);

        List <String> dataList = new ArrayList<>();
        dataList = readInputFile();
        for (String entry : dataList) {
            String[] parsed = entry.split("\\|");
            if (parsed[3].equalsIgnoreCase("drink")) {
                Drink drink = new Drink(parsed[0], parsed[1], new BigDecimal(parsed[2]));
                inventoryMap.put(parsed[0], drink);
            } else if (parsed[3].equalsIgnoreCase("gum")) {
                Gum gum = new Gum(parsed[0], parsed[1], new BigDecimal(parsed[2]));
                inventoryMap.put(parsed[0], gum);
            } else if (parsed[3].equalsIgnoreCase("chip")) {
                Chip chip = new Chip(parsed[0], parsed[1], new BigDecimal(parsed[2]));
                inventoryMap.put(parsed[0], chip);
            } else if (parsed[3].equalsIgnoreCase("candy")) {
                Candy candy = new Candy(parsed[0], parsed[1], new BigDecimal(parsed[2]));
                inventoryMap.put(parsed[0], candy);
            }
        }
        }


    public void displayInventory() {
        Set<Map.Entry<String, Item>> entries = inventoryMap.entrySet();
        for (Map.Entry<String, Item> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue().getItemText());
        }

    }
    public void subtractBalance(BigDecimal price)
    {
        balance = balance.subtract(price);
    }

    public int[]  calculateChange(){
        BigDecimal changeLog = balance;
        BigDecimal temp = balance.movePointRight(2);
        int changeBalance = temp.intValue();

        int amount, quarters, dimes, nickels, pennies;
        int[] result = new int[4];
        amount = changeBalance;
        quarters = amount / 25;
        amount = amount % 25;
        dimes = amount / 10;
        amount = amount % 10;
        nickels = amount / 5;
        amount = amount % 5;
        pennies = amount;

        result[0] = quarters;
        result[1] = dimes;
        result[2] = nickels;
        result[3] = pennies;

        setBalance(BigDecimal.valueOf(0.00));
        BigDecimal balanceAfter = balance.setScale(2);
        String message = "GIVE CHANGE: $" + changeLog + " $" + balanceAfter;
        LogWriter logWriter = new LogWriter(message);

        return(result);
    }
    public void printChange(int[] coins){
        System.out.println("Your change is: ");
        System.out.println(coins[0] + " quarters");
        System.out.println(coins[1]  + " dimes");
        System.out.println(coins[2]  + " nickels and");
        System.out.println(coins[3]  + " pennies");

    }

    public List<String> readInputFile() {

        File inputFile = new File(path);
        List <String> dataList = new ArrayList<>();
        try (Scanner input = new Scanner(inputFile)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                dataList.add(line);
                    }
        } catch (
                FileNotFoundException ex) {
            System.out.println("Sorry, a " + ex.getMessage() + " was encountered");
        }
    return (dataList);
    }


}









