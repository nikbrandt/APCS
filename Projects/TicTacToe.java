import java.util.Scanner;

class TicTacToe {
	public static void main(String str[]) {
		TicTacToe game = new TicTacToe(20);
	}
	
	static final Scanner SCANNER = new Scanner(System.in);
	
	int size;
	boolean turnX;
	char[][] board;

	public TicTacToe() {
		this(3);
	}

	public TicTacToe(int size) {
		this.turnX = true;
		this.size =	size;
		this.board = new char[size][size];
		
		resetBoard();
		
		turn();
	}
	
	private void turn() {
		System.out.println("\nIt's your turn, player with the " + (turnX ? "X." : "O."));
	
		printBoard();
	
		System.out.println("Choose the column (x).");
		int col = SCANNER.nextInt();
		
		System.out.println("Choose the row (y).");
		int row = SCANNER.nextInt();
		
		if (col >= size || col < 0 || row >= size || row < 0) {
			System.out.println("One or more of your entries it out of range. Try again, plebian.");
			turn();
			return;
		}
		
		if (board[row][col] != '_') {
			System.out.println("There's already a thing there. Bad child. Try again.");
			turn();
			return;
		}
		
		board[row][col] = turnX ? 'X' : 'O';
		
		if (checkBoard()) {
			endGame();
			return;
		}
		
		turnX = !turnX;
		turn();
	}
	
	private boolean checkBoard() {
		char check = turnX ? 'X' : 'O';
		
		// check rows
		for (int i = 0; i < size; i++) {
			boolean success = true;
			
			for (int j = 0; j < size; j++) {
				if (board[i][j] != check) success = false;
			}
			
			if (success) return true;
		}
		
		// check columns
		for (int i = 0; i < size; i++) {
			boolean success = true;
			
			for (int j = 0; j < size; j++) {
				if (board[j][i] != check) success = false;
			}
			
			if (success) return true;
		}
		
		// check diagonal
		boolean success = true;
		for (int i = 0; i < size; i++) {
			if (board[i][i] != check) success = false;
		}
		if (success) return true;
		
		// check other diagonal
		success = true;
		for (int i = 0; i < size; i++) {
			if (board[i][size - 1 - i] != check) success = false;
		}
		
		return success;
	}
	
	private void endGame() {
		System.out.println("Player " + (turnX ? 'X' : 'O') + " won the game!");
		System.out.println("Would you like to play again? (yes/no)");
		
		SCANNER.nextLine();
		String input = SCANNER.nextLine();
		input = input.toLowerCase();
		
		if (input.equals("yes")) {
			turnX = true;
			resetBoard();
			turn();
			return;
		}
		
		System.out.println("k, bye.");
	}
	
	private void resetBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	private void printBoard() {
		for (char[] row: board) {
			for (char item: row)
				System.out.print(item + " ");

			System.out.println();
		}
	}
}