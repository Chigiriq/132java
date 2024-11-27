
public class Node {
	private String title;
	private int date;
	
	private Node next;

	
	public Node(String title, int date) {
		this.title = title;
		this.date = date;
		
		this.next = null;
	}
	
	
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node newNode) {
		this.next = newNode;
	}
	
	public String getData() {
		return this.title + "(" + this.date + ")";  
 	}
	
	public String getTitle() {
		return this.title;
	}
	
}
