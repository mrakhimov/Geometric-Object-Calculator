package shapes;
/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

/**
 * Rectangle class inherited from Parallelogram
 * @implemented getWidth(), setWidth(), setLength, setWidth()
 * @overloaded toString()
 */
public class Rectangle extends Parallelogram implements Shape{
	private double width;
	private double length;
	
	public Rectangle(double width, double length) throws Exception {
		super(width, length);
		setWidth(width);
		setLength(length);
	}

	/**
	 * @return this object's width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width of of Rectangle passed
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param Rectangle length passed to set the this.length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "{w=" + getWidth() + ", h=" + getWidth() + "}";
	}
	

}
