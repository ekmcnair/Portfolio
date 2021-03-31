package finalproject;

import java.util.Scanner;

public class Finalproject {
	
	private Scanner input = new Scanner(System.in);
	private Item[] Items = new Item[100];
	private int selectedItem = -1, selection;
	private String exit, username, password;
	private boolean exitNow = false, found = false;

	public static void main(String[] args)
	{
		Finalproject foo = new Finalproject(); 
		foo.MainMenu(); 
	}

	public void MainMenu()
	{
		do {
			System.out.println("Enter the number for the menu option you would like to use:");
			System.out.println("1. Enter as Admin");
			System.out.println("2. Enter as User");
			System.out.println("3. Exit");
				
			selection = input.nextInt();
			while (selection < 1 || selection > 3)
			{
				System.out.println("Please enter a valid choice:");
				selection = input.nextInt();
			}
			
			switch (selection)
			{
				case 1:
				System.out.println("You have chosen to enter as an admin.");
				input.nextLine();
				do {
					System.out.println("Please enter username:");
					username = input.nextLine();
					System.out.println("Please enter password:");
					password = input.nextLine();
					if (username.equalsIgnoreCase("admin") & password.equalsIgnoreCase("admin")) {
						AdminMenu();
					}
					else {
						System.out.println("You have entered an incorrect username or password."
								+ " Please press enter to try again or type the word return to return to the previous menu.");
						String back = input.nextLine();
						if (back.equalsIgnoreCase("return")) {
							break;
						}
					}
				}while(!(username.equalsIgnoreCase("admin") & password.equalsIgnoreCase("admin")));
				break;
	
				case 2:
				UserMenu();
				break;
	
				case 3:
				System.out.println("Are you sure you want to exit? (Yes/No)");
				input.nextLine();
				exit = input.nextLine();
				if (exit.equalsIgnoreCase("Yes")) {
					System.out.println("Thanks for using the program!");
					exitNow = true;
				}
				break;
			}
		}while(!exitNow);
	}

	public void AdminMenu()
	{
		System.out.println("You have now entered the admin menu.");
		System.out.println("Enter the menu number for your desired task:");
		System.out.println("1. Add an Item");
		System.out.println("2. Update an Item");
		System.out.println("3. Delete an Item");
		System.out.println("4. Return to main menu");
		
		selection = input.nextInt();
		while (selection < 1 || selection > 4)
		{
			System.out.println("Please enter a valid choice:");
			selection = input.nextInt();
		}

		switch (selection)
		{
			case 1:
			AddItem();
			break;

			case 2:
			UpdateItem();
			break;

			case 3:
			DeleteItem();
			break;

			case 4:
			return;
		}
	}
	
	public void AddItem() {
		System.out.println("You have chosen to add an Item.");
		System.out.println("Please enter the name of the item");
		input.nextLine();
		String name = input.nextLine();
		System.out.println("Please enter the item manucaturer:");
		String manufacturer = input.nextLine();
		System.out.println("Please enter the item serial number:");
		String serial = input.nextLine();
		System.out.println("Please enter the Item quantity:");
		String quantity = input.nextLine();
		
		for (int i = 0; i < Items.length ; i++) {
			if (Items[i] == null)
			{
				Items[i] = new Item(name, manufacturer, serial, quantity);
				
				found = true;

				System.out.println("The Item has been entered");
				break;
			}
		}
		if (found == false) {
			System.out.println("There are no available spots to store this new Item");
		}
	}
	
	public void UpdateItem() { 
		System.out.println("You have chosen to update a Item");
		SearchForItem(); 
		
		if (found == true) {
			System.out.println("You have chosen to update the Item \"" + Items[selectedItem].getname() + "\"");
			System.out.println("What would you like to update?");
			System.out.println("1. name");
			System.out.println("2. Manufacturer");
			System.out.println("3. Serial");
			System.out.println("4. Item quantity");
			
			selection = input.nextInt();
			while (selection < 1 || selection > 4)
			{
				System.out.println("Please enter a valid choice:");
				selection = input.nextInt();
			}
			
			switch (selection)
			{
				case 1:
					System.out.println("Please enter the name:");
					input.nextLine();
					String name = input.nextLine();
					Items[selectedItem].setname(name);
					break;
				
				case 2:
					System.out.println("Please enter the Manufacturer:");
					input.nextLine();
					String Manufacturer = input.nextLine();
					Items[selectedItem].setManufacturer(Manufacturer);
					break;
				
				case 3:
					System.out.println("Please enter the Serial:");
					input.nextLine();
					String Serial = input.nextLine();
					Items[selectedItem].setSerial(Serial);
					break;
					
				case 4:
					System.out.println("Please enter the Item quantity:");
					input.nextLine();
					String quantity = input.nextLine();
					Items[selectedItem].setquantity(quantity);
					break;
			}	
			System.out.println("The Item has been updated");
			DisplayItem(selectedItem);
		}	
	}
	
