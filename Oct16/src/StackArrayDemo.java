
public class StackArrayDemo {

	public static void main(String[] args) {
		
		VideoGame v1 = new VideoGame("Halo 3", "M");
		VideoGame v2 = new VideoGame("Mario","E");
		VideoGame v3 = new VideoGame("Valheim","T");
		VideoGame v4 = new VideoGame("Call of Duty","M");
		
		StackArray stack = new StackArray();
		
		stack.push(v1);
		stack.push(v2);
		stack.push(v3);
		stack.push(v4);
		
		stack.printStack();
		
		

	}

}
