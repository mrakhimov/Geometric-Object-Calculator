package shapes;
/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

/**
 * Parallelogram class inherited from Shape
 * @implemented getWidth(), setWidth(), setLength, setWidth()
 * @overloaded toString()
 */
public class Parallelogram implements Shape{
	private double width;
	private double length;
	
	public Parallelogram(double width, double length) throws Exception {
		if (width > 0 && length > 0) {
			setWidth(width);
			setLength(length);
		}
		else {
			if(width == length) {
				throw new Exception("Invalid side!\n");
			}
			else 
				throw new Exception("Invalid side(s)!\n");
		}
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
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
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "{w=" + getWidth() + ", h=" + getWidth() + "}";
	}

	@Override
	public double getPerimeter() {
		
		return 2 * getWidth() + 2 * getLength();
	}
	
	

}
