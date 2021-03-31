package lab2;
import java.util.Scanner;

public class Part2 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int Shares;
		double PP, PC, SP, SC, SharePrice, CommissionTotal, NetPrice;
		System.out.print("Enter the number of shares you bought and sold: ");
		Shares = input.nextInt();
		System.out.print("Enter the purchase price per share: ");
		PP = input.nextDouble();
		System.out.print("Enter the purchase commission: ");
		PC = input.nextDouble();
		System.out.print("Enter the sale price per share: ");
		SP = input.nextDouble();
		System.out.print("Enter the sales commission: ");
		SC = input.nextDouble();
		
		SharePrice = (Shares * PP) - (Shares * SP);
		CommissionTotal = (Shares * PP * PC) + (Shares * SP * SC);
		NetPrice = CommissionTotal + SharePrice;
		System.out.print(NetPrice);
		
	}

}
