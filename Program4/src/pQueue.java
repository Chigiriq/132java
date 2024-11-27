import java.util.LinkedList;
import java.util.Scanner;

public class pQueue {
	
	private LinkedList<Customer> prof_queue; //profs
	private LinkedList<Customer> stud_queue; //students
	private int pSize;
	private int sSize;
	private int customers_served = 0;
	
	public pQueue() {
		this.prof_queue = new LinkedList<Customer>();
		this.stud_queue = new LinkedList<Customer>();
		
		this.pSize = 0;
		this.sSize = 0;
		this.customers_served = 0;
	}
	
	public void enqueue(Customer c) {		
		//queue student
		this.stud_queue.add(c);
		this.sSize++;
		System.out.println("Added " + c.getName() + " to the queue");
	}
	
	public void priorityEnqueue(Customer p) {
		//queue prof
		this.prof_queue.add(p);
		this.pSize++;
	}
		
	public void printQueue() {
		//print prof queue
		if (pSize > 0) {
			for (Customer p: this.prof_queue) {
				System.out.println(p.getName() + " (" + p.getOrder() + ")");
			}
		}
		//print student queue
		if (sSize > 0) {
			for (Customer s: this.stud_queue) {
				System.out.println(s.getName() + " (" + s.getOrder() + ")");
			}
		}
	}

	public Customer createCustomer() {
		
		//scan in values
		Scanner scn = new Scanner(System.in);
		
		System.out.println("What is the customer's name?");
		String str1 = scn.next();
		
		System.out.println("What would you like to order?");
		String str2 = scn.next();
		
		long start_time = System.nanoTime();
		//create customer
		Customer c = new Customer(start_time, str1, str2);
//		scn.close();  //it breaks the other scanner i guess
		return c;
	}


	public void dequeue() {
		//dequeue prof
		if (pSize > 0) {
			Customer removed = this.prof_queue.removeFirst();
			
			long end_time = System.nanoTime();
			double elapsed_time = (end_time - removed.getTime()) / 1000000.0;
			
			System.out.println("Time spent in queue: " + elapsed_time/1000 + " seconds");
			System.out.println(removed.getName() + " has been served their " + removed.getOrder());
			this.pSize--;
		}
		
		//dequeue student
		else {
			Customer removed = this.stud_queue.removeFirst();
			
			long end_time = System.nanoTime();
			double elapsed_time = (end_time - removed.getTime()) / 1000000.0;
			
			System.out.println("Time spent in queue: " + elapsed_time/1000 + " seconds");
			System.out.println(removed.getName() + " has been served their " + removed.getOrder());
			this.sSize--;
		}
		customers_served++;
	}

	public void removeFromQueue(String name) {
		//remove a name
		int position = 0;
		Customer found = null;
		//check prof
		if (this.pSize > 0) {
			for (Customer c: this.prof_queue) {
				if (c.getName().equals(name)) {
					found = c;
					break;
				}
				position++;
			}
			//verify match in prof
			if (found != null) {
				//match is in prof queue
				System.out.println("Time spent in queue: " + found.getTime());
				this.prof_queue.remove(position);
				this.pSize--;
				return; //end here
			}
			
			//otherwise no match yet
		}
		
		//check student now
		position = 0;
		for (Customer c: this.stud_queue) {
			if (c.getName().equals(name)) {
				found = c;
				break;
			}
			position++;
		}
		
		//was match in stud queue
		if (found != null) {
			//match was in stud queue
			System.out.println("Time spent in queue: " + found.getTime());
			this.stud_queue.remove(position);
			this.sSize--;
			return; //end here
		}
		
		System.out.println("Error in removing " + name + " from list");
	}

	public void printQueueStats() {
		//no idea
		System.out.println("Queue statistics");
		System.out.println("----------------");
		System.out.println("Average wait time: ");
		System.out.println("Customers served: " + customers_served);
	}

}
