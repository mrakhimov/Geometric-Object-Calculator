package shapes;
/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

/**
 * Square class inherited from Rectangle
 * @implSpec getSide(), setSide()
 * @overloaded toString()
 */
public class Square extends Rectangle implements Shape{
	private double side;
	
	public Square(double side) throws Exception {
		super(side,side);
		setSide(side);	
	}

	/**
	 * @return this object's side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param side of a Square
	 */
	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public String toString() {
		return "{s=" + getSide() + "}";
	}
	
	
	
	

}
