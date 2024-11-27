
public class Dog {
	private String name;
	private String breed;
	private int age;
	private double weight;
	private double[] distance; //maybe double im not sure
	
	private String score = "Unknown";
	
	public Dog(String name, String breed, int age, double weight, double[] distance) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.distance = distance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String printInfo() {
		System.out.println("Name: " + name + " (" + this.breed + ")" + "\nAge: " + age + "\nweight: " + weight + " lbs");
		//return "Name: " + this.name + "(" + this.breed + ")" + "\nAge: " + this.age + "\nweight: " + this.weight + " lbs";
		return null;
	}

	public int getDogAge() {
		int newage = age * 7;
		return newage;
	}

	public double getTotalMiles() {
		double totalDistance = 0.0;
		
		for (int i = 0; i <7; i++) { 
			totalDistance += this.distance[i];
		}
		return totalDistance;
	}
	
	public String checkWalkingScore(double input_distance) {
		//System.out.println("dist =" + input_distance);
		if(input_distance < 3.5) {
			score = this.name + " needs to be walked more!";
		}
		
		else if(input_distance >= 3.5 && input_distance <= 5) {
			score = this.name + " is being walked a healthy amount!";
		}
		
		else if(input_distance > 5) {
			score = this.name + " is being walked a lot!";
		}
		System.out.println(score);
		return score;
		
	}
		
	
}

