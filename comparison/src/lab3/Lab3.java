package lab3;
import java.util.Scanner;

public class Lab3 {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num1, num2, num3, num4;
		int odd = 0;
		int even = 0;
		int oneDigit = 0;
		int twoDigit = 0;
		int sumOdd = 0;
		int sumEven = 0;
		int sumOneDigit = 0;
		int sumTwoDigit = 0;
		System.out.print("Enter a number: ");
		num1 = input.nextInt();
		System.out.print("Enter a second number: ");
		num2 = input.nextInt();
		System.out.print("Enter a third number: ");
		num3 = input.nextInt();
		System.out.print("Enter a fourth number: ");
		num4 = input.nextInt();
		
		if (num1 > num2 && num1 > num3 && num1 > num4) {
			System.out.println("the largest number is " + num1);
		} else if (num2 > num1 && num2 > num3 && num3 > num4) {
			System.out.println("the largest number is " + num2);
		} else if (num3 > num1 && num3 > num2 && num3 > num4) {
			System.out.println("the largest number is " + num3);
		} else if (num4 > num1 && num4 > num2 && num4 > num3) {
			System.out.println("the largest number is " + num4);
		}
		
		if (num1 < num2 && num1 < num3 && num1 < num4) {
			System.out.println("the smallest number is " + num1);
		} else if (num2 < num1 && num2 < num3 && num3 < num4) {
			System.out.println("the smallest number is " + num2);
		} else if (num3 < num1 && num3 < num2 && num3 < num4) {
			System.out.println("the smallest number is " + num3);
		} else if (num4 < num1 && num4 < num2 && num4 < num3) {
			System.out.println("the smallest number is " + num4);
		}
		
		if (num1 % 2 == 0) {
			even = even + 1;
		}
		else odd = odd + 1;
	
		if (num2 % 2 ==0) {
			even = even + 1;
		}
		else odd = odd + 1;
		
		if (num3 % 2 == 0) {
			even = even + 1;
		}
		else odd = odd + 1;
	
		if (num4 % 2 ==0) {
			even = even + 1;
		}
		else odd = odd + 1;
		
		if (num1 % 2 == 0) {
			sumEven = sumEven + num1;
		}
		else sumOdd = sumOdd + num1;
	
		if (num2 % 2 ==0) {
			sumEven = sumEven + num2;
		}
		else sumOdd = sumOdd + num2;
		
		if (num3 % 2 == 0) {
			sumEven = sumEven + num3;
		}
		else sumOdd = sumOdd + num3;
	
		if (num4 % 2 ==0) {
			sumEven = sumEven + num4;
		}
		else sumOdd = sumOdd + num4;
		
		System.out.println("there are " + even + " even numbers");
		System.out.println("there are " + odd + " odd numbers");
		System.out.println("the sum of the even numbers is " + sumEven + ".");
		System.out.println("the sum of the odd numbers is " + sumOdd + ".");
		
		if (num1 >= 10) {
			twoDigit = twoDigit + 1;
		}
		else oneDigit = oneDigit + 1;
		
		if (num2 >= 10) {
			twoDigit = twoDigit + 1;
		}
		else oneDigit = oneDigit + 1;
		
		if (num3 >= 10) {
			twoDigit = twoDigit + 1;
		}
		else oneDigit = oneDigit + 1;
		
		if (num4 >= 10) {
			twoDigit = twoDigit + 1;
		}
		else oneDigit = oneDigit + 1;
		
		if (num1 >= 10) {
			sumTwoDigit = sumTwoDigit + num1;
		}
		else sumOneDigit = sumOneDigit + num1;
		
		if (num2 >= 10) {
			sumTwoDigit = sumTwoDigit + num2;
		}
		else sumOneDigit = sumOneDigit + num2;
		
		if (num3 >= 10) {
			sumTwoDigit = sumTwoDigit + num3;
		}
		else sumOneDigit = sumOneDigit + num3;
		
		if (num4 >= 10) {
			sumTwoDigit = sumTwoDigit + num4;
		}
		else sumOneDigit = sumOneDigit + num4;
		
		System.out.println("there are " + oneDigit + " one digit numbers");
		System.out.println("there are " + twoDigit + " two digit numbers");
		System.out.println("the sum of the one digit numbers is " + sumOneDigit + ".");
		System.out.println("the sum of the two digit numbers is " + sumTwoDigit + ".");
	}
}
