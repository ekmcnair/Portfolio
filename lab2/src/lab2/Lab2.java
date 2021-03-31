package lab2;
import java.util.Scanner;

public class Lab2 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String name, hobby, movie, color, place;
		int age;
		System.out.print("Enter your name: ");
		name = input.next();
		System.out.print("Enter your age: ");
		age = input.nextInt();
		System.out.print("Enter your favorite hobby: ");
		hobby = input.next();
		System.out.print("Enter your favorite movie: ");
		movie = input.next();
		System.out.print("Enter your favorite color: ");
		color = input.next();
		System.out.print("Enter your favorite place: ");
		place = input.next();
		System.out.print("My name is " + name +".");
		System.out.print(" I am " + age + " years old.");
		System.out.print(" My favorite hobby is " + hobby);
		System.out.print(" and my favorite movie is " + movie + ".");
		System.out.print(" I love the color " + color);
		System.out.print(" and I love visiting " + place + ".");
			}

}
