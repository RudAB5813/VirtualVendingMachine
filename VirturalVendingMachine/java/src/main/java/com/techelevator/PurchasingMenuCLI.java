package com.techelevator;

import com.techelevator.exception.insufficientFunds;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PurchasingMenuCLI {
    private static final String PURCH_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCH_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCH_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] PURCH_MENU_OPTIONS = {PURCH_MENU_OPTION_FEED_MONEY, PURCH_MENU_OPTION_SELECT_PRODUCT, PURCH_MENU_OPTION_FINISH_TRANSACTION};

    VendingMachine vendingMachine = new VendingMachine();

    private Menu menu;

    public PurchasingMenuCLI(Menu menu) {
        this.menu = menu;
    }


    public void run() {

        String choice = "";
//        VendingMachine vendingMachine = new VendingMachine();
        do {
            System.out.println("Current Money Provided $" + vendingMachine.getBalance());
            choice = (String) menu.getChoiceFromOptions(PURCH_MENU_OPTIONS);

            if (choice.equals(PURCH_MENU_OPTION_FEED_MONEY)) {
//                System.out.println("choice selected: Feed");
                feedMoney();



            } else if (choice.equals(PURCH_MENU_OPTION_SELECT_PRODUCT)) {
//                System.out.println("choice selected: Select Product");
                vendingMachine.displayInventory();
                userChooseProduct();

            } else if (choice.equals(PURCH_MENU_OPTION_FINISH_TRANSACTION)) {
//                System.out.println("choice selected: finish");
//                vendingMachine.changeReturn();
                int[] coins = vendingMachine.calculateChange();
                vendingMachine.printChange(coins);


            }

        } while (choice.equals("Feed Money") || choice.equals("Select Product"));

        // methods to finish transaction go here
        // then back to the main menu
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        PurchasingMenuCLI cli = new PurchasingMenuCLI(menu);
        cli.run();
    }

    public void feedMoney() {
        Scanner inPut = new Scanner(System.in);
        System.out.print("Please enter 1, 2, 5, or 10 dollars to add: ");

        String dollarsString = (inPut.nextLine());

//        int dollarsFed = Integer.parseInt(inPut.nextLine());
//           BigDecimal dollarsFed = new BigDecimal(stringDollarsFed);

        if (dollarsString.equals("1") || dollarsString.equals("2")  || dollarsString.equals("5")  || dollarsString.equals("10") ) {
            int dollarsFed = Integer.parseInt(dollarsString);

//        if (dollarsFed == 1 || dollarsFed == 2 || dollarsFed == 5 || dollarsFed == 10) {
            BigDecimal bigDollarsFed = new BigDecimal(dollarsFed);
            BigDecimal bigDollarsAndCentsFed = bigDollarsFed.setScale(2);
            VendingMachine.feedMachineMoney(bigDollarsAndCentsFed);
            BigDecimal after = new BigDecimal(String.valueOf(vendingMachine.getBalance()));
            String message = "FEED MONEY: $" + bigDollarsAndCentsFed + " $" + after;
            LogWriter logWriter = new LogWriter(message);

//            System.out.println("balance is " + VendingMachine.getBalance());
        } else System.out.println("No such denomination as a $" + dollarsString + " bill. Please try again.");

    }

    public void userChooseProduct() {
        System.out.print("Which product, please: ");
        Scanner readInKey = new Scanner(System.in);
        String inKey = readInKey.nextLine();

        boolean itemExists = vendingMachine.getInventoryMap().containsKey(inKey);
        boolean enoughMoney = false;
        if (itemExists) {
            Item purchase = vendingMachine.getInventoryMap().get(inKey);

            if ( (vendingMachine.getBalance().compareTo(purchase.getItemPrice()) == 1) ||
            (vendingMachine.getBalance().compareTo(purchase.getItemPrice()) == 0)){
                enoughMoney = true;
            } else

//                {
//                throw new insufficientFunds("Not Enough Money')
//            }
            ;

            int stockLevel = purchase.getStock();

            if ((stockLevel > 0) && enoughMoney) {
                purchase.setStock(stockLevel - 1);
                BigDecimal before = new BigDecimal(String.valueOf(vendingMachine.getBalance()));
                vendingMachine.subtractBalance(purchase.getItemPrice());
                BigDecimal after = new BigDecimal(String.valueOf(vendingMachine.getBalance()));
                System.out.println(purchase.getItemMessage());
                System.out.println(String.format
                        ("You bought " + purchase.getItemName() + " for $" + purchase.getItemPrice()));
                String message = purchase.getItemName() + " " + purchase.getItemSlot() + " $"  + before + " $" + after;
                LogWriter logWriter = new LogWriter(message);

            } else {
                if (stockLevel == 0) {
                    System.out.println("SOLD OUT!");
                } else {
                    System.out.println("Too Poor, Feed the Machine");
                }
            }
        } else {
            System.out.println("Item doesn't exist, please try again");
        }
    }
}







