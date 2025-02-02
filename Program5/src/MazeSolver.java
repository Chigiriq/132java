//XXX Notes:
//			yep definitely should've started earlier and marked where i changed things 
//			could get relatively far into maze before breaking but not sure what i did to 
//			mess up the turning anymore. RIP


// You will likely need to import some stuff up here

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MazeSolver {

	//2D representation of the maze. The maze will always be 12x12
	private char[][] maze = new char[12][12];
	
	
	public MazeSolver() {
		//PART 0 (?) TO DO: You likely will need to add some code here
		//fill empty maze slate
		for (int i = 0; i < 12; i++) {
			for (int k = 0; k < 12; k++) {
				maze[k][i] = ' ';
			}
		}
		
	}
	
	public char[][] loadMaze(String filename){
		//PART 1: Read in the maze from a text file into a 2D char array
		//get file
		try {
			Scanner input = new Scanner( new FileReader(filename) );
			
			int r = 0;
			while(input.hasNext() ) {
				String line = input.nextLine();            
				
				for (int c = 0; c < 12; c++) {      //i dont like this but it works for now
					maze[c][r] = line.charAt(c);
				}
				r++;
			}
			input.close();
			
		}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		return maze;
	}
	
	
	private void print_maze(char[][] maze2) {
		//PART 2: Print out a 2D character maze 
		for (int i = 0; i < 12; i++) {
			for (int k = 0; k < 12; k++) {
				System.out.print(maze2[k][i] + " "); //apparently println forces new line
			}
			System.out.println();
		}
	}

	public void solveMaze() {
		// PART 3: You don't really need to do anything here

		// starting parameters for "maze.txt"
		// If you are using a different maze, you will need to change these four values
		int start_x  = 0;
		int start_y = 2;
		
		int start_hand_x = 0;
		int start_hand_y = 3;
		
		loadMaze("maze.txt");
//		print_maze(maze);
		make_move(start_x, start_y, start_hand_x, start_hand_y);
		
	}
	
	
	
	
	
	public void make_move(int x, int y, int hand_x, int hand_y) {
		// Part 4: Making a single move in the maze 
		// You CANNOT change the arguments to this method
		
		int direction = 0;  //1 N; 2 S; 3 E; 4 W
		
		// Part 4.1: Determine direction (north, east, south, west) using the method inputs
		if (y == hand_y && x < hand_x) {
			direction = 1; //north
		}
		if (y == hand_y && x > hand_x) {
			direction = 2; //south
		}
		if (y < hand_y && x == hand_x) {
			direction = 3; //east
		}
		if (y > hand_y && x == hand_x) {
			direction = 4; //west
		}
		System.out.println();
		System.out.println("mouse: x:" + x + ", y:" + y);
		System.out.println("hand: x:" + hand_x + ", y:" + hand_y);
		System.out.println("heading: " + direction);
		
		print_maze(maze);
		//Base Case
		if (maze[x][y] == 'F') {
			print_maze(maze);
			System.out.println("Exit found! Program ending...");
			return;
		}
		
		//Recursive Cases
		//out of bounds
		if (hand_x < 0 || hand_y < 0 || hand_x >= maze.length || hand_y >= maze[0].length) {
			System.out.println("bounds");
            return;
        }
		if (x < 0 || y < 0 || x >= maze.length ||y >= maze[0].length) {
			System.out.println("bounds");
            return;
        }
			
		//wall hit
		if (maze[x][y] == '#') {
			System.out.println("wall");
//			maze[x][y] = '!';
			print_maze(maze);
			
			//was moving up
			if (direction == 1) {
			    if (y - 1 >= 0) {
			        direction = 3;
			        y++;  
			        hand_y++;
			    }
			}

			//was moving down
			if (direction == 2) {
			    if (y + 1 < maze.length) {
			        direction = 4;
			        y--;  
			        hand_y--;
			    }
			}

			//was moving right
			if (direction == 3) {
			    if (x + 1 < maze[0].length) {
			        direction = 2;
			        x--;
			        hand_x--;
			    }
			}

			//was moving left
			if (direction == 4) {
			    if (x - 1 >= 0) {
			        direction = 1;
			        x++;
			        hand_x++;
			    }
			}

			System.out.println("mouse: x:" + x + ", y:" + y);
			System.out.println("hand: x:" + hand_x + ", y:" + hand_y);
			System.out.println("heading: " + direction);

        }
		
		//hand is on a dot
	   if (maze[hand_x][hand_y] == '.' && maze[x][y] != '#') {
		   System.out.println("found a free space");
		 //was moving up
			if (direction == 1) {
				direction = 3;
			}
			
			//was moving down
			if (direction == 2) {
				direction = 4;
			}
			
			//was moving right
			if (direction == 3) {
				direction = 2;
			}
			
			//was moving left
			if (direction == 4) {
				direction = 1;
			}
			System.out.println("new direction: " + direction);
	   }
//	
		
		maze[x][y] = 'X';
		if (direction == 1) {
			make_move(x, y - 1, hand_x, hand_y - 1); //up
		}
		
		if (direction == 2) {
			make_move(x, y + 1, hand_x, hand_y + 1); //down
		}
		
		if (direction == 3) {
			make_move(x + 1, y, hand_x + 1, hand_y); //move right
		}
		
		if (direction == 4) {
			make_move(x - 1, y, hand_x - 1, hand_y); //move left
		}
		
		
		// Part 4.1: Make the move (turn right, move forward, turn left) depending on what the hand is touching, and what is in front of the character
		// This is where you will recursively call the make_move() method
		// (lots of if statements here)	
	
	
	}
}

