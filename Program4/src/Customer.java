
public class Customer {
	private double time;
	private String name;
	private String order;

	public Customer(double t, String n, String o) {
		this.time = t;
		this.name = n;
		this.order = o;
	}

	//XXX WHAT IS HAPPENING
	public double getTime() {
//		long start = System.nanoTime();
//		// some time passes
//		long end = System.nanoTime();
//		long elapsedTime = end - start;
		
//		this.time = elapsedTime / 1000000000;
	
		
		return this.time;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getOrder() {
		return this.order;
	}
}
