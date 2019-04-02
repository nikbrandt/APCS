class InsertionSort {
  private static final boolean DEBUG = true;
  
  public static void sort (int[] array) {
    for (int i = 1; i < array.length; i++) { // start at one, through end
      if (DEBUG) System.out.print("i ");
      for (int j = i - 1; j >= -1; j--) { // compare backwards from i
        if (DEBUG) System.out.print("j ");
        
        if (j < 0) {
          if (DEBUG) System.out.println("Debug: i = " + i + ", j = -1 inserting at 0");
          insert(array, 0, i);
          break;
        } // if reached the end without smaller, insert at 0
        
        if (array[j] < array[i]) {
          if (DEBUG) {
            System.out.print("Debug:  i = " + i + ", j = " + j + ", array: ");
            printArray(array);
          }
          
          insert(array, j + 1, i);
          break;
        } // if finds something smaller, insert at that position + 1
      }
    }
  }
  
  private static void insert(int[] array, int position, int originalPosition) {
    int value = array[originalPosition];
    // take original value of value being inserted
    
    if (DEBUG) {
      System.out.print("Inserting " + value + " at position " + position + ", ending at " + originalPosition + ".\n\t");
      printArray(array);
      
      System.out.print("\t");
      for (int i = 0; i < position; i++)
        System.out.print("  ");
      System.out.print("^ ");
      for (int i = position + 1; i < originalPosition; i++)
        System.out.print("  ");
      if (position != originalPosition) System.out.print("^");
      System.out.println();
    }
    
    for (int i = originalPosition; i > position; i--) // loop through backwards
      array[i] = array[i - 1]; // set current value to previous value
    
    array[position] = value; // set first value to original value
    
    if (DEBUG) {
      System.out.print("\t");
      printArray(array);
    }
  }
  
  private static void printArray(int[] array) {
    for (int i: array)
      System.out.print(i + " ");
    System.out.println();
  }
  
  public static void main(String[] str) {
    int[] array2 = { 2, 3, 1 };
    int[] array = { 6, 3, 7, 2, 19, 49, 20, 1, 0, -3, 39 };
    
    printArray(array);
    sort(array);
    printArray(array);
  }
}