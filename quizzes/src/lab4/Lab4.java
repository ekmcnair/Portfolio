package lab4;

import java.util.Scanner;
import java.util.Random;

public class Lab4 {
	
	public static void main(String[] args) {
		
		// declare and create variables
		int op1 = 0, op2 = 0, op3 = 0, correctAnswer = 0, studentAnswer;
		int goodFeedback = 0;
		int badFeedback = 0;
		int numCorrect = 0;
		Random random = new Random();
		String again;
		boolean playAgain = true;
		
		// loop until student wants to end game
		do
		{
			// get level
			Scanner in = new Scanner(System.in);
			int level = 0;
			do {
	            System.out.print("Please enter 1, 2, or 3 to choose a level!");
	            while (!in.hasNextInt()) {
	                String input = in.next();
	                System.out.printf("\"%s\" is not a valid number.\n", input);
	            }
	            level = in.nextInt();
	        } while (level < 1 || level > 3);
			
			
			// get problem type
			//int probType = in.nextInt();
			int probType = 0;
			do {
	            System.out.print("Please enter 1, 2, 3, or 4 to choose a problem type!");
	            while (!in.hasNextInt()) {
	                String input = in.next();
	                System.out.printf("\"%s\" is not a valid number.\n", input);
	            }
	            probType = in.nextInt();
	        } while (probType < 1 || probType > 4);
			
			// loop 10 times
			for (int q = 1; q <= 10; q++)
			{
				//generate problem
				switch (level)
				{
				case 1:
					//code
					op1 = random.nextInt(10);
					op2 = random.nextInt(10);
					op3 = random.nextInt(10);
					break;
				case 2:
					//code
					op1 = random.nextInt(100);
					op2 = random.nextInt(100);
					op3 = random.nextInt(100);
					break;
				case 3:
					//code
					op1 = random.nextInt(1000);
					op2 = random.nextInt(1000);
					op3 = random.nextInt(1000);
					break;
				}
			
			//display problem and calculate the correct answer
			switch (probType)
			{
			case 1:
				//code
				System.out.println("What is " + op1 + " + " + op2 + " + " + op3);
				correctAnswer = op1 + op2 + op3;
				break;
			case 2:
				//code
				System.out.println("What is the average of these numbers: " + op1 + ", " + op2 + ", and " + op3);
				correctAnswer = (op1 + op2 + op3) / 3;
				break;
			case 3:
				//code
				System.out.println("Which of these numbers is largest: " + op1 + ", " + op2 + ", or " + op3);
				if (op1 >= op2 && op1 >= op3) {
					correctAnswer = op1;
				} else if (op2 >= op1 && op2 >= op3) {
					correctAnswer = op2;
				} else if (op3 >= op1 && op3 >= op2) {
					correctAnswer = op3;
				}
				break;
			case 4:
				//code
				System.out.println("Which of these numbers is smallest: " + op1 + ", " + op2 + ", or " + op3);
				if (op1 <= op2 && op1 <= op3) {
					correctAnswer = op1;
				} else if (op2 <= op1 && op2 <= op3) {
					correctAnswer = op2;
				} else if (op3 <= op1 && op3 <= op2) {
					correctAnswer = op3;
				}
				break;
			}
			
			//get student answer
			studentAnswer = in.nextInt();
			
			//check answer, give feedback, update numCorrect
			if (studentAnswer == correctAnswer) {
				goodFeedback = random.nextInt(3);
				switch (goodFeedback)
				{
				case 0:
					numCorrect = numCorrect + 1;
					System.out.println("Fantastic! Keep it up!");
					break;
				case 1:
					numCorrect = numCorrect + 1;
					System.out.println("Thats correct, good job!");
					break;
				case 2:
					numCorrect = numCorrect + 1;
					System.out.println("Way to go!");
				}
			}
			else if (studentAnswer != correctAnswer) {
				badFeedback = random.nextInt(3);
				switch (badFeedback)
				{
				case 0:
					numCorrect = numCorrect + 0;
					System.out.println("Almost!");
					break;
				case 1:
					numCorrect = numCorrect + 0;
					System.out.println("Try again!");
					break;
				case 2:
					numCorrect = numCorrect + 0;
					System.out.println("Better luck next time");
					break;
				}
			}
			}
		
		//display number correct
		System.out.println("You got " + numCorrect + " answers correct!");
		
		//ask if the user wants to play again
			
		System.out.println("Do you want to play again? Y or N?");
		/* again = in.next();
		if (again == "Y") {
			playAgain = true;
		} else {
			playAgain = false;
		} */
		//the loop stops regardless of what I answer with this block
		
		
		} while (playAgain);
		
	}
}