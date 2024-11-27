
public class QueueArray {
	private Car[] car;
	
	private int size;
	private int front;
	private int capacity;
	private int washed;
	private double earnings;
	
	public QueueArray(int s) {
		this.car = new Car[s];
		this.size = 0;
		this.front = 0;
		this.capacity = this.car.length;
		this.washed = 0;
		this.earnings = 0;
	}

	public void enqueue(Car c1) {
		if (this.size == this.capacity) {
			System.out.println("Error... queue is full- " + "Cannot add " + c1.getModel() + " (" + c1.getName()  + ")");
			return;
		}
		
		int insert_spot = (front + size) % capacity;
		this.car[insert_spot] = c1;
		
		this.size++;
		System.out.println("Adding " + c1.getModel() + " (" + c1.getName() + ") to the queue");
	}

	public void printQueue() {
		System.out.println("Current Car Wash Queue");
		System.out.println("----------------------");
		
		int start = front;
		int counter = 1;
		int n = 0;
		while (n != this.size) {
			System.out.println(counter + ". " + this.car[start].getModel() + " (" + this.car[start].getName() + ")");
			start = (start + 1) % capacity;
			counter++;
			n++;
		}
	}

	public Car peek() {
		return this.car[front];
	}

	public void dequeue() {
		if (this.size == 0) {
			System.out.println("Error... queue is empty");
		}
		else {
			Car c = this.car[front];
			this.car[front] = null;
			front = (front + 1) % capacity;
			this.size--;
				
			//add car washed
			this.washed++;
			
			//calc earnings
			if (c.getVIP() == true) {
				this.earnings += 6;
			}
			else {
				this.earnings += 10;
			}
			System.out.println("Car has been washed. Removing " + c.getModel() + " (" + c.getName() + ") from the queue");
		}
	}

	public void printStats() {
		System.out.println("Car Wash Statistics");
		System.out.println("-------------------");
		System.out.println("Number of cars serviced: " + this.washed);
		System.out.println("Today's earnings: $" + this.earnings);
	}

	public boolean isEmpty() {
		boolean empty = false;
		
		if (this.size == 0) {
			empty = true;
		}
		return empty;
	}
}
