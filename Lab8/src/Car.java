
public class Car {
	private String name;
	private String model;
	private boolean vip;
	
	public Car(String m, String n, boolean v) {
		this.name = n;
		this.model = m;
		this.vip = v;
	}

	public String getInfo() {
		return this.model + "(" + this.name + ")";
	}	
	
	public String getName() {
		return this.name;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public boolean getVIP() {
		return this.vip;
	}
}
