package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

//	public void run() {
//		while (true) {
//			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//
//			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				System.out.println("choice selected: display");
//			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				System.out.println("choice selected: purchase");
//			}
//			else if (choice.equals("4")) {
//				System.out.println("choice selected: secret report");
//			}
//		}
//	}

	public void run() {
		String choice = "";
		do {
			choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				System.out.println("choice selected: display");
				VendingMachine vendingMachine = new VendingMachine();
				vendingMachine.displayInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				System.out.println("choice selected: purchase");
				PurchasingMenuCLI purchasingMenuCLI = new PurchasingMenuCLI(menu);
				purchasingMenuCLI.run();


			}
			else if (choice.equals("4")) {
				System.out.println("choice selected: secret report");
			}
		} while (choice.equals("Purchase") || choice.equals("Display Vending Machine Items"));
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
