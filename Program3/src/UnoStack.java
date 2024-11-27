import java.util.LinkedList;

public class UnoStack {
	private LinkedList<Card> data;
	private Card top_of_stack;
	private int size = 0;
	
	
	public UnoStack() {
		this.data = new LinkedList<Card>();
		this.top_of_stack = null;
		this.size = 0;
	}


	public void push(Card newCard) {
		//if (newCard.getNum() == "7") {
		if (newCard.getNum().equals("7")) {
			newCard.setNum("B");
		}
		
		else if (newCard.getNum().equals("8")) {
			newCard.setNum("R");
		}
		
		else if (newCard.getNum().equals("9")) {
			newCard.setNum("Wild");
		}
		
		this.data.addFirst(newCard);
		this.size++; //XXX --
		this.top_of_stack = this.data.getFirst();
	}
	
	public void pop() {
		if(this.size != 0) {
			this.data.removeFirst();
			this.size--;
			this.top_of_stack = this.data.getFirst();
		}
	}
	
	public String peek() {
		//return this.top_of_stack;
		return this.top_of_stack.printInfo();
	}
	
	public Card actualPeek() {
		return this.top_of_stack;
	}
	
	public void isEmpty() {
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void printStack() {
		for(Card c: this.data) {
			System.out.println(c.printInfo());
		}
	}
}
