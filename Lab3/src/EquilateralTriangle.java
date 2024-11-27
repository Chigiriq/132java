
import java.lang.Math;
public class EquilateralTriangle implements RegularPolygon {
	
	private double length;

	public EquilateralTriangle(double l) {
		this.length = l;
	}
	
	public double area() {
		double area;
		area = (Math.sqrt(3)) / 4 * Math.pow(this.length, 2);		
		return area;	
	}

	public double perimeter() {
		double perimeter;
		perimeter = 3 * this.length; 
		return perimeter;
				
	}
}
