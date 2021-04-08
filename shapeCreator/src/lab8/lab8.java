package lab8;

import java.util.Scanner;

public class lab8 {
	
	public static void main(String args[])
	{
		// DATA
		Shape[] shapes = new Shape[10];
		int nextIDNumber = 1;
		boolean exit = false;
		int selection;
		Scanner input = new Scanner(System.in);
		int id = 0;
		int x = 0;
		int y = 0;
		double base, height = 0, width = 0, radius;
		boolean found = false;
		double scaleFactor = 1; 

		// ALGORITHM
		// loop until user exits
		do
		{
			// display menu
			System.out.println("1 Add a new circle");
			System.out.println("2 Add a new rectangle");
			System.out.println("3 Add a new right triangle");
			System.out.println("4 Delete a shape");
			System.out.println("5 Delete all shape");
			System.out.println("6 Display all shapes");
			System.out.println("7 Move a shape");
			System.out.println("8 Enter a scale factor");
			System.out.println("9 Scale all shapes");
			System.out.println("10 Exit program");
			selection = input.nextInt();

			// get user choice (validate)
			while(selection < 1 || selection > 10)
			{
				System.out.println("Invaild input try again ");
				System.out.println("1 Add a new circle");
				System.out.println("2 Add a new rectangle");
				System.out.println("3 Add a new right triangle");
				System.out.println("4 Delete a shape");
				System.out.println("5 Delete all shape");
				System.out.println("6 Display all shapes");
				System.out.println("7 Move a shape");
				System.out.println("8 Enter a scale factor");
				System.out.println("9 Scale all shapes");
				System.out.println("10 Exit program");
				selection = input.nextInt();

			}
			// switch on selection
			switch(selection)
			{
			case 1:
				// ADD NEW CIRCLE
				// get size from user (one variable)
				System.out.println("What do want the radius to be?");
				radius = input.nextDouble();
				while (radius <= 0)
				{
					System.out.println("The radius cannot be less than 0");
					radius = input.nextDouble();
				}

				// get location from user (two variables)
				System.out.println("What do you want the x value to be?");
				x = input.nextInt();
				System.out.println("What do you want the y value to be?");
				y = input.nextInt();
				// set found to false
				found = false; 
				// loop through array
					// if this is not a valid object
	 					// create new Circle object and assign to current array element
						for (int i = 0; i < shapes.length; i++)
						{
							if (shapes[i] == null){
								shapes[i] = new Circle(nextIDNumber++, x, y, radius);
								 found = true;
							   break;
							}	
						}
						// set found to true
						// break out of loop
				// if not found, give error message
				if(!found)
				{
					System.out.println("There is no space left");
				}
				else {
					System.out.println("Your circle has been created");
				}
				// break out of switch statement
                break;
			case 2:
				// ADD NEW RECTANGLE
				// get size from user (two variables)
				System.out.println("Input the height of your rectangle");
				height = input.nextInt();
				
				System.out.println("Input the width of your rectangle");
				width = input.nextInt();
				
				// get location from user (two variables)
				System.out.println("Input your x value");
				x = input.nextInt();
				System.out.println("Input your y value");
				y = input.nextInt();
				// set found to false
				found = false; 
				// loop through array
					// if this is not a valid object
	 					// create new Rectangle object and assign to current array element
						for(int i = 0; i < shapes.length; i++) {
							if (shapes[i] == null) 
							{
								shapes[i] = new Rectangle(nextIDNumber++, x, y, height, width);
								found = true;
								break;
							}
						}
						// set found to true
						
						// break out of loop
				// if not found, give error message
						if(!found)
						{
							System.out.println("There is no space left");
						}
						else {
							System.out.println("Your rectangle has been created");
						}
				// break out of switch statement
				break;
			case 3:
				// ADD NEW RIGHT TRIANGLE
				// get size from user (two variables)
				System.out.println("Input the base of your triangle");
				base = input.nextInt();
				// get location from user (two variables)
				System.out.println("Input your x value");
				x = input.nextInt();
				System.out.println("Input your y value");
				y = input.nextInt();
				// set found to false
				found = false;
				// loop through array
					// if this is not a valid object
				for (int i = 0; i < shapes.length; i++) {
					if (shapes[i] == null) {
						shapes [i] = new RightTriangle(nextIDNumber++, x, y, base, height);
						found = true;
						break;
					}
				}
	 					// create new RightTriangle object and assign to current array element

						// set found to true

						// break out of loop

				// if not found, give error message
				if(!found)
				{
					System.out.println("There is no more space");
				}
				else {
					System.out.println("Your triangle has been created");
				}

				// break out of switch statement
				break;

			case 4:
				// DELETE ONE SHAPE
				// get id number to delete
				System.out.println("Enter the ID you would like to delete");
				id = input.nextInt();
				while(id <= 0) {
					System.out.println("Invalid ID number, try again.");
					id = input.nextInt();
				}
				// set found to false
				found = false; 
				// loop through array
					// if this is a valid object and the correct object
						// delete object
				for (int i = 0; i < shapes.length; i++) {
					if(shapes[i] != null && shapes[i].getid() == id) {
						shapes[i] = null;
						found = true;
						break;
					}
				}
						// set found to true

						// break out of loop

				// if not found, give error message
				if(found==false)
				{
					System.out.println("A shape with that ID does not exist");
				}
				else if (found == true){
					System.out.println("The shape has been removed");
				}
				// break out of switch statement
				break;
			case 5:
				// DELETE ALL SHAPES
				// loop through array
					// if this is a valid object
				for(int i=0; i < shapes.length; i++) {
					if(shapes[i] != null) {
						shapes[i]= null;
					}
				}
				System.out.println("All shapes have been deleted");
						// delete object

				// break out of switch statement
				break;
			case 6:
				// DISPLAY ALL SHAPES
				// print header
				for(int i = 0; i < shapes.length; i++) {
					if(shapes[i] !=null) {
					System.out.println("These are the current shapes");
					break;
					}
				}
				

				// loop through array
					// if this is a valid object
				for(int i = 0; i < shapes.length; i++) {
					if(shapes[i] != null) {
					System.out.println("ID#: " + shapes[i].getid());
					System.out.println("x-value: " + shapes[i].getxLoc());
					System.out.println("y-value: " + shapes[i].getyLoc());
					System.out.println("Perimeter: " + shapes[i].getPerimeter());
					System.out.println("Area: " + shapes[i].getArea());
					System.out.println(shapes[i].displayDimensions() + "\n");
					}
				}
						// display ID, X, Y, Parameter and Area
						// call displayDimensions to display its dimensions

				// break out of switch statement
				break;
			case 7:
				// MOVE A SHAPE
				// get id number to move
				System.out.println("What ID number you want to move?");
				id = input.nextInt();
				// get location from user (two variables)
				System.out.println("Input an x value to move to");
				x = input.nextInt();
				System.out.println("Input a y value to move to");
				y = input.nextInt();
				// set found to false
				found = false; 
				// loop through array
				for(int i = 0; i < shapes.length; i++) {
					if(shapes[i] != null && shapes[i].getid() == id) {
						shapes[i].setxLoc(x);
						shapes[i].setyLoc(y);
						found = true; 
						break;
					}
				}
					// if this is a valid object and the correct object
						// call two set methods

						// set found to true

						// break out of loop

				// if not found, give error message
				if(!found)
				{
					System.out.println("No shape with this ID exists");
				}
				else if (found == true){
					System.out.println("Shape has been deleted!");
				}
				// break out of switch statement
				break;
			case 8:
				// ENTER A SCALE FACTOR
				// get scale factor
				System.out.println("Enter a scale factor:");
				scaleFactor = input.nextDouble();
				while(scaleFactor < 0) {
					System.out.println("The scale factor cannot be less than 0 try again");
					scaleFactor = input.nextDouble();
				}
				// call SetScaleFactor to set the new scale factor
				Circle.setscaleFactor(scaleFactor);
				Rectangle.setscaleFactor(scaleFactor);
				RightTriangle.setscaleFactor(scaleFactor);
				
				// break out of switch statement
				break;
			case 9:
				// SCALE ALL SHAPES
				// loop through array
					// if this is a valid object
						// call ScaleShape
				for(int i =0; i < shapes.length; i++) {
					if(shapes[i] != null) {
						shapes[i].scaleShape();
					}
				}
				System.out.println("All of the shapes have been scaled");
				// break out of switch statement
				break;

			case 10:
				// EXIT PROGRAM
				// confirm user wants to exit
					// set variable to break out of loop
				System.out.println("Are you sure you want to end the program? Yes = 1 or No = 2");
				int confirm = input.nextInt();
				
				while (confirm < 1 || confirm > 2){
					System.out.println("Invaild input, are you sure you want to end the program? Yes = 1 or No = 2");
					confirm = input.nextInt();
				}
				// break out of switch statement
				break;
			}
		} while (!exit);
	}
}

