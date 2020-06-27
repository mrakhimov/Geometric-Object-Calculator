package shapes;
/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

/**
 * Circle class inherited from Shape
 * @implSpec getRadius(), setRadius()
 * @overloaded toString(), getPerimeter()
 */
public class Circle implements Shape {
	private double radius;
	
	public Circle(double radius) throws Exception {
		setRadius(radius);
	}
	/**
	 * @return this object's radius
	 */
	public double getRadius() {
		return this.radius;
	}
	/**
	 * @param radius of a circle
	 * @throws Exception 
	 */
	public void setRadius(double radius) throws Exception {
		if(radius > 0)
			this.radius = radius;
		else 
			throw new Exception("Invalid radius!\n");
	}
	
	@Override
	public String toString() {
		return "{r=" + getRadius() + "}";
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	
}
