import java.util.*;

public class twoDArrays {
  // Nikolas Brandt, 3/26/19
  // should be TwoDArrays, but I assume your program searches with case.
  
  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter # of rows: ");
    int rows = scan.nextInt();
    System.out.println("Enter # of columns: ");
    int cols = scan.nextInt();
    int[][] grid = new int[rows][cols];
    boolean[] ascending = new boolean[grid[0].length];
    
    randomize(grid);
    printWithAverages(grid);
    ascendingCheck(grid,ascending);
  }
  
  public static void randomize(int[][] array) {
    for (int i = 0; i < array.length; i++)
      for (int j = 0; j < array[i].length; j++)
        array[i][j] = (int)(Math.random() * 10);
  }
  
  public static void printWithAverages(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      int sum = 0;
      for (int j = 0; j < array[i].length; j++) {
        sum += array[i][j];
        System.out.print(array[i][j] + " ");
      }
      System.out.println("Ave: " + (double) sum / array[i].length);
    }
  }
  
  public static void ascendingCheck(int[][] array, boolean[] booleanArray) {
    for (int i = 0; i < array[0].length; i++) {
      int highest = 0;
      boolean ascending = true;
      
      for (int j = 0; j < array.length; j++) {
        if (array[j][i] >= highest) highest = array[j][i];
        else ascending = false;
      }
      
      System.out.print(ascending ? "+ " : "  ");
    }
  }
}