
public class Card {
	private String color;
	private String number;
	
	public Card(String c, String n) {
		this.color = c;
		this.number = n;
	}
	
	public String printInfo() {
		return "(" + this.color + " " + this.number + ")";
	}

	public String getColor() {
		return this.color;
	}
	
	public String getNum() {
		return this.number;
	}
	
	public void setNum(String newN) {
		this.number = newN;
	}
	
}
