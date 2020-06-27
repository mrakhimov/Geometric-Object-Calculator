package shapes;

/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
	public final static int MAX = 50;// Max number of shapes in the Shapes array
	public static int COUNT = 0;     // Count how many shapes are created
	
	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[MAX];
		
		double maxPerimeterForCircle = 0;
		double minPerimeterForTriangle = 100;
		

		// ========================================= TASK 1 ============================== // 
        // Displays header
		displayTitle(1);
		// Extracts data from source file into shapes container
		getShapes(shapes);
		System.out.println("\n" + COUNT + " shapes were created: ");
		displayShapes(shapes);
		
		// ========================================== TASK 2 ============================== // 
		// Displays header
		displayTitle(2);
		deleteMinMaxPerimeter(shapes, minPerimeterForTriangle, maxPerimeterForCircle);
		System.out.println("\n" + COUNT + " shapes were created: ");
		displayShapes(shapes);
		
		// ========================================== TASK 3 ============================== // 
		// Displays header
		displayTitle(3);
		System.out.println("Total perimeter of Parallelogram is: " + calculateTotalPerimeter(shapes, "Parallelogram"));
		System.out.println("Total perimeter of Triangle is: " + calculateTotalPerimeter(shapes, "Triangle"));
	}
	/** 
	 * Calculates total Perimeter for all "Shape Name"
	 * @param shapes - Array of shapes
	 * @param string - Shape name to calculate
	 */
	public static double calculateTotalPerimeter(Shape[] shapes,String shapeName) {
		double total = 0;
		for (Shape shape : shapes) {
			if(shape != null) {
				if (shape.getClass().getSimpleName().equals(shapeName) ) {
					total += shape.getPerimeter();
				}
			}
		}
		return total;
	}
	/**
	 * Remove Triangle with min value and Circle with max value
	 */
	public static void deleteMinMaxPerimeter(Shape[] shapes, double minPerimeterForTriangle, double maxPerimeterForCircle) {
		// ------------  for task 3: identify max and min perimeters ------------- //
		for (Shape shape : shapes) {
			if(shape != null) {
				if (shape instanceof Circle) {
					maxPerimeterForCircle = shape.getPerimeter();
					break;
				}
				else if (shape instanceof Triangle) {
					minPerimeterForTriangle = shape.getPerimeter();
					break;
				}
			}
		}
		// 1. Identify if the shape is triangle as well as min and max values for a shape
				for (Shape shape : shapes) {
					if(shape != null) {
						if (shape instanceof Triangle && shape.getPerimeter() < minPerimeterForTriangle) {
							minPerimeterForTriangle = shape.getPerimeter();
						}
						else if (shape instanceof Circle && shape.getPerimeter() > maxPerimeterForCircle) {
							maxPerimeterForCircle = shape.getPerimeter();
						}
					}
				}
				// 2. Delete it from the list 
				for (int i=0; i < shapes.length ; i++ ) {
					if(shapes[i] != null) {
						if (  (shapes[i] instanceof Triangle && shapes[i].getPerimeter() == minPerimeterForTriangle) 
							||(shapes[i] instanceof Circle && shapes[i].getPerimeter() ==  maxPerimeterForCircle )
							) 
						{
							// delete record
							shapes[i] = null;
							COUNT--;
						}
					}
				}
	}
	/** 
	 * Displays header
	 * */
	public static void displayTitle(int number) {

		System.out.println("------->JAC 444 Workshop 2 & 3<-------");
		System.out.println("------->Task " + number + " ... <-------");
	}
	/**
	 * Display shape objects with their perimeter
	 */
	public static void displayShapes(Shape[] shapes) {
		DecimalFormat df = new DecimalFormat("0.0000#");
        df.setRoundingMode(RoundingMode.CEILING);
        
     // Iterate over created shape objects
     		for (Shape shape : shapes) {
     			if(shape != null) {

     				// change formatting of perimeter for Square object with less than 0.1 perimeter
     				if (shape instanceof Square && shape.getPerimeter() < 1E-1) {
     					DecimalFormat df2 = new DecimalFormat("0.0000E0");
     			        df.setRoundingMode(RoundingMode.CEILING);
     					System.out.printf( shape.getClass().getSimpleName() + " " + shape.toString() + " perimeter: " + df2.format(shape.getPerimeter()) + "\n\n");				
     				}
     				// regular formatting for others
     				else 
     					System.out.printf( shape.getClass().getSimpleName() + " " + shape.toString() + " perimeter: " + df.format(shape.getPerimeter()) + "\n\n");
     			}
     		}
	}
	
	/** 
	 * Extracts data from txt file to passed Shape container(array)
	 * */
	public static void getShapes (Shape[] shapes){
		String s;
		try (BufferedReader br = new BufferedReader(new FileReader("src/shapes/shapes.txt"))) {
			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				
				switch(tokens[0]) {
					case "Circle": 
						if(tokens.length <= 2) {
							if(tokens[1] != null && !tokens[1].trim().isEmpty()) {
								try {
									shapes[COUNT] = new Circle(Double.parseDouble(tokens[1]));
									COUNT++;
								}
								catch(Exception e) {
									System.out.print(e.getMessage());
								}
							}
						}
						break;
					case "Parallelogram": 
						if(tokens.length <= 3) {
							if(        (tokens[1] != null && !tokens[1].trim().isEmpty()) 
									&& (tokens[2] != null && !tokens[2].trim().isEmpty())
							) 
						    {
								try {
									shapes[COUNT] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
									COUNT++;
								}
								catch(Exception e) {
									System.out.print(e.getMessage());
								}
							}
						}
						break;
					case "Rectangle": 
						if(tokens.length <= 3) {
							if(        (tokens[1] != null && !tokens[1].trim().isEmpty()) 
									&& (tokens[2] != null && !tokens[2].trim().isEmpty())
								) {
								try {
									shapes[COUNT] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
									COUNT++;
								}
								catch(Exception e) {
									System.out.print(e.getMessage());
								}
							}
							break;
						}
					case "Square": 
						if(tokens.length <= 2) {
							if(tokens[1] != null && !tokens[1].trim().isEmpty()) {
								try {
									shapes[COUNT] = new Square(Double.parseDouble(tokens[1]));
									COUNT++;
								}
								catch(Exception e) {
									System.out.print(e.getMessage());
								}
							}
							break;
						}
					case "Triangle": 
						if(tokens.length <= 4) {
							if(        (tokens[1] != null && !tokens[1].trim().isEmpty()) 
									&& (tokens[2] != null && !tokens[2].trim().isEmpty())
									&& (tokens[3] != null && !tokens[3].trim().isEmpty())
								) {
								try {
									shapes[COUNT] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
									COUNT++;
								}
								
								catch(Exception e) {
									System.out.print(e.getMessage());
								}
							}
						}
						break;
					default:
						// ignore that line
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	

}
