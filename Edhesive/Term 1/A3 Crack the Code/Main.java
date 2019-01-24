import java.util.Scanner;

class Main {
  public static void main (String std[]) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Hello. What is your name?");
    String name = scanner.nextLine();
    System.out.println("Hello " + name + ". Try your best to crack the code!");
    
    int input = phase(1, scanner);
    if (input == 3) correct();
    else { end(); return; }
    
    input = phase(2, scanner);
    if (input == 1 || (input >= 33 && input <= 100)) correct();
    else { end(); return; }
    
    input = phase(3, scanner);
    if (input > 0 && (input % 3 == 0 || input % 7 == 0)) correct();
    else { end(); return; }
    
    System.out.println("You have cracked the code!");
  }
  
  private static int phase(int num, Scanner scanner) {
    System.out.println("\nPHASE " + num);
    System.out.println("Enter a number:");
    return scanner.nextInt();
  }
  
  private static void end() {
    System.out.println("Sorry, that was incorrect!");
    System.out.println("Better luck next time!");
    return;
  }
  
  private static void correct() {
    System.out.println("Correct!");
  }
}