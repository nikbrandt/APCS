// Nikolas Brandt, 3/28/19

import java.util.Scanner;

class Battleship {
  private final int BOARD_WIDTH = 10;
  private final int BOARD_HEIGHT = 5;
  
  private char[][] board;
  private Scanner scanner = new Scanner(System.in);
  
  public static void main (String str[]) {
    Battleship b = new Battleship();
  }
  
  Battleship() {
    System.out.println("Welcome to Battleship!");
    
    board = new char[BOARD_HEIGHT][BOARD_WIDTH];
    
    restart();
  }
  
  private void restart() {
    generateBoard();
    prompt();
  }
  
  private void generateBoard() {
    int shipLocation = (int)(Math.random() * 50);
    
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        if (i * BOARD_WIDTH + j == shipLocation) board[i][j] = 'S';
        else board[i][j] = '~';
      }
    }
  }
  
  private void prompt() {
    printBoard();
    
    System.out.println("Enter a row:");
    int row = scanner.nextInt();
    
    System.out.println("Enter a column:");
    int column = scanner.nextInt();
    
    if (row < 0 || row >= BOARD_HEIGHT || column < 0 || column >= BOARD_WIDTH) {
      System.out.println("One or more entries is out of range.\nPlease try again.");
      prompt();
      return;
    }
    
    if (board[row][column] == 'S') {
      System.out.println("You sunk my battleship!");
     
      board[row][column] = '@';
      printBoard();
      
      System.out.println("Would you like to play again? (yes/no)");
      
      scanner.nextLine();
      String in = scanner.nextLine();
      
      if (in.toLowerCase().equals("yes")) {
        restart();
        return;
      } else if (in.toLowerCase().equals("no")) {
        System.out.println("Alright, see ya.");
        return;
      } else {
        System.out.println("I'll take that as a no. B'bye.");
        return;
      }
      
    } else {
      System.out.println("Miss!");
      board[row][column] = 'X';
    }
    
    prompt();
  }
  
  private void printBoard() {
    System.out.println();
    for (int i = 0; i < BOARD_HEIGHT; i++) {
      for (int j = 0; j < BOARD_WIDTH; j++) {
        System.out.print("" + board[i][j] + (j - 1 == BOARD_WIDTH ? "" : ' '));
      }
      System.out.println();
    }
    System.out.println();
  }
}