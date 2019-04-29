class LastMondayOfApril {
  public static int[] getColumn(int[][] grid, int number) {
    int[] column = new int[grid.length];
    
    for (int i = 0; i < grid.length; i++)
      column[i] = grid[i][number];
    
    return column;
  }
  
  public static int[][] getDiagonals(int[][] grid) {
    int[][] out = new int[grid.length][grid.length];
    
    int i = 0;
    int j = grid[0].length - 1;
    
    for (int k = 0; k < grid.length; k++) {
      out[k][i] = grid[k][i];
      out[k][j] = grid[k][j];
     
      i++;
      j--;
    }
    
    return out;
  }
  
  public static void main(String[] args) {
    int[][] x = {{3,4,5,6,1},{7,8,9,5,1},{0,9,8,7,8},{6,5,4,8,2},{1,0,9,8,1}};
    int[] aColumn = getColumn(x,1);
    System.out.print("Column 1: ");
    for(int n: aColumn)
      System.out.print(n+" ");
    System.out.println("\nDiagonals:");
    int[][] diagonals = getDiagonals(x);
    for(int r = 0;r<diagonals.length;r++){
      for(int c = 0;c<diagonals[0].length;c++){
        System.out.print(diagonals[r][c]+" ");
      }
      System.out.println();
    }
  }
}