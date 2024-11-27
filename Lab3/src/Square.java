
import java.lang.Math;
public class Square implements RegularPolygon {

	private double length;

	public Square(double l) {
		this.length = l;
	}
	
	public double area() {
		double area;
		area = Math.pow(this.length,2);		
		return area;	
	}

	public double perimeter() {
		double perimeter;
		perimeter = 4 * this.length; 
		return perimeter;
	}
}