abstract class Shape
{
	private static double scaleFactor;
	private int id; 
	private int xLoc;
	private int yLoc; 
	
	public Shape(int identity, int x, int y) {
		setid(identity);
		setxLoc(x);
		setyLoc(y);
	}
	public void setid (int identity) {
		if (identity > 0) {
			id = identity; 
		}
	}
	public void setxLoc (int x) {
		if (x >= 0) {
			xLoc = x;
		}
	}
	public void setyLoc (int y) {
		if (y >= 0) {
			yLoc = y;
		}
	}
	public static void setscaleFactor (double sF )
	{
		if (sF > 0)
		{
			setScaleFactor(sF);
		}
	}
	
	public int getid()
	{
		return id;
	}
	public int getxLoc()
	{
		return xLoc;
	}
	public int getyLoc()
	{
		return yLoc;
	}
	// declare instance variables

	// one constructor

	// get/set methods

	// abstract methods
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract String displayDimensions();
	public abstract void scaleShape();
	public static double getScaleFactor() {
		return scaleFactor;
	}
	public static void setScaleFactor(double scaleFactor) {
		Shape.scaleFactor = scaleFactor;
	}
}

class Circle extends Shape
{
	// declare instance variable
	private double radius;

	// one constructor
	public Circle (int identity, int x, int y, double r)
	{
	    super(identity, x, y);
		setradius(r);
	}	
	// get/set methods
	public void setradius(double r) {
		if ( r> 0) {
			radius = r;
		}
	}
	public double getRadius() {
		return radius;
	}
	// override abstract methods
	// GetPerimeter method
	public double getPerimeter() {
		return Math.PI * 2 * radius;
	}
	// GetArea method
	public double getArea() {
		return Math.PI * radius * radius;
	}
	// ScaleShape method
	public void scaleShape() {
		radius *= Shape.getScaleFactor();
	}
	// DisplayDimensions method
	public String displayDimensions() {
		return "The cicles radius is " + getRadius() + ".";
	}
}

 class Rectangle extends Shape
{
	// declare instance variables
	private double height;
	private double width;

