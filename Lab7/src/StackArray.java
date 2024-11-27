
public class StackArray {
	
	private int top_of_stack;
	private int size;
	private String[] arr;
	
	public StackArray() {
		this.size = 0;
		this.top_of_stack = -1;
		this.arr = new String[10];
	}

	public void push(String string) {
		if(this.size == this.arr.length) {
			System.out.println("Stack is full...");
			return;
		}
		else {
			this.top_of_stack++;
			arr[top_of_stack] = string;
			this.size++;
		}
	}

	public void printStack() {
		int count = 1;
		System.out.println("The Stack\n---------------");
		for (int i = this.size - 1; i >= 0; i--) {
			System.out.println(count + ": " + arr[i]);
			count++;
		}
	}

	public int getSize() {
		return this.size;
	}

	public String peek() {
		if (this.size == 0) {
			return "nothing";
		}
		else {
			return this.arr[top_of_stack];
		}
	}
	
	public String pop() {
		//System.out.println(arr[top_of_stack]);
		String removed;
		removed = this.arr[top_of_stack];
		this.size--;
		this.top_of_stack--;
			
		return removed;
	}

	public boolean isEmpty() {
		boolean empty = false;
		if (this.size == 0) {
			empty = true;
		}
		return empty;
	}
}
