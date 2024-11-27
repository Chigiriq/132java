
import java.lang.Math;
public class RegularPentagon implements RegularPolygon {
	private double length;

	public RegularPentagon(double l) {
		this.length = l;
	}
	
	public double area() {
		double area;
		area = 1.0/4.0 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(5, 2);
		return area;	
	}

	public double perimeter() {
		double perimeter;
		perimeter = 5 * this.length; 
		return perimeter;
	}
}
