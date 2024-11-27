import java.util.LinkedList;

public class HandList {
	private LinkedList<Card> hand;
	private int size = 0;
	
	
	public HandList() {
		this.hand = new LinkedList<Card>();
		this.size = 0;
	}
	
	public void addCard(Card c) {
		if (c.getNum().equals("7")) {
			c.setNum("B");
		}
		
		else if (c.getNum().equals("8")) {
			c.setNum("R");
		}
		
		else if (c.getNum().equals("9")) {
			c.setNum("Wild");
		}
		this.hand.addFirst(c);
		this.size++;
	}
	
	public void printList() {
		for(Card c: this.hand) {
			System.out.println(c.printInfo());
		}
	}
	
	public void remove(int index) {
		index--;
		this.hand.remove(index);
		this.size--;
	}
	
	public boolean isEmpty() {
		boolean empty = false;
		if (this.size == 0) {
			empty = true;
		}
		
		return empty;
	}
	
	public Card find(int index) {
		index--;
		Card found = this.hand.get(index);
		return found;
	}
	
	public int getSize() {
		return this.size;
	}
}
	
