import java.util.Scanner;

class Main {
  public static void main (String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter the first string:");
    String base = scanner.nextLine();
    
    System.out.println("Enter the pivot string:");
    String pivot = scanner.nextLine();
    
    int index = base.indexOf(pivot);
    if (index < 0) {
      System.out.println("Error: Pivot String not found.");
      return;
    }
    
    String start = base.substring(0, index);
    String end = base.substring(index + pivot.length());
    
    System.out.println(end + pivot + start);
    
  }
}