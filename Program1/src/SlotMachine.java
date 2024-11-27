import java.util.Arrays;
import java.util.Random;

public class SlotMachine {
	private int[] top_row = {0,0,0};
	private int[] mid_row = {0,0,0};
	private int[] bot_row =  {0,0,0};
	private int total_winnings = 0;
	
	
	public SlotMachine()  {
		this.top_row = new int[3];
		this.mid_row = new int[3];
		this.bot_row = new int[3];	
		
//		this.total_winnings = 0; //no fucking clue
	}
	
	public void printMenu() {
		System.out.println(" 1. Play the slot machine once (this costs one credit) ");
		System.out.println(" 2. Play the slot machine N times (this costs N credits) ");
		System.out.println(" 3. Print out the slot machine's total winnings ");
		System.out.println(" 4. Print out the player's current number of credits ");
		System.out.println(" 5. Exit program ");

	}
	
	//pain time
	//SORTING
	//If the sum of all the numbers on the slot machine is greater than 20, then they will win 2 credits
	public boolean sumOfRows() {
		int rowTotal = 0;
		boolean rowWin = false;
		
		//sum row 1->
		for (int i=0; i < 3; i++) {
			rowTotal += top_row[i];
			rowTotal += mid_row[i];
			rowTotal += bot_row[i];
		}
		//is rowTotal > 20?
		if (rowTotal > 20) {
			rowWin = true;
		}
		//else nope
		
		return rowWin;
	}
	
	//If one of the diagonals in the slot machine has matching symbols, 
	//then they will win 2 credits. Both diagonals need to be checked.
	public boolean diagonals_left_to_right() {
		boolean rtlWin = false;
		if (this.top_row[0] == this.mid_row[1] && this.top_row[0] == this.bot_row[2] && this.bot_row[2] == this.mid_row[1]) {
			rtlWin = true;
		}
		
		return rtlWin;
	}
	//same same but different
	public boolean diagonals_right_to_left() {
		boolean ltrWin = false;
		if (this.top_row[2] == this.mid_row[1] && this.top_row[2] == this.bot_row[0] && this.bot_row[0] == this.mid_row[1]) {
			ltrWin = true;
		}
		
		return ltrWin;
	}

	//If one of the rows all have matching symbols, then they will win 2 credits. max 2
	public boolean check_matching_rows() {
		boolean matchRow = false;
		//top row matches
		if (this.top_row[0] == this.top_row[1] && this.top_row[2] == this.top_row[1]) {
			matchRow = true;
		}
		
		//mid or bot could...mid first
		else {
			if (this.mid_row[0] == this.mid_row[1] && this.mid_row[2] == this.mid_row[1]) {
				matchRow = true;
			}
			
			//now checking bot row
			else {
				if (this.bot_row[0] == this.bot_row[1] && this.bot_row[2] == this.bot_row[1]) {
					matchRow = true;
				}
				
				//nothing then
			}
		}
		
		return matchRow;
	}
	
	//If one of the columns all have matching symbols, then they will win 2 credits. max 2
	public boolean check_matching_columns() {
		boolean colRow = false;
		//left col matches
		if (this.top_row[0] == this.mid_row[0] && this.top_row[0] == this.bot_row[0]) {
			colRow = true;
		}
		
		//mid or right could...mid first
		else {
			if (this.top_row[1] == this.mid_row[1] && this.top_row[1] == this.bot_row[1]) {
				colRow = true;
			}
			
			//now checking right col
			else {
				if (this.top_row[2] == this.mid_row[2] && this.top_row[2] == this.bot_row[2]) {
					colRow = true;
				}
				
				//nothing then
			}
		}
		
		return colRow;
	}

	//If all 4 corners of the slot machine have matching symbols, then they will win 3 credits.
	public boolean check_corners() {
		boolean cornerWin = false;
		if (this.top_row[0] == this.top_row[2] && this.bot_row[0] == this.bot_row[2] && this.top_row[0] == this.bot_row[0]) {
			cornerWin = true;
		}
		
		return cornerWin;
	}
	
	
	public int playRound() {
		//get random for each row
		Random rand = new Random();
		
		
		//loop through top row
		for (int i = 0; i < this.top_row.length; i++) {
			this.top_row[i] = rand.nextInt(3) + 1;
			this.mid_row[i] = rand.nextInt(3) + 1;
			this.bot_row[i] = rand.nextInt(3) + 1;
		}
		System.out.println(Arrays.toString(this.top_row));	
		System.out.println(Arrays.toString(this.mid_row));
		System.out.println(Arrays.toString(this.bot_row));
		System.out.println();
		
		if(sumOfRows()) {
			System.out.println("--> Matching Diagonals (+2 credits)");
			total_winnings += 2;
		}
		
		if(diagonals_left_to_right()) {
			System.out.println("--> Matching Diagonals (+2 credits)");
			total_winnings += 2;
		}
		
		if(diagonals_right_to_left()) {
			System.out.println("--> Matching Diagonals (+2 credits)");
			total_winnings += 2;
		}
		
		if(check_matching_rows()) {
			System.out.println("--> Matching Row (+2 credits)");
			total_winnings += 2;
		}
		
		if(check_matching_columns()) {
			System.out.println("--> Matching Column (+2 credits)");
			total_winnings += 2;
		}
		
		if(check_corners()) {
			System.out.println("--> Matching Corners (+3 credits)");
			total_winnings += 3;
		}
		
		 
		return total_winnings;
		
	}
	
	public int getTotalWinnings() {
		return total_winnings;
		
	}
	
}
