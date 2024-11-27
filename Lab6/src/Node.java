
public class Node {
	
	private String country;
	
	private Node next;
	private Node prev;
	
	public Node(String country) {
		this.country = country;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public Node getPrev() {
		return this.prev;
	}
	
	public void setPrev(Node newNode) {
		this.prev = newNode;
	}
	
	public void setNext(Node newNode) {
		this.next = newNode;
	}
	
	public String printNode() {
		return this.country;
	}
	
}
