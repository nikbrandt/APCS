import java.util.Scanner;

class Main {
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    
    boolean error = false;
    int arrayOneIterator = 0;
    String [] arrayOne = new String[10000];
    System.out.println("Enter the values for the first array, up to 10000 values, enter 'End' to quit");
    
    while (arrayOneIterator < 10000) {
      String input = scanner.nextLine();
      if (input.toLowerCase().equals("end")) break;
      
      if (input.length() > 1) input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
      else input = input.toUpperCase();
      
      if (arrayOneIterator > 0 && input.compareTo(arrayOne[arrayOneIterator - 1]) < 0) error = true;
      
      arrayOne[arrayOneIterator] = input;
      
      arrayOneIterator++;
    }
    
    int arrayTwoIterator = 0;
    String [] arrayTwo = new String[10000];
    System.out.println("Enter the values for the second array, up to 10000 values, enter 'End' to quit");
    
    while (arrayTwoIterator < 10000) {
      String input = scanner.nextLine();
      if (input.toLowerCase().equals("end")) break;
      
      if (input.length() > 1) input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
      else input = input.toUpperCase();
      
      if (arrayTwoIterator > 0 && input.compareTo(arrayTwo[arrayTwoIterator - 1]) < 0) error = true;
      
      arrayTwo[arrayTwoIterator] = input;
      
      arrayTwoIterator++;
    }
    
    System.out.println();
    System.out.println("First Array");
    for (int i = 0; i < arrayOneIterator; i++) 
      System.out.print(arrayOne[i] + " ");
    
    System.out.println("\n");
    System.out.println("Second Array");
    for (int i = 0; i < arrayTwoIterator; i++)
      System.out.print(arrayTwo[i] + " ");
    
    System.out.println("\n");
    
    if (error) {
      System.out.println("Error: Arrays not in correct order");
      return;
    }
    
    int sum = arrayOneIterator + arrayTwoIterator;
    int arrayOneLength = arrayOneIterator;
    int arrayTwoLength = arrayTwoIterator;
    arrayOneIterator = 0;
    arrayTwoIterator = 0;
    System.out.println("Merged Array");
    
    for (int i = 0; i < sum; i++) {
      String value;
      
      if (arrayOneIterator == arrayOneLength) {
        value = arrayTwo[arrayTwoIterator];
        arrayTwoIterator++;
      } else if (arrayTwoIterator == arrayTwoLength) {
        value = arrayOne[arrayOneIterator];
        arrayOneIterator++;
      } else if (arrayOne[arrayOneIterator].compareTo(arrayTwo[arrayTwoIterator]) < 0) {
        value = arrayOne[arrayOneIterator];
        arrayOneIterator++;
      } else {
        value = arrayTwo[arrayTwoIterator];
        arrayTwoIterator++;
      }
      
      System.out.print(value + " ");
    }
    
  }
}