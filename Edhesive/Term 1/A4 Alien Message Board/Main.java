import java.util.Scanner;

class Main {
  public static void main (String str[]) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter post okay thankseroni\n");
    
    String input = scanner.nextLine();
    
    String username = input.substring(0, input.indexOf('-') - 1);
    String message = input.substring(username.length() + 3);
    
    int caretCount = 0;
    int qeyCount = 0;
    int moneyCount = 0;
    
    int i = message.length();
    
    while (i > 0) {      
      int spaceIndex = message.indexOf(' ');
      String word = message;
      
      if (spaceIndex == 0) {
        message = message.substring(1);
        i--;
        continue;
      }
      
      if (spaceIndex > 0) {
        word = message.substring(0, spaceIndex);
        i--;
      }
      
      if (word.equals("^^")) caretCount++;
      if (word.toLowerCase().equals("qey")) qeyCount++;
      if (word.equals("$")) moneyCount++;
      
      i -= word.length();
      message = message.substring(spaceIndex + 1);
    }
    
    System.out.println("Results:\n");
    
    if (caretCount == 0 && qeyCount == 0 && moneyCount == 0) {
      System.out.println("CLEAN");
      return;
    }
    
    System.out.println("BAD");
    System.out.println(username);
    System.out.println("^^: " + caretCount);
    System.out.println("qey: " + qeyCount);
    System.out.println("$: " + moneyCount);
  }
}