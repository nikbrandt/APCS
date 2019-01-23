import java.util.Scanner;

class Sort {
  private String [] array = new String[100];
  
  Sort () {}
  
  private void print() {
    for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
    System.out.println();
  }
  
  private void randomize() {
    for (int i = 0; i < array.length; i++) { // loop through array
      int length = (int)(Math.random() * 8) + 3;
      for (int j = 0; j < length; j++) { // loop as many times as there are letters in the word
        char currentCharacter = (char)((int)(Math.random() * 26) + 97);
        if (j == 0) {
          array[i] = "";
          currentCharacter = (char)((int)currentCharacter - 31);
        }
        array[i] += currentCharacter;
      }
    }
    
    System.out.println("Array randomized.");
  }
  
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    Sort sort = new Sort();
    
    System.out.println("Well 'ello, welcome to the sorting program.");
    System.out.println("\tMade by Nik B.");
    System.out.println();
    
    sort.menu(scanner);
  }
  
  private void menu (Scanner scanner) {
    System.out.println("What would you like to do?");
    System.out.println("\tRandomize\tRandomize the array.");
    System.out.println("\tPrint\t\tPrint out the array.");
    System.out.println("\tSort\t\tSort the array alphabetically.");
    System.out.println("\tEnd\t\tEnd the program.");
    
    String input = scanner.nextLine().toLowerCase();
    
    switch (input) {
      case "randomize":
        randomize();
        break;
      case "print":
        print();
        break;
      case "sort":
        
        break;
      case "end":
        return;
      default:
        System.out.println("Huh? Unrecognized command, sorry. Here, try again -");
        break;
    }
    
    System.out.println();
    menu(scanner);
  }
}