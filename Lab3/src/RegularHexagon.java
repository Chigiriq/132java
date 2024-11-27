
import java.lang.Math;
public class RegularHexagon implements RegularPolygon {
	
	private double length;

	public RegularHexagon(double l) {
		this.length = l;
	}
	
	public double area() {
		double area;
		area = (3 * Math.sqrt(3)) / 2 * Math.pow(this.length,2);		
		return area;	
	}

	public double perimeter() {
		double perimeter;
		perimeter = 6 * this.length; 
		return perimeter;
	}
}

