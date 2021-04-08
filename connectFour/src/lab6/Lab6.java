package lab6;
import java.util.Scanner;


public class Lab6 {
	
	//visually formatting the board to have column barriers and bottom border
	public static String[][] createBoard() {
		 
	    String[][] x = new String[7][15];
	 
	    for (int y = 0; y < x.length; y++) {
	 
	    	
	    	//even numbers will store the column barriers
	    	//odd numbers will hold the player's pieces
	       for (int j = 0; j < x[y].length; j++) {
	        if (j % 2 == 0){
	           x[y][j] ="|";
	        } else {
	           x[y][j] = " ";
	        }
	 
	        //bottom row of the array serves as a border
	        if (y == 6) x[y][j]= "-";
	      }
	 
	    }
	    return x;
	  }
	 
	//prints the array 
	  public static void printBoard(String[][] x) {
	    for (int y = 0; y < x.length; y++) {
	      for (int j = 0; j < x[y].length; j++) {
	        System.out.print(x[y][j]);
	      }
	      System.out.println();
	    }
	  }
	 
	  //prompts player 1 to make their move
	  //checks to make sure the number entered is within the board
	  
	  /* do {
      System.out.print("Player two it is your move to drop an O (0-6):");
      while (!in.hasNextInt()) {
          String input = in.next();
          System.out.printf("\"%s\" is not a valid number.\n", input);
      }
      column = in.nextInt();
  } while (column < 1 || column > 3);
  
  
I used a structure similar to this in lab #4 and it worked fine but when I try this now
it says I have duplicate variables for column which leaves me unable to validate the user input
within the given range or to make sure that column is not full
*/
	  
	  public static void playerOneMove(String[][] x) {
	    System.out.print("Player one it is your move to drop an X (0–6): ");
	    Scanner scan = new Scanner (System.in);
	    int column = 2 * scan.nextInt() + 1;
	    for (int y = 5; y >= 0; y--) {
	      if (x[y][column] == " ") {
	        x[y][column] = "X";
	        break;
	      }
	    }
	  }
	 
	  //prompts player 2 to make their move
	  //checks to make sure the number entered is within the board
	  
	  /* do {
	            System.out.print("Player two it is your move to drop an O (0-6):");
	            while (!in.hasNextInt()) {
	                String input = in.next();
	                System.out.printf("\"%s\" is not a valid number.\n", input);
	            }
	            column = in.nextInt();
	        } while (column < 1 || column > 3);
	        
	        
	   I used a structure similar to this in lab #4 and it worked fine but when I try this now
	   it says I have duplicate variables for column which leaves me unable to validate the user input
	   within the given range or to make sure that column is not full
	   */
	  public static void playerTwoMove(String[][] x) {
	    System.out.print("Player two it is your move to drop an O (0–6): ");
	    Scanner scan = new Scanner (System.in);
	    int column = 2 * scan.nextInt() + 1;
	    for (int y = 5; y >= 0; y--) {
	      if (x[y][column] == " ") {
	        x[y][column] = "O";
	        break;
	      }
	    }
	  }
	 
	 //checks to see if there is a winner horizontally, vertically, or diagonally
	  public static String checkWinner(String[][] x) {
	    for (int y = 0; y < 6; y++) {
	      for (int j = 0; j < 7; j +=2) {
	        if ((x[y][j+1] != " ")
	        && (x[y][j+3] != " ")
	        && (x[y][j+5] != " ")
	        && (x[y][j+7] != " ")
	        && ((x[y][j+1] == x[y][j+3])
	        && (x[y][j+3] == x[y][j+5])
	        && (x[y][j+5] == x[y][j+7])))
	 
	          return x[y][j+1]; 
	      }
	    }
	 
	    for (int y = 1; y < 15; y +=2) {
	      for (int j = 0; j < 3; j++) {
	            if((x[j][y] != " ")
	            && (x[j+1][y] != " ")
	            && (x[j+2][y] != " ")
	            && (x[j+3][y] != " ")
	            && ((x[j][y] == x[j+1][y])
	            && (x[j+1][y] == x[j+2][y])
	            && (x[j+2][y] == x[j+3][y])))
	              return x[j][y]; 
	      } 
	    }
	 
	    for (int y = 0; y < 3; y++) {
	 
	      for (int j = 1; j < 9; j +=2) {
	            if((x[y][j] != " ")
	            && (x[y+1][j+2] != " ")
	            && (x[y+2][j+4] != " ")
	            && (x[y+3][j+6] != " ")
	            && ((x[y][j] == x[y+1][j+2])
	            && (x[y+1][j+2] == x[y+2][j+4])
	            && (x[y+2][j+4] == x[y+3][j+6])))
	              return x[y][j]; 
	      } 
	    }
	 
	    for (int y = 0; y < 3; y++) {
	      for (int j = 7; j < 15; j +=2) {
	            if((x[y][j] != " ")
	            && (x[y+1][j-2] != " ")
	            && (x[y+2][j-4] != " ")
	            && (x[y+3][j-6] != " ")
	            && ((x[y][j] == x[y+1][j-2])
	            && (x[y+1][j-2] == x[y+2][j-4])
	            && (x[y+2][j-4] == x[y+3][j-6])))
	              return x[y][j]; 
	      } 
	    }
	 
	    return null;
	  }
	 //loops the game until someone wins or a tie is reached
	  
	 /* I tried to use a do while loop in my main to ask if the user wanted to play another game
	   no matter how i answered another game would not loop
	  */
	  public static void main (String[] args) {
	    String[][] x = createBoard();
	    boolean loop = true;
	    int count = 0;
	    printBoard(x);
	    while(loop) {
	      if (count % 2 == 0) playerOneMove(x);
	      else playerTwoMove(x);
	      count++;
	      if (count == 42) {
	    	  System.out.println("The game has resulted in a tie!");
	      }
	      printBoard(x);
	      if (checkWinner(x) != null) {
	        if (checkWinner(x) == "X"){
	           System.out.println("Congratulations Player One, you win!");
	        } 
	        else if (checkWinner(x)== "O") {
	          System.out.println("Congratulations Player Two, you win!");
	        }
	      }
	    }
	  }
}
