
import java.util.Scanner;

public class SlotMachineDemo {
	public static void main(String[] args) {
		
		int user_choice = 0;
		int credits = 10;
		
		
		Scanner scanner = new Scanner(System.in);
		
		SlotMachine slot = new SlotMachine();
		
		
		while(user_choice != 5) {
			System.out.println();
			
			slot.printMenu();
			user_choice = scanner.nextInt();
			
			//sort choices
			//choice 1
			if (user_choice == 1) {
				
				if (credits == 0) {
					System.out.println("Sorry, you are all out of credits...");
				}
				
				else {
					credits -= 1;
					int winnings = slot.playRound();
					credits += winnings;
				}
			
			}
			
			//choice 2
			if(user_choice == 2) {
				System.out.println("How many times would you like to roll the slot machine?");
				int num_rolls = scanner.nextInt();
				
				if(credits < num_rolls) {
					System.out.println("You don't have enough credits");
				}
				
				else {
					for (int i = 0; i < num_rolls; i++) {
						credits += 1;
						int winnings = slot.playRound();
						credits += winnings;
					}
						
				}
				
			}
			
			//choice 3
			if (user_choice == 3) {
				System.out.println("Total winnings paid out by this machine is: " + slot.getTotalWinnings());
			}
			
			
			//choice 4 
			if (user_choice == 4) {
				System.out.println("Credits available: " + credits);
			}
			
			
		}
		scanner.close();
		
	}
}
