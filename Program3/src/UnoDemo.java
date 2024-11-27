import java.util.Random;
import java.util.Scanner;

public class UnoDemo {
	//Generate random cards for stack
	public static Card getNewCard() {
		String[] colors = {"B", "R", "Y"};
		Random rand = new Random();
		
		int rand_int = rand.nextInt(9) + 1; //range of 1-9 
		int rand_str = rand.nextInt(3); //B=7, R=8, W=9
		
		String str_int = Integer.toString(rand_int);
//		System.out.println(rand_int);
//		System.out.println(colors[rand_str]);
		
		Card c = new Card(colors[rand_str], str_int);
		
		return c;
	}
	
	public static boolean checkMove(Card hand_in, Card stack_top) {
		boolean legal = true;
		int h_i, s_t;
		//true conditions
		
		//wild
		//stack is wild
		if (stack_top.getNum().equals("Wild")) {
			return legal = true;
		}		
		//hand is wild
		if (hand_in.getNum().equals("Wild")) {
			return legal = true;
		}
		
		//r
		//hand or stack is r 
		if (hand_in.getNum().equals("R") || (stack_top.getNum().equals("R"))) {
			//color is same as stack
			if (hand_in.getColor().equals(stack_top.getColor())){ //redundant but finnicky w/out for some reason
				return legal = true;
			}
			//hand not same color
			else {
				//hand and stack are R
				if (stack_top.getNum().equals("R") && hand_in.getNum().equals("R")) {
					return legal = true;
				}
				//no match
				else {
					return legal = false;
				}
			}
		}
		
		//b
		//hand or stack is b
		if (hand_in.getNum().equals("B") || stack_top.getNum().equals("B")) {
			//color same as stack
			if (hand_in.getColor().equals(stack_top.getColor())){
				return legal = true;
			}
			//color doesnt match
			else {
				//both are b
				if (stack_top.getNum().equals("B") && hand_in.getNum().equals("B")) {
					return legal = true;
				}
				//no match
				else {
					return legal = false;
				}
			}
		}

		//normal break conditions
		h_i = Integer.valueOf(hand_in.getNum());
		s_t = Integer.valueOf(stack_top.getNum());
		
		//color and num dont match
		if (hand_in.getColor() != stack_top.getColor()) {
			if (h_i == s_t) {
				legal = true;
			}
			else {
				legal = false;
			}
			
		}
		
		return legal;
	}
	
	//add hand played card to stack and remove from hand
	public static void makeMove(Card hand_in, Card stack_top, UnoStack stack, HandList hand, int choice) {
		if (hand_in.getNum().equals("R")) {
			stack.pop();
			hand.remove(choice);
			return;
		}
		
		if (hand_in.getNum().equals("B")) {
			for (int i = 0; i < stack.getSize()-1; i++) {
				stack.pop();
			}
			hand.remove(choice);
			return;
		}
		
		else {
			stack.push(hand_in);
			hand.remove(choice);
		}
	}
	
	public static void main(String[] args) {
		//make stack and hand
		UnoStack stack = new UnoStack();
		HandList hand = new HandList();
		//make stack
		for (int i = 0; i < 6; i++) {
			Card c1 = getNewCard();
			stack.push(c1);
		}
		//make hand
		for (int i = 0; i < 5; i++) {
			Card h1 = getNewCard();
			hand.addCard(h1);
		}
//		hand.printStack();
		
		Scanner scanner = new Scanner(System.in);
		int user_choice = 1;
		
		while (hand.isEmpty() == false) {
			System.out.println("The top of stack is: " + stack.peek());
			System.out.println("What card do you want to play?");
			System.out.println("Press 0 to draw a new card");
			hand.printList();
		
			//scan choice
			user_choice = scanner.nextInt();
			
			//new card
			if (user_choice == 0) {
				Card h2 = getNewCard();
				hand.addCard(h2);
			}
			
			//play a card
			else {
				
				
				boolean valid;

				//choice larger thand hand size
				if (hand.getSize() < user_choice) {
					valid = false;
					System.out.println("Invalid move... try again");
				}
				else {
					
					valid = checkMove(hand.find(user_choice), stack.actualPeek());
					
					if (valid == true) {
						Card a = hand.find(user_choice);
						makeMove(a, stack.actualPeek(), stack, hand, user_choice);
						
					}
					
					else {
						System.out.println("Invalid move... try again");
					}
				}
				
			}
			
						
		}
		System.out.println("Congrats, you win");
		scanner.close();
	}

}
