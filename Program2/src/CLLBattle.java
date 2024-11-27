import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class CLLBattle {
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public CLLBattle() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void fillLinkedList(String filename) {
		
		try {
			Scanner input = new Scanner( new FileReader(filename) );
			
			while(input.hasNext() ) {
				String line = input.nextLine();
				
				String[] vals = line.split(",");
				String name = vals[0];
				String p_l = vals[1];
				
				//string to int--NEW
				int power_level = Integer.parseInt(p_l);
				
//				System.out.println(name + " " + power_level);
				
				Node n = new Node(name, power_level);
				
//				System.out.println(n.printNode());
				insert(n, this.size+1);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("pain");
			e.printStackTrace();
		}
	}
	
	
	public void insert(Node newNode, int n) {
		//case 1: insert to empty list
		if(this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
		}
		
		else {
			//case 2: insert to front
			this.head.setPrev(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
			
			//cll reattach head/tail 
			this.head.setPrev(this.tail);
			this.tail.setNext(this.head);
		}

		this.size++;
	}

	
	public void printLinkedList() {
		//update for CLL........null never happens so go until current becomes head
		Node current = head;
		do {
			System.out.println(current.printNode());
			System.out.println();
			current = current.getNext();
		} while(current != head);
		
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
	
	public int sizeOf() {
		return size;
	}
	
	public void simulateOneRound() {
		Node current = head;
		Node jNode = null;
		Node kNode = null;
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		int j = r1.nextInt(size);
		int k = r2.nextInt(size);
		System.out.println("j: " + j);
		System.out.println("k: " + k);
		
		//select the nodes
		for (int i = 0; i < j; i++) {		//may have to do j-1
			current = current.getNext();
		}
		jNode = current;
		
		current = head;
		for (int i = 0; i < k; i++) {		//XXX may have to do k-1
			current = current.getNext();
		}
		kNode = current;
		
		//print out fight
		System.out.println("Nodes Selected:");
		System.out.println(jNode.getName());
		System.out.println(jNode.getPowerLevel());
		System.out.println("vs.");
		System.out.println(kNode.getName());
		System.out.println(kNode.getPowerLevel());
		System.out.println("---------------------------");

		
//		compare k and j nodes
		if (jNode.getPowerLevel() > kNode.getPowerLevel()) {
			System.out.println(jNode.getName() + " wins");
			System.out.println(kNode.getName() + " has been eliminated");
			remove(kNode);
			size--;
		}
		
		else if (kNode.getPowerLevel() > jNode.getPowerLevel()) {
			System.out.println(kNode.getName() + " wins");
			System.out.println(jNode.getName() + " has been eliminated");
			remove(jNode);
			size--;
		}
		
		else {
			System.out.println("No one wins");
		}
	}


	public String winName() {
		Node current = head;
		return current.getName();
	}
}
