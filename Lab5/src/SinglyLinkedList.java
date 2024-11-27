
public class SinglyLinkedList {
	private Node head;
	private int size;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	
	public void addToBack(Node newNode) {
		//empty linked list
		if (head == null) {
			head = newNode;
		}
		
		else {
			Node current = head;
			
			//loop to end of list
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		this.size ++;
	}
	
	
	public void printList() {
		
		Node current = head;
		
		while (current != null) {

			System.out.println("-" + current.getData());
			current = current.getNext();
		}
	}
	
	
	public void removeFirst() {
		
		if (head != null) {
			head = head.getNext();
			
			this.size --;
		}
		
		
	}
	
	//XXX??? maybe
	public void insert(Node newNode, int N) {
		if (head == null) {
			head = newNode;
		}
		
		else {
			Node current = head;
			
			//get next node
			Node next = current.getNext();
			
			//find N-1
			for (int i = 0; i < N-1; i++) {
				 current = current.getNext();
			}
			
			//set new nodes
			head.setNext(newNode);
			newNode.setNext(next);
			}
		this.size ++;
	}
	
	
	public void searchForMovie(String m) {
		Node current = head;
		int count = 0;
		//go through every node
		while (current.getNext() != null) {
			count ++;
			
			//finds match
			if (m == current.getTitle()) {
				System.out.println(m + " was found at spot #" + (count));
				return;
			}
	
			current = current.getNext();
		}
		//doesn't find
		System.out.println(m + " was not found");
	}
	
	
	public int getSize() {
		return size;
	}
}
