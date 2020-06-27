package shapes;

/** @author Mohinur Rakhimov
 *  024-958-118
 *  June 7, 2020
 *  Workshop 2
 */

/**
 * Triangle class inherited from Shape
 * @implemented getS1(), getS2(), getS3(),setS1(), setS2(), setS3()
 * @overloaded toString()
 */
public class Triangle implements Shape{
	private double s1;
	private double s2;
	private double s3; 
	
	public Triangle(double s1, double s2, double s3) throws Exception {
		if( s1 > 0 && s2 > 0 && s3 > 0 && s1 + s2 > s3 && s1 + s3 > s2 && s3 + s2 > s1) 
		{
			setS1(s1);
			setS2(s2);
			setS3(s3);
		}
		else
			throw new Exception("Invalid side(s)!\n");
	}

	/**
	 * @return the s1
	 */
	public double getS1() {
		return s1;
	}

	/**
	 * @param s1 the s1 to set
	 */
	public void setS1(double s1) {
		this.s1 = s1;
	}

	/**
	 * @return the s2
	 */
	public double getS2() {
		return s2;
	}

	/**
	 * @param s2 the s2 to set
	 */
	public void setS2(double s2) {
		this.s2 = s2;
	}

	/**
	 * @return the s3
	 */
	public double getS3() {
		return s3;
	}

	/**
	 * @param s3 the s3 to set
	 */
	public void setS3(double s3) {
		this.s3 = s3;
	}

	@Override
	public String toString() {
		return "{s1=" + getS1() + ", {s2=" + getS2() +", {s3=" + getS3() + "}";
	}


	@Override
	public double getPerimeter() {
		return getS1() + getS2() + getS3();
	}
	

}
