import java.util.Random;

public class CircularLinkedList {
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
//XXX TODO: 1. make numbers for node values on print... 2. stop infinite loop on head/tail deletion
	
	public void addAfterTail(Node node) {
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		}
		
		else {
			//case 2: insert to back
			this.tail.setNext(node);
			node.setPrev(this.tail);
			node.setNext(head);
			this.tail = node;
			
			//cll reattach head/tail 
			this.head.setPrev(this.tail);
			this.tail.setNext(this.head);
		}
		this.size++;
	}

	public void printCircularLinkedList(boolean b) {
		int count = 0;
		
		if (b == false) {
			Node current = head;
			do {
				count++;
				System.out.println(count + ": " + current.printNode());
//				System.out.println();
				current = current.getNext();
			} while(current != head);
		}
		
		else if (b == true) {
			Node current = tail;
			do {
				count++;
				System.out.println(count + ": " + current.printNode());
				current = current.getPrev();
//				System.out.println();
				
			} while(current != tail);
		}
	}

	public Node selectRandomCountry(boolean b) {
		Node current = head;
		Random rand = new Random();
		
		int N = rand.nextInt(10);
		System.out.println("Random value generated: " + N);
		if (b == false) {
			current = head;
			for (int i = 0; i < N; i++) {
				current = current.getNext();
//				System.out.println(current.printNode());
			}
			
		}
		
		else if (b == true) {
			current = tail;
			for (int i = 0; i < N; i++) {
				current = current.getPrev();
//				System.out.println(current.printNode());
			}
			
		}
		System.out.println("Country Selected: " + current.printNode());
		return current;
	}

	public void remove(Node n1) {
		Node after = n1.getNext();
		Node before = n1.getPrev();
		if (n1 == head) {
			head = after;
		}
		else if (n1 == tail) {
			tail = before;
			}
		
			//re-attach
			before.setNext(after);
			after.setPrev(before);
		
	}

}