	// one constructor
	public Rectangle(int identity, int x, int y, double h, double w) {
		super(identity,x,y);
		setheight(h);
		setwidth(w);
	}
	// get/set methods
	public double setheight(double h) {
		if(h>0) {
			height = h;
		}
	}
	public double setwidth(double w) {
		if (w>0) {
			width = w;
		}
	}
	// override abstract methods
	// GetPerimeter method
	public double getPerimeter() {
		return height + width * 2;
	}
	// GetArea method
	public double getArea;
	{
		return height * width;
	}
	// ScaleShape method
	public void scaleShape() {
		height *= Shape.getScaleFactor();
		width *= Shape.getScaleFactor();
	}
	public double getheight() {
		return height;
	}
	public double getwidth() {
		return width;
	}
	// DisplayDimensions method
	public String displayDimensions() {
		return "The rectangle dimension height is " + getheight() + "\nThe rectangle dimension width is " + getwidth();
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class RightTriangle extends Shape
{
	// declare instance variables
	private double base;
	private double height;
	private double hypotenuse;

	// one constructor
	public RightTriangle (int identity, int x, int y, double b, double h) {
		super(identity, x, y);
		SetBaseAndHeight(b,h);
	}

	// get/set methods
	public void SetBaseAndHeight(double b, double h)
	{
		if (b > 0.0 && h > 0)
		{
			base = b;
			height = h;
			hypotenuse = Math.hypot(base, height);
		}
	}

	public double GetBase()
	{
		return base;
	}
	public double GetHeight()
	{
		return height;
	}

	public double GetHypotenuse()
	{
		return hypotenuse;
	}

	// override abstract methods
	// GetPerimeter method
	public double getPerimeter() {
		return base * height + hypotenuse;
	}
	// GetArea method
	public double getArea() {
		return ((base * height)/2);
	}
	// ScaleShape method
	public void scaleShape() {
		base *= Shape.getScaleFactor();
		height *= Shape.getScaleFactor();
	}
	// DisplayDimensions method
	public String displayDimensions() {
		return "The right triangle base is " + GetBase() + "\nThe right triangle height is " + GetHeight();
	}

}
