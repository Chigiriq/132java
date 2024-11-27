public class test {
    private static final char WALL = '#';
    private static final char PATH = ' ';

    public static void main(String[] args) {
        // Example maze represented as a 2D array of characters
    	char[][] maze = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
                {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
                {'#', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#', '#'},
                {'#', '#', '#', '#', '.', '#', 'F', '#', '.', '#', '.', '#'},
                {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
                {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
            };

        // Starting point (row, column)
        int startRow = 0;
        int startCol = 2;
//        System.out.println(maze[0][3]);
        solveMaze(maze, startRow, startCol);
//        maze[2][0] = '!';
//        print_maze(maze);
    }

    private static void solveMaze(char[][] maze, int currentRow, int currentCol) {
    	System.out.println();
    	print_maze(maze);
        if (currentRow < 0 || currentCol < 0 || currentRow >= maze.length || currentCol >= maze[0].length) {
            // We are out of bounds, return
            return;
        }

        if (maze[currentRow][currentCol] == WALL || maze[currentRow][currentCol] == 'X') {
            // We hit a wall or visited cell, return
            return;
        }

        if (maze[currentRow][currentCol] == 'X') {
            // We reached the endpoint
            System.out.println("Maze solved! Endpoint reached at: (" + currentRow + ", " + currentCol + ")");
            return;
        }

        // Mark the current cell as visited
        maze[currentRow][currentCol] = 'X'; // You can use a different character to mark the visited cells
        System.out.println("Visited: (" + currentRow + ", " + currentCol + ")");

        // Move right, down, left, or up (following the right-hand rule)
        solveMaze(maze, currentRow, currentCol + 1); // Move right
        solveMaze(maze, currentRow + 1, currentCol); // Move down
        solveMaze(maze, currentRow, currentCol - 1); // Move left
        solveMaze(maze, currentRow - 1, currentCol); // Move up
    }
    
    private static void print_maze(char[][] maze2) {
		//PART 2: Print out a 2D character maze
    	
		for (int i = 0; i < 12; i++) {
			for (int k = 0; k < 12; k++) {
				System.out.print(maze2[i][k] + " "); //apparently println forces new line
			}
			System.out.println();
		}
	}
}