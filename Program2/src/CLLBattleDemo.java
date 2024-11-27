import java.util.Scanner;

public class CLLBattleDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char user_choice = 'y';
		
		CLLBattle cll = new CLLBattle();
		
		cll.fillLinkedList("participants.txt");
		System.out.println("Challengers Remaining:");
		System.out.println("---------------------------");
		cll.printLinkedList();
		System.out.println();
		System.out.println("Would you like to continue (y/n) ?");
		
		
		while(cll.sizeOf() != 1) {
			user_choice = scanner.next().charAt(0);
			//System.out.println(user_choice);
			if (user_choice == 'n') {
				break;
			}
			
			else {
				System.out.println();
				cll.simulateOneRound();
				System.out.println();
				System.out.println("Challengers Remaining:");
				System.out.println("---------------------------");
				cll.printLinkedList();
				
				if (cll.sizeOf() == 1) {
					System.out.println();
					System.out.println("The winner is: " + cll.winName());
				}
				else {
					System.out.println("Would you like to continue (y/n) ?");
					//user_choice = scanner.next();
				}
			}
		}
		scanner.close();
	}
	
}