	private void DisplayItem(int selectedItem) {
		System.out.print(selectedItem);
		
	}

	public void DeleteItem() { 
		System.out.println("You have chosen to delete a Item");
		SearchForItem();
		
		if (found == true) {
			System.out.println("You have chosen to delete the Item \"" + Items[selectedItem].getname() + "\"");
			
			Items[selectedItem] = null;
			
			System.out.println("The Item has now been deleted");
		}		
	}
			
	public void UserMenu()
	{
		System.out.println("You have now entered the user menu");
		System.out.println("Enter the menu number for your desired task:");
		System.out.println("1. Search for an Item");
		System.out.println("2. Place an order for an item");
		System.out.println("3. Return to main menu");
		selection = input.nextInt();

		switch (selection)
		{
			case 1:
			System.out.println("You have chosen to search for an Item.");
			SearchForItem();
			if (found == true) {
				DisplayItem(selectedItem);
			}
			break;

			case 2:
			PurchaseItem();
			break;

			case 3:
			return;
		}
	}

	public void SearchForItem()
	{
		System.out.println("Please enter the name of the Item:");
		input.nextLine();
		String searchText = input.nextLine();

		int[] matches = new int[100]; 
		for (int x = 0; x < matches.length; x++) {
			matches[x] = -1;
		}
		int lastMatchIndex = -1; 
		int result;
		found = false;
		for (int i = 0; i < Items.length; i++)
		{
			if (Items[i] != null) {
				
				result = (Items[i].getname().toLowerCase()).indexOf(searchText.toLowerCase());
				
				if (result >= 0)
				{	
					if (lastMatchIndex == -1)
					{
						lastMatchIndex = 0;
					}
					else
					{
						lastMatchIndex++;
					}
					matches[lastMatchIndex] = i;
				}
			} 
			else {
				continue;
			}
		}
	
		if (lastMatchIndex != -1)
		{
			found = true;
			if (lastMatchIndex >= 0)
			{
				System.out.println("Please select the Item with the correct name:");
				for (int i = 0; i <= lastMatchIndex; i++) {
					System.out.println("Item #" + matches[i] + " " + Items[matches[i]].getname());
				}
				selectedItem = input.nextInt();
			}
			else {
				selectedItem = 0;
			}		
		}
		else {
			System.out.println("There are no Items to display.");
		}
	}
	
	public void PurchaseItem() {
		System.out.println("You have chosen to purchase an Item.");
		SearchForItem();
		if (found == true) {
			System.out.println("You have chosen to purchase the Item \"" + Items[selectedItem].getname() + "\"");
			System.out.println("Please enter the quantity you want to buy:");
			int quantity = input.nextInt();
			Items[selectedItem].calculatePrice(quantity);
			System.out.println("We are now reviewing your order");
		}
	}
	
}

class Item
{
	private String name;
	private String Manufacturer;
	private String Serial;
	private String quantity;
	private double price;
	
	public Item(String t, String a, String i, String g) {
		setname(t);
		setManufacturer(a);
		setSerial(i);
		setquantity(g);
	}
	
	public void setname(String t) {
		name = t;
	}
	
	public String getname() {
		return name;
	}
	
	public void setManufacturer(String a) {
		Manufacturer = a;
	}
	
	public String getManufacturer() {
		return Manufacturer;
	}

	public void setSerial(String i) {
		Serial = i;
	}
	
	public String getSerial() {
		return Serial;
	}
	
	public void setquantity(String d) {
		quantity = d;
	}
	
	public String getquantity() {
		return quantity;
	}
	
	double total = 0;
	int numRating = 0;
	public void calculatePrice (int price) {
		if (price > 0) {
			total = (total + price)/numRating;
		}
	}
	public double gettotal() {
		return total;
	}

}
